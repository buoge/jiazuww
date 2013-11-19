/**
 * 用户登录 注册等等控制器
 * ============================================================================
 * 声明：北京旺族互联网科技有限公司版权所有
 * ----------------------------------------------------------------------------
 * Official Website: http://www.jiazuww.com
 * ----------------------------------------------------------------------------
 * Copyright: © 2012 JiaZuWW All Rights Reserved.
 * ----------------------------------------------------------------------------
 * @version: 1.0
 * ----------------------------------------------------------------------------
 * @author: Architect.bian
 * ----------------------------------------------------------------------------
 * Create at: 2012-8-27 上午7:14:28
 * ============================================================================
 */
package com.jiazu.web.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jiazu.core.cache.rule.SessionRule;
import com.jiazu.global.constants.EOrder;
import com.jiazu.global.constants.EPageState;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.MsgConstant;
import com.jiazu.global.constants.SessConstant;
import com.jiazu.global.constants.SysConf;
import com.jiazu.global.constants.SysConstant;
import com.jiazu.global.constants.UserConstant;
import com.jiazu.global.constants.ValidConstant;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.global.factory.SessionFactory;
import com.jiazu.global.utility.CookieUtil;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.Message;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.proxy.MessagePX;
import com.jiazu.web.platform.proxy.SysPX;
import com.jiazu.web.platform.proxy.UserPX;

/**
 * @author Architect.bian
 * 
 */
@Controller
public class UserController extends BaseController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Map<String, Object> model) {
		model.put("onlineUserNum", "10");
		model.put("jiaZuTreesNum", "11");
		model.put("f_userid", UserConstant.LOGINID);
		model.put("f_pwd", UserConstant.PWD);
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Map<String, Object> model, HttpServletRequest request) {
		UserPX.offline(new SessionRule(request, SessConstant.USER, SysConf.Expire_UserSession).toString());
		CookieUtil.removeCookie(request, SysConstant.SESSION_ID);
		cloneParamsToModel(model, request.getParameterMap());
		
		Map<String, String> errs = new HashMap<String, String>();
		boolean valid = loginValidate(request, errs);
		if (valid) {
			model.put(ViewKeyConstant.title, "恭喜您，登录成功！");
			return UserConstant.viewName_LoginSuccess;
		} else {
			model.put(ValidConstant.VALID, errs);
			return "login";
		}
	}

	/**
	 * @param request
	 * @param errs
	 * @return
	 */
	private boolean loginValidate(HttpServletRequest request, Map<String, String> errs) {
		String userId = request.getParameter(UserConstant.LOGINID);
		String pwd = request.getParameter(UserConstant.PWD);
		boolean valid = true;
		if (StringUtils.isEmpty(userId)) {
			errs.put("useridneed", "请填写用户名！");
			valid = false;
		}
		if (StringUtils.isEmpty(pwd)) {
			errs.put("pwdneed", "请填写密码！");
			valid = false;
		}
		if (StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(pwd)) {
			User user = UserPX.getUser(userId, pwd);
			if (user == null) {
				errs.put("loginfailed", "用户名或密码错误！新注册用户请先邮箱激活再登录");
				valid = false;
			}
		}
		return valid;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return UserConstant.viewName_RedirectLogoutSuccess;
	}
	
	@RequestMapping(value="/active/{uid:.{32}}", method = RequestMethod.GET)
	public String ActiveValidate(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (UserPX.active(uid)) {
			model.put(ViewKeyConstant.msg, MsgConstant.activeSuccess);
			model.put(ViewKeyConstant.activeResult, true);
			model.put(ViewKeyConstant.title, "请重新登录");
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.activeFailed);
		}
		return UserConstant.viewName_RegisterSuccess;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid User user, BindingResult result, Map<String, Object> model, HttpServletRequest request, Locale locale) {
		Map<String, String> errs = new HashMap<String, String>();
		ResourceBundle resource = ResourceBundle.getBundle("i18n/validate", locale);
		
		boolean valid = registerValidate(user, request, errs, resource);
		if (result.hasErrors() || !valid) {
			validateErrors(result, errs);
			model.put(ValidConstant.VALID, errs);
			return "login";
		} else {
			UserPX.registerUser(user);
			model.put(ViewKeyConstant.title, "恭喜您，注册成功！请查收您的邮箱激活账号");
			if (UserPX.sendValidEmail(user)) {
				model.put(ViewKeyConstant.emailSendResult, true);
			}
			model.put(ViewKeyConstant.state, EPageState.registered.toString());
			return UserConstant.viewName_RegisterSuccess;
		}
	}

	/**
	 * @param user
	 * @param request
	 * @param errs
	 * @param resource
	 * @return
	 */
	private boolean registerValidate(User user, HttpServletRequest request, Map<String, String> errs, ResourceBundle resource) {
		boolean valid = true;
		if (StringUtils.isNotEmpty(request.getParameter("validcode"))) {
			HttpSession sess = SessionFactory.getHttpSession();
			String sessCaptchaKey = new SessionRule(request, SessConstant.CAPTCHA).toString();
			if (request.getParameter("validcode") == null || StringUtils.isEmpty(request.getParameter("validcode")) || !sess.getAttribute(sessCaptchaKey).equals(request.getParameter("validcode").toLowerCase())) {
				errs.put("validcode", "验证码错误！");
				valid = false;
				return valid;
			}
		} else {
			errs.put("validcode", "请填写验证码！");
			valid = false;
			return valid;
		}
		if (StringUtils.isNotEmpty(request.getParameter("aggreerule")) && request.getParameter("aggreerule").equals("true")) {
			if (StringUtils.isEmpty(user.getPassword())) {
				errs.put("password", "请填写密码!");
				valid = false;
			}
			if(!user.getPassword().equals(request.getParameter("password2"))) {
				errs.put("password2", resource.getString("valid.password2.equal"));
				valid = false;
			}
		} else {
			errs.put("aggreerule", "要注册成为本站会员必须同意《用户协议》");
			valid = false;
		}
		if (StringUtils.isEmpty(user.getName())) {
			user.setName(user.getUserid());
		}
		return valid;
	}
	
	@RequestMapping(value="/isuserexist", method = RequestMethod.GET)
	public @ResponseBody boolean isUserExist(@Param(value = "userId") String userId) {
		return UserPX.isExistByUserid(userId);
	}
	
	@RequestMapping(value="/isemailexist", method = RequestMethod.GET)
	public @ResponseBody boolean isEmailExist(@Param(value = "email") String email) {
		return UserPX.isExistByEmail(email);
	}
	
	@RequestMapping(value="/resetpwd", method = RequestMethod.GET)
	public @ResponseBody boolean resetpwd(@Param(value = "email") String email) {
		return UserPX.resetpwd(email);
	}

	@RequestMapping(value="/myhome/account", method = RequestMethod.GET)
	public String myaccount(Map<String, Object> model, HttpServletRequest request) {
		User user = getCurrUser(request);
		request.setAttribute(ViewKeyConstant.me, UserPX.freshCache(getCurrUserCacheKey(request), user.getUid()));
		return "myaccount";
	}
	
	@RequestMapping(value="/myhome/msg", method = RequestMethod.GET)
	public String mymsg(Map<String, Object> model, HttpServletRequest request) {
		User user = (User)request.getAttribute(ViewKeyConstant.me);
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 10);
		List<Message> list = MessagePX.getList(user.getUid(), pager);
		model.put(ViewKeyConstant.list, list);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		SysPX.clearUnreadMsgList_StatisticsUser(user.getUid());
		return "mymsg";
	}
	
	@RequestMapping(value="/myhome/msg/{uid:.{32}}/del", method = RequestMethod.GET)
	public String mymsg(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (MessagePX.delete(uid)) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteFailed);
		}
		return mymsg(model, request);
	}
	
	@RequestMapping(value="/myhome/msg/{uid:.{32}}", method = RequestMethod.POST)
	public String mymsg(Map<String, Object> model, @PathVariable String uid, String msg, HttpServletRequest request) {
		User user = getCurrUser(request);
		String[] uids = {uid};
		if (MessagePX.send(uid, uids, user.getUid(), "", msg)) {
			for (String id : uids) {
				SysPX.plusUnreadMsgCount_StatisticsGroup(id, "");
			}
			model.put(ViewKeyConstant.msg, MsgConstant.sendSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.sendFailed);
		}
		return mymsg(model, request);
	}
	
	@RequestMapping(value="/myhome/pwd", method = RequestMethod.POST)
	public String modifyPwd(Map<String, Object> model, @RequestParam String oldpassword, @RequestParam String password, @RequestParam String password2, HttpServletRequest request) {
		if (!password.equals(password2)) {
			model.put(ViewKeyConstant.msg, "密码不一致");
			return myaccount(model, request);
		}
		User user = (User)request.getAttribute(ViewKeyConstant.me);
		if (UserPX.getUser(user.getUserid(), oldpassword) != null) {
			if (UserPX.updatePwd(user.getUid(), password)) {
				model.put(ViewKeyConstant.msg, MsgConstant.modifySuccess);
			} else {
				model.put(ViewKeyConstant.msg, MsgConstant.modifyFailed);
			}
		} else {
			model.put(ViewKeyConstant.msg, "原密码输入错误");
		}
		return myaccount(model, request);
	}
	
	@RequestMapping(value="/myhome/account", method = RequestMethod.POST)
	public String modifyUserInfor(Map<String, Object> model, User user, HttpServletRequest request, @RequestParam MultipartFile file) {
		if (file.getSize() > 0) {
			String[] paths = FileUtil.resizeImage(file, 50, 50);
			if (user.getAvatar().indexOf("defaulthead.jpg") < 0) {
				FileUtil.deleteImg(user.getOriginal(), user.getAvatar());
			}
			user.setOriginal(paths[0]);
			user.setAvatar(paths[1]);
		}
		user.setUid(((User)request.getAttribute(ViewKeyConstant.me)).getUid());
		if (UserPX.updateInfor(user)) {
			user = UserPX.getUser(user.getUid());
			UserPX.freshCache(getCurrUserCacheKey(request), user.getUid());
			request.setAttribute(ViewKeyConstant.me, user);
			model.put(ViewKeyConstant.msg2, MsgConstant.saveSuccess);
		} else {
			model.put(ViewKeyConstant.msg2, MsgConstant.saveFailed);
		}
		return myaccount(model, request);
	}

	@RequestMapping(value="/admin/dousers", method = RequestMethod.GET)
	public String dousers(Map<String, Object> model, HttpServletRequest request) {
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 20);
		List<User> list = UserPX.getList(pager);
		model.put(ViewKeyConstant.list, list);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		model.put(ViewKeyConstant.sum, UserPX.getSumMoney());
		model.put(ViewKeyConstant.count, UserPX.getCount());
		return "dousers";
	}

	@RequestMapping(value = "/admin/dousers/search", method = RequestMethod.GET)
	public String dousers_search(Map<String, Object> model, String userid, String name, String email, String mobile, String status, String num) {
		Pager pager = Pager.getNewInstance(num, 20);
		Map<String, Object> map = getParamMap(pager);
		if (StringUtils.isNotEmpty(userid)) {
			map.put(MapperConstant.userid + MapperConstant.like, userid);
		}
		if (StringUtils.isNotEmpty(name)) {
			map.put(MapperConstant.name + MapperConstant.like, name);
		}
		if (StringUtils.isNotEmpty(email)) {
			map.put(MapperConstant.email + MapperConstant.like, email);
		}
		if (StringUtils.isNotEmpty(mobile)) {
			map.put(MapperConstant.mobile + MapperConstant.like, mobile);
		}
		if (StrUtil.isNumeric(status)) {
			map.put(MapperConstant.status, EOrder.get(Integer.valueOf(status)));
		}
		List<User> list = UserPX.getList(map);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		model.put(ViewKeyConstant.list, list);
		model.put(ViewKeyConstant.userid, userid);
		model.put(ViewKeyConstant.name, name);
		model.put(ViewKeyConstant.email, email);
		model.put(ViewKeyConstant.mobile, mobile);
		model.put(ViewKeyConstant.status, status);
		return "dousers";
	}
	
	@RequestMapping(value="/admin/dousers/{uid:.{32}}/del", method = RequestMethod.GET)
	public String dousers_delete(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (UserPX.delete(uid)) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.deleteFailed);
		}
		return dousers(model, request);
	}
	
	@RequestMapping(value="/admin/dousers/{uid:.{32}}/status/{status:\\d+}", method = RequestMethod.GET)
	public String dousers_status(Map<String, Object> model, @PathVariable String uid, @PathVariable int status, HttpServletRequest request) {
		if (UserPX.updateStatus(uid, status == 1)) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.deleteFailed);
		}
		return dousers(model, request);
	}
	

	@RequestMapping(value="/admin/dousers/{uid:.{32}}/updateaccount")
	public String dousers_updateaccount(Map<String, Object> model, @PathVariable String uid, Double account, HttpServletRequest request) {
		if (UserPX.updateAccount(uid, account)) {
			model.put(ViewKeyConstant.msg, MsgConstant.modifySuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.modifyFailed);
		}
		return dousers(model, request);
	}
}

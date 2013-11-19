/**
 * 
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
 * Create at: 2012-9-2 下午1:59:35
 * ============================================================================
 */
package com.jiazu.web.platform.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiazu.global.constants.EEducation;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.MsgConstant;
import com.jiazu.global.constants.SysConf;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.global.utility.ConvertUtil;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.Education;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.proxy.EduPX;
import com.jiazu.web.platform.proxy.SysPX;
import com.jiazu.web.shop.entity.B2C;
import com.jiazu.web.shop.proxy.B2CPX;

/**
 * @author Architect.bian
 *
 */
@Controller
public class EduController extends BaseController {
	
	@RequestMapping(value = "/edu", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		model.put(ViewKeyConstant.famousList, EduPX.getFamousListTop(9));
		model.put(ViewKeyConstant.professionalList, EduPX.getProfessionalListTop(9));
		model.put(ViewKeyConstant.homeList, EduPX.getHomeListTop(9));
		model.put(ViewKeyConstant.bookList, B2CPX.getBookListTop(6));
		return "edu";
	}
	
	@RequestMapping("/edu/{type}")
	public String more(@PathVariable String type, Map<String, Object> model, String num) {
		Pager pager = Pager.getNewInstance(num, 20);
		if (type.equals(EEducation.Book.toString())) {
			List<B2C> list = B2CPX.getBooksList(pager);
			pager.refresh(list);
			model.put(ViewKeyConstant.list, list);
		} else {
			List<Education> list = EduPX.getList(EEducation.get(Integer.valueOf(type)), pager);
			pager.refresh(list);
			model.put(ViewKeyConstant.list, list);
		}
		model.put(ViewKeyConstant.type, type);
		model.put(ViewKeyConstant.typeName, EEducation.getName(EEducation.get(Integer.valueOf(type))));
		model.put(ViewKeyConstant.bookList, B2CPX.getBookListTop(6));
		model.put(ViewKeyConstant.pager, pager);
		return "edulist";
	}
	
	@RequestMapping("/edu/{type:\\d+}/{id:\\d+}")
	public String show(@PathVariable String type, @PathVariable String id, Map<String, Object> model) {
		EduPX.increaseClickCount(id);
		model.put(ViewKeyConstant.bean, EduPX.get(Integer.valueOf(id)));
		model.put(ViewKeyConstant.bookList, B2CPX.getBookListTop(6));
		return "eduuid";
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/edu", method = RequestMethod.GET)
	public String myedu(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 10);
		List<Education> list = EduPX.getMyHomeList(uid, pager);
		model.put(ViewKeyConstant.homeList, list);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		SysPX.clearNewEduList_StatisticsUser(uid, getCurrUser(request).getUid());
		return "myedu";
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/edu", method = RequestMethod.POST)
	public String myedu(Map<String, Object> model, @PathVariable String uid, Education edu, HttpServletRequest request) {
		if (validEdu(model, edu)) {
			User user = (User)request.getAttribute(ViewKeyConstant.me);
			edu.setUseruid(user.getUid());
			edu.setGroupuid(uid);
			edu.setType(EEducation.Home);
			if (StringUtils.isEmpty(request.getParameter("ispublic"))) {
				edu.setIspublic(false);
			}
			if (EduPX.add(edu)) {
				SysPX.addJiazuNews(user.getName(), user.getAvatar(), SysConf.format_jiazunews_educationadd, "");
				EduPX.addNewEduList_StatisticsUser(uid, edu.getUid());
				model.put(ViewKeyConstant.msg, String.format(MsgConstant.publishSuccessArgs, "家族教育"));
			} else {
				model.put(ViewKeyConstant.msg, String.format(MsgConstant.publishFailedArgs, "家族教育"));
			}
		}
		return myedu(model, uid, request);
	}

	@RequestMapping(value="/myhome/{uid:.{32}}/edu/{id:\\d+}/edit", method = RequestMethod.GET)
	public String myedu_edit(Map<String, Object> model, @PathVariable String uid, @PathVariable String id, HttpServletRequest request) {
		model.put(ViewKeyConstant.editbean, EduPX.get(Integer.valueOf(id)));
		return myedu(model, uid, request);
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/edu/{id:\\d+}/edit", method = RequestMethod.POST)
	public String myedu_edit(Map<String, Object> model, @PathVariable String uid, @PathVariable String id, Education varedu, HttpServletRequest request) {
		if (validEdu(model, varedu)) {
			Education edu = EduPX.get(Integer.valueOf(id));
			edu.setType(EEducation.Home);
			String ispublic = request.getParameter("ispublic");
			if (StringUtils.isEmpty(ispublic)) {
				edu.setIspublic(false);
			} else {
				edu.setIspublic(true);
			}
			edu.setTitle(varedu.getTitle());
			edu.setContent(varedu.getContent());
			if (EduPX.update(edu)) {
				model.put(ViewKeyConstant.msg, String.format(MsgConstant.editSuccessArgs, "家族教育"));
			} else {
				model.put(ViewKeyConstant.msg, String.format(MsgConstant.editFailedArgs, "家族教育"));
			}
		}
		return myedu(model, uid, request);
	}
	
	@RequestMapping(value="/myhome/{cuid:.{32}}/edu/{uid:\\d+}/del", method = RequestMethod.GET)
	public String myedu_del(Map<String, Object> model, @PathVariable String cuid, @PathVariable String uid, HttpServletRequest request) {
		Education edu = EduPX.get(Integer.valueOf(uid));
		if (edu != null) {
			if (edu.getGroupuid().equals(cuid)) {
				if (EduPX.delete(Integer.valueOf(uid))) {
					model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
				} else {
					model.put(ViewKeyConstant.alertmsg, MsgConstant.deleteFailed);
				}
			} else {
				model.put(ViewKeyConstant.msg, "没有权限");
			}
		}
		return myedu(model, cuid, request);
	}

	/**
	 * @param model
	 * @param edu
	 * @return
	 */
	private boolean validEdu(Map<String, Object> model, Education edu) {
		if (StringUtils.isEmpty(edu.getTitle().trim())) {
			model.put(ViewKeyConstant.msg, MsgConstant.err_titlecannotbeempty);
			return false;
		} else if (StringUtils.isEmpty(edu.getContent().trim())) {
			model.put(ViewKeyConstant.msg, MsgConstant.err_contentcannotbeempty);
			return false;
		}
		return true;
	}
	
	@RequestMapping(value="/admin/doedu", method = RequestMethod.GET)
	public String doedu(Map<String, Object> model, HttpServletRequest request) {
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 20);
		List<Education> list = EduPX.getList(pager);
		pager.refresh(list);
		model.put(ViewKeyConstant.list, list);
		model.put(ViewKeyConstant.pager, pager);
		return "doedu";
	}
	
	@RequestMapping(value="/admin/doedu", method = RequestMethod.POST)
	public String doedu_add(Map<String, Object> model, Education edu, HttpServletRequest request) {
		if (EduPX.add(edu)) {
			model.put(ViewKeyConstant.msg, MsgConstant.addSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.addFailed);
			model.put(ViewKeyConstant.bean, edu);
		}
		return doedu(model, request);
	}
	
	@RequestMapping(value="/admin/doedu/{id:\\d+}", method = RequestMethod.GET, params="do=del")
	public String doedu_delete(Map<String, Object> model, @PathVariable String id, HttpServletRequest request) {
		if (EduPX.delete(Integer.valueOf(id))) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.deleteFailed);
		}
		return doedu(model, request);
	}
	
	@RequestMapping(value="/admin/doedu/{id:\\d+}", method = RequestMethod.GET, params="do=edit")
	public String doedu_edit(Map<String, Object> model, @PathVariable String id, HttpServletRequest request) {
		model.put(ViewKeyConstant.bean, EduPX.get(Integer.valueOf(id)));
		model.put(ViewKeyConstant.isedit, true);
		return doedu(model, request);
	}
	
	@RequestMapping(value="/admin/doedu/{id:\\d+}", method = RequestMethod.GET, params="do=recommend")
	public String doedu_recommend(Map<String, Object> model, @PathVariable String id, String is, HttpServletRequest request) {
		if (EduPX.updateRecommend(Integer.valueOf(id), ConvertUtil.toBoolean(is))) {
			model.put(ViewKeyConstant.msg, MsgConstant.uploadSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.uploadFailed);
		}
		return doedu(model, request);
	}
	
	@RequestMapping(value="/admin/doedu/{id:\\d+}", method = RequestMethod.POST)
	public String doedu_update(Map<String, Object> model, @PathVariable String id, Education edu, HttpServletRequest request) {
		if (EduPX.update(edu)) {
			model.put(ViewKeyConstant.msg, MsgConstant.editSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.editFailed);
		}
		return doedu(model, request);
	}
	
	@RequestMapping(value = "/admin/doedu/search", method = RequestMethod.GET)
	public String doedu_search(Map<String, Object> model, String title, String istop, String type, String num) {
		Pager pager = Pager.getNewInstance(num, 20);
		Map<String, Object> map = getParamMap(pager);
		if (StringUtils.isNotEmpty(title)) {
			map.put(MapperConstant.title + MapperConstant.like, title.trim());
		}
		if (StrUtil.isNumeric(istop) && Integer.valueOf(istop) >= 0) {
			map.put(MapperConstant.isrecommend, ConvertUtil.toBoolean(istop));
		}
		if (StrUtil.isNumeric(type) && Integer.valueOf(type) >= 0) {
			map.put(MapperConstant.type, EEducation.get(type));
		}
		List<Education> list = EduPX.getList(map);
		pager.refresh(list);
		model.put(ViewKeyConstant.list, list);
		model.put(ViewKeyConstant.title, title);
		model.put(ViewKeyConstant.istop, istop);
		model.put(ViewKeyConstant.type, type);
		model.put(ViewKeyConstant.pager, pager);
		return "doedu";
	}
	
}

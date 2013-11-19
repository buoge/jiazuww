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
 * Create at: 2012-9-1 下午9:46:58
 * ============================================================================
 */
package com.jiazu.web.platform.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jiazu.global.constants.EAdmin;
import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.MsgConstant;
import com.jiazu.global.constants.SysConf;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.Jiazu;
import com.jiazu.web.platform.entity.Member;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.proxy.JiazuPX;
import com.jiazu.web.platform.proxy.MemberPX;
import com.jiazu.web.platform.proxy.MessagePX;
import com.jiazu.web.platform.proxy.SysPX;
import com.jiazu.web.platform.proxy.UserPX;
import com.jiazu.web.platform.proxy.ZuPuPX;

/**
 * @author Architect.bian
 *
 */
@Controller
public class JiazuController extends BaseController {
	
	@RequestMapping(value="/myhome/jiazu", method = RequestMethod.GET)
	public String jiazu(Map<String, Object> model, HttpServletRequest request) {
		User u = getCurrUser(request);
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 5);
		List<Jiazu> list = JiazuPX.getList(u.getUid(), pager);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		model.put(ViewKeyConstant.list, list);
		return "myjiazu";
	}
	
	@RequestMapping(value="/myhome/jiazu", method = RequestMethod.POST)
	public String modify(Map<String, Object> model, @RequestParam(required=false) String uid, String name, HttpServletRequest request) {
//		User user = getCurrUser(request);
		if (JiazuPX.modify(uid, name)) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteFailed);
		}
		return jiazu(model, request);
	}

	@RequestMapping(value="/myhome/jiazu/create")
	public String create(Map<String, Object> model, @RequestParam(required=true) String name, HttpServletRequest request) {
		User user = getCurrUser(request);
		Jiazu j = new Jiazu(name, user.getUid(), user.getUserid());
		if (JiazuPX.create(j)) {
			SysPX.addJiazuNews(user.getName(), user.getAvatar(), SysConf.format_jiazunews_jiazucreate, "");
			SysPX.addZupuNews(j.getName(), j.getHeadimg(), SysConf.format_zupunews_create, "");
			ZuPuPX.addLatestJiazu(j.getName());
			model.put(ViewKeyConstant.alert, "创建成功，您现在可以上传族徽，编辑族训，并且邀请家人加入本家族！");
			SysPX.setMemberCount_StatisticsGroup(j.getUid(), 1);
		} else {
			model.put(ViewKeyConstant.alert, "创建失败，请联系管理员");
		}
		return "myhome";
	}

	@RequestMapping(value="/myhome/jiazu/list")
	public String list(Map<String, Object> model, @RequestParam(required=false) String name, HttpServletRequest request) {
		model.put(ViewKeyConstant.resultList, JiazuPX.getListByName(name));
		model.put(ViewKeyConstant.query, name);
		return jiazu(model, request);
	}
	
	@RequestMapping(value="/myhome/jiazu/{uid:.{32}}/del", method = RequestMethod.GET)
	public String delete(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (JiazuPX.updateStatus(uid, EStatus.disable)) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteFailed);
		}
		return jiazu(model, request);
	}

	@RequestMapping(value="/myhome/jiazu/{uid:.{32}}/quit", method = RequestMethod.GET)
	public String quit(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		User user = getCurrUser(request);
		if (JiazuPX.quit(uid, user.getUid())) {
			SysPX.plusMemberCount_StatisticsGroup(uid, -1);
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.doFailed);
		}
		return jiazu(model, request);
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/add", method = RequestMethod.GET)
	public String add(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		User user = getCurrUser(request);
		if (JiazuPX.add(uid, user.getUid())) {
			SysPX.plusMemberCount_StatisticsGroup(uid, 1);
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.doFailed);
		}
		return jiazu(model, request);
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/logo", method = RequestMethod.GET)
	public String logo(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		model.put(ViewKeyConstant.admintype, MemberPX.getOne(uid, getCurrUser(request).getUid()).getType().toString());
		model.put(ViewKeyConstant.img, JiazuPX.getLogoOriginal(uid));
		return "mylogo";
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/logo", method = RequestMethod.POST)
	public String logo(Map<String, Object> model, @PathVariable String uid, @RequestParam MultipartFile file, HttpServletRequest request) {
		if (file.getSize() > 0) {
			Jiazu jiazu = JiazuPX.get(uid);
			int[][] sizes = {{130,130}, {50,50}, {700, 700}};
			String[] paths = FileUtil.resizeImage(file, sizes);
			User user = getCurrUser(request);
			if (jiazu.getLogo().indexOf("default") < 0) {
				FileUtil.deleteImg(jiazu.getLogooriginal(), jiazu.getLogo(), jiazu.getHeadimg());
			}
			if (paths != null && JiazuPX.updateLogo(uid, paths[3], paths[1], paths[2])) {
				SysPX.addJiazuNews(user.getName(), user.getAvatar(), SysConf.format_jiazunews_jiazulogo, "");
				SysPX.addZupuNews(jiazu.getName(), paths[2], SysConf.format_zupunews_updatelogo, "");
				model.put(ViewKeyConstant.msg, MsgConstant.uploadSuccess);
			} else {
				model.put(ViewKeyConstant.msg, MsgConstant.uploadFailed);
			}
		} else {
			model.put("msg", file.getOriginalFilename() + "上传失败，文件不能为空");
		}
		
		return logo(model, uid, request);
	}

	@RequestMapping(value="/myhome/{uid:.{32}}/brief", method = RequestMethod.GET)
	public String brief(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		model.put(ViewKeyConstant.admintype, MemberPX.getOne(uid, getCurrUser(request).getUid()).getType().toString());
		return "mybrief";
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/brief", method = RequestMethod.POST)
	public String brief(Map<String, Object> model, @PathVariable String uid, @RequestParam String brief, HttpServletRequest request) {
		Jiazu jiazu = JiazuPX.get(uid);
		if (brief.length() > 150) {
			brief = brief.substring(0, 150);
		}
		if (JiazuPX.updateBrief(uid, brief)) {
			User user = getCurrUser(request);
			SysPX.addJiazuNews(user.getName(), user.getAvatar(), SysConf.format_jiazunews_jiazubrief, "");
			SysPX.addZupuNews(jiazu.getName(), jiazu.getHeadimg(), SysConf.format_zupunews_updatebrief, "");
			model.put(ViewKeyConstant.msg, MsgConstant.saveSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.saveFailed);
		}
		return brief(model, uid, request);
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/history", method = RequestMethod.GET)
	public String history(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		model.put(ViewKeyConstant.admintype, MemberPX.getOne(uid, getCurrUser(request).getUid()).getType().toString());
		return "myhistory";
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/history", method = RequestMethod.POST)
	public String history(Map<String, Object> model, @PathVariable String uid, @RequestParam String desc, HttpServletRequest request) {
		User user = getCurrUser(request);
		if (user == null) {
			return "/login";
		}
		Jiazu jiazu = JiazuPX.get(uid);
		if (desc.length() > 1100) {
			desc = desc.substring(0, 1100);
		}
		if (JiazuPX.updateHistory(uid, desc)) {
			SysPX.addJiazuNews(user.getName(), user.getAvatar(), SysConf.format_jiazunews_jiazubrief, "");
			SysPX.addZupuNews(jiazu.getName(), jiazu.getHeadimg(), SysConf.format_zupunews_updatehistory, "");
			model.put(ViewKeyConstant.msg, MsgConstant.saveSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.saveFailed);
		}
		return history(model, uid, request);
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/member", method = RequestMethod.GET)
	public String member(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		model.put(ViewKeyConstant.adminList, JiazuPX.getAdminListByGroupUid(uid));
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 50);
		List<Member> list = JiazuPX.getMemberListByGroupUid(uid, pager);
		model.put(ViewKeyConstant.userList, list);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		model.put(ViewKeyConstant.admintype, MemberPX.getOne(uid, getCurrUser(request).getUid()).getType().toString());
		return "mymember";
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/member", method = RequestMethod.POST, params="action=list")
	public String member_list(Map<String, Object> model, @PathVariable String uid, @RequestParam String name, HttpServletRequest request) {
		model.put(ViewKeyConstant.resultList, UserPX.getListByMemberSearch(uid, name));
		model.put(ViewKeyConstant.name, name);
		return member(model, uid, request);
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/member", method = RequestMethod.POST, params="action=add")
	public String member_add(Map<String, Object> model, @PathVariable String uid, @RequestParam String[] select, HttpServletRequest request) {
		if (MemberPX.addMembers(uid, select)) {
			SysPX.plusMemberCount_StatisticsGroup(uid, select.length);
			model.put(ViewKeyConstant.msg, MsgConstant.addSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.addFailed);
		}
		return member(model, uid, request);
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/member", method = RequestMethod.POST, params="action=sendmsg")
	public String member_sendmsg(Map<String, Object> model, @PathVariable String uid, @RequestParam String msg, String title, @RequestParam String[] select, HttpServletRequest request) {
		User user = getCurrUser(request);
		if (MessagePX.send(uid, select, user.getUid(), title, msg)) {
			for (String id : select) {
				SysPX.plusUnreadMsgCount_StatisticsGroup(id, "");
			}
			model.put(ViewKeyConstant.msg, MsgConstant.sendSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.sendFailed);
		}
		return member(model, uid, request);
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/member", method = RequestMethod.POST, params="action=del")
	public String member_del(Map<String, Object> model, @PathVariable String uid, @RequestParam String[] select, HttpServletRequest request) {
		Member m = MemberPX.getOne(uid, getCurrUser(request).getUid());
		Member owner = JiazuPX.getOwerByGroupUid(uid);
		if (Integer.valueOf(m.getType().toString()) < Integer.valueOf(EAdmin.True.toString())) {
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.deleteFailedArgs, "非管理员操作"));
		} else if (JiazuPX.getMemberCount(uid) == 1) {
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.deleteFailedArgs, "最后一个用户不能删除"));
		} else if (ArrayUtils.contains(select, m.getUid())) {
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.deleteFailedArgs, "不能删除自己"));
		} else if (owner != null && ArrayUtils.contains(select,  owner.getUseruid())) {
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.deleteFailedArgs, "不能删除创建者"));
		} else if (MemberPX.delMembers(uid, select)) {
			SysPX.plusMemberCount_StatisticsGroup(uid, select.length * -1);
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteFailed);
		}
		return member(model, uid, request);
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/member", method = RequestMethod.POST, params="action=setadmin")
	public String member_setadmin(Map<String, Object> model, @PathVariable String uid, @RequestParam String[] select, HttpServletRequest request) {
		Member m = MemberPX.getOne(uid, getCurrUser(request).getUid());
		if (Integer.valueOf(m.getType().toString()) < Integer.valueOf(EAdmin.True.toString())) {
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.deleteFailedArgs, "非管理员操作"));
		} else if (MemberPX.setAdmin(uid, select)) {
			model.put(ViewKeyConstant.msg, MsgConstant.setSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.setFailed);
		}
		return member(model, uid, request);
	}

	@RequestMapping(value="/myhome/{uid:.{32}}/member", method = RequestMethod.POST, params="action=canceladmin")
	public String member_canceladmin(Map<String, Object> model, @PathVariable String uid, @RequestParam String[] select, HttpServletRequest request) {
		Member m = MemberPX.getOne(uid, getCurrUser(request).getUid());
		Member owner = JiazuPX.getOwerByGroupUid(uid);
		if (Integer.valueOf(m.getType().toString()) < Integer.valueOf(EAdmin.True.toString())) {
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.deleteFailedArgs, "非管理员操作"));
		} else if (JiazuPX.getMemberCount(uid) == 1) {
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.deleteFailedArgs, "最后一个用户不能取消管理员"));
		} else if (owner != null && ArrayUtils.contains(select, owner.getUseruid())) {
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.deleteFailedArgs, "创建者不能取消管理员身份"));
		} else if (MemberPX.cancelAdmin(uid, select)) {
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.doFailed);
		}
		return member(model, uid, request);
	}

	@RequestMapping(value="/admin/dojiazu", method = RequestMethod.GET)
	public String dojiazu(Map<String, Object> model, HttpServletRequest request) {
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 10);
		List<Jiazu> list = JiazuPX.getList(pager);
		model.put(ViewKeyConstant.list, list);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		return "dojiazu";
	}
	
	@RequestMapping(value="/admin/dojiazu/search", method = RequestMethod.GET)
	public String dojiazu_search(Map<String, Object> model, String name, HttpServletRequest request) {
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 10);
		Map<String, Object> map = getParamMap(pager);
		if (StringUtils.isNotEmpty(name)) {
			map.put(MapperConstant.name, name.trim());
		}
		List<Jiazu> list = JiazuPX.getList(map);
		model.put(ViewKeyConstant.list, list);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		model.put(ViewKeyConstant.name, name);
		return "dojiazu";
	}

	@RequestMapping(value="/admin/dojiazu/{uid:.{32}}/del", method = RequestMethod.GET)
	public String dojiazu_delete(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		delete(model, uid, request);
		return dojiazu(model, request);
	}

	@RequestMapping(value="/admin/dojiazu/{uid:.{32}}/active", method = RequestMethod.GET)
	public String active(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (JiazuPX.updateStatus(uid, EStatus.enable)) {
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.doFailed);
		}
		return dojiazu(model, request);
	}
	
	@RequestMapping(value="/admin/dojiazu/{uid:.{32}}/disable", method = RequestMethod.GET)
	public String disable(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (JiazuPX.updateStatus(uid, EStatus.disable)) {
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.doFailed);
		}
		return dojiazu(model, request);
	}

	@RequestMapping(value={"/html/{uid:.{32}}/zupu"}, method = RequestMethod.GET)
	public String dojiazu_viewzupu(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		model.put(ViewKeyConstant.zupu, JiazuPX.getZupu(uid));
		model.put(ViewKeyConstant.resphtml, ZuPuPX.getHtmlTree(uid).replace("<img src=\"", "<img src=\"" + request.getContextPath()));
		return "viewzupu";
	}
}

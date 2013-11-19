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
 * Create at: 2012-9-2 下午2:06:39
 * ============================================================================
 */
package com.jiazu.web.platform.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jiazu.global.constants.MsgConstant;
import com.jiazu.global.constants.SysConf;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.Comment;
import com.jiazu.web.platform.entity.Event;
import com.jiazu.web.platform.entity.Jiazu;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.proxy.CommentPX;
import com.jiazu.web.platform.proxy.EventPX;
import com.jiazu.web.platform.proxy.JiazuPX;
import com.jiazu.web.platform.proxy.SysPX;

/**
 * @author Architect.bian
 *
 */
@Controller
public class EventController extends BaseController {
	
	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public String index(Map<String, Object> model, String num) {
		Pager pager = Pager.getNewInstance(num, 10);
		List<Event> list = EventPX.getList(pager);
		pager.refresh(list);
		model.put(ViewKeyConstant.list, list);
		model.put(ViewKeyConstant.pager, pager);
		return "/event";
	}
	
	@RequestMapping(value = "/event/{uid:.{32}}", method = RequestMethod.GET)
	public String event(Map<String, Object> model, @PathVariable String uid) {
		Event event = EventPX.get(uid);
		List<Event> list = new ArrayList<>();
		if (event != null) {
			list.add(event);
		}
		model.put(ViewKeyConstant.list, list);
		model.put(ViewKeyConstant.pager, new Pager());
		return "/event";
	}

	@RequestMapping(value="/myhome/{uid:.{32}}/event", method = RequestMethod.GET)
	public String myevent(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 5);
		List<Event> list = EventPX.getMyList(uid, pager);
		model.put(ViewKeyConstant.list, list);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		SysPX.clearNewEventList_StatisticsUser(uid, getCurrUser(request).getUid());
		return "myevent";
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/event", method = RequestMethod.POST)
	public String myevent(Map<String, Object> model, @PathVariable String uid, Event event, @RequestParam MultipartFile file, HttpServletRequest request) {
		if (validate(model, event)) {
			if (file.getSize() > 0) {
				int[][] sizes = {{160,160}, {700,700}};
				String[] paths = FileUtil.resizeImage(file, sizes);
				event.setRawimg(paths[0]);
				event.setImg(paths[1]);
				event.setBigimg(paths[2]);
			}
			Jiazu j = JiazuPX.get(uid);
			event.setGroupuid(j.getUid());
			event.setGroupImg(j.getHeadimg());
			event.setGroupName(j.getName());
			User u = getCurrUser(request);
			event.setUseruid(u.getUid());
			event.setUserName(u.getName());
			if (EventPX.add(event)) {
				SysPX.addJiazuNews(u.getName(), u.getAvatar(), SysConf.format_jiazunews_eventadd, "");
				EventPX.addNewEventList_StatisticsUser(uid, event.getUid());
				model.put(ViewKeyConstant.msg, String.format(MsgConstant.publishSuccessArgs, "大事记"));
			} else {
				model.put(ViewKeyConstant.msg, String.format(MsgConstant.publishFailedArgs, "大事记"));
			}
		}
		return myevent(model, uid, request);
	}

	@RequestMapping(value="/myhome/{cuid:.{32}}/event/{uid:.{32}}/del", method = RequestMethod.GET)
	public String myevent_del(Map<String, Object> model, @PathVariable String uid, @PathVariable String cuid, HttpServletRequest request) {
		if (EventPX.delete(uid)) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteFailed);
		}
		return myevent(model, cuid, request);
	}
	
	@RequestMapping(value="/event/comment/{uid:.{32}}", method = RequestMethod.POST)
	public String AddComment(@PathVariable String uid, Map<String, Object> model,Comment comment, HttpServletRequest request) {
		User user = getCurrUser(request);
		comment.setUseruid(user.getUid());
		if (CommentPX.add(comment)) {
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.doFailed);
		}
		return prefixRedirect + index(model, "");
	}
	
	/**
	 * @param model
	 * @param event
	 * @return
	 */
	private boolean validate(Map<String, Object> model, Event event) {
		if (StringUtils.isEmpty(event.getContent().trim())) {
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.err_cannotbeemptyArgs, "大事记"));
			return false;
		}
		if (event.getContent().length() > 300) {
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.err_morethanmaxwordcountArgs, "大事记", 300));
			return false;
		}
		return true;
	}
	

	@RequestMapping(value="/admin/doevent", method = RequestMethod.GET)
	public String doevent(Map<String, Object> model, HttpServletRequest request) {
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 20);
		List<Event> list = EventPX.getList(pager);
		pager.refresh(list);
		model.put(ViewKeyConstant.list, list);
		model.put(ViewKeyConstant.pager, pager);
		return "doevent";
	}
	
	@RequestMapping(value="/admin/doevent/{uid:.{32}}/del", method = RequestMethod.GET)
	public String doevent_del(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (EventPX.delete(uid)) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteFailed);
		}
		return doevent(model, request);
	}
	
	@RequestMapping(value="/admin/doevent/{uid:.{32}}/top", method = RequestMethod.GET)
	public String doevent_top(Map<String, Object> model, @PathVariable String uid, boolean top, HttpServletRequest request) {
		if (EventPX.updateTop(uid, top)) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteFailed);
		}
		return doevent(model, request);
	}
	
}

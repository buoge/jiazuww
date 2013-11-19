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
 * Create at: 2012-11-6 上午10:27:22
 * ============================================================================
 */
package com.jiazu.web.platform.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiazu.global.constants.MsgConstant;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.platform.entity.Comment;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.proxy.CommentPX;

/**
 * @author Architect.bian
 *
 */
@Controller
public class CommentController extends BaseController {
	
	@RequestMapping(value="/myhome/comment/{uid:.{32}}", method = RequestMethod.POST)
	public @ResponseBody Comment AddComment(@PathVariable String uid, Map<String, Object> model,Comment comment, HttpServletRequest request) {
		User user = getCurrUser(request);
		comment.setUseruid(user.getUid());
		comment.setFromuid(uid);
		if (CommentPX.add(comment)) {
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
			return comment;
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.doFailed);
			return null;
		}
	}
	
	@RequestMapping(value={"/myhome/comment/{uid:.{32}}", "/admin/comment/{uid:.{32}}"}, method = RequestMethod.DELETE)
	public @ResponseBody boolean DeleteComment(@PathVariable String uid, Map<String, Object> model, HttpServletRequest request) {
		//User user = getCurrUser(request);
		if (CommentPX.delete(uid)) {
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
			return true;
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.doFailed);
			return false;
		}
	}
}

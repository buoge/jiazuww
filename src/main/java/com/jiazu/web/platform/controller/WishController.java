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
 * Create at: 2012-9-2 下午12:58:35
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

import com.jiazu.global.constants.MsgConstant;
import com.jiazu.global.constants.SysConf;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.entity.Wish;
import com.jiazu.web.platform.proxy.SysPX;
import com.jiazu.web.platform.proxy.WishPX;

/**
 * @author Architect.bian
 *
 */
@Controller
public class WishController extends BaseController {

	@RequestMapping(value="/myhome/{uid:.{32}}/wish", method = RequestMethod.GET)
	public String mywish(Map<String, Object> model, @PathVariable String uid) {
		model.put(ViewKeyConstant.list, WishPX.getList(uid));
		return "mywish";
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/wish", method = RequestMethod.POST)
	public String mywish(Map<String, Object> model, @PathVariable String uid, Wish wish, HttpServletRequest request) {
		if (validate(model, wish)) {
			User user = getCurrUser(request);
			if (WishPX.add(wish)) {
				SysPX.addJiazuNews(user.getName(), user.getAvatar(), SysConf.format_jiazunews_wishadd, "");
				model.put(ViewKeyConstant.msg, String.format(MsgConstant.sendSuccessArgs, "祝福"));
			} else {
				model.put(ViewKeyConstant.msg, String.format(MsgConstant.sendFailedArgs, "祝福"));
			}
		}
		return mywish(model, uid);
	}

	private boolean validate(Map<String, Object> model, Wish wish) {
		if (StringUtils.isEmpty(wish.getWish().trim())) {
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.err_cannotbeemptyArgs, "祝福语"));
			return false;
		}
		return true;
	}
	
	@RequestMapping(value="/admin/dowish", method = RequestMethod.GET)
	public String dowish(Map<String, Object> model, HttpServletRequest request) {
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 20);
		List<Wish> list = WishPX.getList(pager);
		model.put(ViewKeyConstant.list, list);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		return "dowish";
	}
	

	@RequestMapping(value="/admin/dowish/{uid:.{32}}/del", method = RequestMethod.GET)
	public String dowish(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (WishPX.delete(uid)) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.deleteFailed);
		}
		return dowish(model, request);
	}
}

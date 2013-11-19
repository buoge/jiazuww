/**
 * 用户拦截器
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
 * Create at: 2012-8-4 下午4:40:09
 * ============================================================================
 */
package com.jiazu.core.interceptors;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.global.utility.WebUtil;
import com.jiazu.web.platform.entity.Jiazu;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.proxy.EduPX;
import com.jiazu.web.platform.proxy.EventPX;
import com.jiazu.web.platform.proxy.JiazuPX;
import com.jiazu.web.platform.proxy.MessagePX;

/**
 * @author Architect.bian
 * 
 */
public class UserHomeInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (WebUtil.isNotAjaxRequest(request)) {
			InitPageVar(request, modelAndView);
		}
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * @param request
	 * @param modelAndView 
	 */
	private void InitPageVar(HttpServletRequest request, ModelAndView modelAndView) {
		if (request.getAttribute(ViewKeyConstant.me) != null) {
			User user = (User)request.getAttribute(ViewKeyConstant.me);
			Map<String, Object> model = modelAndView.getModel();
			String useruid = user.getUid();
			List<Jiazu> jiazuList = JiazuPX.getList(useruid);
			String currUid = null;
			Matcher m = Pattern.compile("/myhome/(.{32})").matcher(request.getRequestURI());
			if (model.get(ViewKeyConstant.currUid) != null) {
				currUid = model.get(ViewKeyConstant.currUid).toString();
			} else if (m.find() && !StrUtil.isContainAny(request.getRequestURI(), "msg", "/myhome/jiazu", "c2c", "order", "account")) {// (Pattern.matches(".*/myhome/(.{32})\\S*", request.getRequestURI())) {
				currUid = m.group(1);
				if (!JiazuPX.isGroupMember(currUid, useruid)) {
					modelAndView.setViewName("error");
					model.put(ViewKeyConstant.errormsg, "您没有还不是本家族成员");
				}
			} else {
//				if (StringUtils.isNotEmpty(user.getGroupuid())) {
//					currUid = user.getGroupuid();
//				} else 
				if (jiazuList != null && jiazuList.size() > 0) {
					currUid = jiazuList.get(0).getId();
				}
			}
			if (StringUtils.isNotEmpty(currUid)) {
				model.put(ViewKeyConstant.currUid, currUid);
				request.setAttribute(ViewKeyConstant.bean, JiazuPX.get(currUid));
				request.setAttribute(ViewKeyConstant.newEduCount, EduPX.getNewEduCount(currUid, useruid));
				request.setAttribute(ViewKeyConstant.newEventCount, EventPX.getNewEventCount(currUid, useruid));
				request.setAttribute(ViewKeyConstant.jiazuMemberCount, JiazuPX.getMemberCount(currUid));
				request.setAttribute(ViewKeyConstant.jiazuList, jiazuList);
			}
			request.setAttribute(ViewKeyConstant.newMsgCount, MessagePX.getNewMsgCount(useruid));
		}
	}

}

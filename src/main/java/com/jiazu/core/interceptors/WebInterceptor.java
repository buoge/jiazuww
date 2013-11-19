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

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jiazu.core.cache.rule.SessionRule;
import com.jiazu.global.constants.MappingConf;
import com.jiazu.global.constants.SessConstant;
import com.jiazu.global.constants.SysConf;
import com.jiazu.global.constants.SysConstant;
import com.jiazu.global.constants.UserConstant;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.global.factory.SessionFactory;
import com.jiazu.global.utility.CookieUtil;
import com.jiazu.global.utility.DateUtil;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.global.utility.WebUtil;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.proxy.ContentPX;
import com.jiazu.web.platform.proxy.UserPX;

/**
 * @author Architect.bian
 * 
 */
public class WebInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		/*
		 * 首先调用isLogin 将user对象添加到request中
		 */
		if(!isLogin(request) && isLoginNeedUrl(request.getRequestURI())) {
			//CookieUtil.clearAll(request, response);
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		} else if (isLogoutUrl(request.getRequestURI()) && isLogin(request)) {
			UserPX.offline(new SessionRule(request, SessConstant.USER, SysConf.Expire_UserSession).toString());
			CookieUtil.clearAll(request, response);
			request.removeAttribute(ViewKeyConstant.me);
		} else {
//			Cookie cookie = CookieUtil.getCookie(request, SysConstant.UID);
//			if (cookie != null && StringUtils.isNotEmpty(cookie.getValue())) {
//				String useruid = cookie.getValue();
//				User user = UserPX.getUser(useruid);
//				request.setAttribute(ViewKeyConstant.user, user);
//			}
		}
		return super.preHandle(request, response, handler);
	}

	/**
	 * @param requestURI
	 * @return
	 */
	private boolean isLogoutUrl(String requestURI) {
		String[] strs = MappingConf.mappingProps.get(MappingConf.USER_LOGOUT_URL).toString().split(",");
		if (StrUtil.isMatchAny(requestURI, strs)) {
			return true;
		}
		return false;
	}

	/**
	 * @param requestURI
	 * @return
	 */
	private boolean isLoginNeedUrl(String requestURI) {
		String[] strs = MappingConf.getNeedLoginUrls();
		if (StrUtil.isMatchAny(requestURI, strs)) {
			return true;
		}
		return false;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (WebUtil.isNotAjaxRequest(request)) {
			if (modelAndView != null) {
				if (modelAndView.getViewName().equals(UserConstant.viewName_RegisterSuccess) || modelAndView.getViewName().equals(UserConstant.viewName_LoginSuccess)) {
					if (isLogin(request)) {
						String sid = WebUtil.getValueFromAttributeOrCookie(request, SysConstant.SESSION_ID);
						String uid = WebUtil.getValueFromAttributeOrCookie(request, SysConstant.UID);
						//CookieUtil.addCookie(response, SysConstant.SESSION_ID, sid);//写cookie,作为登录的标志
						request.setAttribute(SysConstant.SESSION_ID, sid);//js写cookie当前窗口有效
						CookieUtil.addCookie(response, SysConstant.UID, uid);//用户UID
					}
				}
			}
			InitPageVar(request);
		}
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * @param request
	 */
	private void InitPageVar(HttpServletRequest request) {
		if (!isAdminUrl(request.getRequestURI())) {
			request.setAttribute(ViewKeyConstant.logo, ContentPX.getLogoContent());
			request.setAttribute(ViewKeyConstant.notices, ContentPX.getNotices());
			request.setAttribute(ViewKeyConstant.hotsearchList, ContentPX.getHotSearch());
		}
	}

	/**
	 * @param request
	 * @return
	 */
	private boolean isAdminUrl(String requestURI) {
		String[] strs = MappingConf.getAdminUrls();
		if (StrUtil.isMatchAny(requestURI, strs)) {
			return true;
		}
		return false;
	}

	/**
	 * @param request 
	 * @return
	 */
	private boolean isLogin(HttpServletRequest request) {
		HttpSession sess = SessionFactory.getHttpSession();

		User user = (User) sess.getAttribute(new SessionRule(request, SessConstant.USER, SysConf.Expire_UserSession).toString());
		if (user == null) {
			String userId = request.getParameter(UserConstant.LOGINID);
			String pwd = request.getParameter(UserConstant.PWD);
			if (StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(pwd)) {
				User u = UserPX.getUser(userId, pwd);
				if (u != null) {
					request.setAttribute(SysConstant.SESSION_ID, createSessionID(u));
					request.setAttribute(SysConstant.UID, u.getUid());
					UserPX.online(new SessionRule(request, SessConstant.USER, SysConf.Expire_UserSession).toString(), u);//使在线
				}
			} else {
				return false;
			}
		}
		request.setAttribute(ViewKeyConstant.me, user);
		return true;
	}

	/**
	 * 生成登录序列号
	 * @param u
	 * @return
	 */
	private String createSessionID(User u) {
		int random = (new Random(DateUtil.Now())).nextInt(u.getUid().length() - SysConf.SessionIDLength - 1);
		return DateUtil.Now() + u.getUid().substring(random, random + SysConf.SessionIDLength) ;
	}

}

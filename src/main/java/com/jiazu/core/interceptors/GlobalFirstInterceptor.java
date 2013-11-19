/**
 * 所有拦截器中第一个拦截器
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
 * Create at: 2012-8-15 下午10:02:14
 * ============================================================================
 */
package com.jiazu.core.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jiazu.global.constants.SysConstant;
import com.jiazu.global.utility.CookieUtil;
import com.jiazu.global.utility.DateUtil;
import com.jiazu.global.utility.StrUtil;

/**
 * @author Architect.bian
 *
 */
public class GlobalFirstInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Cookie cookie = CookieUtil.getCookie(request, SysConstant.SESSION_ID);
		if (cookie == null || StringUtils.isEmpty(cookie.getValue())) {
			CookieUtil.addCookie(response, SysConstant.SESSION_ID, DateUtil.Now() + StrUtil.getRandomString(SysConstant.SESSION_ID_LEN));
			request.setAttribute(SysConstant.SESSION_ID, DateUtil.Now() + StrUtil.getRandomString(SysConstant.SESSION_ID_LEN));//第一次页面访问的时候cookie没法进行页面传递所以使用rquest.attribute
		}
		return super.preHandle(request, response, handler);
	}
}

/**
 * Web工具类，提供web过滤 验证等等功能
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
 * Create at: 2012-8-5 上午11:06:21
 * ============================================================================
 */
package com.jiazu.global.utility;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Architect.bian
 *
 */
public class WebUtil {

	/**
	 * @param request
	 * @param sessionId
	 * @return
	 */
	public static String getValueFromAttributeOrCookie(HttpServletRequest request, String key) {
		Object attr = request.getAttribute(key);
		if (attr != null) {
			return request.getAttribute(key).toString();
		} else {
			Cookie cookie = CookieUtil.getCookie(request, key);
			if (cookie != null) {
				return cookie.getValue();
			} else {
				return "";
			}
		}
	}

	/**
	 * @param request
	 * @return
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		if (StringUtils.isEmpty(request.getHeader("x-requested-with"))) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * @param request
	 * @return
	 */
	public static boolean isNotAjaxRequest(HttpServletRequest request) {
		return !isAjaxRequest(request);
	}

}

/**
 * Cookie工具类
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
 * Create at: 2012-8-5 上午10:36:43
 * ============================================================================
 */
package com.jiazu.global.utility;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Architect.bian
 * 
 */
public class CookieUtil {

	public static void addCookie(HttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(3600 * 24 * 365);
		cookie.setPath("/");

		response.addCookie(cookie);
	}

	public static void addCookie(HttpServletResponse response, String name, String value, int age) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(age);
		cookie.setPath("/");

		response.addCookie(cookie);
	}

	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];

				if (c.getName().equals(name)) {
					return c;
				}
			}
		}

		return null;
	}

	/**
	 * @param request
	 * @param response
	 */
	public static void clearAll(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		try {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = new Cookie(cookies[i].getName(), null);
				cookie.setMaxAge(0);
				cookie.setPath("/");// 根据你创建cookie的路径进行填写
				response.addCookie(cookie);
			}
		} catch (Exception ex) {
			System.out.println("清空Cookies发生异常！");
		}
	}

	/**
	 * @param request
	 * @param uid
	 */
	public static void removeCookie(HttpServletRequest request, String name) {
		Cookie cookie = getCookie(request, name);
		cookie.setValue(null);
		cookie.setMaxAge(0);
	}
}

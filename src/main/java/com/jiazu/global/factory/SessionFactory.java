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
 * Create at: 2012-8-15 下午8:52:44
 * ============================================================================
 */
package com.jiazu.global.factory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jiazu.core.cache.Session;
import com.jiazu.core.cache.impl.SessionImpl;

/**
 * @author Architect.bian
 *
 */
@Component
@Scope("singleton")
public final class SessionFactory {
	
	private static HttpSession session = null;
	
	public static HttpSession getHttpSession() {
		if (session == null) {
			session = new SessionImpl();
		}
		return session;
	}

	/**
	 * 通过request获得session，设置protected以后扩展用
	 * @param request
	 * @return
	 */
	protected static HttpSession getHttpSession(HttpServletRequest request) {
		return request.getSession();
	}
	
//	@Autowired
	public void setSession(Session sess) {
		session = sess;
	}
}

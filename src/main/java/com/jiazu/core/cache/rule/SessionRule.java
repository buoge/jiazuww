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
 * Create at: 2012-8-15 下午8:22:38
 * ============================================================================
 */
package com.jiazu.core.cache.rule;

import javax.servlet.http.HttpServletRequest;

import com.jiazu.global.constants.CacheConf;
import com.jiazu.global.constants.SysConstant;
import com.jiazu.global.utility.WebUtil;

/**
 * @author Architect.bian
 *
 */
public class SessionRule extends SessionSuperRule {

	protected static String p = "sid";

	@SuppressWarnings("unused")
	private SessionRule() {
		this(p, "", 0);
	}
	
	/**
	 * 
	 * @param p session的ID，如从cookie中获取的sid
	 * @param k 键
	 */
	public SessionRule(String sid, String k) {
		this(sid, k, 0);
	}

	/**
	 * 
	 * @param k 键值
	 * @param exp 过期时间
	 */
	public SessionRule(String sid, String k, int exp) {
		super(k, exp);
		super.path += CacheConf.SPLITTER_PATH + sid;
		refreshCachId();
	}

	/**
	 * 通过request获得cookie或者attribute中的值，拼接成cachekey
	 * @param request
	 * @param sessUserkey
	 */
	public SessionRule(HttpServletRequest request, String k) {
		this(WebUtil.getValueFromAttributeOrCookie(request, SysConstant.SESSION_ID), k, 0);
	}

	/**
	 * @param request
	 * @param user
	 * @param expire_UserSession
	 */
	public SessionRule(HttpServletRequest request, String k, int expire_UserSession) {
		this(WebUtil.getValueFromAttributeOrCookie(request, SysConstant.SESSION_ID), k, expire_UserSession);
	}
}

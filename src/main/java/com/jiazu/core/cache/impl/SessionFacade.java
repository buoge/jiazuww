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
 * Create at: 2012-8-12 下午2:31:39
 * ============================================================================
 */
package com.jiazu.core.cache.impl;

import com.jiazu.core.cache.Engine;
import com.jiazu.core.cache.Rule;
import com.jiazu.core.cache.rule.SessionSuperRule;

/**
 * @author Architect.bian
 *
 */
public class SessionFacade extends CacheFacade {
	
	private static Engine getEngine() {
//		int start = (new SessionSuperRule()).getCacheId().length();
//		int end = k.indexOf(CacheConf.SPLITTER_KEY);
//		Rule rule = new SessionRule(StringUtils.substring(k, start, end), k);
		Rule rule = new SessionSuperRule();
		return getEngine(rule);
	}
	
	public static Object get(String k) throws Exception {
		return getEngine().get(k);
	}

	/**
	 * @param name
	 * @param value
	 */
	public static void set(String key, Object value) {
		getEngine().set(key, value);
	}

	/**
	 * @param name
	 */
	public static void remove(String key) {
		getEngine().remove(key);
	}
}

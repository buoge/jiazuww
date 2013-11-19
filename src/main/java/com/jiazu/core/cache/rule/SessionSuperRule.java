/**
 * Session key的规则
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
 * Create at: 2012-8-15 下午8:15:43
 * ============================================================================
 */
package com.jiazu.core.cache.rule;

import com.jiazu.core.cache.BaseRule;

/**
 * @author Architect.bian
 *
 */
public class SessionSuperRule extends BaseRule {
	
	protected static String p = "s";
	
	public SessionSuperRule() {
		this("", 0);
	}

	public SessionSuperRule(String k) {
		this("", 0);
	}
	
	/**
	 * @param k
	 * @param exp 单位为妙 s
	 */
	public SessionSuperRule(String k, int exp) {
		super(k, exp);
		super.path += p;
		refreshCachId();
	}
}

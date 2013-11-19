/**
 * user缓存对象的缓存key的生成规则
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
 * Create at: 2012-8-12 下午2:20:30
 * ============================================================================
 */
package com.jiazu.core.cache.rule;

import org.springframework.stereotype.Component;

import com.jiazu.core.cache.BaseRule;

/**
 * @author Architect.bian
 *
 */
@Component
public class GroupRule extends BaseRule {

	protected static String p = "groups";
	
	public GroupRule() {
		this("", 0);
	}
	
	/**
	 * @param k
	 */
	public GroupRule(String k) {
		this(k, 0);
	}

	/**
	 * @param k
	 */
	public GroupRule(String k, int exp) {
		super(k, exp);
		super.path += p;
		refreshCachId();
	}

}

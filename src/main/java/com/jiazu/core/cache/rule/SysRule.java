/**
 * 系统对象的缓存key的生成规则
 * ============================================================================
 * 声明：北京旺族互联网科技有限公司版权所有
 * ----------------------------------------------------------------------------
 * Official Website: http://www.jiazuww.com
 * ----------------------------------------------------------------------------
 * Copyright: ? 2012 JiaZuWW All Rights Reserved.
 * ----------------------------------------------------------------------------
 * @version: 1.0
 * ----------------------------------------------------------------------------
 * @author: Greatbsky
 * ----------------------------------------------------------------------------
 * @email: verygreat@126.com
 * ----------------------------------------------------------------------------
 * Create at: 2012-9-10 下午4:17:57
 * ============================================================================
 */
package com.jiazu.core.cache.rule;

import org.springframework.stereotype.Component;

import com.jiazu.core.cache.BaseRule;

/**
 * @author GreatHost
 *
 */
@Component
public class SysRule extends BaseRule {
	
	protected static String p = "sys";
	
	public SysRule() {
		this("", 0);
	}

	/**
	 * @param k
	 */
	public SysRule(String k) {
		this(k, 0);
	}

	/**
	 * @param k
	 */
	public SysRule(String k, int exp) {
		super(k, exp);
		super.path += p;
		refreshCachId();
	}
}

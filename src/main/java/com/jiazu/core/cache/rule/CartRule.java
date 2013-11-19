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

import com.jiazu.global.constants.CacheConf;

/**
 * @author Architect.bian
 *
 */
@Component
public class CartRule extends UserRule {

	protected static String p = "cart";
	
	public CartRule() {
		this("", 0);
	}
	
	/**
	 * @param k
	 */
	public CartRule(String k) {
		this(k, 0);
	}

	/**
	 * @param k
	 */
	public CartRule(String k, int exp) {
		super(k, exp);
		super.path += CacheConf.SPLITTER_PATH + p;
		refreshCachId();
	}

}

/**
 * 在线用户缓存键生成规则
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
 * Create at: 2012-8-14 上午7:17:40
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
public class UserStatRule extends UserRule {
	
	protected static String p = "stat";

	public UserStatRule() {
		this("", 0);
	}
	
	/**
	 * @param k
	 */
	public UserStatRule(String k) {
		this(k, 0);
	}

	/**
	 * 
	 * @param k 键值
	 * @param exp 过期时间
	 */
	public UserStatRule(String k, int exp) {
		super(k, exp);
		super.path += CacheConf.SPLITTER_PATH + p;
		refreshCachId();
	}

}

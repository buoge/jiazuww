/**
 * Cache Key的生成规则
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
 * Create at: 2012-8-12 下午2:18:42
 * ============================================================================
 */
package com.jiazu.core.cache;

import java.util.Set;

/**
 * @author Architect.bian
 *
 */
public interface Rule {
	
	/**
	 * @return
	 */
	String getCacheId();
	
	/**
	 * @return
	 */
	String getKey();
	
	/**
	 * @return
	 */
	void setKey(String k);

	/**
	 * @return
	 */
	void addKey(String k);

	/**
	 * @return
	 */
	Set<String> getKeys();
	
	/**
	 * @return
	 */
	String getPath();

	/**
	 * 
	 * @return
	 */
	int getExpire();
	
	/**
	 * 
	 * @param exp
	 * @return
	 */
	void setExpire(int exp);

}

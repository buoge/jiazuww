/**
 * 所有不同cache服务器的接口
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
 * Create at: 2012-8-12 下午2:12:00
 * ============================================================================
 */
package com.jiazu.core.cache;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author Architect.bian
 * 
 */
public interface Engine {

	/**
	 * @return
	 */
	boolean init();

	/**
	 * @param servers
	 * @param weights
	 * @return
	 */
	boolean init(String servers, String weights);

	/**
	 * @return
	 */
	boolean stop();

	/**
	 * @param key
	 * @param value
	 * @return
	 */
	boolean set(String key, Object value);

	/**
	 * @param key
	 * @param expire
	 * @param value
	 * @return
	 */
	boolean set(String key, int expire, Object value);

	/**
	 * @param key
	 * @return
	 * @throws Exception
	 */
	Object get(String key) throws Exception;

	/**
	 * @param key
	 * @param newExpire
	 * @return
	 * @throws Exception
	 */
	Object get(String key, int newExpire) throws Exception;

	/**
	 * @param keys
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> get(Collection<String> keys) throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	Set<String> getKeys() throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	Collection<Object> getValues() throws Exception;

	/**
	 * @param key
	 * @return
	 */
	boolean remove(String key);

	/**
	 * @return
	 * @throws Exception
	 */
	int size() throws Exception;

	/**
	 * 使缓存失效，但并不即时清楚
	 * @return
	 */
	boolean flushAll();

	boolean clearAll();

}

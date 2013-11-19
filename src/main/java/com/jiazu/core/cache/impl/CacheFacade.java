/**
 * 不同engine的门面类
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
 * Create at: 2012-8-12 下午2:24:02
 * ============================================================================
 */
package com.jiazu.core.cache.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.jiazu.core.cache.Engine;
import com.jiazu.core.cache.Rule;
import com.jiazu.global.constants.CacheConf;

/**
 * @author Architect.bian
 * 
 */
public class CacheFacade {

	private static Map<String, Engine> pool = new HashMap<String, Engine>();

	/**
	 * @param rule
	 * @return
	 */
	protected static Engine getEngine(Rule rule) {
		if (pool.containsKey(rule.getCacheId())) {
			return pool.get(rule.getCacheId());
		} else {
			Engine engine = new MemcacheEngine();// 可重构成工厂模式
			String conf = (String) CacheConf.cacheProps.get(rule.getCacheId());
			String[] strs = conf.split(",");
			String servers = strs.length > 1 ? strs[1] : CacheConf.DEFAULT_SERVER;
			String weights = strs.length > 2 ? strs[2] : "";
			engine.init(servers, weights);
			pool.put(rule.getCacheId(), engine);
		}
		return pool.get(rule.getCacheId());
	}

	/**
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean set(Rule rule, Object value) {
		if (rule.getExpire() > 0) {
			return getEngine(rule).set(rule.getKey(), rule.getExpire(), value);
		}
		return getEngine(rule).set(rule.getKey(), value);
	}

	/**
	 * 通过rule获得对应的值
	 * keys大于一个时，说明是多个key，则获取所有的Key对应的值返回：Map<String, Object>
	 * 若key只有一个，则返回单个值：Object
	 * 若Expire大于0，则重新设置过期时间
	 * @param rule
	 * @return
	 * @throws Exception
	 */
	public static Object get(Rule rule) throws Exception {
		if (rule.getKeys().size() == 1) {
			if (rule.getExpire() > 0) {
				return getEngine(rule).get(rule.getKey(), rule.getExpire());
			}
		} else {
			return getEngine(rule).get(rule.getKeys());
		}
		return getEngine(rule).get(rule.getKey());
	}
	
	public static Set<String> getKeys(Rule rule) throws Exception {
		return getEngine(rule).getKeys();
	}
	
	public static Collection<Object> getValues(Rule rule) throws Exception {
		return getEngine(rule).getValues();
	}
	
	public static boolean remove(Rule rule) {
		if (rule.getKeys().size() == 1) {
			return getEngine(rule).remove(rule.getKey());
		} else {
			Set<String> ks = rule.getKeys();
			Engine engine = getEngine(rule);
			for (String k : ks) {
				engine.remove(k);
			}
			return true;
		}
	}
	
	public static int size(Rule rule) throws Exception {
		return getEngine(rule).size();
	}
	
	public static boolean flushAll(Rule rule) {
		return getEngine(rule).flushAll();
	}

}

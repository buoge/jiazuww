/**
 * Java虚拟机内置的缓存，使用static field实现
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
 * Create at: 2012-8-13 下午8:42:49
 * ============================================================================
 */
package com.jiazu.core.cache.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jiazu.core.cache.Engine;

/**
 * @author Architect.bian
 *
 */
@Component
public class JvmCacheEngine implements Engine {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	private Map<String, Object> cache = new HashMap<String, Object>();
	
	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Engine#init()
	 */
	@Override
	public boolean init() {
		return this.init(null, null);
	}

	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Engine#init(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean init(String servers, String weights) {
		this.cache = new HashMap<String, Object>();
		log.debug("Jvm Cache Engine started   Servers:" + servers + " Weights:" + weights);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Engine#stop()
	 */
	@Override
	public boolean stop() {
		this.cache = null;
		return true;
	}

	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Engine#set(java.lang.String, java.lang.Object)
	 */
	@Override
	public boolean set(String key, Object value) {
		this.cache.put(key, value);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Engine#set(java.lang.String, int, java.lang.Object)
	 * 后期可实现超时清楚处理，hashmap中新加一个key，
	 * 如20120909105730记录应该清除的时间,
	 * 如果存在此key则清除对应value（另外一个key）的对应的值
	 */
	@Override
	public boolean set(String key, int expire, Object value) {
		this.cache.put(key, value);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Engine#get(java.lang.String)
	 */
	@Override
	public Object get(String key) throws Exception {
		return this.cache.get(key);
	}

	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Engine#get(java.lang.String, int)
	 */
	@Override
	public Object get(String key, int newExpire) throws Exception {
		return this.cache.get(key);
	}

	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Engine#get(java.util.Collection)
	 */
	@Override
	public Map<String, Object> get(Collection<String> keys) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Engine#getKeys()
	 */
	@Override
	public Set<String> getKeys() throws Exception {
		return this.cache.keySet();
	}

	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Engine#getValues()
	 */
	@Override
	public Collection<Object> getValues() throws Exception {
		Collection<Object> set = new HashSet<Object>();
		Set<String> keys = this.cache.keySet();
		for (String key : keys) {
			set.add(this.get(key));
		}
		return set;
	}

	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Engine#remove(java.lang.String)
	 */
	@Override
	public boolean remove(String key) {
		this.cache.remove(key);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Engine#size()
	 */
	@Override
	public int size() throws Exception {
		return this.cache.size();
	}

	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Engine#flushAll()
	 */
	@Override
	public boolean flushAll() {
		this.clearAll();
		return true;
	}

	@Override
	public boolean clearAll() {
		this.cache.clear();
		return true;
	}

}

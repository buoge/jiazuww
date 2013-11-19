/**
 * 使用memcached做缓存
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
 * Create at: 2012-8-12 下午2:15:45
 * ============================================================================
 */
package com.jiazu.core.cache.impl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.KeyIterator;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.utils.AddrUtil;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jiazu.core.cache.Engine;
import com.jiazu.global.constants.CacheConf;
import com.jiazu.global.utility.StrUtil;

/**
 * @author Architect.bian TODO 需要记录日志，异常不要抛出，修改返回结果，成功为true否则为false
 */
@SuppressWarnings("deprecation")
@Component
public class MemcacheEngine implements Engine {

	Logger log = LoggerFactory.getLogger(this.getClass());

	private MemcachedClient client;

	private int timeout = 3000;

	private List<InetSocketAddress> servers;

	private int[] weights;

	public int getTimeout() {
		return timeout;
	}

	// @Value("#{cache.timeout}")
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jiazu.core.cache.Engine#init()
	 */
	@Override
	public boolean init() {
		return init(CacheConf.DEFAULT_SERVER, CacheConf.DEFAULT_WEIGHT);
	}

	/**
	 * memcache缓存服务器初始化
	 * 
	 * @param servers
	 * @param weights
	 * @return 成功true 失败false
	 */
	@Override
	public boolean init(String servers, String weights) {
		this.servers = AddrUtil.getAddresses(servers);
		this.weights = StrUtil.splitToIntArray(weights);
		if (this.servers.size() > this.weights.length) {
			int offset = this.servers.size() - this.weights.length;
			for (int i = 0; i < offset; i++) {
				this.weights = ArrayUtils.add(this.weights, 1);
			}
		}
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(this.servers, this.weights);
		// MemcachedClientBuilder builder = new
		// XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:12000 localhost:12001"),new
		// int[]{1,3});
		// builder.setCommandFactory(new BinaryCommandFactory());//use binary
		// protocol
		builder.setSessionLocator(new KetamaMemcachedSessionLocator());
		// builder.setConnectionPoolSize(5);
		try {
			client = builder.build();
//			client.flushAll();
		} catch (IOException e) {
			log.error(e.getMessage());
			return false;
		}
		log.debug("MemcacheEngine started   Servers:" + servers + " Weights:" + weights);
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jiazu.core.cache.Engine#stop()
	 */
	@Override
	public boolean stop() {
		try {
			client.shutdown();
		} catch (IOException e) {
			log.error(e.getMessage());
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jiazu.core.cache.Engine#set(java.lang.String, java.lang.Object)
	 */
	@Override
	public boolean set(String key, Object value) {
		return set(key, 0, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jiazu.core.cache.Engine#set(java.lang.String, int,
	 * java.lang.Object)
	 */
	@Override
	public boolean set(String key, int expire, Object value) {
		try {
			client.set(key, expire, value, timeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			log.error(e.getMessage());
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jiazu.core.cache.Engine#get(java.lang.String)
	 */
	@Override
	public Object get(String key) throws Exception {
		try {
			return client.get(key);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public Object get(String key, int newExpire) throws Exception {
		Object value = null;
		try {
			value = this.get(key);
			client.set(key, newExpire, value);
			//TODO replace with touch??
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return value;
		// return client.getAndTouch(key, newExp);
	}

	@Override
	public Map<String, Object> get(Collection<String> keys) throws Exception {
		try {
			return client.get(keys);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jiazu.core.cache.Engine#getKeys()
	 */
	@Override
	public Set<String> getKeys() throws Exception {
		Set<String> set = new HashSet<String>();
		try {
			for (InetSocketAddress address : servers) {
				KeyIterator it = client.getKeyIterator(address);
				while (it.hasNext()) {
					String k = it.next();
					set.add(k);
				}
			}
			if(set.size() == 4) {
				System.out.println(set.toString());
			}
		} catch (MemcachedException | TimeoutException | InterruptedException e) {
			log.error(e.getMessage());
			throw e;
		}
		return set;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jiazu.core.cache.Engine#getValues()
	 */
	@Override
	public Collection<Object> getValues() throws Exception {
		Set<String> keys;
		Collection<Object> values = new ArrayList<Object>();
		try {
			keys = this.getKeys();
			values.addAll(client.get(keys).values());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return values;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jiazu.core.cache.Engine#remove(java.lang.String)
	 */
	@Override
	public boolean remove(String key) {
		try {
			client.delete(key);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			log.error(e.getMessage());
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jiazu.core.cache.Engine#size()
	 */
	@Override
	public int size() throws Exception {
//		try {
//			//Map<InetSocketAddress, Map<String, String>> result = client.getStats();
//		} catch (MemcachedException | InterruptedException | TimeoutException e) {
//			log.error(e.getMessage());
//			throw e;
//		}
		// TODO 通过stats获得key的数量
		return 0;
	}
	
	@Override
	public boolean flushAll() {
		try {
			client.flushAll();
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			log.error(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean clearAll() {
		try {
			Set<String> s = this.getKeys();
			for (String k : s) {
				this.remove(k);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
		return true;
	}

}

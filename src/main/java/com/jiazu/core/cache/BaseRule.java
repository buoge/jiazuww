/**
 * Rule抽象类封装共用方法等等
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
 * Create at: 2012-8-13 下午10:09:21
 * ============================================================================
 */
package com.jiazu.core.cache;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.jiazu.global.constants.CacheConf;

/**
 * @author Architect.bian
 * /users/online:uidxxxxxx
 * CacheId:/users
 * path:/users/online
 * key:/users/online:uidxxxxxx
 * toString:/users/online:uidxxxxxx
 */
@Component
public abstract class BaseRule implements Rule {

	protected String cacheId = "/";

	protected String key = "";
	
	protected String path = "/";
	
	protected int expire = -1;

	private Set<String> keys = new HashSet<String>();

	public BaseRule() {
		this("");
	}

	public BaseRule(String k) {
		this.setKey(k);
		//refreshCachId();
	}

	public BaseRule(String k, int exp) {
		this.setKey(k);
		this.expire = exp;
		//refreshCachId();
	}

	public void refreshCachId() {
		if(CacheConf.cacheProps != null && CacheConf.cacheProps.containsKey(this.getPath())) {
			String conf = (String) CacheConf.cacheProps.get((this.getPath()));
			boolean enable = Boolean.parseBoolean(conf.split(",")[0]);
			if (enable) {
				this.cacheId = this.getPath();
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Rule#getCacheId()
	 */
	@Override
	public String getCacheId() {
		return this.cacheId ;
	}

	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Rule#getKey()
	 */
	@Override
	public String getKey() {
		return this.path + CacheConf.SPLITTER_KEY + this.key;
	}

	@Override
	public void setKey(String k) {
		this.key = k;
	}

	@Override
	public void addKey(String k) {
		if (this.keys.size() == 0) {
			this.keys.add(this.path + CacheConf.SPLITTER_KEY + key);
		}
		this.keys.add(this.path + CacheConf.SPLITTER_KEY + k);
	}

	@Override
	public Set<String> getKeys() {
		if (this.keys.size() == 0) {
			this.keys.add(this.path + CacheConf.SPLITTER_KEY + key);
		}
		return this.keys;
	}
	
	/* (non-Javadoc)
	 * @see com.jiazu.core.cache.Rule#getPath()
	 */
	@Override
	public String getPath() {
		return this.path;
	}

	@Override
	public String toString() {
		return this.getKey();
	}

	@Override
	public int getExpire() {
		return this.expire;
	}

	@Override
	public void setExpire(int exp) {
		this.expire = exp;
	}

	@Override
	public int hashCode() {
		return StringUtils.isEmpty(this.getKey()) ? System.identityHashCode(this) : this.getKey().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this.hashCode() == o.hashCode()) {
			return true;
		} else {
			return false;
		}
	}
}

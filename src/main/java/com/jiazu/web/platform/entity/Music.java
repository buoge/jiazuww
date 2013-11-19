/**
 * 
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
 * Create at: 2012-12-27 下午8:23:01
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
public class Music extends BaseEntity {

	private static final long serialVersionUID = -9034589024144022904L;
	
	private String name;
	private String path;
	
	public Music() {}
	/**
	 * @param name2
	 * @param upload
	 */
	public Music(String name, String path) {
		this.setUid(GlobalUtil.getUUID());
		this.name = name;
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

}

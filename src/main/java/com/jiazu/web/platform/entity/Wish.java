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
 * Create at: 2012-8-17 上午8:30:34
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EWish;
import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
@Scope("prototype")
public class Wish extends BaseEntity {

	private static final long serialVersionUID = 5079043085410685054L;
	
	private String groupuid;
	private String groupname;
	private String useruid;
	private String name;
	private String wish;
	private EWish type;
	
	public String getGroupuid() {
		return groupuid;
	}
	public void setGroupuid(String groupuid) {
		this.groupuid = groupuid;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getUseruid() {
		return useruid;
	}
	public void setUseruid(String useruid) {
		this.useruid = useruid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWish() {
		return wish;
	}
	public void setWish(String wish) {
		this.wish = wish;
	}
	public EWish getType() {
		return type;
	}
	public void setType(EWish type) {
		this.type = type;
	}
	
	
}

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
 * Create at: 2012-11-12 下午9:48:54
 * ============================================================================
 */
package com.jiazu.web.shop.entity;

import org.springframework.stereotype.Component;

import com.jiazu.global.constants.SysConf;
import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
public class Role extends BaseEntity {

	private static final long serialVersionUID = -6710936079968296463L;
	
	private String userid;
	private String authority;
	
	public Role() {}
	
	/**
	 * @param admin
	 */
	public Role(Admin admin) {
		this.userid = admin.getUserid();
		this.authority = SysConf.role_admin;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

}

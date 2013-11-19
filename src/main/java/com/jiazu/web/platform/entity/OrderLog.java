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
 * Create at: 2012-8-18 上午9:15:19
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EOrderLogType;
import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
@Scope("prototype")
public class OrderLog extends BaseEntity {

	private static final long serialVersionUID = -100252198471353167L;

	private String useruid;
	private String orderuid;
	private String doaction;
	private EOrderLogType logtype;
	
	public String getUseruid() {
		return useruid;
	}
	public void setUseruid(String useruid) {
		this.useruid = useruid;
	}
	public String getOrderuid() {
		return orderuid;
	}
	public void setOrderuid(String orderuid) {
		this.orderuid = orderuid;
	}
	public String getDoaction() {
		return doaction;
	}
	public void setDoaction(String doaction) {
		this.doaction = doaction;
	}
	public EOrderLogType getLogtype() {
		return logtype;
	}
	public void setLogtype(EOrderLogType logtype) {
		this.logtype = logtype;
	}
	
}

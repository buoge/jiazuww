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
 * Create at: 2012-8-18 上午8:57:20
 * ============================================================================
 */
package com.jiazu.web.shop.entity;

import org.springframework.stereotype.Component;

import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
public class Cart extends BaseEntity {

	private static final long serialVersionUID = 6813360330277579086L;
	private String useruid;
	private String b2cuid;
	private int number;
	
	public String getUseruid() {
		return useruid;
	}
	public void setUseruid(String useruid) {
		this.useruid = useruid;
	}
	public String getB2cuid() {
		return b2cuid;
	}
	public void setB2cuid(String b2cuid) {
		this.b2cuid = b2cuid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

}

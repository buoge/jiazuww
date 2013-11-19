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
 * Create at: 2012-11-9 下午1:43:35
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
public class OrderDetail extends BaseEntity {

	private static final long serialVersionUID = -7747835698905004187L;
	
	private String b2cuid;
	private String b2csn;
	private String b2cname;
	private String b2clittlethumb;
	private String b2cthumb;
	
	private int num;
	
	public OrderDetail(){}
	
	/**
	 * @param uid
	 * @param parameter
	 */
	public OrderDetail(String uid, int num) {
		this.b2cuid = uid;
		this.num = num;
	}
	/**
	 * @param b2c
	 * @param num2
	 */
	public OrderDetail(B2C b2c, int num) {
		this.b2cuid = b2c.getUid();
		this.b2csn = b2c.getSn();
		this.b2cname = b2c.getName();
		this.b2clittlethumb = b2c.getLittlethumb();
		this.b2cthumb = b2c.getThumb();
		this.num = num;
	}

	public String getB2cuid() {
		return b2cuid;
	}
	public void setB2cuid(String b2cuid) {
		this.b2cuid = b2cuid;
	}
	public String getB2csn() {
		return b2csn;
	}

	public void setB2csn(String b2csn) {
		this.b2csn = b2csn;
	}

	public String getB2cname() {
		return b2cname;
	}

	public void setB2cname(String b2cname) {
		this.b2cname = b2cname;
	}

	public String getB2clittlethumb() {
		return b2clittlethumb;
	}

	public void setB2clittlethumb(String b2clittlethumb) {
		this.b2clittlethumb = b2clittlethumb;
	}

	public String getB2cthumb() {
		return b2cthumb;
	}

	public void setB2cthumb(String b2cthumb) {
		this.b2cthumb = b2cthumb;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

}

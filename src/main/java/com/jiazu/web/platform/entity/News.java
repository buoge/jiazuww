/**
 * 家族动态实体类，保存在内存中，不存在数据库中
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
 * Create at: 2012-9-7 上午8:03:26
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import org.joda.time.DateTime;

import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
public class News extends BaseEntity {

	private static final long serialVersionUID = -5872298520471292483L;
	
	private String author;
	private String headimg;
	private String title;
	private String desc;
	public News(String author, String headimg, String title, String desc) {
		this.author = author;
		this.headimg = headimg;
		this.title = title;
		this.desc = desc;
		this.setCreateTime(new DateTime());
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	

}

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
 * Create at: 2012-8-18 上午9:00:15
 * ============================================================================
 */
package com.jiazu.web.shop.entity;

import org.springframework.stereotype.Component;

import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component("b2cGallery")
public class Gallery extends BaseEntity {

	private static final long serialVersionUID = -794053185794387891L;
	private String goodsuid;
	private String img;
	private String thumb;
	private String bigimg;
	private String original;
	private String title;
	private boolean isdefault;
	private int sortorder;
	
	public String getGoodsuid() {
		return goodsuid;
	}
	public void setGoodsuid(String goodsuid) {
		this.goodsuid = goodsuid;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getBigimg() {
		return bigimg;
	}
	public void setBigimg(String bigimg) {
		this.bigimg = bigimg;
	}
	public String getOriginal() {
		return original;
	}
	public void setOriginal(String original) {
		this.original = original;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isdefault() {
		return isdefault;
	}
	public void setIsdefault(boolean isdefault) {
		this.isdefault = isdefault;
	}
	/**
	 * @return the sortorder
	 */
	public int getSortorder() {
		return sortorder;
	}
	/**
	 * @param sortorder the sortorder to set
	 */
	public void setSortorder(int sortorder) {
		this.sortorder = sortorder;
	}
	
}

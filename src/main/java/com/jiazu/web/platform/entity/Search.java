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
 * Create at: 2012-11-11 上午9:36:30
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import com.jiazu.global.constants.SysConf;
import com.jiazu.web.base.entity.BaseEntity;
import com.jiazu.web.shop.entity.B2C;
import com.jiazu.web.shop.entity.C2C;

/**
 * @author Architect.bian
 *
 */
public class Search extends BaseEntity {

	private static final long serialVersionUID = -8878218478772126749L;
	
	private String useruid;
	private String userName;
	private String userAvatar;
	private String title;
	private String href;
	private String desc;
	private String type;
	private String thumb;
	private int clickcount;
	
	/**
	 * @param edu
	 */
	public Search(Education edu) {
		if (edu != null) {
			this.setUseruid(edu.getUseruid());
			this.title = edu.getTitle();
			this.href = String.format(SysConf.format_eduhref, edu.getType(), edu.getId());
			this.desc = edu.getContent().substring(0, SysConf.searchResultTextCount > edu.getContent().length() ? edu.getContent().length() : SysConf.searchResultTextCount);
		}
	}
	/**
	 * @param item
	 */
	public Search(Event event) {
		if (event != null) {
			this.setUseruid(event.getUseruid());
			this.userName = event.getUserName();
			this.title = event.getContent().length() > 30 ? event.getContent().substring(0, 30) : event.getContent().substring(0, event.getContent().length());
			this.href = String.format(SysConf.format_eventhref, event.getUid());
			this.desc = event.getContent().substring(0, SysConf.searchResultTextCount > event.getContent().length() ? event.getContent().length() : SysConf.searchResultTextCount);
		}
	}
	/**
	 * @param item
	 */
	public Search(B2C b2c) {
		if (b2c != null) {
			this.title = b2c.getName();
			this.href = String.format(SysConf.format_b2chref, b2c.getUid());
			this.desc = b2c.getDesc().substring(0, SysConf.searchResultTextCount > b2c.getDesc().length() ? b2c.getDesc().length() : SysConf.searchResultTextCount);
		}
	}
	/**
	 * @param item
	 */
	public Search(C2C c2c) {
		if (c2c != null) {
			this.title = c2c.getName();
			this.href = String.format(SysConf.format_c2chref, c2c.getUid());
			this.desc = c2c.getDesc().substring(0, SysConf.searchResultTextCount > c2c.getDesc().length() ? c2c.getDesc().length() : SysConf.searchResultTextCount);
		}
	}

	public String getUseruid() {
		return useruid;
	}
	public void setUseruid(String useruid) {
		this.useruid = useruid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public int getClickcount() {
		return clickcount;
	}
	public void setClickcount(int clickcount) {
		this.clickcount = clickcount;
	}

}

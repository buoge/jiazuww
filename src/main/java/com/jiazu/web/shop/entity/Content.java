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
 * Create at: 2012-8-18 上午9:29:17
 * ============================================================================
 */
package com.jiazu.web.shop.entity;

import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EContent;
import com.jiazu.global.constants.EStatus;
import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
public class Content extends BaseEntity {

	private static final long serialVersionUID = 6869138039640927119L;
	
	private int channel_id = 0;
	private EContent type;
	private String adminuid;
	private int top_level = 0;
	private int priority = 0;
	private String title;
	private String titleshort;
	private String titleimg;
	private String originalimg;
	private String author;
	private String origin;
	private String originurl;
	private String description;
	private String content;
	private boolean isrecommend = false;
	private EStatus status = EStatus.enable;
	private int viewsday = 0;
	private int commentsday = 0;
	private int upsday = 0;
	private int sortorder = 0;
	
	public Content() { }
	
	/**
	 * @param text
	 */
	public Content(String title) {
		this.title = title;
	}
	public int getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}
	public EContent getType() {
		return type;
	}
	public void setType(EContent type) {
		this.type = type;
	}
	public String getAdminuid() {
		return adminuid;
	}
	public void setAdminuid(String adminuid) {
		this.adminuid = adminuid;
	}
	public int getTop_level() {
		return top_level;
	}
	public void setTop_level(int top_level) {
		this.top_level = top_level;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleshort() {
		return titleshort;
	}
	public void setTitleshort(String titleshort) {
		this.titleshort = titleshort;
	}
	public String getTitleimg() {
		return titleimg;
	}
	public void setTitleimg(String titleimg) {
		this.titleimg = titleimg;
	}
	public String getOriginalimg() {
		return originalimg;
	}

	public void setOriginalimg(String originalimg) {
		this.originalimg = originalimg;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getOriginurl() {
		return originurl;
	}
	public void setOriginurl(String originurl) {
		this.originurl = originurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isrecommend() {
		return isrecommend;
	}
	public void setIsrecommend(boolean isrecommend) {
		this.isrecommend = isrecommend;
	}
	public EStatus getStatus() {
		return status;
	}
	public void setStatus(EStatus status) {
		this.status = status;
	}
	public int getViewsday() {
		return viewsday;
	}
	public void setViewsday(int viewsday) {
		this.viewsday = viewsday;
	}
	public int getCommentsday() {
		return commentsday;
	}
	public void setCommentsday(int commentsday) {
		this.commentsday = commentsday;
	}
	public int getUpsday() {
		return upsday;
	}
	public void setUpsday(int upsday) {
		this.upsday = upsday;
	}
	public int getSortorder() {
		return sortorder;
	}
	public void setSortorder(int sortorder) {
		this.sortorder = sortorder;
	}

}

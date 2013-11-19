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
 * Create at: 2012-8-17 上午7:48:25
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EEducation;
import com.jiazu.global.constants.EStatus;
import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
@Scope("prototype")
public class Education extends BaseEntity {

	private static final long serialVersionUID = -7808425329939415333L;

	private String groupuid = "";
	private String useruid = "";
	private EEducation type;
	private String title;
	private String titleimg = "";
	private String author;
	private String content;
	private int viewsday = 0;
	private boolean isrecommend = false;
	private boolean ispublic = true;
	private int clickcount = 0;
	private EStatus status = EStatus.enable;
	public String getGroupuid() {
		return groupuid;
	}
	public void setGroupuid(String groupuid) {
		this.groupuid = groupuid;
	}
	public String getUseruid() {
		return useruid;
	}
	public void setUseruid(String useruid) {
		this.useruid = useruid;
	}
	public EEducation getType() {
		return type;
	}
	public String getTypeName() {
		return EEducation.getName(type);
	}
	public void setType(EEducation type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleimg() {
		return titleimg;
	}
	public void setTitleimg(String titleimg) {
		this.titleimg = titleimg;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewsday() {
		return viewsday;
	}
	public void setViewsday(int viewsday) {
		this.viewsday = viewsday;
	}
	public boolean isIsrecommend() {
		return isrecommend;
	}
	public void setIsrecommend(boolean isrecommend) {
		this.isrecommend = isrecommend;
	}
	public boolean isIspublic() {
		return ispublic;
	}
	public void setIspublic(boolean ispublic) {
		this.ispublic = ispublic;
	}
	public EStatus getStatus() {
		if (status == null) {
			status = EStatus.enable;
		}
		return status;
	}
	public String getStatusName() {
		return EStatus.getName(status);
	}
	public void setStatus(EStatus status) {
		this.status = status;
	}
	public int getClickcount() {
		return clickcount;
	}
	public void setClickcount(int clickcount) {
		this.clickcount = clickcount;
	}
	
	
}

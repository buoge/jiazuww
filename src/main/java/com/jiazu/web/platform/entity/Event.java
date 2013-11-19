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
 * Create at: 2012-8-17 上午8:13:06
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EEvent;
import com.jiazu.global.constants.EStatus;
import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
@Scope("prototype")
public class Event extends BaseEntity {

	private static final long serialVersionUID = 7281214924791868962L;
	
	private String groupuid;
	private String groupName;
	private String groupImg;
	private String useruid;
	private String userName;
	private EEvent type;
	private String content;
	private String img;
	private String bigimg;
	private String rawimg;
	@SuppressWarnings("unused")
	private int commentcount;
	private boolean isrecommend;
	private boolean ispublic;
	private EStatus status;
	private List<Comment> comments = new ArrayList<>();
	
	public String getGroupuid() {
		return groupuid;
	}
	public void setGroupuid(String groupuid) {
		this.groupuid = groupuid;
	}
	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * @return the groupImg
	 */
	public String getGroupImg() {
		return groupImg;
	}
	/**
	 * @param groupImg the groupImg to set
	 */
	public void setGroupImg(String groupImg) {
		this.groupImg = groupImg;
	}
	public String getUseruid() {
		return useruid;
	}
	public void setUseruid(String useruid) {
		this.useruid = useruid;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public EEvent getType() {
		return type;
	}
	public void setType(EEvent type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getBigimg() {
		return bigimg;
	}
	public void setBigimg(String bigimg) {
		this.bigimg = bigimg;
	}
	public String getRawimg() {
		return rawimg;
	}
	public void setRawimg(String rawimg) {
		this.rawimg = rawimg;
	}
	public int getCommentcount() {
		return comments.size();
	}
	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}
	public boolean isrecommend() {
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
		return status;
	}
	public void setStatus(EStatus status) {
		this.status = status;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}

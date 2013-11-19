/**
 * 风土人情实体类
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
 * Create at: 2012-8-17 上午7:42:48
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component("customGallery")
@Scope("prototype")
public class Gallery extends BaseEntity {

	private static final long serialVersionUID = -3251176374373591075L;
	
	private String groupuid;
	private String useruid;
	private String img;
	private String littlethumb;
	private String thumb;
	private String bigthumb;
	private String original;
	private String title;
	private String desc;
	private boolean istop;
	private int sortorder;
	private boolean ispublic;
	private int clickcount = 0;
	private User user;
	private int commentscount = 0;
	private List<Comment> comments = new ArrayList<>();
	
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * @return the littlethumb
	 */
	public String getLittlethumb() {
		return littlethumb;
	}
	/**
	 * @param littlethumb the littlethumb to set
	 */
	public void setLittlethumb(String littlethumb) {
		this.littlethumb = littlethumb;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	/**
	 * @return the bigthumb
	 */
	public String getBigthumb() {
		return bigthumb;
	}
	/**
	 * @param bigthumb the bigthumb to set
	 */
	public void setBigthumb(String bigthumb) {
		this.bigthumb = bigthumb;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public boolean istop() {
		return istop;
	}
	public void setIstop(boolean istop) {
		this.istop = istop;
	}
	public int getSortorder() {
		return sortorder;
	}
	public void setSortorder(int sortorder) {
		this.sortorder = sortorder;
	}
	public boolean ispublic() {
		return ispublic;
	}
	public void setIspublic(boolean ispublic) {
		this.ispublic = ispublic;
	}
	public int getClickcount() {
		return clickcount;
	}
	public void setClickcount(int clickcount) {
		this.clickcount = clickcount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCommentscount() {
		return commentscount;
	}
	public void setCommentscount(int commentscount) {
		this.commentscount = commentscount;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}

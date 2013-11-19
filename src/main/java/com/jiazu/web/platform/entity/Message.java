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
 * Create at: 2012-8-17 上午8:27:19
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EMsg;
import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
@Scope("prototype")
public class Message extends BaseEntity {
	
	private static final long serialVersionUID = 2280784393548254307L;
	
	private String useruid;
	private String useruidfrom;
	private String title;
	private String msg;
	private EMsg type;
	private User user;
	
	public String getUseruid() {
		return useruid;
	}
	public void setUseruid(String useruid) {
		this.useruid = useruid;
	}
	public String getUseruidfrom() {
		return useruidfrom;
	}
	public void setUseruidfrom(String useruidfrom) {
		this.useruidfrom = useruidfrom;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public EMsg getType() {
		return type;
	}
	public void setType(EMsg type) {
		this.type = type;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}

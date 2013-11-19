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
 * Create at: 2012-8-17 上午8:34:41
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EGender;
import com.jiazu.global.constants.EStatus;
import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
@Scope("prototype")
public class ZupuMember extends BaseEntity {

	private static final long serialVersionUID = -8863266596777840134L;
	private String groupuid;
	private String useruid;
	private String useruid2;
	private String name;
	private String name2;
	private EGender gender;
	private EGender gender2;
	private String realname;
	private String realname2;
	private String birthday;
	private String birthday2;
	private String dieday;
	private String dieday2;
	private String introduce;
	private String introduce2;
	private String avatar;
	private String avatar2;
	private int level = 1;
//	private String loveruid;
	private String parentuid;
//	private boolean isadmin;
	private EStatus status = EStatus.enable;
	private EStatus status2 = EStatus.enable;
	private List<ZupuMember> children = new ArrayList<>();
	
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
	public String getUseruid2() {
		return useruid2;
	}
	public void setUseruid2(String useruid2) {
		this.useruid2 = useruid2;
	}
	public String getName() {
		if (StringUtils.isNotEmpty(this.realname)) {
			return this.realname;
		}
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName2() {
		if (StringUtils.isNotEmpty(this.realname2)) {
			return this.realname2;
		}
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public EGender getGender() {
		return gender;
	}
	public void setGender(EGender gender) {
		this.gender = gender;
	}
	public EGender getGender2() {
		return gender2;
	}
	public void setGender2(EGender gender2) {
		this.gender2 = gender2;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getRealname2() {
		return realname2;
	}
	public void setRealname2(String realname2) {
		this.realname2 = realname2;
	}
	public String getBirthday() {
		return birthday;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBirthday2() {
		return birthday2;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setBirthday2(String birthday2) {
		this.birthday2 = birthday2;
	}
	public String getDieday() {
		return dieday;
	}
	public void setDieday(String dieday) {
		this.dieday = dieday;
	}
	public String getDieday2() {
		return dieday2;
	}
	public void setDieday2(String dieday2) {
		this.dieday2 = dieday2;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getIntroduce2() {
		return introduce2;
	}
	public void setIntroduce2(String introduce2) {
		this.introduce2 = introduce2;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getAvatar2() {
		return avatar2;
	}
	public void setAvatar2(String avatar2) {
		this.avatar2 = avatar2;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int i) {
		this.level = i;
	}
	public String getParentuid() {
		return parentuid;
	}
	public void setParentuid(String parentuid) {
		this.parentuid = parentuid;
	}
	public EStatus getStatus() {
		return status;
	}
	public void setStatus(EStatus status) {
		this.status = status;
	}
	public EStatus getStatus2() {
		return status2;
	}
	public void setStatus2(EStatus status2) {
		this.status2 = status2;
	}
	public List<ZupuMember> getChildren() {
		return children;
	}
	public void setChildren(List<ZupuMember> children) {
		this.children = children;
	}
	
	
}

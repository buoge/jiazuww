/**
 * 用户entity
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
 * Create at: 2012-8-4 下午6:37:59
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EGender;
import com.jiazu.global.constants.EStatus;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
@Scope("prototype")
public class User extends BaseEntity {
	
	private static final long serialVersionUID = 4105665925642979854L;
	
//	@NotNull(message="valid.userid.null")
	@NotEmpty(message="{valid.userid.empty}")
	@Size(min=3, max=100, message="{valid.userid.length}")
	private String userid;//用户登录ID
	private String groupuid;//默认家族UID
	private double account;//账户余额
	@NotNull
	private String password;
	private String name;
	public EGender gender;//性别
	private String realname;
	private LocalDate birthday;
	private String email;
	private String intro;//个人简介
	private String thumb;//缩略图
	private String avatar;//个人头像
	private String original;//原图
	private String signed;//个性签名
	private String qq;
	private String msn;
	private String phone;
	private String mobile;
	private int salary;
	public EStatus status;//是否激活等等状态
	private String resetpwd;//重置密码VALUE
	private int logincount;//登录次数
	private int educount;//最新教育
	private int eventcount;//最新大事
	private int groupcount;//家族成员
	private int msgcount;//未读信息
	private DateTime errorlasttime;//登录错误时间
	private int errorcount;//登录错误次数
	private String errorip;//登录错误IP
	private DateTime lastlogintime;//最后登录时间
	private String lastloginip = "";//最后登录IP
	private String registerip = "";//注册IP

	public User() {	}
	
	/**
	 * @param name
	 */
	public User(String name) {
		this.setUid(GlobalUtil.getUUID());
		this.name = name;
		this.setCreateTime(new DateTime());
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getGroupuid() {
		return groupuid;
	}
	public void setGroupuid(String groupuid) {
		this.groupuid = groupuid;
	}
	public double getAccount() {
		return account;
	}
	public void setAccount(double account) {
		this.account = account;
	}
	public void plusAccount(double plusvar) {
		this.account += plusvar;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EGender getGender() {
		return gender;
	}
	public String getGenderName() {
		return EGender.getName(gender);
	}
	public void setGender(EGender gender) {
		this.gender = gender;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getOriginal() {
		return original;
	}
	public void setOriginal(String original) {
		this.original = original;
	}
	public String getSigned() {
		return signed;
	}
	public void setSigned(String signed) {
		this.signed = signed;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMsn() {
		return msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public EStatus getStatus() {
		if (status == null) {
			status = EStatus.enable;
		}
		return status;
	}
//	public void setStatus(int status) {
//		this.status = EStatus.get(status);
//	}
	public void setStatus(EStatus status) {
		this.status = status;
	}
	public String getResetpwd() {
		return resetpwd;
	}
	public void setResetpwd(String resetpwd) {
		this.resetpwd = resetpwd;
	}
	public int getLogincount() {
		return logincount;
	}
	public void setLogincount(int logincount) {
		this.logincount = logincount;
	}
	public int getEducount() {
		return educount;
	}
	public void setEducount(int educount) {
		this.educount = educount;
	}
	public int getEventcount() {
		return eventcount;
	}
	public void setEventcount(int eventcount) {
		this.eventcount = eventcount;
	}
	public int getGroupcount() {
		return groupcount;
	}
	public void setGroupcount(int groupcount) {
		this.groupcount = groupcount;
	}
	public int getMsgcount() {
		return msgcount;
	}
	public void setMsgcount(int msgcount) {
		this.msgcount = msgcount;
	}
	public DateTime getErrorlasttime() {
		return errorlasttime;
	}
	public void setErrorlasttime(DateTime errorlasttime) {
		this.errorlasttime = errorlasttime;
	}
	public int getErrorcount() {
		return errorcount;
	}
	public void setErrorcount(int loginErrCount) {
		this.errorcount = loginErrCount;
	}
	public String getErrorip() {
		return errorip;
	}
	public void setErrorip(String errorip) {
		this.errorip = errorip;
	}
	public DateTime getLastlogintime() {
		return lastlogintime;
	}
	public void setLastlogintime(DateTime lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	public String getLastloginip() {
		return lastloginip;
	}
	public void setLastloginip(String lastloginip) {
		this.lastloginip = lastloginip;
	}
	public String getRegisterip() {
		return registerip;
	}
	public void setRegisterip(String registerip) {
		this.registerip = registerip;
	}
	
	/**
	 * 对象的初始化
	 */
	public void initialize() {
		this.setPassword(DigestUtils.md5Hex(this.password));
		this.setStatus(EStatus.init);
		this.setAvatar("/imgs/default/defaulthead.jpg");
	}

}

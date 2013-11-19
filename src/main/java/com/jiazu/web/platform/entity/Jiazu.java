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
 * Create at: 2012-8-17 上午8:24:44
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EStatus;
import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
@Scope("prototype")
public class Jiazu extends BaseEntity {
	
	private static final long serialVersionUID = -4403364325395441447L;
	
	private String owner;
	private String ownerid;
	private String name;
	private String headimg;
	private String logo;
	private String logooriginal;
	private String brief;
	private String desc;
	private EStatus status = EStatus.enable;
	private int memberCount = 0;
	private int totalMoney = 0;
	private List<Member> members = new ArrayList<>();
	private List<ZupuMember> zupumembers = new ArrayList<>();
	@Deprecated
	private String logaction;
	
	public Jiazu() {}
	
	/**
	 * @param name
	 */
	public Jiazu(String name) {
		this();
		this.name = name;
		this.setCreateTime(new DateTime());
	}
	
	/**
	 * @param ownerid 
	 * @param owner 
	 * @param name2
	 */
	public Jiazu(String name, String owner, String ownerid) {
		this(name);
		this.owner = owner;
		this.ownerid = ownerid;
	}

	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLogooriginal() {
		return logooriginal;
	}
	public void setLogooriginal(String logooriginal) {
		this.logooriginal = logooriginal;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public EStatus getStatus() {
		return status;
	}

	public void setStatus(EStatus status) {
		this.status = status;
	}

	public int getMemberCount() {
		if (this.members != null) {
			this.memberCount = this.members.size();
		}
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public int getTotalMoney() {
		if (this.members != null) {
			this.totalMoney = 0;
			for (Member item : this.members) {
				this.totalMoney += item.getAccount();
			}
		}
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getLogaction() {
		return logaction;
	}
	public void setLogaction(String logaction) {
		this.logaction = logaction;
	}
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	public List<ZupuMember> getZupumembers() {
		return zupumembers;
	}
	public void setZupumembers(List<ZupuMember> zupumembers) {
		this.zupumembers = zupumembers;
	}

	public void initialize() {
		this.logo = "/imgs/default/noimg130_130.gif";
		this.headimg = "/imgs/default/noimg50_50.gif";
		this.logooriginal = "/imgs/default/noimg130_130.gif";
	}
	
}

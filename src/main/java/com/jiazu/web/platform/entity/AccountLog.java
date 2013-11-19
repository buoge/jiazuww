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
 * Create at: 2012-8-17 上午7:28:54
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
@Scope("prototype")
public class AccountLog extends BaseEntity {

	private static final long serialVersionUID = 5768286159576517153L;
	
	private String useruid;
	private String doaction;
	private double usemoney;
	private double account = 0;//账户余额
	
	public String getUseruid() {
		return useruid;
	}
	public void setUseruid(String userUid) {
		this.useruid = userUid;
	}
	public String getDoaction() {
		return doaction;
	}
	public void setDoaction(String doAction) {
		this.doaction = doAction;
	}
	public double getUsemoney() {
		return usemoney;
	}
	public void setUsemoney(double useMoney) {
		this.usemoney = useMoney;
	}
	public double getAccount() {
		return account;
	}
	public void setAccount(double account) {
		this.account = account;
	}

}

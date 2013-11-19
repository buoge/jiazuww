/**
 * 家族成员
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
 * Create at: 2012-10-6 上午8:32:59
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EAdmin;


/**
 * @author Architect.bian
 *
 */
@Component
@Scope("prototype")
public class Member extends User {

	private static final long serialVersionUID = -7314231434542027124L;
	
	private String useruid;
	
	private EAdmin type;

	public String getUseruid() {
		return useruid;
	}

	public void setUseruid(String useruid) {
		this.useruid = useruid;
	}

	public EAdmin getType() {
		return type;
	}

	public void setType(EAdmin type) {
		this.type = type;
	}

}

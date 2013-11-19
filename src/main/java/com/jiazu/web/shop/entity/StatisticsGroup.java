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
 * Create at: 2012-11-18 上午8:26:34
 * ============================================================================
 */
package com.jiazu.web.shop.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
public class StatisticsGroup extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	//家族成员
	private Map<String, Integer> memberCount = new HashMap<String, Integer>();

	public StatisticsGroup() { }
	
	/**
	 * @param groupuid
	 */
	public StatisticsGroup(String groupuid) {
		this.setUid(groupuid);
	}

	public Map<String, Integer> getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Map<String, Integer> memberCount) {
		this.memberCount = memberCount;
	}

}

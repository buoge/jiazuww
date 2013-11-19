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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
public class StatisticsUser extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private Map<String, List<String>> newEduList = new HashMap<String, List<String>>();
	private Map<String, List<String>> newEventList = new HashMap<String, List<String>>();
	private List<String> unreadMsgList = new ArrayList<>();
	
	public StatisticsUser() {}
	
	/**
	 * @param useruid
	 */
	public StatisticsUser(String useruid) {
		this.setUid(useruid);
	}
	public Map<String, List<String>> getNewEduList() {
		return newEduList;
	}
	public void setNewEduList(Map<String, List<String>> newEduList) {
		this.newEduList = newEduList;
	}
	public Map<String, List<String>> getNewEventList() {
		return newEventList;
	}
	public void setNewEventList(Map<String, List<String>> newEventList) {
		this.newEventList = newEventList;
	}
	public List<String> getUnreadMsgList() {
		return unreadMsgList;
	}
	public void setUnreadMsgList(List<String> unreadMsgList) {
		this.unreadMsgList = unreadMsgList;
	}

}

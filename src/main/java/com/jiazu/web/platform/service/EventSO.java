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
 * Create at: 2012-10-21 上午8:20:18
 * ============================================================================
 */
package com.jiazu.web.platform.service;

import java.util.List;

import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.Event;

/**
 * @author Architect.bian
 *
 */
public interface EventSO {

	/**
	 * @param event
	 * @return
	 */
	boolean add(Event event);

	/**
	 * @param pager
	 * @return
	 */
	List<Event> getList(Pager pager);

	/**
	 * @param uid
	 * @param pager
	 * @return
	 */
	List<Event> getList(String uid, Pager pager);

	/**
	 * @param uid
	 * @return
	 */
	boolean delete(String uid);

	/**
	 * @param s
	 * @param pager
	 * @return
	 */
	List<Event> search(String s, Pager pager);

	/**
	 * @param s
	 * @param groupuids
	 * @return
	 */
	List<Event> search(String s, String groupuids);

	/**
	 * @param uid
	 * @param top
	 * @return
	 */
	boolean updateTop(String uid, boolean top);

	/**
	 * @param uid 
	 * @param pager
	 * @return
	 */
	List<Event> getMyList(String uid, Pager pager);

	/**
	 * @param uid
	 * @return
	 */
	Event get(String uid);

}

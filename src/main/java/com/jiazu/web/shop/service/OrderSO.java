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
 * Create at: 2012-11-9 下午2:37:15
 * ============================================================================
 */
package com.jiazu.web.shop.service;

import java.util.List;
import java.util.Map;

import com.jiazu.global.constants.EOrder;
import com.jiazu.global.constants.EPay;
import com.jiazu.global.constants.EShipping;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.shop.entity.Order;

/**
 * @author Architect.bian
 *
 */
public interface OrderSO {
	
	/**
	 * @param uid
	 * @return
	 */
	Order get(String uid);
	
	/**
	 * @param useruid
	 * @param pager 
	 * @return
	 */
	List<Order> getList(String useruid, Pager pager);

	/**
	 * @param order
	 * @return
	 */
	boolean create(Order order);

	/**
	 * @param uid
	 * @param status
	 * @return
	 */
	boolean updateStatus(String uid, EOrder status);

	/**
	 * @param uid
	 * @param status
	 * @return
	 */
	boolean updateStatus(String uid, EShipping status);

	/**
	 * @param uid
	 * @param status
	 * @return
	 */
	boolean updateStatus(String uid, EPay status);

	/**
	 * @param order
	 * @return
	 */
	boolean update(Order order);

	/**
	 * @param uid
	 * @return
	 */
	boolean delete(String uid);

	/**
	 * @param sn
	 * @return
	 */
	Order getBySN(String sn);

	/**
	 * @param map
	 * @return
	 */
	List<Order> getList(Map<String, Object> map);

	/**
	 * @param pager
	 * @return
	 */
	List<Order> getList(Pager pager);

	/**
	 * @param uid
	 * @param minusprice
	 * @return
	 */
	boolean updateMinusprice(String uid, int minusprice);

}

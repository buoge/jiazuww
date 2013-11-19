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
 * Create at: 2012-11-7 下午6:10:54
 * ============================================================================
 */
package com.jiazu.web.shop.proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jiazu.core.cache.Rule;
import com.jiazu.core.cache.impl.CacheFacade;
import com.jiazu.core.cache.rule.CartRule;
import com.jiazu.global.constants.EOrder;
import com.jiazu.global.constants.EPay;
import com.jiazu.global.constants.EShipping;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.shop.entity.B2C;
import com.jiazu.web.shop.entity.Order;
import com.jiazu.web.shop.service.OrderSO;

/**
 * @author Architect.bian
 *
 */
public class OrderPX extends BasePX {

	private static final int maxSize = 100;

	/**
	 * @param b2c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean addCart(String useruid, B2C b2c) {
		Rule rule = new CartRule(useruid);
		try {
			Map<String, B2C> map = (Map<String, B2C>)CacheFacade.get(rule);
			if (map == null) {
				map = new HashMap<String, B2C>();
			} else if (map.size() >= maxSize) {
				map.remove(map.keySet().toArray()[0]);
			}
			if (map.containsKey(b2c.getUid())) {
				B2C b = map.get(b2c.getUid());
				b2c.setNumber(b2c.getNumber() + b.getNumber());
			}
			map.put(b2c.getUid(), b2c);
			return CacheFacade.set(rule, map);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @return
	 */
	public static boolean clearCart(String useruid) {
		Rule rule = new CartRule(useruid);
		return CacheFacade.remove(rule);
	}

	/**
	 * @param uid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, B2C> getCart(String useruid) {
		Rule rule = new CartRule(useruid);
		try {
			Map<String, B2C> map = (Map<String, B2C>)CacheFacade.get(rule);
			if (map == null) {
				map = new HashMap<String, B2C>();
			}
			return map;
		} catch (Exception e) {
			CacheFacade.remove(rule);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param uid
	 * @param map
	 * @return
	 */
	public static boolean saveCart(String useruid, Map<String, B2C> map) {
		Rule rule = new CartRule(useruid);
		try {
			return CacheFacade.set(rule, map);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param useruid 
	 * @param todelete
	 */
	@SuppressWarnings("unchecked")
	public static boolean deleteCart(String useruid, List<String> todelete) {
		Rule rule = new CartRule(useruid);
		try {
			Map<String, B2C> map = (Map<String, B2C>)CacheFacade.get(rule);
			if (map == null) {
				map = new HashMap<String, B2C>();
			}
			for (String deluid : todelete) {
				map.remove(deluid);
			}
			return CacheFacade.set(rule, map);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param order
	 */
	public static Order get(String uid) {
		OrderSO so = (OrderSO)spring.getBean(OrderSO.class);
		return so.get(uid);
	}
	
	/**
	 * @param pager 
	 * @param order
	 */
	public static List<Order> getList(String useruid, Pager pager) {
		OrderSO so = (OrderSO)spring.getBean(OrderSO.class);
		return so.getList(useruid, pager);
	}

	/**
	 * @param order
	 */
	public static boolean create(Order order) {
		OrderSO so = (OrderSO)spring.getBean(OrderSO.class);
		return so.create(order);
		
	}
	
	/**
	 * @param order
	 */
	public static boolean updateStatus(String uid, EOrder status) {
		OrderSO so = (OrderSO)spring.getBean(OrderSO.class);
		return so.updateStatus(uid, status);
	}
	
	/**
	 * @param order
	 */
	public static boolean updateStatus(String uid, EShipping status) {
		OrderSO so = (OrderSO)spring.getBean(OrderSO.class);
		return so.updateStatus(uid, status);
	}
	
	/**
	 * @param order
	 */
	public static boolean updateStatus(String uid, EPay status) {
		OrderSO so = (OrderSO)spring.getBean(OrderSO.class);
		return so.updateStatus(uid, status);
	}
	
	/**
	 * @param order
	 */
	public static boolean update(Order order) {
		OrderSO so = (OrderSO)spring.getBean(OrderSO.class);
		return so.update(order);
	}
	
	/**
	 * @param order
	 */
	public static boolean delete(String uid) {
		OrderSO so = (OrderSO)spring.getBean(OrderSO.class);
		return so.delete(uid);
	}

	/**
	 * @param order_no
	 * @return
	 */
	public static Order getBySN(String sn) {
		OrderSO so = (OrderSO)spring.getBean(OrderSO.class);
		return so.getBySN(sn);
	}

	/**
	 * @return
	 */
	public static List<Order> getList(Pager pager) {
		OrderSO so = (OrderSO)spring.getBean(OrderSO.class);
		return so.getList(pager);
	}

	/**
	 * @param map
	 * @return
	 */
	public static List<Order> getList(Map<String, Object> map) {
		OrderSO so = (OrderSO)spring.getBean(OrderSO.class);
		return so.getList(map);
	}

	/**
	 * @param uid
	 * @param valueOf
	 * @return
	 */
	public static boolean updateMinusprice(String uid, int minusprice) {
		OrderSO so = (OrderSO)spring.getBean(OrderSO.class);
		return so.updateMinusprice(uid, minusprice);
	}

}

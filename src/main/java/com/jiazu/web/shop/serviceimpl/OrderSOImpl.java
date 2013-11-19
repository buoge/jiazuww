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
 * Create at: 2012-11-9 下午2:45:56
 * ============================================================================
 */
package com.jiazu.web.shop.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.EOrder;
import com.jiazu.global.constants.EPay;
import com.jiazu.global.constants.EShipping;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.platform.proxy.UserPX;
import com.jiazu.web.shop.dao.OrderDao;
import com.jiazu.web.shop.dao.OrderDetailDao;
import com.jiazu.web.shop.entity.Order;
import com.jiazu.web.shop.entity.OrderDetail;
import com.jiazu.web.shop.service.OrderSO;

/**
 * @author Architect.bian
 *
 */
@Service
public class OrderSOImpl extends BaseSO implements OrderSO {

	@Autowired
	private OrderDao dao;
	
	@Autowired
	OrderDetailDao daoDetail;
	
	@Override
	public Order get(String uid) {
		try {
			Order order = dao.get(uid);
			order.setDetails(daoDetail.getListByOrderUid(uid));
			return order;
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Order> getList(String useruid, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.useruid, useruid);
			List<Order> list = dao.getList(map);
			for (Order order : list) {
				order.setDetails(daoDetail.getListByOrderUid(order.getUid()));
				order.setUser(UserPX.getUser(order.getUseruid()));
			}
			return list;
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean create(Order order) {
		try {
			for (OrderDetail detail : order.getDetails()) {
				detail.setUid(order.getUid());
				daoDetail.insert(detail);
			}
			dao.insert(order);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean updateStatus(String uid, EOrder status) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.orderstatus, status);
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean updateStatus(String uid, EShipping status) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.shippingstatus, status);
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean updateStatus(String uid, EPay status) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.paystatus, status);
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean update(Order order) {
		try {
			dao.update(order);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean delete(String uid) {
		try {
			dao.delete(uid);
			Map<String, Object> map = new HashMap<>();
			map.put(MapperConstant.UID, uid);
			daoDetail.delete(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public Order getBySN(String sn) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.ordersn, sn);
			Order order = dao.getOne(map);
			order.setDetails(daoDetail.getListByOrderUid(order.getUid()));
			return order;
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Order> getList(Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			List<Order> list = dao.getList(map);
			for (Order order : list) {
				order.setDetails(daoDetail.getListByOrderUid(order.getUid()));
				order.setUser(UserPX.getUser(order.getUseruid()));
			}
			return list;
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Order> getList(Map<String, Object> map) {
		try {
			List<Order> list = dao.getList(map);
			for (Order order : list) {
				order.setDetails(daoDetail.getListByOrderUid(order.getUid()));
				order.setUser(UserPX.getUser(order.getUseruid()));
			}
			return list;
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean updateMinusprice(String uid, int minusprice) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.minusprice, minusprice);
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

}

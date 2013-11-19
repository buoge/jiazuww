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
 * Create at: 2012-11-8 下午1:46:23
 * ============================================================================
 */
package com.jiazu.web.shop.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.EAddress;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.shop.dao.AddressDao;
import com.jiazu.web.shop.entity.Address;
import com.jiazu.web.shop.service.AddressSO;

/**
 * @author Architect.bian
 *
 */
@Service
public class AddressSOImpl extends BaseSO implements AddressSO {

	@Autowired
	private AddressDao dao;
	
	@Override
	public Address get(String uid) {
		try {
			return dao.get(uid);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Address> getList(String useruid) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.useruid, useruid);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean add(Address address) {
		try {
			dao.insert(address);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean update(Address address) {
		try {
			dao.update(address);
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
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean updateType(String uid, EAddress type) {
		try {
			Address addr = get(uid);
			Map<String, Object> map = new HashMap<>();
			map.put(MapperConstant.type, EAddress.Default);
			map.put(MapperConstant.useruid, addr.getUseruid());
			addr = dao.getOne(map);
			map = new HashMap<>();
			map.put(MapperConstant.UID, addr.getUid());
			map.put(MapperConstant.type, EAddress.home);
			dao.updateFields(map);//取消上一个默认地址
			map = new HashMap<>();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.type, type);
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

}

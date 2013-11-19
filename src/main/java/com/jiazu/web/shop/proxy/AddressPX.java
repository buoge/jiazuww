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
 * Create at: 2012-11-8 上午8:02:20
 * ============================================================================
 */
package com.jiazu.web.shop.proxy;

import java.util.List;

import com.jiazu.global.constants.EAddress;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.shop.entity.Address;
import com.jiazu.web.shop.service.AddressSO;

/**
 * @author Architect.bian
 *
 */
public class AddressPX extends BasePX {

	/**
	 * @param uid
	 * @return
	 */
	public static Address get(String uid) {
		AddressSO so = (AddressSO)spring.getBean(AddressSO.class);
		return so.get(uid);
	}
	
	/**
	 * @param uid
	 * @return
	 */
	public static List<Address> getList(String useruid) {
		AddressSO so = (AddressSO)spring.getBean(AddressSO.class);
		return so.getList(useruid);
	}

	/**
	 * @param uid
	 * @param address
	 * @return
	 */
	public static boolean add(Address address) {
		AddressSO so = (AddressSO)spring.getBean(AddressSO.class);
		return so.add(address);
	}

	/**
	 * @param address
	 * @return
	 */
	public static boolean update(Address address) {
		AddressSO so = (AddressSO)spring.getBean(AddressSO.class);
		return so.update(address);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean delete(String uid) {
		AddressSO so = (AddressSO)spring.getBean(AddressSO.class);
		return so.delete(uid);
	}

	/**
	 * @param uid
	 * @param eAddress
	 * @return
	 */
	public static boolean updateType(String uid, EAddress type) {
		AddressSO so = (AddressSO)spring.getBean(AddressSO.class);
		return so.updateType(uid, type);
	}

}

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
 * Create at: 2012-11-8 下午1:42:22
 * ============================================================================
 */
package com.jiazu.web.shop.service;

import java.util.List;

import com.jiazu.global.constants.EAddress;
import com.jiazu.web.shop.entity.Address;

/**
 * @author Architect.bian
 *
 */
public interface AddressSO {

	/**
	 * @param uid
	 * @return
	 */
	Address get(String uid);

	/**
	 * @param useruid
	 * @return
	 */
	List<Address> getList(String useruid);

	/**
	 * @param address
	 * @return
	 */
	boolean add(Address address);

	/**
	 * @param address
	 * @return
	 */
	boolean update(Address address);

	/**
	 * @param uid
	 * @return
	 */
	boolean delete(String uid);

	/**
	 * @param uid
	 * @param type
	 * @return
	 */
	boolean updateType(String uid, EAddress type);

}

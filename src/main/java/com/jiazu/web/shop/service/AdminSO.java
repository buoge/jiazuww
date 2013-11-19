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
 * Create at: 2012-11-13 上午8:23:09
 * ============================================================================
 */
package com.jiazu.web.shop.service;

import java.util.List;

import com.jiazu.web.shop.entity.Admin;

/**
 * @author Architect.bian
 *
 */
public interface AdminSO {

	/**
	 * @param admin
	 * @return
	 */
	boolean add(Admin admin);

	/**
	 * @param uid
	 * @return
	 */
	boolean delete(String uid);

	/**
	 * @return
	 */
	List<Admin> getList();

}

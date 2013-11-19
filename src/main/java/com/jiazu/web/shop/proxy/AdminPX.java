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
 * Create at: 2012-11-13 上午8:08:26
 * ============================================================================
 */
package com.jiazu.web.shop.proxy;

import java.util.List;

import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.shop.entity.Admin;
import com.jiazu.web.shop.service.AdminSO;
import com.jiazu.web.shop.service.C2CSO;

/**
 * @author Architect.bian
 *
 */
public class AdminPX extends BasePX {

	/**
	 * @return
	 */
	public static List<Admin> getList() {
		AdminSO so = (AdminSO)spring.getBean(AdminSO.class);
		return so.getList();
	}

	/**
	 * @param admin
	 * @return
	 */
	public static boolean add(Admin admin) {
		AdminSO so = (AdminSO)spring.getBean(AdminSO.class);
		return so.add(admin);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean delete(String uid) {
		AdminSO so = (AdminSO)spring.getBean(AdminSO.class);
		return so.delete(uid);
	}

}

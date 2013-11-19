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
 * Create at: 2012-11-12 下午9:50:24
 * ============================================================================
 */
package com.jiazu.web.shop.dao;

import com.jiazu.web.base.dao.BaseDao;
import com.jiazu.web.shop.entity.Role;

/**
 * @author Architect.bian
 *
 */
public interface RoleDao extends BaseDao<Role> {

	/**
	 * @param uid
	 */
	void deleteByAdminUid(String uid);

}

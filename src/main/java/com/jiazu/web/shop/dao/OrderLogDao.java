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
 * Create at: 2012-8-22 上午7:03:28
 * ============================================================================
 */
package com.jiazu.web.shop.dao;

import com.jiazu.web.base.dao.BaseDao;
import com.jiazu.web.platform.entity.OrderLog;

/**
 * @author Architect.bian
 *
 */
public interface OrderLogDao extends BaseDao<OrderLog> {

	OrderLog get(int id);

	@Deprecated
	OrderLog get(String s);
	
	void delete(int id);
	
	@Deprecated
	void delete(String id);

}

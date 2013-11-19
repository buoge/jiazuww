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
 * Create at: 2012-11-9 下午1:51:40
 * ============================================================================
 */
package com.jiazu.web.shop.dao;

import java.util.List;
import java.util.Map;

import com.jiazu.web.base.dao.BaseDao;
import com.jiazu.web.shop.entity.OrderDetail;

/**
 * @author Architect.bian
 *
 */
public interface OrderDetailDao extends BaseDao<OrderDetail> {
	
	@Deprecated
	OrderDetail get(String id);
	
	@Deprecated
	void delete(String id);
	
	void delete(Map<String, Object> map);

	/**
	 * @param uid
	 * @return
	 */
	List<OrderDetail> getListByOrderUid(String uid);
}

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
 * Create at: 2012-8-22 上午6:59:37
 * ============================================================================
 */
package com.jiazu.web.shop.dao;

import java.util.Map;

import com.jiazu.web.base.dao.BaseDao;
import com.jiazu.web.shop.entity.B2C;

/**
 * @author Architect.bian
 *
 */
public interface B2CDao extends BaseDao<B2C> {

	/**
	 * @param map
	 * @return
	 */
	int getCount(Map<String, Object> map);

}

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
 * Create at: 2012-8-5 下午7:12:22
 * ============================================================================
 */
package com.jiazu.web.shop.dao;

import java.util.Map;

import com.jiazu.web.base.dao.BaseDao;
/**
 * @author Architect.bian
 *
 */
public interface TestDao extends BaseDao {
	
	Map<String, String> getTest(int id);
	
	void insertTest(Map<String, String> map);
	
}

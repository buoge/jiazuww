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
 * Create at: 2012-8-22 上午7:04:18
 * ============================================================================
 */
package com.jiazu.web.shop.dao;

import com.jiazu.web.base.dao.BaseDao;
import com.jiazu.web.shop.entity.Content;

/**
 * @author Architect.bian
 *
 */
public interface ContentDao extends BaseDao<Content> {
	/**
	 * 通过ID查询数据库，返回对象
	 * @param id 对应数据库中oid
	 * @return
	 */
	Content get(int id);
	
	@Deprecated
	Content get(String uid);
	
	void delete(int id);
	
	@Deprecated
	void delete(String s);
}

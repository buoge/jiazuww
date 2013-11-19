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
 * Create at: 2012-8-19 下午9:02:05
 * ============================================================================
 */
package com.jiazu.web.platform.dao;

import java.util.Map;

import com.jiazu.web.base.dao.BaseDao;
import com.jiazu.web.platform.entity.Gallery;

/**
 * @author Architect.bian
 *
 */
public interface GalleryDao extends BaseDao<Gallery> {

	/**
	 * @param map
	 */
	void increase(Map<String, Object> map);

}

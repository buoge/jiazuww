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
 * Create at: 2012-8-22 上午7:01:35
 * ============================================================================
 */
package com.jiazu.web.shop.dao;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.jiazu.web.base.dao.BaseDao;
import com.jiazu.web.shop.entity.Gallery;

/**
 * @author Architect.bian
 *
 */
@Component("shopGalleryDao")
public interface GalleryDao extends BaseDao<Gallery> {

	/**
	 * @param map
	 * @return
	 */
	Object deleteByMap(Map<String, Object> map);

}

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
 * Create at: 2012-11-7 上午11:53:12
 * ============================================================================
 */
package com.jiazu.web.shop.service;

import java.util.List;

import com.jiazu.web.shop.entity.Gallery;

/**
 * @author Architect.bian
 *
 */
public interface GallerySO {

	/**
	 * @param groupuid
	 * @return
	 */
	List<Gallery> getList(String groupuid);

	/**
	 * @param g
	 * @return
	 */
	boolean add(Gallery g);

	/**
	 * @param uid
	 * @return
	 */
	boolean delete(String uid);

	/**
	 * @param g
	 * @return
	 */
	boolean update(Gallery g);

	/**
	 * @param groupuid
	 * @return
	 */
	boolean deleteByGroupuid(String groupuid);

	/**
	 * @param uid
	 * @return
	 */
	Gallery get(String uid);

	/**
	 * @param uid
	 * @param isdefault 
	 * @return
	 */
	boolean updateDefault(String uid, boolean isdefault);

}

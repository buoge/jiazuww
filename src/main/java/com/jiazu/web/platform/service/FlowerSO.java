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
 * Create at: 2012-12-8 上午10:37:40
 * ============================================================================
 */
package com.jiazu.web.platform.service;

import java.util.List;

import com.jiazu.web.platform.entity.Flower;

/**
 * @author Architect.bian
 *
 */
public interface FlowerSO {

	/**
	 * @param uid
	 * @return
	 */
	Flower get(String uid);

	/**
	 * @return
	 */
	List<Flower> getList();

	/**
	 * @param flower
	 * @return
	 */
	boolean update(Flower flower);

	/**
	 * @param flower
	 * @return
	 */
	boolean add(Flower flower);

	/**
	 * @param uid
	 * @return
	 */
	boolean delete(String uid);

}

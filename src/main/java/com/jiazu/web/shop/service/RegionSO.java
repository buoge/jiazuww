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
 * Create at: 2012-11-8 下午12:45:45
 * ============================================================================
 */
package com.jiazu.web.shop.service;

import java.util.List;

import com.jiazu.web.shop.entity.Region;

/**
 * @author Architect.bian
 *
 */
public interface RegionSO {

	/**
	 * @return
	 */
	List<Region> getProvinceList();

	/**
	 * @param pid
	 * @return
	 */
	List<Region> getList(String pid);

}

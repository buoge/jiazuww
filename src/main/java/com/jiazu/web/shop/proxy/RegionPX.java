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
 * Create at: 2012-11-8 下午12:44:26
 * ============================================================================
 */
package com.jiazu.web.shop.proxy;

import java.util.List;

import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.shop.entity.Region;
import com.jiazu.web.shop.service.RegionSO;

/**
 * @author Architect.bian
 *
 */
public class RegionPX extends BasePX {

	/**
	 * @return
	 */
	public static List<Region> getProvinceList() {
		RegionSO so = (RegionSO)spring.getBean(RegionSO.class);
		return so.getProvinceList();
	}

	/**得到子集
	 * @param pid
	 * @return
	 */
	public static List<Region> getList(String pid) {
		RegionSO so = (RegionSO)spring.getBean(RegionSO.class);
		return so.getList(pid);
	}

}

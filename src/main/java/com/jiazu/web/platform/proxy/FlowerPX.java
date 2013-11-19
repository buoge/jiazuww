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
 * Create at: 2012-12-8 上午10:36:07
 * ============================================================================
 */
package com.jiazu.web.platform.proxy;

import java.util.List;

import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.entity.Flower;
import com.jiazu.web.platform.service.FlowerSO;

/**
 * @author Architect.bian
 *
 */
public class FlowerPX extends BasePX {
	
	/**
	 * @param uid
	 * @return
	 */
	public static List<Flower> getList() {
		FlowerSO so = (FlowerSO)spring.getBean(FlowerSO.class);
		return so.getList();
	}

	/**
	 * @param uid
	 * @return
	 */
	public static Flower get(String uid) {
		FlowerSO so = (FlowerSO)spring.getBean(FlowerSO.class);
		return so.get(uid);
	}

	/**
	 * @param flower
	 * @return
	 */
	public static boolean update(Flower flower) {
		FlowerSO so = (FlowerSO)spring.getBean(FlowerSO.class);
		return so.update(flower);
	}

	/**
	 * @param flower
	 * @return
	 */
	public static boolean add(Flower flower) {
		FlowerSO so = (FlowerSO)spring.getBean(FlowerSO.class);
		return so.add(flower);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean delete(String uid) {
		FlowerSO so = (FlowerSO)spring.getBean(FlowerSO.class);
		return so.delete(uid);
	}
	
}

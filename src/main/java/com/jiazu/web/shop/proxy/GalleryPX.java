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
 * Create at: 2012-11-7 上午11:51:01
 * ============================================================================
 */
package com.jiazu.web.shop.proxy;

import java.util.List;

import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.shop.entity.Gallery;
import com.jiazu.web.shop.service.GallerySO;

/**
 * @author Architect.bian
 *
 */
public class GalleryPX extends BasePX {

	/**
	 * @param uid
	 * @return
	 */
	public static List<Gallery> getList(String groupuid) {
		GallerySO so = (GallerySO)spring.getBean(GallerySO.class);
		return so.getList(groupuid);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean add(Gallery g) {
		GallerySO so = (GallerySO)spring.getBean(GallerySO.class);
		return so.add(g);
	}
	
	/**
	 * @param uid
	 * @return
	 */
	public static Gallery get(String uid) {
		GallerySO so = (GallerySO)spring.getBean(GallerySO.class);
		return so.get(uid);
	}
	
	/**
	 * @param uid
	 * @return
	 */
	public static boolean delete(String uid) {
		GallerySO so = (GallerySO)spring.getBean(GallerySO.class);
		return so.delete(uid);
	}
	/**
	 * @param uid
	 * @return
	 */
	public static boolean update(Gallery g) {
		GallerySO so = (GallerySO)spring.getBean(GallerySO.class);
		return so.update(g);
	}

	/**
	 * @param uid
	 */
	public static boolean deleteByGroupuid(String groupuid) {
		GallerySO so = (GallerySO)spring.getBean(GallerySO.class);
		return so.deleteByGroupuid(groupuid);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean updateDefault(String uid, boolean isdefault) {
		GallerySO so = (GallerySO)spring.getBean(GallerySO.class);
		return so.updateDefault(uid, isdefault);
	}
}

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
 * Create at: 2012-9-9 上午6:57:01
 * ============================================================================
 */
package com.jiazu.web.platform.proxy;

import java.util.List;

import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.entity.Gallery;
import com.jiazu.web.platform.service.CustomSO;

/**
 * @author Architect.bian
 *
 */
public class CustomPX extends BasePX {

	/**
	 * 从数据库中读取istop的记录或者点击数最多的记录，并保存到缓存中
	 * 若缓存中存在，则直接从缓存中取
	 * @param j 
	 * @return
	 */
	public static List<Gallery> getTop(int j) {
		CustomSO so = (CustomSO)spring.getBean(CustomSO.class);
		return so.getTop(j);
	}

	/**
	 * @param uid 
	 * @param page
	 * @return
	 */
	public static List<Gallery> getList(String uid, Pager pager) {
		CustomSO so = (CustomSO)spring.getBean(CustomSO.class);
		return so.getList(uid, pager);
	}

	/**
	 * @param pager
	 * @return
	 */
	public static List<Gallery> getList(Pager pager) {
		CustomSO so = (CustomSO)spring.getBean(CustomSO.class);
		return so.getList(pager);
	}
	
	/**
	 * @param uid
	 * @return
	 */
	public static Gallery get(String uid) {
		CustomSO so = (CustomSO)spring.getBean(CustomSO.class);
		return so.get(uid);
	}

	/**
	 * @param gallery
	 * @return
	 */
	public static boolean add(Gallery gallery) {
		CustomSO so = (CustomSO)spring.getBean(CustomSO.class);
		return so.add(gallery);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean delete(String uid) {
		CustomSO so = (CustomSO)spring.getBean(CustomSO.class);
		return so.delete(uid);
	}

	/**
	 * @return
	 */
	public static List<Gallery> getTopList() {
		CustomSO so = (CustomSO)spring.getBean(CustomSO.class);
		return so.getTopList();
	}

	/**
	 * @param uid
	 * @param b
	 * @return
	 */
	public static boolean setTop(String uid, boolean istop) {
		CustomSO so = (CustomSO)spring.getBean(CustomSO.class);
		return so.setTop(uid, istop);
	}

	/**
	 * @param uid
	 */
	public static boolean increaseClickCount(String uid) {
		CustomSO so = (CustomSO)spring.getBean(CustomSO.class);
		return so.increaseClickCount(uid);
	}

}

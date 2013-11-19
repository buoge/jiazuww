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
 * Create at: 2012-10-21 下午3:54:10
 * ============================================================================
 */
package com.jiazu.web.platform.service;

import java.util.List;

import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.Gallery;

/**
 * @author Architect.bian
 *
 */
public interface CustomSO {

	/**
	 * @param gallery
	 * @return
	 */
	boolean add(Gallery gallery);

	/**
	 * @param uid 
	 * @param pager
	 * @return
	 */
	List<Gallery> getList(String uid, Pager pager);

	/**
	 * @param pager
	 * @return
	 */
	List<Gallery> getList(Pager pager);

	/**
	 * @param uid
	 * @return
	 */
	boolean delete(String uid);

	/**
	 * @param j
	 * @return
	 */
	List<Gallery> getTop(int j);

	/**
	 * @param uid
	 * @return
	 */
	Gallery get(String uid);

	/**
	 * @return
	 */
	List<Gallery> getTopList();

	/**
	 * @param uid
	 * @param istop
	 * @return
	 */
	boolean setTop(String uid, boolean istop);

	/**
	 * @param uid
	 * @return
	 */
	boolean increaseClickCount(String uid);

}

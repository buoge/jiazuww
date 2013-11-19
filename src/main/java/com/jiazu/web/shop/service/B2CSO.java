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
 * Create at: 2012-11-4 下午1:03:20
 * ============================================================================
 */
package com.jiazu.web.shop.service;

import java.util.List;
import java.util.Map;

import com.jiazu.global.constants.EB2C;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.shop.entity.B2C;

/**
 * @author Architect.bian
 *
 */
public interface B2CSO {

	/**
	 * @param pager
	 * @return
	 */
	List<B2C> getList(Pager pager);

	/**
	 * @param pager
	 * @return
	 */
	List<B2C> getBooksList(Pager pager);

	/**
	 * @param i
	 * @return
	 */
	List<B2C> getB2CTxtTop(int i);

	/**
	 * @param i
	 * @return
	 */
	List<B2C> getB2CImgTop(int i);

	/**
	 * @param i
	 * @return
	 */
	List<B2C> getBookListTop(int i);

	/**
	 * @param i
	 * @return
	 */
	List<B2C> getCultureProdsTop(int i);

	/**
	 * @param i
	 * @return
	 */
	List<B2C> getEduToolsTop(int i);

	/**
	 * @param i
	 * @return
	 */
	List<B2C> getBooksTop(int i);

	/**
	 * @param i
	 * @return
	 */
	List<B2C> getSoftwaresTop(int i);

	/**
	 * @return
	 */
	int getCultureProdAmount();

	/**
	 * @return
	 */
	int getEduToolsAmount();

	/**
	 * @return
	 */
	int getBooksAmount();

	/**
	 * @return
	 */
	int getSoftwareAmount();

	/**
	 * @param type
	 * @param pager
	 * @return
	 */
	List<B2C> getListByType(EB2C type, Pager pager);

	/**
	 * @param pager
	 * @return
	 */
	List<B2C> getHotList(Pager pager);

	/**
	 * @param uid
	 * @return
	 */
	B2C get(String uid);

	/**
	 * @param s
	 * @param pager
	 * @return
	 */
	List<B2C> search(String s, Pager pager);

	/**
	 * @param b2c
	 * @return
	 */
	boolean add(B2C b2c);

	/**
	 * @param uid
	 * @return
	 */
	boolean delete(String uid);

	/**
	 * @param b2c
	 * @return
	 */
	boolean update(B2C b2c);

	/**
	 * @param map
	 * @return
	 */
	List<B2C> getList(Map<String, Object> map);

}

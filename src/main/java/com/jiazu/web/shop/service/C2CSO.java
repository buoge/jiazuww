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
 * Create at: 2012-10-28 下午2:36:47
 * ============================================================================
 */
package com.jiazu.web.shop.service;

import java.util.List;
import java.util.Map;

import com.jiazu.global.constants.EC2C;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.shop.entity.C2C;

/**
 * @author Architect.bian
 *
 */
public interface C2CSO {

	/**
	 * @param c2c
	 * @return
	 */
	boolean create(C2C c2c);

	/**
	 * @param c2c
	 * @return
	 */
	boolean updateInfo(C2C c2c);

	/**
	 * @param uid
	 * @return
	 */
	C2C get(String uid);

	/**
	 * @param uid
	 * @return
	 */
	boolean delete(String uid);

	/**
	 * @param uid
	 * @param pager
	 * @return
	 */
	List<C2C> getList(String uid, Pager pager);

	/**
	 * @param i
	 * @return
	 */
	List<C2C> getCharityTop(int i);

	/**
	 * @param pager
	 * @return
	 */
	List<C2C> getList(Pager pager);

	/**
	 * @param pager
	 * @return
	 */
	List<C2C> getCharityList(Pager pager);

	/**
	 * @param i
	 * @return
	 */
	List<C2C> getC2CBestTop(int i);

	/**
	 * @param i
	 * @return
	 */
	List<C2C> getTopList(int i);

	/**
	 * @param pager
	 * @return
	 */
	List<C2C> getProdList(Pager pager);

	/**
	 * @param types
	 * @param pager
	 * @return
	 */
	List<C2C> getListByType(EC2C[] types, Pager pager);

	/**
	 * @param s
	 * @param pager
	 * @return
	 */
	List<C2C> search(String s, Pager pager);

	/**
	 * @param s
	 * @param groupuids
	 * @return
	 */
	List<C2C> search(String s, String groupuids);

	/**
	 * @return
	 */
	List<C2C> getTopList();

	/**
	 * @param uid
	 * @param istop
	 * @return
	 */
	boolean setTop(String uid, boolean istop);

	/**
	 * @param c2c
	 * @return
	 */
	boolean update(C2C c2c);

	/**
	 * @param uid
	 * @param status
	 * @return
	 */
	boolean updateStatus(String uid, boolean status);

	/**
	 * @param uid
	 * @param pager
	 * @return
	 */
	List<C2C> getDisableList(String useruid, Pager pager);

	/**
	 * @param map
	 * @return
	 */
	List<C2C> getList(Map<String, Object> map);

}

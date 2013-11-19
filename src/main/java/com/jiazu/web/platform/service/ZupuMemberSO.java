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
 * Create at: 2012-10-28 下午4:46:28
 * ============================================================================
 */
package com.jiazu.web.platform.service;

import java.util.List;

import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.ZupuMember;

/**
 * @author Architect.bian
 *
 */
public interface ZupuMemberSO {

	/**
	 * @param groupuid
	 * @return
	 */
	List<ZupuMember> getList(String groupuid);

	/**
	 * @param member
	 * @return
	 */
	boolean add(ZupuMember member);

	/**
	 * @param uid
	 * @return
	 */
	boolean delete(String uid);

	/**
	 * @param uid
	 * @return
	 */
	ZupuMember get(String uid);

	/**
	 * @param pager 
	 * @param uid
	 * @return
	 */
	List<ZupuMember> getJisiList(String groupuid, Pager pager);

	/**
	 * @param m
	 * @return
	 */
	boolean update(ZupuMember m);

}

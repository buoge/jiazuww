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
 * Create at: 2012-10-27 上午11:30:25
 * ============================================================================
 */
package com.jiazu.web.platform.service;

import com.jiazu.web.platform.entity.Member;

/**
 * @author Architect.bian
 *
 */
public interface MemberSO {

	/**
	 * @param uid
	 * @param select
	 * @return
	 */
	boolean addMembers(String uid, String[] select);

	/**
	 * @param uid
	 * @param select
	 * @return
	 */
	boolean delMembers(String uid, String[] select);

	/**
	 * @param uid
	 * @param select
	 * @return
	 */
	boolean setAdmin(String uid, String[] select);

	/**
	 * @param uid
	 * @param select
	 * @return
	 */
	boolean cancelAdmin(String uid, String[] select);

	/**
	 * @param uid
	 * @param useruid
	 * @return
	 */
	Member getOne(String uid, String useruid);

}

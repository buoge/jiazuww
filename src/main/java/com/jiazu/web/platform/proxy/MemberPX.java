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
 * Create at: 2012-10-27 上午11:28:38
 * ============================================================================
 */
package com.jiazu.web.platform.proxy;

import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.entity.Member;
import com.jiazu.web.platform.service.MemberSO;

/**
 * @author Architect.bian
 *
 */
public class MemberPX extends BasePX {

	/**
	 * @param uid
	 * @param select
	 * @return
	 */
	public static boolean addMembers(String uid, String[] select) {
		MemberSO so = (MemberSO)spring.getBean(MemberSO.class);
		return so.addMembers(uid, select);
	}

	/**
	 * @param uid
	 * @param select
	 * @return
	 */
	public static boolean delMembers(String uid, String[] select) {
		MemberSO so = (MemberSO)spring.getBean(MemberSO.class);
		return so.delMembers(uid, select);
	}

	/**
	 * @param uid
	 * @param select
	 * @return
	 */
	public static boolean setAdmin(String uid, String[] select) {
		MemberSO so = (MemberSO)spring.getBean(MemberSO.class);
		return so.setAdmin(uid, select);
	}

	/**
	 * @param uid
	 * @param select
	 * @return
	 */
	public static boolean cancelAdmin(String uid, String[] select) {
		MemberSO so = (MemberSO)spring.getBean(MemberSO.class);
		return so.cancelAdmin(uid, select);
	}

	/**
	 * @param uid
	 * @param uid2
	 * @return
	 */
	public static Member getOne(String uid, String useruid) {
		MemberSO so = (MemberSO)spring.getBean(MemberSO.class);
		return so.getOne(uid, useruid);
	}

}

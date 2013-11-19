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
 * Create at: 2012-10-14 下午1:27:32
 * ============================================================================
 */
package com.jiazu.web.platform.service;

import java.util.List;
import java.util.Map;

import com.jiazu.global.constants.EStatus;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.Jiazu;
import com.jiazu.web.platform.entity.Member;

/**
 * @author Architect.bian
 *
 */
public interface JiaZuSO {

	/**
	 * @param name
	 * @param user
	 * @return
	 */
	boolean add(Jiazu j);

	/**
	 * @param useruid
	 * @return
	 */
	List<Jiazu> getList(String useruid);

	Jiazu get(String uid);

	boolean updateLogo(String uid, String logoorignial, String logo, String headimg);

	/**
	 * @param uid
	 * @param brief
	 * @return
	 */
	boolean updateBrief(String uid, String brief);

	/**
	 * @param uid
	 * @param desc
	 * @return
	 */
	boolean updateHistroy(String uid, String desc);

	/**
	 * @param uid
	 * @return
	 */
	List<Member> getAdminListByGroupUid(String uid);

	/**
	 * @param uid
	 * @return
	 */
	List<Member> getListByGroupUid(String uid);

	/**
	 * @param uid
	 * @param pager 
	 * @return
	 */
	List<Member> getMemberListByGroupUid(String uid, Pager pager);

	/**
	 * @param uid
	 * @return
	 */
	boolean delete(String uid);

	/**
	 * @param uid
	 * @param useruid
	 * @return
	 */
	boolean quit(String uid, String useruid);

	/**
	 * @param uid
	 * @param name
	 * @return
	 */
	boolean updateName(String uid, String name);

	/**
	 * @param name
	 * @return
	 */
	List<Jiazu> getListByName(String name);

	/**
	 * @param uid
	 * @param useruid
	 * @return
	 */
	boolean add(String uid, String useruid);

	/**
	 * @return
	 */
	int getCount();

	/**
	 * @param pager
	 * @return
	 */
	List<Jiazu> getList(Pager pager);

	/**
	 * @param groupuid
	 * @return
	 */
	int getMemberCount(String groupuid);

	/**
	 * @param currUid
	 * @param useruid
	 * @return
	 */
	boolean isGroupMember(String groupuid, String useruid);

	/**
	 * @param uid
	 * @param status
	 * @return
	 */
	boolean updateStatus(String uid, EStatus status);

	/**
	 * @param uid
	 * @return
	 */
	Member getOwnerByGroupUid(String uid);

	/**
	 * @param useruid
	 * @param pager
	 * @return
	 */
	List<Jiazu> getList(String useruid, Pager pager);

	/**
	 * @param map
	 * @return
	 */
	List<Jiazu> getList(Map<String, Object> map);

}

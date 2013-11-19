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
 * Create at: 2012-10-18 上午8:05:45
 * ============================================================================
 */
package com.jiazu.web.platform.service;

import java.util.List;
import java.util.Map;

import com.jiazu.global.constants.EEducation;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.Education;

/**
 * @author Architect.bian
 *
 */
public interface EduSO {

	/**
	 * @param edu
	 * @return
	 */
	boolean add(Education edu);

	List<Education> getHomeList(String uid, Pager pager);

	Education get(int id);

	boolean update(Education edu);

	/**
	 * @param i
	 * @return
	 */
	List<Education> getTop(int i);

	/**
	 * @param pager
	 * @return
	 */
	List<Education> getList(Pager pager);

	/**
	 * @param i
	 * @return
	 */
	List<Education> getHomeListTop(int i);

	/**
	 * @param i
	 * @return
	 */
	List<Education> getProfessionalListTop(int i);

	/**
	 * @param i
	 * @return
	 */
	List<Education> getFamousListTop(int i);

	/**
	 * @param type
	 * @param pager
	 * @return
	 */
	List<Education> getList(EEducation type, Pager pager);

	/**
	 * @param s
	 * @param pager
	 * @return
	 */
	List<Education> search(String s, Pager pager);

	/**
	 * @param s
	 * @param groupuids
	 * @return
	 */
	List<Education> search(String s, String groupuids);

	/**
	 * @param uid
	 * @return
	 */
	boolean delete(int uid);

	/**
	 * @param map
	 * @return
	 */
	List<Education> getList(Map<String, Object> map);

	/**
	 * @param id
	 * @param b
	 * @return
	 */
	boolean updateRecommend(int id, boolean b);

	/**
	 * @param i
	 * @return
	 */
	List<Education> getIndex(int i);

	/**
	 * @param id
	 * @return
	 */
	boolean increaseClickCount(String id);

	/**
	 * @param uid
	 * @param pager
	 * @return
	 */
	List<Education> getMyHomeList(String uid, Pager pager);

}

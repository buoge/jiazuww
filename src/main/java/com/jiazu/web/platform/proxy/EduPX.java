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
 * Create at: 2012-9-8 下午10:15:00
 * ============================================================================
 */
package com.jiazu.web.platform.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jiazu.global.constants.EEducation;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.entity.Education;
import com.jiazu.web.platform.entity.Member;
import com.jiazu.web.platform.entity.Search;
import com.jiazu.web.platform.service.EduSO;

/**
 * @author Architect.bian
 *
 */
public class EduPX extends BasePX {

	/**
	 * @param j 
	 * @return
	 */
	public static List<Education> getTop(int i) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.getTop(i);
	}
	/**
	 * @param j 
	 * @return
	 */
	public static List<Education> getIndex(int i) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.getIndex(i);
	}

	/**
	 * @param useruid2 
	 * @param string
	 * @return
	 */
	public static int getNewEduCount(String groupuid, String useruid) {
		List<String> list;
		try {
			list = SysPX.getNewEduList_StatisticsUser(groupuid, useruid);
			if (list == null) {
				return 0;
			} else {
				return list.size();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//TODO 记录日志
			return - 1;
		}
	}

	/**
	 * @param i
	 * @return
	 */
	public static List<Education> getFamousListTop(int i) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.getFamousListTop(i);
	}

	/**
	 * @param i
	 * @return
	 */
	public static List<Education> getProfessionalListTop(int i) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.getProfessionalListTop(i);
	}

	/**
	 * @param i
	 * @return
	 */
	public static List<Education> getHomeListTop(int i) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.getHomeListTop(i);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static Education get(int id) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.get(id);
	}

	/**
	 * @param pager
	 * @return
	 */
	public static List<Education> getList(Pager pager) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.getList(pager);
	}

	/**
	 * @param eEducation
	 * @param pager
	 * @return
	 */
	public static List<Education> getList(EEducation type, Pager pager) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.getList(type, pager);
	}

	/**
	 * @param uid
	 * @param pager
	 * @return
	 */
	public static List<Education> getHomeList(String uid, Pager pager) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.getHomeList(uid, pager);
	}

	/**
	 * @param edu
	 */
	public static boolean add(Education edu) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.add(edu);
	}

	public static boolean update(Education edu) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.update(edu);
	}

	/**
	 * @param s
	 * @param pager
	 * @return
	 */
	public static List<Education> search(String s, Pager pager) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.search(s, pager);
	}

	/**
	 * @param s
	 * @return
	 */
	public static List<Search> getSearchResult(String s) {
		List<Search> list = new ArrayList<>();
		List<Education> edus = search(s, new Pager());
		if (edus != null) {
			for (Education edu : edus) {
				list.add(new Search(edu));
			}
		}
		return list;
	}

	/**
	 * @param s
	 * @param groupuids
	 * @return
	 */
	public static List<Search> getSearchResult(String s, String groupuids) {
		List<Search> list = new ArrayList<>();
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		List<Education> edus = so.search(s, groupuids);
		for (Education edu : edus) {
			list.add(new Search(edu));
		}
		return list;
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean delete(int id) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.delete(id);
	}

	/**
	 * @param uid
	 * @param uid2
	 * @param uid3
	 */
	public static void addNewEduList_StatisticsUser(String groupuid, String valueuid) {
		List<Member> list = JiazuPX.getListByGroupUid(groupuid);
		for (Member mem : list) {
			SysPX.addNewEduList_StatisticsUser(groupuid, mem.getUseruid(), valueuid);
		}
	}

	/**
	 * @param map
	 * @return
	 */
	public static List<Education> getList(Map<String, Object> map) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.getList(map);
	}

	/**
	 * @param valueOf
	 * @param boolean1
	 * @return
	 */
	public static boolean updateRecommend(int id, boolean b) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.updateRecommend(id, b);
	}
	/**
	 * @param id
	 */
	public static boolean increaseClickCount(String id) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.increaseClickCount(id);
	}
	/**
	 * @param uid
	 * @param pager
	 * @return
	 */
	public static List<Education> getMyHomeList(String uid, Pager pager) {
		EduSO so = (EduSO)spring.getBean(EduSO.class);
		return so.getMyHomeList(uid, pager);
	}
}

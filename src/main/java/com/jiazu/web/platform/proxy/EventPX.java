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
 * Create at: 2012-9-9 下午3:04:38
 * ============================================================================
 */
package com.jiazu.web.platform.proxy;

import java.util.ArrayList;
import java.util.List;

import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.entity.Event;
import com.jiazu.web.platform.entity.Member;
import com.jiazu.web.platform.entity.Search;
import com.jiazu.web.platform.service.EventSO;

/**
 * @author Architect.bian
 *
 */
public class EventPX extends BasePX {
	
	/**
	 * @param pager
	 * @return
	 */
	public static List<Event> getList(Pager pager) {
		EventSO so = (EventSO)spring.getBean(EventSO.class);
		List<Event> list = so.getList(pager);
		return list;
	}

	/**
	 * @param uid 
	 * @return
	 */
	public static List<Event> getList(String uid, Pager pager) {
		EventSO so = (EventSO)spring.getBean(EventSO.class);
		return so.getList(uid, pager);
	}

	/**
	 * @param useruid2 
	 * @param string
	 * @return
	 */
	public static int getNewEventCount(String groupuid, String useruid) {
		List<String> list;
		try {
			list = SysPX.getNewEventList_StatisticsUser(groupuid, useruid);
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
	 * @param event
	 * @return
	 */
	public static boolean add(Event event) {
		EventSO so = (EventSO)spring.getBean(EventSO.class);
		return so.add(event);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean delete(String uid) {
		EventSO so = (EventSO)spring.getBean(EventSO.class);
		return so.delete(uid);
	}

	/**
	 * @param s
	 * @param pager
	 * @return
	 */
	public static List<Event> search(String s, Pager pager) {
		EventSO so = (EventSO)spring.getBean(EventSO.class);
		return so.search(s, pager);
	}

	/**
	 * @param s
	 * @return
	 */
	public static List<Search> getSearchResult(String s) {
		List<Search> result = new ArrayList<>();
		List<Event> list = search(s, new Pager());
		if (list != null) {
			for (Event item : list) {
				result.add(new Search(item));
			}
		}
		return result;
	}

	/**
	 * @param s
	 * @param groupuids
	 * @return
	 */
	public static List<Search> getSearchResult(String s, String groupuids) {
		List<Search> list = new ArrayList<>();
		EventSO so = (EventSO)spring.getBean(EventSO.class);
		List<Event> events = so.search(s, groupuids);
		for (Event event : events) {
			list.add(new Search(event));
		}
		return list;
	}

	/**
	 * @param uid
	 * @param top
	 * @return
	 */
	public static boolean updateTop(String uid, boolean top) {
		EventSO so = (EventSO)spring.getBean(EventSO.class);
		return so.updateTop(uid, top);
	}

	/**
	 * @param groupuid
	 * @param valueuid
	 */
	public static boolean addNewEventList_StatisticsUser(String groupuid, String valueuid) {
		try {
			List<Member> list = JiazuPX.getListByGroupUid(groupuid);
			for (Member mem : list) {
				SysPX.addNewEventList_StatisticsUser(groupuid, mem.getUseruid(), valueuid);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param uid
	 * @param pager
	 * @return
	 */
	public static List<Event> getMyList(String uid, Pager pager) {
		EventSO so = (EventSO)spring.getBean(EventSO.class);
		List<Event> list = so.getMyList(uid, pager);
		return list;
	}

	/**
	 * @param uid
	 * @return
	 */
	public static Event get(String uid) {
		EventSO so = (EventSO)spring.getBean(EventSO.class);
		return so.get(uid);
	}

}

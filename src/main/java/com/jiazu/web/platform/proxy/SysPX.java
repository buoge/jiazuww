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
 * Create at: 2012-9-8 下午10:07:38
 * ============================================================================
 */
package com.jiazu.web.platform.proxy;

import java.util.ArrayList;
import java.util.List;

import com.jiazu.core.cache.Rule;
import com.jiazu.core.cache.impl.CacheFacade;
import com.jiazu.core.cache.rule.GroupRule;
import com.jiazu.core.cache.rule.SysRule;
import com.jiazu.core.cache.rule.UserStatRule;
import com.jiazu.global.constants.CacheKeyConstant;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.entity.News;
import com.jiazu.web.shop.entity.StatisticsGroup;
import com.jiazu.web.shop.entity.StatisticsUser;

/**
 * @author Architect.bian
 *
 */
@SuppressWarnings("unchecked")
public class SysPX extends BasePX {

	private static final int maxSize = 30;
	
	/**
	 * 从缓存中读取家族动态
	 * @return 
	 * @throws Exception 
	 */
	public static List<News> getJiaZuNews() throws Exception {
		List<News> list = (List<News>)CacheFacade.get(new SysRule(CacheKeyConstant.jiazuNews));
		return list;
	}
	
	/**
	 * 将最新动态写入到缓存中
	 * @return
	 * @throws Exception 
	 */
	public static boolean addJiazuNews(String author, String headimg, String title, String desc) {
		News news = new News(author, headimg, title, desc);
		Rule rule = new SysRule(CacheKeyConstant.jiazuNews);
		try {
			return insertNews(rule, news);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * 从缓存中读取族谱动态
	 * @return 
	 * @throws Exception 
	 */
	public static List<News> getZupuNews() throws Exception {
		List<News> list = (List<News>)CacheFacade.get(new SysRule(CacheKeyConstant.zupuNews));
		return list;
	}
	
	/**
	 * 将最新动态写入到缓存中
	 * @return
	 * @throws Exception 
	 */
	public static boolean addZupuNews(String author, String headimg, String title, String desc) {
		News news = new News(author, headimg, title, desc);
		Rule rule = new SysRule(CacheKeyConstant.zupuNews);
		try {
			return insertNews(rule, news);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 将最新动态写入到缓存中
	 * @return
	 * @throws Exception 
	 */
	private static boolean insertNews(Rule rule, News news) throws Exception {
		List<News> list = (List<News>)CacheFacade.get(rule);
		if (list == null) {
			list = new ArrayList<News>();
		} else if (list.size() >= maxSize) {
			list.remove(maxSize - 1);
		}
		list.add(0, news);
		CacheFacade.set(rule, list);
		return true;
	}
	
	/**
	 * @return
	 */
	public static int getOnlineUsersCount() {
		return 387;
	}

	/**
	 * @param groupuid
	 * @param useruid
	 * @return
	 * @throws Exception 
	 */
	public static List<String> getNewEduList_StatisticsUser(String groupuid, String useruid) throws Exception {
		StatisticsUser stat = (StatisticsUser)CacheFacade.get(new UserStatRule(useruid));
		if (stat != null) {
			return stat.getNewEduList().get(groupuid);
		}
		return null;
	}
	
	public static boolean addNewEduList_StatisticsUser(String groupuid, String useruid, String valueuid) {
		try {
			Rule rule = new UserStatRule(useruid);
			StatisticsUser stat = (StatisticsUser)CacheFacade.get(rule);
			if (stat == null) {
				stat = new StatisticsUser(useruid);
			}
			List<String> list = stat.getNewEduList().get(groupuid);
			if (list == null) {
				list = new ArrayList<>();
			}
			list.add(valueuid);
			stat.getNewEduList().put(groupuid, list);
			CacheFacade.set(rule, stat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param groupuid
	 * @param useruid
	 * @return
	 * @throws Exception 
	 */
	public static List<String> getNewEventList_StatisticsUser(String groupuid, String useruid) throws Exception {
		StatisticsUser stat = (StatisticsUser)CacheFacade.get(new UserStatRule(useruid));
		if (stat != null) {
			return stat.getNewEventList().get(groupuid);
		}
		return null;
	}
	
	public static boolean addNewEventList_StatisticsUser(String groupuid, String useruid, String valueuid) {
		try {
			Rule rule = new UserStatRule(useruid);
			StatisticsUser stat = (StatisticsUser)CacheFacade.get(rule);
			if (stat == null) {
				stat = new StatisticsUser(useruid);
			}
			List<String> list = stat.getNewEventList().get(groupuid);
			if (list == null) {
				list = new ArrayList<>();
			}
			list.add(valueuid);
			stat.getNewEventList().put(groupuid, list);
			CacheFacade.set(rule, stat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param groupuid
	 * @return
	 * @throws Exception 
	 */
	public static int getMemberCount_StatisticsGroup(String groupuid) throws Exception {
		StatisticsGroup stat = (StatisticsGroup)CacheFacade.get(new GroupRule(groupuid));
		if (stat != null) {
			return stat.getMemberCount().get(groupuid);
		}
		return 0;
	}

	/**
	 * @param groupuid
	 * @param amount
	 * @throws Exception 
	 */
	public static boolean setMemberCount_StatisticsGroup(String groupuid, int count) {
		try {
			Rule rule = new GroupRule(groupuid);
			StatisticsGroup stat = (StatisticsGroup)CacheFacade.get(rule);
			if (stat == null) {
				stat = new StatisticsGroup();
			}
			stat.getMemberCount().put(groupuid, count);
			CacheFacade.set(rule, stat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	 * @param groupuid
	 * @param count 增加的数量 eg: 1, -1 , -3, 5
	 * @throws Exception
	 */
	public static boolean plusMemberCount_StatisticsGroup(String groupuid, int count) {
		try {
			Rule rule = new GroupRule(groupuid);
			StatisticsGroup stat = (StatisticsGroup)CacheFacade.get(rule);
			if (stat == null) {
				stat = new StatisticsGroup(groupuid);
			}
			if (stat.getMemberCount().containsKey(groupuid)) {
				count += stat.getMemberCount().get(groupuid);
			}
			stat.getMemberCount().put(groupuid, count);
			CacheFacade.set(rule, stat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param uid
	 * @param uid2
	 */
	public static boolean clearNewEduList_StatisticsUser(String groupuid, String useruid) {
		try {
			Rule rule = new UserStatRule(useruid);
			StatisticsUser stat = (StatisticsUser)CacheFacade.get(rule);
			if (stat == null) {
				stat = new StatisticsUser(useruid);
			}
			List<String> list = stat.getNewEduList().get(groupuid);
			if (list != null) {
				list.clear();
			} else {
				list = new ArrayList<>();
			}
			stat.getNewEduList().put(groupuid, list);
			CacheFacade.set(rule, stat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param groupuid
	 * @param useruid
	 */
	public static boolean clearNewEventList_StatisticsUser(String groupuid, String useruid) {
		try {
			Rule rule = new UserStatRule(useruid);
			StatisticsUser stat = (StatisticsUser)CacheFacade.get(rule);
			if (stat == null) {
				stat = new StatisticsUser(useruid);
			}
			List<String> list = stat.getNewEventList().get(groupuid);
			if (list != null) {
				list.clear();
			} else {
				list = new ArrayList<>();
			}
			stat.getNewEventList().put(groupuid, list);
			CacheFacade.set(rule, stat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param useruid
	 * @return
	 * @throws Exception 
	 */
	public static List<String> getUnreadMsgList_StatisticsUser(String useruid) throws Exception {
		StatisticsUser stat = (StatisticsUser)CacheFacade.get(new UserStatRule(useruid));
		if (stat != null) {
			return stat.getUnreadMsgList();
		}
		return null;
	}

	/**
	 * @param id
	 * @param uid Message的uid
	 */
	public static boolean plusUnreadMsgCount_StatisticsGroup(String useruid, String valueuid) {
		try {
			Rule rule = new UserStatRule(useruid);
			StatisticsUser stat = (StatisticsUser)CacheFacade.get(rule);
			if (stat == null) {
				stat = new StatisticsUser(useruid);
			}
			List<String> list = stat.getUnreadMsgList();
			if (list == null) {
				list = new ArrayList<>();
			}
			list.add(valueuid);
			CacheFacade.set(rule, stat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * @param uid
	 */
	public static boolean clearUnreadMsgList_StatisticsUser(String useruid) {
		try {
			Rule rule = new UserStatRule(useruid);
			StatisticsUser stat = (StatisticsUser)CacheFacade.get(rule);
			if (stat == null) {
				stat = new StatisticsUser(useruid);
			}
			List<String> list = stat.getUnreadMsgList();
			if (list != null) {
				list.clear();
			} else {
				list = new ArrayList<>();
			}
			CacheFacade.set(rule, stat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

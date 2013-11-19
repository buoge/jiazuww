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
 * Create at: 2012-9-16 下午1:31:46
 * ============================================================================
 */
package com.jiazu.web.platform.proxy;

import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

import com.jiazu.global.constants.EStatus;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.entity.Jiazu;
import com.jiazu.web.platform.entity.Member;
import com.jiazu.web.platform.entity.News;
import com.jiazu.web.platform.service.JiaZuSO;

/**
 * @author Architect.bian
 *
 */
public class JiazuPX extends BasePX {

	/**
	 * @param string
	 * @return
	 */
	public static Jiazu get(String uid) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.get(uid);
	}

	/**
	 * @param useruid
	 * @return
	 */
	public static List<Jiazu> getList(String useruid) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.getList(useruid);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static String getLogo(String uid) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		Jiazu j = so.get(uid);
		if (j != null) {
			return j.getLogo();
		}
		return null;
	}

	/**
	 * @param uid
	 * @return
	 */
	public static Jiazu getZupu(String uid) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		Jiazu j = so.get(uid);
		if (j != null) {
			j.setZupumembers(ZuPuPX.getMembers(uid, false));
		}
		return j;
	}

	/**
	 * @param name
	 * @return
	 */
	public static boolean create(Jiazu j) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.add(j);
	}

	/**
	 * @param uid
	 * @param path
	 * @return
	 */
	public static boolean updateLogo(String uid, String logoorignial, String logo, String headimg) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.updateLogo(uid, logoorignial, logo, headimg);
	}

	public static Object getLogoOriginal(String uid) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		Jiazu j = so.get(uid);
		if (j != null) {
			return j.getLogooriginal();
		}
		return null;
	}

	/**
	 * @param uid
	 * @param brief
	 * @return
	 */
	public static boolean updateBrief(String uid, String brief) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.updateBrief(uid, brief);
	}

	/**
	 * @param uid
	 * @param desc
	 * @return
	 */
	public static boolean updateHistory(String uid, String desc) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.updateHistroy(uid, desc);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static List<Member> getListByGroupUid(String uid) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.getListByGroupUid(uid);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static List<Member> getAdminListByGroupUid(String uid) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.getAdminListByGroupUid(uid);
	}

	/**
	 * @param uid
	 * @param pager 
	 * @return
	 */
	public static List<Member> getMemberListByGroupUid(String uid, Pager pager) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.getMemberListByGroupUid(uid, pager);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean delete(String uid) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.delete(uid);
	}

	/**
	 * @param uid
	 * @param uid2
	 * @return
	 */
	public static boolean quit(String uid, String useruid) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.quit(uid, useruid);
	}

	/**
	 * @param uid
	 * @param name
	 * @return
	 */
	public static boolean modify(String uid, String name) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.updateName(uid, name);
	}

	/**
	 * @param name
	 * @return
	 */
	public static List<Jiazu> getListByName(String name) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.getListByName(name);
	}

	/**
	 * @param uid
	 * @param uid2
	 * @return
	 */
	public static boolean add(String uid, String useruid) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.add(uid, useruid);
	}

	/**
	 * 从缓存中读取
	 * @param i
	 * @return
	 */
	public static List<News> getJiaZuNews(int i) {
		try {
			List<News> list = SysPX.getJiaZuNews();
			return list;
		} catch (Exception e) {
			logException(LoggerFactory.getLogger(JiazuPX.class), e);
			return null;
		}
	}

	public static int getCount() {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.getCount();
	}

	/**
	 * @param pager
	 * @return
	 */
	public static List<Jiazu> getList(Pager pager) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.getList(pager);
	}

	/**
	 * @param currUid
	 * @param useruid
	 * @return
	 */
	public static int getMemberCount(String groupuid) {
		try {
			int count = SysPX.getMemberCount_StatisticsGroup(groupuid);
			if (count >0) {
				return count;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		int amount = so.getMemberCount(groupuid);
		SysPX.setMemberCount_StatisticsGroup(groupuid, amount);
		return amount;
	}

	/**
	 * @param currUid
	 * @param useruid
	 * @return
	 */
	public static boolean isGroupMember(String groupuid, String useruid) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.isGroupMember(groupuid, useruid);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean updateStatus(String uid, EStatus status) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.updateStatus(uid, status);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static Member getOwerByGroupUid(String uid) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.getOwnerByGroupUid(uid);
	}

	/**
	 * @param uid
	 * @param pager
	 * @return
	 */
	public static List<Jiazu> getList(String useruid, Pager pager) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.getList(useruid, pager);
	}

	/**
	 * @param map
	 * @return
	 */
	public static List<Jiazu> getList(Map<String, Object> map) {
		JiaZuSO so = (JiaZuSO)spring.getBean(JiaZuSO.class);
		return so.getList(map);
	}
}

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
 * Create at: 2012-9-9 上午7:50:49
 * ============================================================================
 */
package com.jiazu.web.shop.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jiazu.global.constants.EC2C;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.entity.Search;
import com.jiazu.web.platform.service.EduSO;
import com.jiazu.web.shop.entity.C2C;
import com.jiazu.web.shop.service.C2CSO;

/**
 * @author Architect.bian
 * 
 */
public class C2CPX extends BasePX {

	/**
	 * @param i 
	 * @return
	 */
	public static List<C2C> getCharityTop(int i) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.getCharityTop(i);
	}

	/**
	 * @param i
	 * @return
	 */
	public static List<C2C> getProdListTop(int i) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.getTopList(i);
	}

	/**
	 * 首页显示
	 * @param i
	 * @return
	 */
	public static List<C2C> getC2CBestTop(int i) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.getC2CBestTop(i);
	}

	/**
	 * @param pager
	 * @return
	 */
	public static List<C2C> getProdList(Pager pager) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.getProdList(pager);
	}

	/**
	 * @param pager
	 * @return
	 */
	public static List<C2C> getCharityList(Pager pager) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.getCharityList(pager);
	}

	/**
	 * @param string
	 * @param pager
	 * @return
	 */
	public static List<C2C> getList(String uid, Pager pager) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.getList(uid, pager);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static C2C get(String uid) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.get(uid);
	}

	/**
	 * @param c2c
	 * @return
	 */
	public static boolean create(C2C c2c) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.create(c2c);
	}

	/**
	 * @param c2c
	 * @return
	 */
	public static boolean update(C2C c2c) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.updateInfo(c2c);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean delete(String uid) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.delete(uid);
	}

	/**
	 * @param types
	 * @param pager
	 * @return
	 */
	public static List<C2C> getListByType(EC2C[] types, Pager pager) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.getListByType(types, pager);
	}

	/**
	 * @param s
	 * @param pager
	 * @return
	 */
	public static List<C2C> search(String s, Pager pager) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.search(s, pager);
	}

	/**
	 * @param s
	 * @return
	 */
	public static List<Search> getSearchResult(String s) {
		List<Search> result = new ArrayList<>();
		List<C2C> list = search(s, new Pager());
		if (list != null) {
			for (C2C item : list) {
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
		C2CSO so = (C2CSO)spring.getBean(EduSO.class);
		List<C2C> c2cs = so.search(s, groupuids);
		for (C2C c2c : c2cs) {
			list.add(new Search(c2c));
		}
		return list;
	}

	/**
	 * @param pager
	 * @return
	 */
	public static List<C2C> getList(Pager pager) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.getList(pager);
	}

	/**
	 * @return
	 */
	public static List<C2C> getTopList() {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.getTopList();
	}

	/**
	 * @param uid
	 * @param b
	 * @return
	 */
	public static boolean setTop(String uid, boolean istop) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.setTop(uid, istop);
	}

	/**
	 * @param uid
	 * @param b
	 * @return
	 */
	public static boolean updateStatus(String uid, boolean status) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.updateStatus(uid, status);
	}

	/**
	 * @param uid
	 * @param pager
	 * @return
	 */
	public static List<C2C> getDisableList(String uid, Pager pager) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.getDisableList(uid, pager);
	}

	/**
	 * @param map
	 * @return
	 */
	public static List<C2C> getList(Map<String, Object> map) {
		C2CSO so = (C2CSO)spring.getBean(C2CSO.class);
		return so.getList(map);
	}
}

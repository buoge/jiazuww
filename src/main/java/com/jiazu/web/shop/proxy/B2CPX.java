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
 * Create at: 2012-9-11 下午10:22:50
 * ============================================================================
 */
package com.jiazu.web.shop.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jiazu.global.constants.EB2C;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.entity.Search;
import com.jiazu.web.shop.entity.B2C;
import com.jiazu.web.shop.entity.OrderDetail;
import com.jiazu.web.shop.service.B2CSO;

/**
 * @author Architect.bian
 *
 */
public class B2CPX extends BasePX {

	/**
	 * @return
	 */
	public static int getCultureProdAmount() {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getCultureProdAmount();
	}

	/**
	 * @return
	 */
	public static int getEduToolsAmount() {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getEduToolsAmount();
	}

	/**
	 * @return
	 */
	public static int getBooksAmount() {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getBooksAmount();
	}

	/**
	 * @return
	 */
	public static int getSoftwareAmount() {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getSoftwareAmount();
	}

	/**
	 * @return
	 */
	public static List<B2C> getCultureProdsTop(int i) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getCultureProdsTop(i);
	}

	/**
	 * @param i
	 * @return
	 */
	public static List<B2C> getEduToolsTop(int i) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getEduToolsTop(i);
	}

	/**
	 * @param i
	 * @return
	 */
	public static List<B2C> getBooksTop(int i) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getBooksTop(i);
	}

	/**
	 * @param i
	 * @return
	 */
	public static List<B2C> getSoftwaresTop(int i) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getSoftwaresTop(i);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static B2C get(String uid) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.get(uid);
	}

	/**
	 * @param i
	 * @return
	 */
	public static List<B2C> getBookListTop(int i) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getBookListTop(i);
	}

	/**
	 * @param pager
	 * @return
	 */
	public static List<B2C> getList(Pager pager) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getList(pager);
	}

	/**
	 * @param pager
	 * @return
	 */
	public static List<B2C> getBooksList(Pager pager) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getBooksList(pager);
	}

	/**
	 * @param i
	 * @return
	 */
	public static List<B2C> getB2CTxtTop(int i) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getB2CTxtTop(i);
	}

	/**
	 * @param i
	 * @return
	 */
	public static List<B2C> getB2CImgTop(int i) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getB2CImgTop(i);
	}

	/**
	 * @param type
	 * @param pager
	 * @return
	 */
	public static List<B2C> getListByType(EB2C type, Pager pager) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getListByType(type, pager);
	}

	/**
	 * @param pager
	 * @return
	 */
	public static List<B2C> getHotList(Pager pager) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getHotList(pager);
	}

	/**
	 * @param s
	 * @param pager
	 * @return
	 */
	public static List<B2C> search(String s, Pager pager) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.search(s, pager);
	}

	/**
	 * @param s
	 * @return
	 */
	public static List<Search> getSearchResult(String s) {
		List<Search> result = new ArrayList<>();
		List<B2C> list = search(s, new Pager());
		if (list != null) {
			for (B2C item : list) {
				result.add(new Search(item));
			}
		}
		return result;
	}

	/**
	 * @param b2c
	 * @return
	 */
	public static boolean add(B2C b2c) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.add(b2c);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean delete(String uid) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.delete(uid);
	}

	/**
	 * @param b2c
	 * @return
	 */
	public static boolean update(B2C b2c) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.update(b2c);
	}

	/**
	 * @param map
	 * @return
	 */
	public static List<B2C> getList(Map<String, Object> map) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		return so.getList(map);
	}

	/**
	 * @param details
	 */
	public static void plusSellCount(List<OrderDetail> details) {
		B2CSO so = (B2CSO)spring.getBean(B2CSO.class);
		for (OrderDetail orderDetail : details) {
			B2C b2c = so.get(orderDetail.getB2cuid());
			b2c.setSellcount(b2c.getSellcount() + orderDetail.getNum());
			so.update(b2c);
		}
	}
}

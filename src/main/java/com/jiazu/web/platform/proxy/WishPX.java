package com.jiazu.web.platform.proxy;

import java.util.List;

import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.entity.Wish;
import com.jiazu.web.platform.service.WishSO;

public class WishPX extends BasePX {

	public static boolean add(Wish wish) {
		WishSO so = (WishSO)spring.getBean(WishSO.class);
		return so.add(wish);
	}

	public static List<Wish> getList(String uid) {
		WishSO so = (WishSO)spring.getBean(WishSO.class);
		return so.getList(uid);
	}

	/**
	 * @param pager
	 * @return
	 */
	public static List<Wish> getList(Pager pager) {
		WishSO so = (WishSO)spring.getBean(WishSO.class);
		return so.getList(pager);
	}

	/**
	 * @param uid
	 */
	public static boolean delete(String uid) {
		WishSO so = (WishSO)spring.getBean(WishSO.class);
		return so.delete(uid);
	}

}

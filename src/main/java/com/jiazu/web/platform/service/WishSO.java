package com.jiazu.web.platform.service;

import java.util.List;

import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.Wish;

public interface WishSO {

	boolean add(Wish wish);

	List<Wish> getList(String uid);

	/**
	 * @param pager
	 * @return
	 */
	List<Wish> getList(Pager pager);

	/**
	 * @param uid
	 * @return
	 */
	boolean delete(String uid);

}

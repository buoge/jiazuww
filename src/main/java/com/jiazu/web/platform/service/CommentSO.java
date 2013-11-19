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
 * Create at: 2012-11-6 下午4:54:44
 * ============================================================================
 */
package com.jiazu.web.platform.service;

import java.util.List;

import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.Comment;

/**
 * @author Architect.bian
 *
 */
public interface CommentSO {

	/**
	 * @param comment
	 * @return
	 */
	boolean add(Comment comment);

	/**
	 * @param fromuid
	 * @param pager
	 * @return
	 */
	List<Comment> getList(String fromuid, Pager pager);

	/**
	 * @param uid
	 * @return
	 */
	boolean delete(String uid);

	/**
	 * @param pager
	 * @return
	 */
	List<Comment> getList(Pager pager);

	/**
	 * @param groupuid
	 * @return
	 */
	boolean deleteByGroupuid(String groupuid);

	/**
	 * @param fromuid
	 * @return
	 */
	int getCount(String fromuid);

}

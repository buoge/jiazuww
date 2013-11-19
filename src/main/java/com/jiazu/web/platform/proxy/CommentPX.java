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
 * Create at: 2012-11-6 上午10:36:04
 * ============================================================================
 */
package com.jiazu.web.platform.proxy;

import java.util.List;

import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.entity.Comment;
import com.jiazu.web.platform.service.CommentSO;

/**
 * @author Architect.bian
 *
 */
public class CommentPX extends BasePX {

	/**
	 * @param comment
	 * @return
	 */
	public static boolean add(Comment comment) {
		CommentSO so = (CommentSO)spring.getBean(CommentSO.class);
		return so.add(comment);
	}

	/**
	 * @param uid
	 * @param pager
	 * @return
	 */
	public static List<Comment> getList(String fromuid, Pager pager) {
		CommentSO so = (CommentSO)spring.getBean(CommentSO.class);
		return so.getList(fromuid, pager);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean delete(String uid) {
		CommentSO so = (CommentSO)spring.getBean(CommentSO.class);
		return so.delete(uid);
	}

	/**
	 * @param uid
	 */
	public static boolean deleteByGroupuid(String groupuid) {
		CommentSO so = (CommentSO)spring.getBean(CommentSO.class);
		return so.deleteByGroupuid(groupuid);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static int getCount(String fromuid) {
		CommentSO so = (CommentSO)spring.getBean(CommentSO.class);
		return so.getCount(fromuid);
	}

}

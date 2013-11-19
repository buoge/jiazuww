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
 * Create at: 2012-10-27 下午9:29:20
 * ============================================================================
 */
package com.jiazu.web.platform.service;

import java.util.List;

import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.Message;

/**
 * @author Architect.bian
 *
 */
public interface MessageSO {

	/**
	 * @param groupuid
	 * @param touids
	 * @param fromuid
	 * @param title
	 * @param msg
	 * @return
	 */
	boolean send(String groupuid, String[] touids, String fromuid, String title, String msg);

	/**
	 * @param useruid
	 * @param pager
	 * @return
	 */
	List<Message> getList(String useruid, Pager pager);

	/**
	 * @param uid
	 * @return
	 */
	boolean delete(String uid);

}

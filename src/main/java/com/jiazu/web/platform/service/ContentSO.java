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
 * Create at: 2012-11-3 下午4:16:15
 * ============================================================================
 */
package com.jiazu.web.platform.service;

import java.util.List;

import com.jiazu.global.constants.EContent;
import com.jiazu.web.shop.entity.Content;

/**
 * @author Architect.bian
 *
 */
public interface ContentSO {

	/**
	 * @return
	 */
	List<Content> getNotices();

	/**
	 * @return
	 */
	Content getRegisterRule();

	/**
	 * @return
	 */
	List<Content> getTxtFriendLinks();

	/**
	 * @return
	 */
	List<Content> getImgFriendLinks();

	/**
	 * @return
	 */
	Content getZupuIntroduce();

	/**
	 * @param content
	 * @return
	 */
	boolean add(Content content);

	/**
	 * @param id
	 * @return
	 */
	boolean delete(int id);

	/**
	 * @param hotsearch
	 * @return
	 */
	List<Content> getListByType(EContent hotsearch);

	/**
	 * @param uid
	 * @param content
	 * @return
	 */
	boolean updateContent(String id, String content);

	/**
	 * @param e
	 * @return
	 */
	Content getOneByType(EContent e);

	/**
	 * @param content
	 * @return
	 */
	boolean update(Content content);

}

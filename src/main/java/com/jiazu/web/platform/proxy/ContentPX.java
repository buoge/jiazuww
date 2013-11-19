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
 * Create at: 2012-9-9 上午8:29:53
 * ============================================================================
 */
package com.jiazu.web.platform.proxy;

import java.util.List;

import com.jiazu.global.constants.EContent;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.service.ContentSO;
import com.jiazu.web.shop.entity.Content;

/**
 * @author Architect.bian
 *
 */
public class ContentPX extends BasePX {

	/**
	 * @return
	 */
	public static List<Content> getImgFriendLinks() {
		ContentSO so = (ContentSO)spring.getBean(ContentSO.class);
		return so.getImgFriendLinks();
	}

	/**
	 * @return
	 */
	public static List<Content> getTxtFriendLinks() {
		ContentSO so = (ContentSO)spring.getBean(ContentSO.class);
		return so.getTxtFriendLinks();
	}

	/**
	 * @return
	 */
	public static Content getRegisterRule() {
		ContentSO so = (ContentSO)spring.getBean(ContentSO.class);
		return so.getRegisterRule();
	}

	/**
	 * @return
	 */
	public static List<Content> getNotices() {
		ContentSO so = (ContentSO)spring.getBean(ContentSO.class);
		return so.getNotices();
	}

	/**
	 * @return
	 */
	public static Content getZupuIntroduce() {
		ContentSO so = (ContentSO)spring.getBean(ContentSO.class);
		return so.getZupuIntroduce();
	}

	/**
	 * @param content
	 * @return
	 */
	public static boolean add(Content content) {
		ContentSO so = (ContentSO)spring.getBean(ContentSO.class);
		return so.add(content);
	}

	/**
	 * @param valueOf
	 * @return
	 */
	public static boolean delete(int id) {
		ContentSO so = (ContentSO)spring.getBean(ContentSO.class);
		return so.delete(id);
	}

	/**
	 * @return
	 */
	public static List<Content> getHotSearch() {
		ContentSO so = (ContentSO)spring.getBean(ContentSO.class);
		return so.getListByType(EContent.hotsearch);
	}

	/**
	 * @param uid
	 * @param content
	 * @return
	 */
	public static boolean updateContent(String uid, String content) {
		ContentSO so = (ContentSO)spring.getBean(ContentSO.class);
		return so.updateContent(uid, content);
	}

	/**
	 * @param e
	 * @return
	 */
	public static Content getOneByType(EContent e) {
		ContentSO so = (ContentSO)spring.getBean(ContentSO.class);
		return so.getOneByType(e);
	}

	/**
	 * @return
	 */
	public static List<Content> getBannerList() {
		ContentSO so = (ContentSO)spring.getBean(ContentSO.class);
		return so.getListByType(EContent.banner);
	}

	/**
	 * @return
	 */
	public static List<Content> getLogoList() {
		ContentSO so = (ContentSO)spring.getBean(ContentSO.class);
		return so.getListByType(EContent.logo);
	}

	/**
	 * @param content
	 * @return
	 */
	public static boolean update(Content content) {
		ContentSO so = (ContentSO)spring.getBean(ContentSO.class);
		return so.update(content);
	}

	/**
	 * @return
	 */
	public static Content getLogoContent() {
		List<Content> list = getLogoList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

}

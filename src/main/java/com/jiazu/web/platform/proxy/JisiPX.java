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
 * Create at: 2012-12-6 下午12:16:22
 * ============================================================================
 */
package com.jiazu.web.platform.proxy;

import java.util.List;

import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.entity.ZupuMember;
import com.jiazu.web.platform.service.ZupuMemberSO;

/**
 * @author Architect.bian
 *
 */
public class JisiPX extends BasePX {

	/**
	 * @param uid
	 * @param pager 
	 * @return
	 */
	public static List<ZupuMember> getListByGroupUid(String uid, Pager pager) {
		ZupuMemberSO so = (ZupuMemberSO)spring.getBean(ZupuMemberSO.class);
		return so.getJisiList(uid, pager);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static ZupuMember get(String uid) {
		ZupuMemberSO so = (ZupuMemberSO)spring.getBean(ZupuMemberSO.class);
		return so.get(uid);
	}

}

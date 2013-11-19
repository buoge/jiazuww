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
 * Create at: 2012-8-21 上午6:59:02
 * ============================================================================
 */
package com.jiazu.web.platform.dao;

import java.util.List;
import java.util.Map;

import com.jiazu.web.base.dao.BaseDao;
import com.jiazu.web.platform.entity.Jiazu;
import com.jiazu.web.platform.entity.Member;

/**
 * @author Architect.bian
 *
 */
public interface JiazuDao extends BaseDao<Jiazu> {

	/**
	 * @param useruid
	 * @return
	 */
	List<Jiazu> getAssociateListByUseruid(Map<String, Object> map);

	/**
	 * @param map
	 * @return
	 */
	List<Member> getMemberList(Map<String, Object> map);

	/**
	 * @param map
	 * @return
	 */
	int getCount(Map<String, Object> map);

}

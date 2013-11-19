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
 * Create at: 2012-10-27 上午11:33:50
 * ============================================================================
 */
package com.jiazu.web.platform.dao;

import org.apache.ibatis.annotations.Param;

import com.jiazu.web.base.dao.BaseDao;
import com.jiazu.web.platform.entity.Member;

/**
 * @author Architect.bian
 *
 */
public interface MemberDao extends BaseDao<Member> {
	
	@Deprecated
	Member get(String id);
	
	Member get(@Param("uid") String uid, @Param("useruid") String useruid);

	@Deprecated
	void delete(@Param("uid") String uid);
	/**
	 * @param uid
	 * @param useruid
	 */
	void delete(@Param("uid") String uid, @Param("useruid") String useruid);

}

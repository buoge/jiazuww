/**
 * 用户数据访问层
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
 * Create at: 2012-8-8 下午9:57:36
 * ============================================================================
 */
package com.jiazu.web.platform.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jiazu.web.base.dao.BaseDao;
import com.jiazu.web.platform.entity.User;

/**
 * @author Architect.bian
 *
 */
@Repository("userDao")
public interface UserDao extends BaseDao<User> {
	User getUserbyOid(int oid);
	User getUserbyUseridPwd(@Param("userid") String userId, @Param("password") String pwd);
	String getUidByUserid(String userId);
	/**
	 * @param map
	 * @return 
	 */
	List<User> getListByMemberSearch(Map<String, Object> map);
	/**
	 * @return
	 */
	int getSumMoney();
	/**
	 * @return
	 */
	int getCount();
}

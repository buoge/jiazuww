/**
 * 用户操作服务层接口
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
 * Create at: 2012-8-4 下午6:28:30
 * ============================================================================
 */
package com.jiazu.web.platform.service;

import java.util.List;
import java.util.Map;

import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.User;

/**
 * @author Architect.bian
 *
 */
public interface UserSO {
	
	/**
	 * 根据用户名判断此用户是否存在（不区分大小写）
	 * @param userid
	 * @return
	 */
	public boolean isExistByUserid(String userId);
	
	/**
	 * 根据Uid获取用户对象，若会员不存在，则返回null（不区分大小写）
	 * 
	 */
	public User getUser(String uid);
	
	/**
	 * 根据Uid获取用户对象，若会员不存在，则返回null（不区分大小写）
	 * 
	 */
	public User getUser(int oid);

	/**
	 * 根据用户名密码获取用户对象，若会员不存在，则返回null（不区分大小写）
	 * 
	 */
	public User getUser(String userId, String pwd);
	
	/**
	 * 根据用户名密码获取用户对象，若会员不存在，则返回null（不区分大小写）
	 * 
	 */
	public boolean registerUser(User user);

	/**
	 * @param uid
	 * @param name
	 * @return
	 */
	public List<User> getListByMemberSearch(String uid, String name);

	/**
	 * @param uid
	 * @param password
	 * @return
	 */
	public boolean updatePwd(String uid, String password);

	/**
	 * @param user
	 * @return
	 */
	public boolean updateInfor(User user);

	/**
	 * @param userid
	 * @return
	 */
	public User getUserByUserid(String userid);

	/**
	 * @param pager
	 * @return
	 */
	public List<User> getList(Pager pager);

	/**
	 * @param uid
	 * @return
	 */
	public boolean delete(String uid);

	/**
	 * @param uid
	 * @param status
	 * @return
	 */
	public boolean updateStatus(String uid, boolean status);

	/**
	 * @param map
	 * @return
	 */
	public List<User> getList(Map<String, Object> map);

	/**
	 * @param email
	 * @return
	 */
	public boolean isExistByEmail(String email);

	/**
	 * @param email
	 * @return
	 */
	public User getUserByEmail(String email);

	/**
	 * @return
	 */
	public int getSumMoney();

	/**
	 * @return
	 */
	public int getCount();

	/**
	 * @param uid
	 * @param account
	 * @return
	 */
	public boolean updateAccount(String uid, double account);
}

/**
 * User操作代理类
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
 * Create at: 2012-8-10 上午7:48:27
 * ============================================================================
 */
package com.jiazu.web.platform.proxy;

import java.util.List;
import java.util.Map;

import com.jiazu.core.cache.impl.SessionImpl;
import com.jiazu.global.constants.EContent;
import com.jiazu.global.constants.SysConf;
import com.jiazu.global.utility.EmailUtil;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.service.UserSO;
import com.jiazu.web.shop.entity.Content;

/**
 * @author Architect.bian
 *
 */
public class UserPX extends BasePX {

	public static boolean isExistByUserid(String userId) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.isExistByUserid(userId);
	}
	
	public static User getUser(String uid) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.getUser(uid);
	}
	
	public static User getUser(int oid) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.getUser(oid);
	}
	
	public static User getUser(String userId, String pwd) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.getUser(userId, pwd);
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @return success->true,failed->false
	 */
	public static boolean registerUser(User user) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.registerUser(user);
	}

	/**
	 * 设置用户对象为在线登录状态,将对象添加到sessin及cache中
	 * @param user
	 */
	public static void online(String key, User user) {
		//TODO 将user对象保存到session中，同时在/user/online下设置uid
		spring.getBean(SessionImpl.class).setAttribute(key, user);
	}

	/**
	 * @param string
	 * @param user
	 */
	public static void offline(String key) {
		spring.getBean(SessionImpl.class).removeAttribute(key);
	}

	/**
	 * @param string
	 * @param uid
	 */
	public static User freshCache(String key, String uid) {
		User user =  get(uid);
		spring.getBean(SessionImpl.class).setAttribute(key, user);
		return user;
	}

	/**
	 * 通过name搜索jiazu.uid不为uid的用户
	 * @param uid
	 * @param name
	 * @return
	 */
	public static List<User> getListByMemberSearch(String uid, String name) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.getListByMemberSearch(uid, name);
	}

	/**
	 * @param uid
	 * @param password
	 * @return 
	 */
	public static boolean updatePwd(String uid, String password) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.updatePwd(uid, password);
	}

	/**
	 * @param user
	 * @return
	 */
	public static boolean updateInfor(User user) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.updateInfor(user);
	}

	/**
	 * @param userid
	 * @return
	 */
	public static User getUserByUserid(String userid) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.getUserByUserid(userid);
	}

	/**
	 * @param pager
	 * @return
	 */
	public static List<User> getList(Pager pager) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.getList(pager);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean delete(String uid) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.delete(uid);
	}

	/**
	 * @param uid
	 * @param status
	 * @return
	 */
	public static boolean updateStatus(String uid, boolean status) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.updateStatus(uid, status);
	}

	/**
	 * @param map
	 * @return
	 */
	public static List<User> getList(Map<String, Object> map) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.getList(map);
	}

	/**
	 * @param uid
	 * @return
	 */
	private static User get(String uid) {
		return getUser(uid);
	}

	/**
	 * @param email
	 * @return
	 */
	public static boolean resetpwd(String email) {
		try {
			String pwd = StrUtil.getRandomString(6);
			User u = UserPX.getUserByEmail(email);
			UserPX.updatePwd(u.getUid(), pwd);
			String title = SysConf.EmailResetTitle;
			Content content = ContentPX.getOneByType(EContent.email_pwdreset);
			String msg = "USER:{USER}   PASSWORD:{PASSWORD}";
			if (content != null) {
				msg = content.getContent();
			}
			msg = msg.replace("{USER}", u.getUserid()).replace("{PASSWORD}", pwd);
			return EmailUtil.send(email, title,  msg);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param email
	 * @return
	 */
	private static User getUserByEmail(String email) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.getUserByEmail(email);
	}

	/**
	 * @param email
	 * @return
	 */
	public static boolean isExistByEmail(String email) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.isExistByEmail(email);
	}

	/**
	 * @param user
	 * @return
	 */
	public static boolean sendValidEmail(User user) {
		try {
			Content content = ContentPX.getOneByType(EContent.email_validate);
			String title = SysConf.EmailValidateTitle;
			String msg = "{URL}";
			if (content != null) {
				msg = content.getContent();
			}
			msg = msg.replace("{URL}", String.format(SysConf.EmailValidateUrlFormat, user.getUid()));
			EmailUtil.send(user.getEmail(), title, msg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean active(String uid) {
		return UserPX.updateStatus(uid, true);
	}

	/**
	 * @return
	 */
	public static int getSumMoney() {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.getSumMoney();
	}

	/**
	 * @return
	 */
	public static int getCount() {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.getCount();
	}

	/**
	 * @param user
	 */
	public static boolean updateAccount(User user) {
		return updateAccount(user.getUid(), user.getAccount());
	}
	
	/**
	 * @param user
	 */
	public static boolean updateAccount(String uid, double account) {
		UserSO so = (UserSO)spring.getBean(UserSO.class);
		return so.updateAccount(uid, account);
	}
}

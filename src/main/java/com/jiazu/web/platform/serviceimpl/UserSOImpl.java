/**
 * 用户操作service层实现类
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
 * Create at: 2012-8-10 上午7:08:58
 * ============================================================================
 */
package com.jiazu.web.platform.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.platform.dao.UserDao;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.service.UserSO;

/**
 * @author Architect.bian
 * 
 */
@Service
public class UserSOImpl extends BaseSO implements UserSO {

	@Autowired
	private UserDao dao;

	@Override
	public boolean isExistByUserid(String userid) {
		return StringUtils.isNotEmpty(dao.getUidByUserid(userid));
	}

	@Override
	public User getUser(String uid) {
		return dao.get(uid);
	}

	@Override
	public User getUser(int oid) {
		return dao.getUserbyOid(oid);
	}

	@Override
	public User getUser(String userId, String pwd) {
		Map<String, Object> map = getParamMap();
		map.put(MapperConstant.userid, userId);
		map.put(MapperConstant.pwd, DigestUtils.md5Hex(pwd));
		return dao.getOne(map);
	}

	@Override
	public boolean registerUser(User user) {
		try {
			user.initialize();
			dao.insert(user);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public List<User> getListByMemberSearch(String uid, String name) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.name, name);
			return dao.getListByMemberSearch(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean updatePwd(String uid, String password) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.pwd, DigestUtils.md5Hex(password));
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean updateInfor(User user) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, user.getUid());
			map.put(MapperConstant.name, user.getName());
			map.put(MapperConstant.gender, user.getGender());
			// map.put(MapperConstant.realname, user.getRealname());
			map.put(MapperConstant.birthday, user.getBirthday());
			map.put(MapperConstant.email, user.getEmail());
			map.put(MapperConstant.phone, user.getPhone());
			// map.put(MapperConstant.mobile, user.getMobile());
			map.put(MapperConstant.avatar, user.getAvatar());
			map.put(MapperConstant.original, user.getOriginal());
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public User getUserByUserid(String userid) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(MapperConstant.userid, userid);
			return dao.getOne(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<User> getList(Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.remove(MapperConstant.status);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean delete(String uid) {
		try {
			User u = getUser(uid);
			if (u.getAvatar().indexOf("default") == -1) {
				FileUtil.deleteImg(u.getOriginal(), u.getAvatar());
			}
			dao.delete(uid);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean updateStatus(String uid, boolean status) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.status, status);
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public List<User> getList(Map<String, Object> map) {
		try {
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean isExistByEmail(String email) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(MapperConstant.email, email);
			User u = dao.getOne(map);
			if (u != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public User getUserByEmail(String email) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(MapperConstant.email, email);
			return dao.getOne(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public int getSumMoney() {
		try {
			return dao.getSumMoney();
		} catch (Exception e) {
			logException(e);
			return -1;
		}
	}

	@Override
	public int getCount() {
		try {
			return dao.getCount();
		} catch (Exception e) {
			logException(e);
			return -1;
		}
	}

	@Override
	public boolean updateAccount(String uid, double account) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.account, account);
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

}

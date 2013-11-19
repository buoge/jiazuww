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
 * Create at: 2012-11-13 上午8:24:05
 * ============================================================================
 */
package com.jiazu.web.shop.serviceimpl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.shop.dao.AdminDao;
import com.jiazu.web.shop.dao.RoleDao;
import com.jiazu.web.shop.entity.Admin;
import com.jiazu.web.shop.entity.Role;
import com.jiazu.web.shop.service.AdminSO;

/**
 * @author Architect.bian
 *
 */
@Service
public class AdminSOImpl extends BaseSO implements AdminSO {

	@Autowired
	private AdminDao dao;
	
	@Autowired
	private RoleDao dao2;
	
	@Override
	public boolean add(Admin admin) {
		try {
			admin.setPassword(DigestUtils.md5Hex(admin.getPassword()));
			dao.insert(admin);
			Role role = new Role(admin);
			dao2.insert(role);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean delete(String uid) {
		try {
			dao2.deleteByAdminUid(uid);
			dao.delete(uid);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public List<Admin> getList() {
		try {
			return dao.getList(getParamMap());
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

}

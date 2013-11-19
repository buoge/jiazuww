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
 * Create at: 2012-10-27 上午11:31:00
 * ============================================================================
 */
package com.jiazu.web.platform.serviceimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.EAdmin;
import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.platform.dao.MemberDao;
import com.jiazu.web.platform.entity.Jiazu;
import com.jiazu.web.platform.entity.Member;
import com.jiazu.web.platform.proxy.JiazuPX;
import com.jiazu.web.platform.service.MemberSO;

/**
 * @author Architect.bian
 *
 */
@Service
public class MemberSOImpl extends BaseSO implements MemberSO {

	@Autowired
	private MemberDao dao;

	@Override
	public boolean addMembers(String uid, String[] select) {
		try {
			for (String useruid : select) {
				Member m = new Member();
				m.setUid(uid);
				m.setUseruid(useruid);
				m.setType(EAdmin.False);
				m.setStatus(EStatus.enable);
				dao.insert(m);
			}
			return true;
		} catch (Exception e) {
			logException(e);
		}
		return false;
	}

	@Override
	public boolean delMembers(String uid, String[] select) {
		try {
			for (String useruid : select) {
				dao.delete(uid, useruid);
			}
			return true;
		} catch (Exception e) {
			logException(e);
		}
		return false;
	}

	@Override
	public boolean setAdmin(String uid, String[] select) {
		try {
			for (String useruid : select) {
				Map<String, Object> map = getParamMap();
				map.put(MapperConstant.UID, uid);
				map.put(MapperConstant.useruid, useruid);
				map.put(MapperConstant.type, EAdmin.True);
				dao.updateFields(map);
			}
			return true;
		} catch (Exception e) {
			logException(e);
		}
		return false;
	}

	@Override
	public boolean cancelAdmin(String uid, String[] select) {
		try {
			Jiazu jiazu = JiazuPX.get(uid);
			for (String useruid : select) {
				if (!jiazu.getOwner().equals(useruid)) {
					Map<String, Object> map = getParamMap();
					map.put(MapperConstant.UID, uid);
					map.put(MapperConstant.useruid, useruid);
					map.put(MapperConstant.type, EAdmin.False);
					dao.updateFields(map);
				}
			}
			return true;
		} catch (Exception e) {
			logException(e);
		}
		return false;
	}

	@Override
	public Member getOne(String uid, String useruid) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.useruid, useruid);
			return dao.getOne(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

}

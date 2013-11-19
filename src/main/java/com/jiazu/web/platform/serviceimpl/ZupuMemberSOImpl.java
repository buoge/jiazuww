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
 * Create at: 2012-10-28 下午4:47:36
 * ============================================================================
 */
package com.jiazu.web.platform.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.platform.dao.ZupuMemberDao;
import com.jiazu.web.platform.entity.ZupuMember;
import com.jiazu.web.platform.service.ZupuMemberSO;

/**
 * @author Architect.bian
 *
 */
@Service
public class ZupuMemberSOImpl extends BaseSO implements ZupuMemberSO {

	@Autowired
	private ZupuMemberDao dao;
	
	@Override
	public List<ZupuMember> getList(String groupuid) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.level + " " + MapperConstant.asc + "," + MapperConstant.parentuid + " " + MapperConstant.asc);
			map.put(MapperConstant.groupuid, groupuid);
			map.remove(MapperConstant.status);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean add(ZupuMember member) {
		try {
			dao.insert(member);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean delete(String uid) {
		try {
			dao.delete(uid);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public ZupuMember get(String uid) {
		try {
			return dao.get(uid);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<ZupuMember> getJisiList(String groupuid, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.level + " " + MapperConstant.desc + "," + MapperConstant.parentuid + " " + MapperConstant.asc);
			map.put(MapperConstant.groupuid, groupuid);
			map.put(MapperConstant.status, EStatus.disable);
			map.put(MapperConstant.status + MapperConstant._2, EStatus.disable);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean update(ZupuMember m) {
		try {
			dao.update(m);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

}

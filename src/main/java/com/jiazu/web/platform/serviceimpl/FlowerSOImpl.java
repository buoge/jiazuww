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
 * Create at: 2012-12-8 上午10:39:13
 * ============================================================================
 */
package com.jiazu.web.platform.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.platform.dao.FlowerDao;
import com.jiazu.web.platform.entity.Flower;
import com.jiazu.web.platform.service.FlowerSO;

/**
 * @author Architect.bian
 *
 */
@Service
public class FlowerSOImpl extends BaseSO implements FlowerSO {

	@Autowired
	private FlowerDao dao;
	
	@Override
	public Flower get(String uid) {
		try {
			return dao.get(uid);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Flower> getList() {
		try {
			Map<String, Object> map = getParamMap();
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
		}
		return null;
	}

	@Override
	public boolean update(Flower flower) {
		try {
			dao.update(flower);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean add(Flower flower) {
		try {
			dao.insert(flower);
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

}

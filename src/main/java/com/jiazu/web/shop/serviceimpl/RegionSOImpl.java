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
 * Create at: 2012-11-8 下午1:57:26
 * ============================================================================
 */
package com.jiazu.web.shop.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.GlobalConstant;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.SysConstant;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.shop.dao.RegionDao;
import com.jiazu.web.shop.entity.Region;
import com.jiazu.web.shop.service.RegionSO;

/**
 * @author Architect.bian
 *
 */
@Service
public class RegionSOImpl extends BaseSO implements RegionSO {

	@Autowired
	private RegionDao dao;
	
	@Override
	public List<Region> getProvinceList() {
		return getList(SysConstant.ChinaCode);
	}

	@Override
	public List<Region> getList(String pid) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.ASCDESC, GlobalConstant.ASC);
			map.put(MapperConstant.parentid, pid);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

}

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
 * Create at: 2012-10-18 上午8:10:09
 * ============================================================================
 */
package com.jiazu.web.platform.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.EEducation;
import com.jiazu.global.constants.GlobalConstant;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.platform.dao.EducationDao;
import com.jiazu.web.platform.entity.Education;
import com.jiazu.web.platform.service.EduSO;

/**
 * @author Architect.bian
 *
 */
@Service
public class EduSOImpl extends BaseSO implements EduSO {

	@Autowired
	private EducationDao dao;
	
	public boolean add(Education edu) {
		try {
			dao.insert(edu);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public List<Education> getHomeList(String uid, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.groupuid, uid);
			map.put(MapperConstant.type, EEducation.Home);
			map.put(MapperConstant.ASCDESC, GlobalConstant.DESC);
			map.put(MapperConstant.ispublic, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
		}
		return null;
	}

	@Override
	public Education get(int id) {
		try {
			return dao.get(id);
		} catch (Exception e) {
			logException(e);
		}
		return null;
	}

	@Override
	public boolean update(Education edu) {
		try {
			dao.update(edu);
			return true;
		} catch (Exception e) {
			logException(e);
		}
		return false;
	}

	@Override
	public List<Education> getTop(int i) {
		try {
			Map<String, Object> map = getParamMap(i);
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.isrecommend + " " + MapperConstant.desc + "," + MapperConstant.viewsday + " " + MapperConstant.desc);
			map.put(MapperConstant.ispublic, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Education> getList(Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Education> getHomeListTop(int i) {
		try {
			Map<String, Object> map = getParamMap(i);
			map.put(MapperConstant.type, EEducation.Home);
			map.put(MapperConstant.ispublic, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Education> getProfessionalListTop(int i) {
		try {
			Map<String, Object> map = getParamMap(i);
			map.put(MapperConstant.type, EEducation.Professional);
			map.put(MapperConstant.ispublic, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Education> getFamousListTop(int i) {
		try {
			Map<String, Object> map = getParamMap(i);
			map.put(MapperConstant.type, EEducation.Famous);
			map.put(MapperConstant.ispublic, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Education> getList(EEducation type, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.type, type);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Education> search(String s, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.search, s);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Education> search(String s, String groupuids) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.search, s);
			map.put(MapperConstant.groupuids, groupuids);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			dao.delete(id);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public List<Education> getList(Map<String, Object> map) {
		try {
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
		}
		return null;
	}

	@Override
	public boolean updateRecommend(int id, boolean b) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.ID, id);
			map.put(MapperConstant.isrecommend, b);
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public List<Education> getIndex(int i) {
		try {
			Map<String, Object> map = getParamMap(i);
			map.put(MapperConstant.isrecommend,true);
			map.put(MapperConstant.ispublic, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean increaseClickCount(String id) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.ID, id);
			map.put(MapperConstant.clickcount, 1);
			dao.increase(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public List<Education> getMyHomeList(String uid, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.groupuid, uid);
			map.put(MapperConstant.type, EEducation.Home);
			map.put(MapperConstant.ASCDESC, GlobalConstant.DESC);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
		}
		return null;
	}

}

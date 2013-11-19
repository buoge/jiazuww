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
 * Create at: 2012-10-28 下午2:37:38
 * ============================================================================
 */
package com.jiazu.web.shop.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.EC2C;
import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.GlobalConstant;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.shop.dao.C2CDao;
import com.jiazu.web.shop.entity.C2C;
import com.jiazu.web.shop.service.C2CSO;

/**
 * @author Architect.bian
 *
 */
@Service
public class C2CSOImpl extends BaseSO implements C2CSO {

	@Autowired
	private C2CDao dao;
	
	@Override
	public boolean create(C2C c2c) {
		try {
			dao.insert(c2c);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean updateInfo(C2C c2c) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, c2c.getUid());
			map.put(MapperConstant.name, c2c.getName());
			map.put(MapperConstant.type, c2c.getType());
			map.put(MapperConstant.address, c2c.getAddress());
			map.put(MapperConstant.desc, c2c.getDesc());
			map.put(MapperConstant.contactname, c2c.getContactname());
			map.put(MapperConstant.telephone, c2c.getTelephone());
			map.put(MapperConstant.price, c2c.getPrice());
			map.put(MapperConstant.originalimg, c2c.getOriginalimg());
			map.put(MapperConstant.img, c2c.getImg());
			map.put(MapperConstant.bigthumb, c2c.getBigthumb());
			map.put(MapperConstant.thumb, c2c.getThumb());
			map.put(MapperConstant.littlethumb, c2c.getLittlethumb());
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public C2C get(String uid) {
		try {
			return dao.get(uid);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean delete(String uid) {
		try {
			C2C c2c = get(uid);
			FileUtil.deleteImg(c2c.getOriginalimg(), c2c.getBigthumb(), c2c.getImg(), c2c.getThumb(), c2c.getLittlethumb());
			dao.delete(uid);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public List<C2C> getList(String useruid, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.useruid, useruid);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<C2C> getCharityTop(int i) {
		try {
			Map<String, Object> map = getParamMap(i);
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.isbest + " " + MapperConstant.desc + "," + MapperConstant.sortorder + " " + MapperConstant.desc);
			map.put(MapperConstant.type, EC2C.charity);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<C2C> getList(Pager pager) {
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
	public List<C2C> getCharityList(Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.type, EC2C.charity);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	/*
	 * 首页显示
	 */
	@Override
	public List<C2C> getC2CBestTop(int i) {
		try {
			Map<String, Object> map = getParamMap(i);
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.sortorder + " " + MapperConstant.desc);
			map.put(MapperConstant.isbest, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	/*
	 * 置顶
	 */
	@Override
	public List<C2C> getTopList(int i) {
		try {
			Map<String, Object> map = getParamMap(i);
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.sortorder + " " + MapperConstant.desc);
			map.put(MapperConstant.istop, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<C2C> getProdList(Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.notype, EC2C.charity);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<C2C> getListByType(EC2C[] types, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			StringBuffer sb = new StringBuffer();
			for (EC2C e : types) {
				if (e != null) {
					sb.append(e.toString());
					sb.append(GlobalConstant.COMMA);
				}
			}
			map.put(MapperConstant.intype, StrUtil.trim(sb.toString(), GlobalConstant.COMMA));
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<C2C> search(String s, Pager pager) {
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
	public List<C2C> search(String s, String groupuids) {
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
	public List<C2C> getTopList() {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.sortorder + " " + MapperConstant.desc);
			map.put(MapperConstant.istop, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean setTop(String uid, boolean istop) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.istop, istop);
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean update(C2C c2c) {
		try {
			dao.update(c2c);
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
	public List<C2C> getDisableList(String useruid, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.useruid, useruid);
			map.put(MapperConstant.status, EStatus.disable);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<C2C> getList(Map<String, Object> map) {
		try {
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

}

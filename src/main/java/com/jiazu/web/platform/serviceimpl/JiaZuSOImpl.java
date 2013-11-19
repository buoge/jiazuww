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
 * Create at: 2012-10-14 下午1:29:30
 * ============================================================================
 */
package com.jiazu.web.platform.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.EAdmin;
import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.utility.ListUtil;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.platform.dao.JiazuDao;
import com.jiazu.web.platform.dao.MemberDao;
import com.jiazu.web.platform.entity.Jiazu;
import com.jiazu.web.platform.entity.Member;
import com.jiazu.web.platform.service.JiaZuSO;

/**
 * @author Architect.bian
 *
 */
@Service
public class JiaZuSOImpl extends BaseSO implements JiaZuSO {
	
	@Autowired
	private JiazuDao dao;
	
	@Autowired
	private MemberDao memdao;

	@Override
	public boolean add(Jiazu j) {
		try {
			Member m = new Member();
			m.setUid(j.getUid());
			m.setUseruid(j.getOwner());
			m.setType(EAdmin.Owner);
			m.setStatus(EStatus.enable);
			j.initialize();
			dao.insert(j);
			memdao.insert(m);
			return true;
		} catch (Exception e) {
			logException(e);
		}
		return false;
	}

	@Override
	public List<Jiazu> getList(String useruid) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.type + " " + MapperConstant.desc + "," + MapperConstant.createtime + " " + MapperConstant.desc);
			map.put(MapperConstant.useruid, useruid);
			List<Jiazu> list = dao.getAssociateListByUseruid(map);
			if (list == null) {
				list = new ArrayList<>();
			} else {
				ListUtil.trim(list);
			}
//			map.clear();
//			map.put(MapperConstant.owneruid, useruid);
//			Jiazu j = dao.getOne(map);
//			if (j != null) {
//				list.add(0, j);
//			}
			return list;
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean updateLogo(String uid, String logoorignial, String logo, String headimg) {
		Map<String, Object> map = new HashMap<>();
		map.put(MapperConstant.UID, uid);
		map.put(MapperConstant.logooriginal, logoorignial);
		map.put(MapperConstant.logo, logo);
		map.put(MapperConstant.headimg, headimg);
		try {
			dao.updateFields(map);
		} catch (Exception e) {
			logException(e);
			return false;
		}
		return true;
	}

	@Override
	public Jiazu get(String uid) {
		try {
			return dao.get(uid);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean updateBrief(String uid, String brief) {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.brief, brief);
			dao.updateFields(map);
		} catch (Exception e) {
			logException(e);
			return false;
		}
		return true;
	}

	@Override
	public boolean updateHistroy(String uid, String desc) {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.desc, desc);
			dao.updateFields(map);
		} catch (Exception e) {
			logException(e);
			return false;
		}
		return true;
	}

	@Override
	public List<Member> getAdminListByGroupUid(String uid) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.type + MapperConstant.GreaterOrEqual, EAdmin.True);
			return dao.getMemberList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Member> getListByGroupUid(String uid) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, uid);
			return dao.getMemberList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Member> getMemberListByGroupUid(String uid, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.type, EAdmin.False);
			return dao.getMemberList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean delete(String uid) {
		try {
			dao.delete(uid);
			memdao.delete(uid, null);
		} catch (Exception e) {
			logException(e);
			return false;
		}
		return true;
	}

	@Override
	public boolean quit(String uid, String useruid) {
		try {
			memdao.delete(uid, useruid);
		} catch (Exception e) {
			logException(e);
			return false;
		}
		return true;
	}

	@Override
	public boolean updateName(String uid, String name) {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.name, name);
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public List<Jiazu> getListByName(String name) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.name, name);
			List<Jiazu> list = dao.getList(map);
			return list;
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean add(String uid, String useruid) {
		try {
			Member m = new Member();
			m.setUid(uid);
			m.setUseruid(useruid);
			m.setType(EAdmin.False);
			memdao.insert(m);
		} catch (Exception e) {
			logException(e);
			return false;
		}
		return true;
	}

	@Override
	public int getCount() {
		try {
			Map<String, Object> map = getParamMap();
			return dao.getCount(map);
		} catch (Exception e) {
			logException(e);
			return -1;
		}
	}

	@Override
	public List<Jiazu> getList(Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.remove(MapperConstant.status);
			List<Jiazu> list = dao.getList(map);
			if (list != null) {
				for (Jiazu item : list) {
					item.setMembers(getListByGroupUid(item.getUid()));
				}
			}
			return list;
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public int getMemberCount(String groupuid) {
		List<Member> list = getListByGroupUid(groupuid);
		if (list != null) {
			return list.size();
		} else {
			return -1;
		}
	}

	@Override
	public boolean isGroupMember(String groupuid, String useruid) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, groupuid);
			map.put(MapperConstant.useruid, useruid);
			List<Member> list = dao.getMemberList(map);
			if (list != null && list.size() == 1) {
				return true;
			}
		} catch (Exception e) {
			logException(e);
		}
		return false;
	}

	@Override
	public boolean updateStatus(String uid, EStatus status) {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.status, status);
			dao.updateFields(map);
		} catch (Exception e) {
			logException(e);
			return false;
		}
		return true;
	}

	@Override
	public Member getOwnerByGroupUid(String uid) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.type, EAdmin.Owner);
			return dao.getMemberList(map).get(0);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Jiazu> getList(String useruid, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.type + " " + MapperConstant.desc + "," + MapperConstant.createtime + " " + MapperConstant.desc);
			map.put(MapperConstant.useruid, useruid);
			List<Jiazu> list = dao.getAssociateListByUseruid(map);
			if (list == null) {
				list = new ArrayList<>();
			} else {
				ListUtil.trim(list);
			}
			return list;
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Jiazu> getList(Map<String, Object> map) {
		try {
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

}

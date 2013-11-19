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
 * Create at: 2012-10-21 上午8:20:59
 * ============================================================================
 */
package com.jiazu.web.platform.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.MapperConstant;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.platform.dao.EventDao;
import com.jiazu.web.platform.entity.Event;
import com.jiazu.web.platform.proxy.CommentPX;
import com.jiazu.web.platform.service.EventSO;

/**
 * @author Architect.bian
 *
 */
@Service
public class EventSOImpl extends BaseSO implements EventSO {

	@Autowired
	private EventDao dao;
	
	@Override
	public boolean add(Event event) {
		try {
			dao.insert(event);
			return true;
		} catch (Exception e) {
			logException(e);
		}
		return false;
	}

	@Override
	public List<Event> getList(Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.isrecommend + " " + MapperConstant.desc + "," + MapperConstant.createtime + " " + MapperConstant.desc);
			map.put(MapperConstant.ispublic, true);
			List<Event> list = dao.getList(map);
			for (Event event : list) {
				event.setComments(CommentPX.getList(event.getUid(), new Pager()));
			}
			return list;
		} catch (Exception e) {
			logException(e);
		}
		return null;
	}

	@Override
	public List<Event> getList(String uid, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.isrecommend + " " + MapperConstant.desc + "," + MapperConstant.createtime + " " + MapperConstant.desc);
			map.put(MapperConstant.groupuid, uid);
			List<Event> list = dao.getList(map);
			for (Event event : list) {
				event.setComments(CommentPX.getList(event.getUid(), new Pager()));
			}
			return list;
		} catch (Exception e) {
			logException(e);
		}
		return null;
	}

	@Override
	public boolean delete(String uid) {
		try {
			dao.delete(uid);
			return true;
		} catch (Exception e) {
			logException(e);
		}
		return false;
	}

	@Override
	public List<Event> search(String s, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.search, s);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
		}
		return null;
	}

	@Override
	public List<Event> search(String s, String groupuids) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.search, s);
			map.put(MapperConstant.groupuids, groupuids);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
		}
		return null;
	}

	@Override
	public boolean updateTop(String uid, boolean top) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.isrecommend, top);
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public List<Event> getMyList(String uid, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.isrecommend + " " + MapperConstant.desc + "," + MapperConstant.createtime + " " + MapperConstant.desc);
			map.put(MapperConstant.groupuid, uid);
			List<Event> list = dao.getList(map);
			for (Event event : list) {
				event.setComments(CommentPX.getList(event.getUid(), new Pager()));
			}
			return list;
		} catch (Exception e) {
			logException(e);
		}
		return null;
	}

	@Override
	public Event get(String uid) {
		try {
			return dao.get(uid);
		} catch (Exception e) {
			logException(e);
		}
		return null;
	}

}

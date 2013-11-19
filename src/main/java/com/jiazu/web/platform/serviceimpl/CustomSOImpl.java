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
 * Create at: 2012-10-21 下午4:04:05
 * ============================================================================
 */
package com.jiazu.web.platform.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.platform.dao.GalleryDao;
import com.jiazu.web.platform.entity.Gallery;
import com.jiazu.web.platform.proxy.CommentPX;
import com.jiazu.web.platform.proxy.UserPX;
import com.jiazu.web.platform.service.CustomSO;

/**
 * @author Architect.bian
 *
 */
@Service
public class CustomSOImpl extends BaseSO implements CustomSO {

	@Autowired
	private GalleryDao dao;
	
	@Override
	public boolean add(Gallery gallery) {
		try {
			dao.insert(gallery);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public List<Gallery> getList(String uid, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.groupuid, uid);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
		}
		return null;
	}

	@Override
	public List<Gallery> getList(Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
		}
		return null;
	}

	@Override
	public boolean delete(String uid) {
		try {
			Gallery g = get(uid);
			FileUtil.deleteImg(g.getOriginal(), g.getBigthumb(), g.getImg(), g.getThumb(), g.getLittlethumb());
			dao.delete(uid);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public List<Gallery> getTop(int i) {
		try {
			Map<String, Object> map = getParamMap(i);
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.sortorder + " " + MapperConstant.desc);
			map.put(MapperConstant.ispublic, true);
			map.put(MapperConstant.istop, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
		}
		return null;
	}

	@Override
	public Gallery get(String uid) {
		try {
			Gallery g = dao.get(uid);
			g.setUser(UserPX.getUser(g.getUseruid()));
			g.setCommentscount(CommentPX.getCount(g.getUid()));
			return g;
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Gallery> getTopList() {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.sortorder + " " + MapperConstant.desc);
			map.put(MapperConstant.istop, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
		}
		return null;
	}

	@Override
	public boolean setTop(String uid, boolean istop) {
		try {
			Map<String, Object> map = new HashMap<>();
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
	public boolean increaseClickCount(String uid) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.UID, uid);
			map.put(MapperConstant.clickcount, 1);
			dao.increase(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

}

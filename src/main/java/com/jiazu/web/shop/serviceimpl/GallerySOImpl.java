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
 * Create at: 2012-11-7 上午11:56:02
 * ============================================================================
 */
package com.jiazu.web.shop.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.shop.dao.GalleryDao;
import com.jiazu.web.shop.entity.Gallery;
import com.jiazu.web.shop.service.GallerySO;

/**
 * @author Architect.bian
 * 
 */
@Service
public class GallerySOImpl extends BaseSO implements GallerySO {

	@Autowired
	private GalleryDao dao;

	@Override
	public List<Gallery> getList(String groupuid) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.isdefault + " "
					+ MapperConstant.desc + "," + MapperConstant.sortorder + " " + MapperConstant.desc);
			map.put(MapperConstant.goodsuid, groupuid);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean add(Gallery g) {
		try {
			dao.insert(g);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean delete(String uid) {
		try {
			Gallery g = get(uid);
			FileUtil.deleteImg(g.getOriginal(), g.getBigimg(), g.getImg(), g.getThumb());
			dao.delete(uid);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean update(Gallery g) {
		try {
			dao.update(g);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean deleteByGroupuid(String groupuid) {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put(MapperConstant.goodsuid, groupuid);
			dao.deleteByMap(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public Gallery get(String uid) {
		try {
			return dao.get(uid);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean updateDefault(String uid, boolean isdefault) {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put(ViewKeyConstant.UID, uid);
			map.put(ViewKeyConstant.isdefault, isdefault);
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

}

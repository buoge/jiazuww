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
 * Create at: 2012-11-4 下午1:06:50
 * ============================================================================
 */
package com.jiazu.web.shop.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.EB2C;
import com.jiazu.global.constants.EShow;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.platform.proxy.CommentPX;
import com.jiazu.web.shop.dao.B2CDao;
import com.jiazu.web.shop.entity.B2C;
import com.jiazu.web.shop.entity.Gallery;
import com.jiazu.web.shop.proxy.GalleryPX;
import com.jiazu.web.shop.service.B2CSO;

/**
 * @author Architect.bian
 *
 */
@Service
public class B2CSOImpl extends BaseSO implements B2CSO {

	@Autowired
	private B2CDao dao;
	
	@Override
	public List<B2C> getList(Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<B2C> getBooksList(Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.type, EB2C.book);
			map.put(MapperConstant.isonsale, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<B2C> getB2CTxtTop(int i) {
		try {
			Map<String, Object> map = getParamMap(i);
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.sortorder + " " + MapperConstant.desc);
			map.put(MapperConstant.showtype, EShow.text);
			map.put(MapperConstant.isonsale, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<B2C> getB2CImgTop(int i) {
		try {
			Map<String, Object> map = getParamMap(i);
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.sortorder + " " + MapperConstant.desc);
			map.put(MapperConstant.showtype, EShow.image);
			map.put(MapperConstant.isonsale, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<B2C> getBookListTop(int i) {
		try {
			Map<String, Object> map = getParamMap(i);
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.sortorder + " " + MapperConstant.desc);
			map.put(MapperConstant.type, EB2C.book);
			map.put(MapperConstant.ishot, true);
			map.put(MapperConstant.isonsale, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<B2C> getCultureProdsTop(int i) {
		return getProdsTop(EB2C.culture, i);
	}

	/**
	 * @param culture
	 * @param i
	 * @return
	 */
	private List<B2C> getProdsTop(EB2C type, int i) {
		try {
			Map<String, Object> map = getProdsTopParamMap(i);
			map.put(MapperConstant.type, type);
			map.put(MapperConstant.isonsale, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	/**
	 * @param i
	 * @return
	 */
	private Map<String, Object> getProdsTopParamMap(int i) {
		Map<String, Object> map = getParamMap(i);
		map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.isbest + " " + MapperConstant.desc + "," + MapperConstant.sortorder + " " + MapperConstant.desc);
		map.put(MapperConstant.isonsale, true);
		return map;
	}

	@Override
	public List<B2C> getEduToolsTop(int i) {
		return getProdsTop(EB2C.edutool, i);
	}

	@Override
	public List<B2C> getBooksTop(int i) {
		return getProdsTop(EB2C.book, i);
	}

	@Override
	public List<B2C> getSoftwaresTop(int i) {
		return getProdsTop(EB2C.software, i);
	}

	@Override
	public int getCultureProdAmount() {
		return getProdsAmount(EB2C.culture);
	}

	/**
	 * @param culture
	 * @return
	 */
	private int getProdsAmount(EB2C type) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.type, type);
			map.put(MapperConstant.isonsale, true);
			return dao.getCount(map);
		} catch (Exception e) {
			logException(e);
			return -1;
		}
	}

	@Override
	public int getEduToolsAmount() {
		return getProdsAmount(EB2C.edutool);
	}

	@Override
	public int getBooksAmount() {
		return getProdsAmount(EB2C.book);
	}

	@Override
	public int getSoftwareAmount() {
		return getProdsAmount(EB2C.software);
	}

	@Override
	public List<B2C> getListByType(EB2C type, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.sortorder + " " + MapperConstant.desc);
			map.put(MapperConstant.type, type);
			map.put(MapperConstant.isonsale, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<B2C> getHotList(Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.sortorder + " " + MapperConstant.desc);
			map.put(MapperConstant.ishot, true);
			map.put(MapperConstant.isonsale, true);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public B2C get(String uid) {
		try {
			B2C b2c = dao.get(uid);
			b2c.setGalleries(GalleryPX.getList(b2c.getUid()));
			b2c.setCommentscount(CommentPX.getCount(b2c.getUid()));
			return b2c;
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<B2C> search(String s, Pager pager) {
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
	public boolean add(B2C b2c) {
		try {
			for (Gallery g : b2c.getGalleries()) {
				GalleryPX.add(g);
			}
			dao.insert(b2c);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean delete(String uid) {
		try {
			B2C b2c = get(uid);
			for (Gallery g : b2c.getGalleries()) {
				FileUtil.deleteImg(g.getOriginal(), g.getBigimg(), g.getImg(), g.getThumb());
			}
			GalleryPX.deleteByGroupuid(uid);
			FileUtil.deleteImg(b2c.getThumb(), b2c.getLittlethumb());
			CommentPX.deleteByGroupuid(uid);
			dao.delete(uid);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean update(B2C b2c) {
		try {
//			for (Gallery g : b2c.getGalleries()) {
//				FileUtil.deleteImg(g.getOriginal(), g.getBigimg(), g.getImg(), g.getThumb());
//			}
//			GalleryPX.deleteByGroupuid(b2c.getUid());
			for (Gallery g : b2c.getGalleries()) {
				GalleryPX.add(g);
			}
			dao.update(b2c);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public List<B2C> getList(Map<String, Object> map) {
		return dao.getList(map);
	}

}

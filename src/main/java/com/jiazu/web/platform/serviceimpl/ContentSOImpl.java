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
 * Create at: 2012-11-3 下午4:16:56
 * ============================================================================
 */
package com.jiazu.web.platform.serviceimpl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.EContent;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.platform.service.ContentSO;
import com.jiazu.web.shop.dao.ContentDao;
import com.jiazu.web.shop.entity.Content;

/**
 * @author Architect.bian
 *
 */
@Service
public class ContentSOImpl extends BaseSO implements ContentSO {
	
	@Autowired
	private ContentDao dao;
	
	@Override
	public List<Content> getNotices() {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.sortorder + " " + MapperConstant.desc + "," + MapperConstant.createtime + " " + MapperConstant.desc);
			map.put(MapperConstant.type, EContent.notice);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public Content getRegisterRule() {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.type, EContent.rule_register);
			return dao.getOne(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Content> getTxtFriendLinks() {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.sortorder + " " + MapperConstant.desc);
			map.put(MapperConstant.type, EContent.friendLink_txt);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public List<Content> getImgFriendLinks() {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.sortorder + " " + MapperConstant.desc);
			map.put(MapperConstant.type, EContent.friendLink_img);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public Content getZupuIntroduce() {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.type, EContent.zupu_introduce);
			return dao.getOne(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean add(Content content) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.type, EContent.notice);
			dao.insert(content);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			Content tmp = dao.get(id);
			if (StringUtils.isNotEmpty(tmp.getTitleimg())) {
				FileUtil.deleteImg(tmp.getTitleimg());
			}
			dao.delete(id);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public List<Content> getListByType(EContent type) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.ORDERBY, MapperConstant.order_by + MapperConstant.sortorder + " " + MapperConstant.desc + "," + MapperConstant.createtime + " " + MapperConstant.desc);
			map.put(MapperConstant.type, type);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean updateContent(String id, String content) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.OID, id);
			map.put(MapperConstant.content, content);
			dao.updateFields(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public Content getOneByType(EContent type) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.type, type.toString());
			return dao.getOne(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean update(Content content) {
		try {
			dao.update(content);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

}

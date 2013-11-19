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
 * Create at: 2012-11-6 下午4:56:47
 * ============================================================================
 */
package com.jiazu.web.platform.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.MapperConstant;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.platform.dao.CommentDao;
import com.jiazu.web.platform.entity.Comment;
import com.jiazu.web.platform.proxy.UserPX;
import com.jiazu.web.platform.service.CommentSO;

/**
 * @author Architect.bian
 *
 */
@Service
public class CommentSOImpl extends BaseSO implements CommentSO {

	@Autowired
	private CommentDao dao;
	
	@Override
	public boolean add(Comment comment) {
		try {
			dao.insert(comment);
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

	@Override
	public List<Comment> getList(String fromuid, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.fromuid, fromuid);
			List<Comment> list = dao.getList(map);
			for (Comment comment : list) {
				comment.setUser(UserPX.getUser(comment.getUseruid()));
			}
			return list;
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	@Override
	public List<Comment> getList(Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			return dao.getList(map);
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean deleteByGroupuid(String groupuid) {
		try {
			Map<String, String> map = new HashMap<>();
			map.put(MapperConstant.fromuid, groupuid);
			dao.deleteByMap(map);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

	@Override
	public int getCount(String fromuid) {
		try {
			Map<String, Object> map = getParamMap();
			map.put(MapperConstant.fromuid, fromuid);
			return dao.getCount(map);
		} catch (Exception e) {
			logException(e);
			return -1;
		}
	}

}

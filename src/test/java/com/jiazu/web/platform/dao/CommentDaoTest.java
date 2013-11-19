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
 * Create at: 2012-8-19 下午2:45:50
 * ============================================================================
 */
package com.jiazu.web.platform.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.platform.entity.Comment;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class CommentDaoTest {
	
	@Autowired
	CommentDao dao;
	
	@Autowired
	Comment comment;
	
	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#get(java.lang.String)}.
	 */
	@Test
	public void testGet() {
		assertNotNull(dao.get(TestConstants.uidpk2));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getOne(java.util.Map)}.
	 */
	@Test
	public void testGetOne() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.useruid, TestConstants.userId);
		assertNotNull(dao.getOne(map));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getList(java.util.Map)}.
	 */
	@Test
	public void testGetList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.userid, TestConstants.userId);
		assertTrue(dao.getList(map).size() > 0);
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#insert(java.lang.Object)}.
	 */
	@Test
	public void testInsertDelete() {
		String uid = GlobalUtil.getUUID();
		comment.setUid(uid);
		comment.setComment("asdfkfds");
		comment.setFromuid(TestConstants.uidpk);
		dao.insert(comment);
		assertNotNull(dao.get(uid));
		assertEquals(uid, dao.get(uid).getUid());
		assertEquals(TestConstants.uidpk, dao.get(uid).getFromuid());
		dao.delete(uid);
		assertNull(dao.get(uid));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		comment = dao.get(TestConstants.uidpk2);
		String comm = comment.getComment();
		comment.setComment(StrUtil.getRandomString(100));
		comment.setStatus(EStatus.disable);
		dao.update(comment);
		assertFalse(comm.equals(dao.get(TestConstants.uidpk2).getComment()));
		assertEquals(EStatus.disable, dao.get(TestConstants.uidpk2).getStatus());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#updateFields(java.util.Map)}.
	 */
	@Test
	public void testUpdateFields() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.UID, TestConstants.uidpk2);
		map.put(MapperConstant.status, EStatus.enable);
		dao.updateFields(map);
		assertEquals(EStatus.enable, dao.get(TestConstants.uidpk2).getStatus());
	}

}

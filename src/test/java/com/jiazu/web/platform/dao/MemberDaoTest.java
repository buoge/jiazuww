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
 * Create at: 2012-8-20 下午8:40:18
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

import com.jiazu.global.constants.EAdmin;
import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.web.platform.entity.Member;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class MemberDaoTest {

	@Autowired
	MemberDao dao;
	
	@Autowired
	Member entity;
	
	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#get(java.lang.String)}.
	 */
	@Test
	public void testGet() {
		entity = dao.get(TestConstants.uidpk, TestConstants.uid);
		assertNotNull(entity);
		assertEquals(TestConstants.uid, entity.getUseruid());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getOne(java.util.Map)}.
	 */
	@Test
	public void testGetOne() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.useruid, TestConstants.uid);
		assertNotNull(dao.getOne(map));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getList(java.util.Map)}.
	 */
	@Test
	public void testGetList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.useruid, TestConstants.uid);
		assertTrue(dao.getList(map).size() > 0);
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#insert(java.lang.Object)}.
	 */
	@Test
	public void testInsert() {
		String uid = GlobalUtil.getUUID();
		entity.setUid(uid);
		entity.setUseruid(TestConstants.uid);
		entity.setType(EAdmin.Owner);
		entity.setStatus(EStatus.enable);
		dao.insert(entity);
		assertNotNull(dao.get(uid, entity.getUseruid()));
		dao.delete(uid, entity.getUseruid());
		assertNull(dao.get(uid, entity.getUseruid()));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		entity = dao.get(TestConstants.uidpk, TestConstants.uid);
		entity.setType(EAdmin.True);
		dao.update(entity);
		assertTrue(dao.get(TestConstants.uidpk, TestConstants.uid).getType().equals(EAdmin.True));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#updateFields(java.util.Map)}.
	 */
	@Test
	public void testUpdateFields() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.UID, TestConstants.uidpk);
		map.put(MapperConstant.useruid, TestConstants.uid);
		map.put(MapperConstant.type, EAdmin.True);
		dao.updateFields(map);
		assertTrue(dao.get(TestConstants.uidpk, TestConstants.uid).getType().equals(EAdmin.True));
	}

}

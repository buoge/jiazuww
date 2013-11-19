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
 * Create at: 2012-8-21 上午6:59:40
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
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.web.platform.entity.Jiazu;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class JiazuDaoTest {
	
	@Autowired
	JiazuDao dao;
	
	@Autowired
	Jiazu jiazu;

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#get(java.lang.String)}.
	 */
	@Test
	public void testGet() {
		jiazu = dao.get(TestConstants.uidpk);
		assertNotNull(jiazu);
		assertEquals(TestConstants.uidpk, jiazu.getUid());
		assertEquals(TestConstants.userId, jiazu.getOwnerid());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getOne(java.util.Map)}.
	 */
	@Test
	public void testGetOne() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.owneruid, TestConstants.uid);
		assertNotNull(dao.getOne(map));
	}
	
	@Test
	public void testGetCount() {
		Map<String, Object> map = new HashMap<String, Object>();
		assertTrue(dao.getCount(map) > 0);
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getList(java.util.Map)}.
	 */
	@Test
	public void testGetList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.owneruid, TestConstants.uid);
		assertTrue(dao.getList(map).size() > 0);
	}

	@Test
	public void testGetAssociateListByUseruid() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.useruid, TestConstants.uid);
		assertTrue(dao.getAssociateListByUseruid(map).size() > 0);
	}
	
	@Test
	public void testgetMemberList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.UID, TestConstants.uidpk);
		map.put(MapperConstant.type, EAdmin.False);
		assertTrue(dao.getMemberList(map).size() > 0);
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#insert(java.lang.Object)}.
	 */
	@Test
	public void testInsert() {
		String uid = GlobalUtil.getUUID();
		jiazu.setUid(uid);
		jiazu.setOwner(TestConstants.uid);
		jiazu.setOwnerid(TestConstants.userId);
		jiazu.setName("里斯");
		dao.insert(jiazu);
		assertNotNull(dao.get(uid));
		dao.delete(uid);
		assertNull(dao.get(uid));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		jiazu = dao.get(TestConstants.uidpk);
		String brief = "族训";
		jiazu.setBrief(brief );
		dao.update(jiazu);
		assertEquals(brief, dao.get(TestConstants.uidpk).getBrief());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#updateFields(java.util.Map)}.
	 */
	@Test
	public void testUpdateFields() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.UID, TestConstants.uidpk);
		String brief = "家族族训";
		map.put(MapperConstant.brief, brief);
		map.put(MapperConstant.desc, "家族渊源");
		dao.updateFields(map);
		assertEquals(brief, dao.get(TestConstants.uidpk).getBrief());
	}

}

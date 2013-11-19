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
 * Create at: 2012-8-21 上午8:13:44
 * ============================================================================
 */
package com.jiazu.web.platform.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.global.constants.EGender;
import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.web.platform.entity.ZupuMember;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class ZupuMemberDaoTest {

	@Autowired
	ZupuMemberDao dao;
	
	@Autowired
	ZupuMember entity;
	
	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#get(java.lang.String)}.
	 */
	@Test
	public void testGet() {
		entity = dao.get(TestConstants.uidpk);
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
		entity.setUseruid2(TestConstants.uid);
		entity.setName("beksihill");
		entity.setName2("beksihill");
		entity.setGender(EGender.Gentleman);
		entity.setGender(EGender.Lady);
		entity.setRealname("真实姓名");
		entity.setRealname2("真实姓名");
		entity.setBirthday(new LocalDate(1988, 1, 5).toString());
		entity.setBirthday2(new LocalDate(1988, 1, 5).toString());
		entity.setAvatar("avatar");
		entity.setAvatar2("avatar");
		entity.setLevel(1);
		entity.setParentuid(TestConstants.uidpk);
		entity.setStatus(EStatus.enable);
		entity.setStatus2(EStatus.disable);
		dao.insert(entity);
		assertNotNull(dao.get(uid));
		dao.delete(uid);
		assertNull(dao.get(uid));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		entity = dao.get(TestConstants.uidpk);
		entity.setGender(EGender.Lady);
		dao.update(entity);
		assertEquals(EGender.Lady, dao.get(TestConstants.uidpk).getGender());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#updateFields(java.util.Map)}.
	 */
	@Test
	public void testUpdateFields() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.UID, TestConstants.uidpk);
		map.put(MapperConstant.useruid, TestConstants.uid);
		dao.updateFields(map);
		assertEquals(TestConstants.uid, dao.get(TestConstants.uidpk).getUseruid());
	}

}

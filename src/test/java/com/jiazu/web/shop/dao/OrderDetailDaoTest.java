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
 * Create at: 2012-11-9 下午2:04:26
 * ============================================================================
 */
package com.jiazu.web.shop.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.shop.entity.OrderDetail;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class OrderDetailDaoTest {

	@Autowired
	OrderDetailDao dao;
	
	@Autowired
	OrderDetail entity;

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getOne(java.util.Map)}.
	 */
	@Test
	public void testGetOne() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.UID, TestConstants.uid);
		map.put(MapperConstant.b2cuid, TestConstants.uidpk);
		entity = dao.getOne(map);
		assertNotNull(entity);
		assertEquals(TestConstants.uid, entity.getUid());
		assertEquals(TestConstants.uidpk, entity.getB2cuid());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getList(java.util.Map)}.
	 */
	@Test
	public void testGetList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.UID, TestConstants.uid);
		assertTrue(dao.getList(map).size() > 0);
	}
	
	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getList(java.util.Map)}.
	 */
	@Test
	public void testGetListByOrderUid() {
		assertTrue(dao.getListByOrderUid(TestConstants.uid).size() > 0);
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#insert(java.lang.Object)}.
	 */
	@Test
	public void testInsert() {
		entity.setUid(GlobalUtil.getUUID());
		entity.setB2cuid(GlobalUtil.getUUID());
		entity.setB2cname("D90");
		entity.setB2csn(StrUtil.getRandomString(6));
		entity.setB2clittlethumb("");
		entity.setB2cthumb("");
		entity.setNum(1);
		dao.insert(entity);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.UID, entity.getUid());
		map.put(MapperConstant.b2cuid, entity.getB2cuid());
		assertNotNull(dao.getOne(map));
		map.put(MapperConstant.num, 3);
		dao.updateFields(map);
		dao.delete(map);
		assertNull(dao.getOne(map));
	}

}

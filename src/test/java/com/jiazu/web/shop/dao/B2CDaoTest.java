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
 * Create at: 2012-8-22 上午7:05:38
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

import com.jiazu.global.constants.EB2C;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.shop.entity.B2C;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class B2CDaoTest {

	@Autowired
	B2CDao dao;
	
	@Autowired
	B2C entity;
	
	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#get(java.lang.String)}.
	 */
	@Test
	public void testGet() {
		entity = dao.get(TestConstants.uidpk);
		assertNotNull(entity);
		assertEquals(TestConstants.uid, entity.getCatuid());
		assertEquals(TestConstants.uidpk2, entity.getSn());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getOne(java.util.Map)}.
	 */
	@Test
	public void testGetOne() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.sn, TestConstants.uidpk2);
		assertNotNull(dao.getOne(map));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getList(java.util.Map)}.
	 */
	@Test
	public void testGetList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.sn, TestConstants.uidpk2);
		assertTrue(dao.getList(map).size() > 0);
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#insert(java.lang.Object)}.
	 */
	@Test
	public void testInsert() {
		
		for (int j = 0; j < 3; j++) {
			String uid = GlobalUtil.getUUID();
			entity = new B2C();
			entity.setCatuid(TestConstants.uid);
			entity.setSn(StrUtil.getRandomString(8));
			entity.setName("**书");
			entity.setNumber(12);
			entity.setWeight(2.1);
			entity.setMarketprice(1.23);
			entity.setShopprice(1.111);
			entity.setShippingfee(4.33);
			entity.setKeywords("乔布斯");
			entity.setBrief("传记");
			entity.setDesc("描述");
			entity.setThumb("asdthunmb.jpg");
			entity.setLittlethumb("asdthunmb.jpg");
			entity.setRate(2.6);
			entity.setIsbest(true);
			entity.setUid(uid);
			
			entity.setIsbest(true);
			entity.setSortorder(122);
			entity.setType(EB2C.software);
			entity.setName("Windows 7家庭普通版 操作系统 销量先锋，惊喜特卖！");
			entity.setShopprice(39);
			entity.setMarketprice(154);
			entity.setBuyercount(11);
			
			dao.insert(entity);
			assertNotNull(dao.get(uid));
		}
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		entity = dao.get(TestConstants.uidpk);
		String name = "好多村";
		entity.setName(name);
		entity.setType(EB2C.book);
		dao.update(entity);
		assertEquals(name, dao.get(TestConstants.uidpk).getName());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#updateFields(java.util.Map)}.
	 */
	@Test
	public void testUpdateFields() {
		Map<String, Object> map = new HashMap<String, Object>();
		String name = "好多村";
		map.put(MapperConstant.UID, TestConstants.uidpk);
		map.put(MapperConstant.name, name);
		dao.updateFields(map);
		assertEquals(name, dao.get(TestConstants.uidpk).getName());
	}

}

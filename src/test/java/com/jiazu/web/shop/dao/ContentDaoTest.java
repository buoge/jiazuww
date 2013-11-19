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
 * Create at: 2012-8-22 上午7:06:28
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

import com.jiazu.global.constants.EContent;
import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.web.shop.entity.Content;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class ContentDaoTest {

	@Autowired
	ContentDao dao;
	
	@Autowired
	Content entity;
	
	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#get(java.lang.String)}.
	 */
	@Test
	public void testGet() {
		entity = dao.get(1);
		assertNotNull(entity);
		assertEquals(TestConstants.uid, entity.getAdminuid());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getOne(java.util.Map)}.
	 */
	@Test
	public void testGetOne() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.OID, 1);
		assertNotNull(dao.getOne(map));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getList(java.util.Map)}.
	 */
	@Test
	public void testGetList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.OID, 1);
		assertTrue(dao.getList(map).size() > 0);
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#insert(java.lang.Object)}.
	 */
	@Test
	public void testInsert() {
		String uid = GlobalUtil.getUUID();
		entity.setType(EContent.ad);
		entity.setAdminuid(uid);
		entity.setTop_level(1);
		entity.setPriority(12);
		entity.setTitle("my title");
		entity.setTitleshort("简短标题");
		entity.setTitleimg("titleimg.jpg");
		entity.setAuthor(TestConstants.userId);
		entity.setOrigin("google");
		entity.setOriginurl("haap://g.com");
		entity.setDescription("内容描述");
		entity.setContent("内容");
		entity.setIsrecommend(true);
		entity.setStatus(EStatus.disable);
		entity.setViewsday(0);
		entity.setCommentsday(1);
		entity.setUpsday(1);
		dao.insert(entity);
		int id = entity.getOid();
		assertNotNull(dao.get(id));
		dao.delete(id);
		assertNull(dao.get(id));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		entity = dao.get(1);
		entity.setType(EContent.ad);
		dao.update(entity);
		assertEquals(EContent.ad, dao.get(1).getType());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#updateFields(java.util.Map)}.
	 */
	@Test
	public void testUpdateFields() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.OID, 1);
		map.put(MapperConstant.type, EContent.ad);
		dao.updateFields(map);
		assertEquals(EContent.ad, dao.get(1).getType());
	}

}

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
 * Create at: 2012-11-8 下午12:26:49
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
import com.jiazu.global.constants.SysConstant;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.shop.entity.Region;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class RegionDaoTest {
	@Autowired
	RegionDao dao;
	
	@Autowired
	Region entity;
	
	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#get(java.lang.String)}.
	 */
	@Test
	public void testGet() {
		entity = dao.get(SysConstant.ChinaCode);
		assertNotNull(entity);
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getOne(java.util.Map)}.
	 */
	@Test
	public void testGetOne() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.name_short, "BJ");
		assertNotNull(dao.getOne(map));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getList(java.util.Map)}.
	 */
	@Test
	public void testGetList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.name_short, "BJ");
		assertNotNull(dao.getList(map).size() > 0);
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#insert(java.lang.Object)}.
	 */
	@Test
	public void testInsert() {
		String id = StrUtil.getRandomString(6);
		entity.setId(id);
		entity.setName("test");
		entity.setName_english("testengl");
		entity.setName_short("tt");
		entity.setAreacode("222");
		entity.setPostcode("100087");
		entity.setParentid("000000");
		dao.insert(entity);
		assertNotNull(dao.get(id));
		entity.setParentid("1111");
		dao.update(entity);
		dao.delete(id);
		assertNull(dao.get(id));
	}

}

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
 * Create at: 2012-8-20 上午7:46:41
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

import com.jiazu.global.constants.EEducation;
import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.web.platform.entity.Education;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class EducationDaoTest {
	
	@Autowired
	EducationDao dao;
	
	@Autowired
	Education education;

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#get(java.lang.String)}.
	 */
	@Test
	public void testGet() {
		assertNotNull(dao.get(1));
		assertEquals(TestConstants.uidpk, dao.get(1).getGroupuid());
		assertEquals(TestConstants.uid, dao.get(1).getUseruid());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getOne(java.util.Map)}.
	 */
	@Test
	public void testGetOne() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.useruid, TestConstants.uid);
		map.put(MapperConstant.groupuid, TestConstants.uidpk);
		assertNotNull(dao.getOne(map));
		
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getList(java.util.Map)}.
	 */
	@Test
	public void testGetList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.useruid, TestConstants.uid);
		map.put(MapperConstant.groupuid, TestConstants.uidpk);
		assertTrue(dao.getList(map).size() > 0);
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#insert(java.lang.Object)}.
	 */
	@Test
	public void testInsert() {
		String groupuid = GlobalUtil.getUUID();
		education.setGroupuid(groupuid);
		String useruid = GlobalUtil.getUUID();
		education.setUseruid(useruid);
		education.setType(EEducation.Book);
		education.setTitle("title");
		education.setTitleimg("asdjk.jpg");
		education.setAuthor("beskyhill");
		education.setContent("contenttttt");
		education.setViewsday(122222);
		education.setIsrecommend(true);
		education.setIspublic(true);
		education.setStatus(EStatus.enable);
		dao.insert(education);
		int id = education.getOid();
		assertTrue(id > 1);
		assertEquals(groupuid,  dao.get(id).getGroupuid());
		assertEquals(useruid, dao.get(id).getUseruid());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		education = dao.get(1);
		assertEquals(TestConstants.uidpk, education.getGroupuid());
		String author = "autohor";
		education.setAuthor(author );
		education.setStatus(EStatus.disable);
		dao.update(education);
		education = dao.get(1);
		assertEquals(author, education.getAuthor());
		assertEquals(EStatus.disable, education.getStatus());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#updateFields(java.util.Map)}.
	 */
	@Test
	public void testUpdateFields() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.ID, 1);
		map.put(MapperConstant.status, EStatus.enable);
		dao.updateFields(map);
		assertEquals(EStatus.enable, dao.get(1).getStatus());
	}

}

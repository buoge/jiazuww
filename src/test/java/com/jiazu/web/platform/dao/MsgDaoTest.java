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
 * Create at: 2012-8-21 上午8:06:58
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

import com.jiazu.global.constants.EMsg;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.web.platform.entity.Message;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class MsgDaoTest {

	@Autowired
	MsgDao dao;
	
	@Autowired
	Message message;
	
	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#get(java.lang.String)}.
	 */
	@Test
	public void testGet() {
		message = dao.get(TestConstants.uidpk);
		assertNotNull(message);
		assertEquals(TestConstants.uid, message.getUseruid());
		assertEquals(TestConstants.uidpk2, message.getUseruidfrom());
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
		message.setUid(uid);
		message.setUseruid(TestConstants.uid);
		message.setTitle("你好");
		message.setMsg("谢谢xiexie");
		message.setType(EMsg.sys);
		dao.insert(message);
		assertNotNull(dao.get(uid));
		dao.delete(uid);
		assertNull(dao.get(uid));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		message = dao.get(TestConstants.uidpk);
		String msg = "O(∩_∩)O哈哈~";
		message.setMsg(msg );
		message.setType(EMsg.sys);
		dao.update(message);
		assertEquals(msg, dao.get(TestConstants.uidpk).getMsg());
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

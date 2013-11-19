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
 * Create at: 2012-8-18 下午8:14:41
 * ============================================================================
 */
package com.jiazu.web.platform.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.global.constants.DBMysqlConstant;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.web.platform.entity.AccountLog;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class AccountLogDaoTest {

	@Autowired
	AccountLogDao dao;
	
	@Autowired
	AccountLog log;
	
	@Test
	public void testGet() {
		AccountLog log = dao.get(TestConstants.uidpk);
		assertNotNull(log);
		assertEquals(TestConstants.uidpk, log.getUid());
	}
	
	@Test
	public void testGetOne() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.useruid, TestConstants.uid);
		AccountLog log = dao.getOne(map);
		assertNotNull(log);
		assertEquals(TestConstants.uidpk, log.getUid());
	}

	@Test
	public void testGetList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AccountLog> list = dao.getList(map);
		assertTrue(list.size() > 0);
		//开始测试排序
		map.put(MapperConstant.ASCDESC, DBMysqlConstant.ASC);
		List<AccountLog> list1 = dao.getList(map);
		map.put(MapperConstant.ASCDESC, DBMysqlConstant.DESC);
		List<AccountLog> list2 = dao.getList(map);
		assertEquals(list1.get(0).hashCode(), list2.get(list2.size()-1).hashCode());
		assertFalse(list1.get(0) == list2.get(0));
		//开始测试limit
		map.put(MapperConstant.PAGESIZE, "1");
		List<AccountLog> list3 = dao.getList(map);
		assertEquals(1, list3.size());
		map.clear();
		map.put(MapperConstant.STARTINDEX, "1");
		List<AccountLog> list4 = dao.getList(map);
		assertTrue(list4.size() > 0);
		//开始测试where条件
		map.clear();
		map.put(MapperConstant.useruid, TestConstants.uid);
		List<AccountLog> list5 = dao.getList(map);
		assertEquals(TestConstants.uid, list5.get(0).getUseruid());
	}

	@Test
	public void testInsert() {
//		log.setUid(GlobalUtil.getUUID());
		log.setUseruid(GlobalUtil.getUUID());
		log.setUsemoney(-105.8);
		log.setAccount(336.7);
		log.setDoaction("支付某商品");
		dao.insert(log);
	}

	@Test
	public void testUpdate() {
		log.setUid(TestConstants.uidpk);
		log.setUseruid(TestConstants.uid);
		double money = 30;
		log.setUsemoney(money);
		dao.update(log);
		log = dao.get(TestConstants.uidpk);
//		DateTime dateTime = log.getUpdateTime();
		assertTrue(money == log.getUsemoney());
		log.setUseruid(TestConstants.uid);
		dao.update(log);
//		log = dao.get(TestConstants.uidpk);
//		assertTrue(dateTime.getMillis() < log.getUpdateTime().getMillis());//测试更新日期
	}
	
	@Test
	public void testUpdateFields() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.UID, TestConstants.uidpk);
		map.put(MapperConstant.useruid, TestConstants.uid);
		double money = 999.99;
		map.put("usemoney", 999.99);
		dao.updateFields(map);
		assertTrue(money == dao.get(TestConstants.uidpk).getUsemoney());
	}

	@Test
	public void testDelete() {
		String uid = GlobalUtil.getUUID();
		log.setUid(uid);
		log.setUseruid(GlobalUtil.getUUID());
		log.setUsemoney(-205.8);
		log.setAccount(56.7);
		log.setDoaction("支付某商品");
		dao.insert(log);
		assertNotNull(dao.get(uid));
		dao.delete(uid);
		assertNull(dao.get(uid));
	}

}

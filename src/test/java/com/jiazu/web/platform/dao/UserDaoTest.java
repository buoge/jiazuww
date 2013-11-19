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
 * Create at: 2012-8-9 上午7:15:26
 * ============================================================================
 */
package com.jiazu.web.platform.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
import com.jiazu.web.platform.entity.User;

/**
 * @author Architect.bian
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void testInsertUser() {
		User user = new User();
		user.setUid(GlobalUtil.getUUID());
		user.setUserid(StringUtils.substring(GlobalUtil.getUUID(), 0, 11));
		user.setPassword(TestConstants.pwd_123456);
		user.setName("随即UID用户");
		user.setEmail("great@asd.com");
		user.setBirthday(new LocalDate(1988, 1, 5));
//		user.setStatus(Integer.parseInt(EStatus.enable.toString()));
		user.setStatus(EStatus.enable);
		userDao.insert(user);
	}

	@Test
	public void testGetUserbyUid() {
		assertNotNull(userDao.get(TestConstants.uid));
	}

	@Test
	public void testGetUserbyOid() {
		User user = userDao.getUserbyOid(TestConstants.oid);
		assertNotNull(user);
	}
	
	@Test
	public void testgetSumMoney() {
		assertTrue(userDao.getSumMoney() == 111);
	}
	
	@Test
	public void testgetCount() {
		assertTrue(userDao.getCount() > 0);
	}

	@Test
	public void testGetOne() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.userid, TestConstants.userId);
		map.put(MapperConstant.pwd, TestConstants.pwd_123456);
		assertNotNull(userDao.getOne(map));
	}

	@Test
	public void testGetUserbyUseridPwd() {
		User user = userDao.getUserbyUseridPwd(TestConstants.userId, TestConstants.pwd_123456);
		assertNotNull(user);
		assertEquals(TestConstants.userId, user.getUserid());
	}

	@Test
	public void testGetUidByUserid() {
		assertEquals(TestConstants.uid, userDao.getUidByUserid(TestConstants.userId));
	}
	
	@Test
	public void testGetList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.userid, TestConstants.userId);
		map.put(MapperConstant.pwd, TestConstants.pwd_123456);
		assertTrue(userDao.getList(map).size() == 1);
	}
	
	@Test
	public void testGetListByMemberSearch() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.UID, TestConstants.uid);
		map.put(MapperConstant.name, TestConstants.userId);
		assertTrue(userDao.getListByMemberSearch(map).size() >= 1);
	}
	
	@Test
	public void testUpdate() {
		User user = userDao.getUserbyUseridPwd(TestConstants.userId, TestConstants.pwd_123456);
		user.setGender(EGender.Gentleman);
		userDao.update(user);
	}
	
	@Test
	public void testUpdateFields() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.UID, TestConstants.uid);
		map.put(MapperConstant.pwd, TestConstants._123456);
		userDao.updateFields(map);
		assertEquals(TestConstants._123456, userDao.get(TestConstants.uid).getPassword());
		map.put(MapperConstant.pwd, TestConstants.pwd_123456);
		userDao.updateFields(map);
	}
	
	@Test
	public void testDelete() {
		String uid = GlobalUtil.getUUID();
		User user = new User();
		user.setUid(uid);
		user.setUserid(StringUtils.substring(GlobalUtil.getUUID(), 0, 11));
		user.setPassword(TestConstants.pwd_123456);
		user.setName("随即UID用户");
		user.setEmail("great@asd.com");
		user.setBirthday(new LocalDate(1988, 1, 5));
		user.setStatus(EStatus.enable);
		userDao.insert(user);
		userDao.delete(uid);
		assertNull(userDao.get(uid));
	}

}

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
 * Create at: 2012-8-10 上午7:33:18
 * ============================================================================
 */
package com.jiazu.web.platform.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.web.platform.entity.User;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:**/applicationContext**.xml"})
public class UserSOTest {

	@Autowired
	private UserSO so;
	
	/**
	 * Test method for {@link com.jiazu.web.platform.service.UserSO#isExistByUserid(java.lang.String)}.
	 */
	@Test
	public void testIsExistByUserid() {
		assertTrue(so.isExistByUserid(TestConstants.userId));
		assertFalse(so.isExistByUserid("jasdlk"));
	}

	/**
	 * Test method for {@link com.jiazu.web.platform.service.UserSO#getUser(java.lang.String)}.
	 */
	@Test
	public void testGetUserUid() {
		assertNotNull(so.getUser(TestConstants.uid));
	}

	/**
	 * Test method for {@link com.jiazu.web.platform.service.UserSO#getUser(int)}.
	 */
	@Test
	public void testGetUserInt() {
		assertNotNull(so.getUser(TestConstants.oid));
	}

	/**
	 * Test method for {@link com.jiazu.web.platform.service.UserSO#getUser(java.lang.String, java.lang.String)}.
	 */
	@Test
	@Ignore
	public void testGetUserbyUserIdPwd() {
		assertNotNull(so.getUser(TestConstants.userId, TestConstants.pwd_123456));
	}

	/**
	 * Test method for {@link com.jiazu.web.platform.service.UserSO#registerUser(com.jiazu.web.platform.entity.User)}.
	 */
	@Test
	@Ignore
	public void testRegisterUser() {
		User user = new User();
		user.setUid(GlobalUtil.getUUID());
		user.setUserid(StringUtils.substring(GlobalUtil.getUUID(), 0, 11));
		user.setPassword(DigestUtils.md5Hex(TestConstants._123456));
		user.setName("随即UID用户");
		user.setEmail("great@asd.com");
		user.setBirthday(new LocalDate(1988, 1, 5));
		assertTrue(so.registerUser(user));
	}

}

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
 * Create at: 2012-8-11 上午10:18:51
 * ============================================================================
 */
package com.jiazu.web.platform.proxy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.core.cache.impl.CacheFacade;
import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.factory.SessionFactory;
import com.jiazu.global.utility.CacheUtil;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.web.platform.entity.User;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class UserPXTest {

	/**
	 * Test method for {@link com.jiazu.web.platform.proxy.UserPX#isExistByUserid(java.lang.String)}.
	 */
	@Test
	public void testIsExistByUserid() {
		assertTrue(UserPX.isExistByUserid(TestConstants.userId));
		assertFalse(UserPX.isExistByUserid("sdfeklnd"));
	}

	/**
	 * Test method for {@link com.jiazu.web.platform.proxy.UserPX#getUser(java.lang.String)}.
	 */
	@Test
	public void testGetUserString() {
		assertNotNull(UserPX.getUser(TestConstants.uid));
		assertNull(UserPX.getUser(GlobalUtil.getUUID()));
	}

	/**
	 * Test method for {@link com.jiazu.web.platform.proxy.UserPX#getUser(int)}.
	 */
	@Test
	public void testGetUserInt() {
		assertNotNull(UserPX.getUser(TestConstants.oid));
		assertNull(UserPX.getUser(2993938));
	}

	/**
	 * Test method for {@link com.jiazu.web.platform.proxy.UserPX#getUser(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetUserStringString() {
		assertNotNull(UserPX.getUser(TestConstants.userId, TestConstants._123456));
	}

	/**
	 * 测试user必填项及userid唯一等等
	 * Test method for {@link com.jiazu.web.platform.proxy.UserPX#registerUser(com.jiazu.web.platform.entity.User)}.
	 */
	@Test
	public void testRegisterUser() {
		User user = new User();
		assertFalse(UserPX.registerUser(user));
		user.setUid(GlobalUtil.getUUID());
		user.setUserid(TestConstants.userId);
		user.setPassword(TestConstants.pwd_123456);
		user.setName("随即UID用户");
		user.setEmail("great@asd.com");
		assertFalse(UserPX.registerUser(user));
		user.setBirthday(new LocalDate(1988, 1, 5));
		user.setUserid(StringUtils.substring(GlobalUtil.getUUID(), 0, 11));
		assertTrue(UserPX.registerUser(user));
	}
	
	@Test
	public void testOnline() {
		User user = new User();
		assertFalse(UserPX.registerUser(user));
		user.setUid(GlobalUtil.getUUID());
		user.setPassword(TestConstants.pwd_123456);
		user.setName("随即UID用户");
		user.setEmail("great@asd.com");
		user.setUserid(StringUtils.substring(GlobalUtil.getUUID(), 0, 11));
		UserPX.online(user.getUid(), user);
		HttpSession sess = SessionFactory.getHttpSession();
		assertNotNull(sess.getAttribute(user.getUid()));
	}

}

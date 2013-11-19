/**
 * 
 * ============================================================================
 * 声明：北京旺族互联网科技有限公司版权所有
 * ----------------------------------------------------------------------------
 * Official Website: http://www.jiazuww.com
 * ----------------------------------------------------------------------------
 * Copyright: ? 2012 JiaZuWW All Rights Reserved.
 * ----------------------------------------------------------------------------
 * @version: 1.0
 * ----------------------------------------------------------------------------
 * @author: Greatbsky
 * ----------------------------------------------------------------------------
 * @email: verygreat@126.com
 * ----------------------------------------------------------------------------
 * Create at: 2012-8-14 下午3:52:09
 * ============================================================================
 */
package com.jiazu.core.cache.impl;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.core.cache.rule.SessionRule;
import com.jiazu.core.cache.rule.UserOnlineRule;
import com.jiazu.core.cache.rule.UserRule;
import com.jiazu.global.constants.TestConstants;
import com.jiazu.web.platform.entity.User;

/**
 * @author GreatHost
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class CacheFacadeTest {

	/**
	 * Test method for {@link com.jiazu.core.cache.impl.CacheFacade#set(com.jiazu.core.cache.Rule, java.lang.Object)}.
	 * @throws Exception 
	 */
	@Test
	public final void testSet() throws Exception {
//		CacheFacade.flushAll(new UserRule());
//		CacheFacade.flushAll(new UserOnlineRule());
		User user = new User();
		user.setUid(TestConstants.uid);
		user.setUserid(TestConstants.userId);
		CacheFacade.set(new UserRule(TestConstants.userId), user);
		assertNotNull(CacheFacade.get(new UserRule(TestConstants.userId)));
		CacheFacade.set(new UserOnlineRule(TestConstants.userId), TestConstants.uid);
		assertNotNull(CacheFacade.get(new UserRule(TestConstants.userId)));
		assertEquals(TestConstants.uid, ((User)CacheFacade.get(new UserRule(TestConstants.userId))).getUid());
		assertEquals(TestConstants.userId, ((User)CacheFacade.get(new UserRule(TestConstants.userId))).getUserid());
		assertEquals(TestConstants.uid, CacheFacade.get(new UserOnlineRule(TestConstants.userId)));
	}

	/**
	 * Test method for {@link com.jiazu.core.cache.impl.CacheFacade#get(com.jiazu.core.cache.Rule)}.
	 * @throws Exception 
	 */
	@Test
	public final void testGet() throws Exception {
		assertNull(CacheFacade.get(new UserRule("")));
		assertNull(CacheFacade.get(new UserOnlineRule("")));
		User user = new User();
		user.setUid(TestConstants.uid);
		user.setUserid(TestConstants.userId);
		CacheFacade.set(new UserRule(TestConstants.userId), user);
		CacheFacade.set(new UserOnlineRule(TestConstants.userId), TestConstants.uid);
		assertEquals(TestConstants.uid, ((User)CacheFacade.get(new UserRule(TestConstants.userId))).getUid());
		assertEquals(TestConstants.userId, ((User)CacheFacade.get(new UserRule(TestConstants.userId))).getUserid());
		assertEquals(TestConstants.uid, CacheFacade.get(new UserOnlineRule(TestConstants.userId)));
	}

	/**
	 * Test method for {@link com.jiazu.core.cache.impl.CacheFacade#getKeys(com.jiazu.core.cache.Rule)}.
	 * @throws Exception 
	 */
	@Test
	public final void testGetKeys() throws Exception {
		User user = new User();
		user.setUid(TestConstants.uid);
		user.setUserid(TestConstants.userId);
		CacheFacade.set(new UserRule(TestConstants.userId), user);
		assertTrue(CacheFacade.getKeys(new UserRule(TestConstants.userId)).contains(new UserRule(TestConstants.userId)));
		assertFalse(CacheFacade.getKeys(new UserRule(TestConstants.userId)).contains(TestConstants.uid));
	}

	/**
	 * Test method for {@link com.jiazu.core.cache.impl.CacheFacade#getValues(com.jiazu.core.cache.Rule)}.
	 * @throws Exception 
	 */
	@Test
	public final void testGetValues() throws Exception {
		User user = new User();
		user.setUid(TestConstants.uid);
		user.setUserid(TestConstants.userId);
		CacheFacade.set(new UserRule(TestConstants.userId), user);
		CacheFacade.set(new UserRule(TestConstants.uid), user);
		assertTrue(CacheFacade.getValues(new UserRule(TestConstants.userId)).contains(user));
	}

	/**
	 * Test method for {@link com.jiazu.core.cache.impl.CacheFacade#remove(com.jiazu.core.cache.Rule)}.
	 * @throws Exception 
	 */
	@Test
	public final void testRemove() throws Exception {
		User user = new User();
		user.setUid(TestConstants.uid);
		user.setUserid(TestConstants.userId);
		CacheFacade.set(new UserRule(TestConstants.uid), user);
		CacheFacade.set(new UserRule(TestConstants.userId), user);
		CacheFacade.remove(new UserRule(TestConstants.userId));
		assertNull(CacheFacade.get(new UserRule(TestConstants.userId)));
		assertEquals(TestConstants.userId, ((User)CacheFacade.get(new UserRule(TestConstants.uid))).getUserid());
	}

	/**
	 * Test method for {@link com.jiazu.core.cache.impl.CacheFacade#flushAll(com.jiazu.core.cache.Rule)}.
	 * @throws Exception 
	 */
	@Test
	public final void testFlushAll() throws Exception {
		User user = new User();
		user.setUid(TestConstants.uid);
		user.setUserid(TestConstants.userId);
		CacheFacade.set(new UserRule(TestConstants.userId), user);
		CacheFacade.set(new UserOnlineRule(TestConstants.userId), TestConstants.uid);
		CacheFacade.flushAll(new UserRule());
		CacheFacade.flushAll(new UserOnlineRule());
		assertNull(CacheFacade.get(new UserRule(TestConstants.userId)));
		assertNull(CacheFacade.get(new UserOnlineRule(TestConstants.userId)));
	}

	@Test
	public final void testGetSessionKeys() throws Exception {
		Set<String> keys = CacheFacade.getKeys(new SessionRule("",""));
		System.out.println(keys);
	}
}

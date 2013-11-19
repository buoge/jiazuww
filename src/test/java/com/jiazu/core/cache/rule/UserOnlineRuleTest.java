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
 * Create at: 2012-8-14 上午7:24:25
 * ============================================================================
 */
package com.jiazu.core.cache.rule;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.core.cache.Rule;
import com.jiazu.global.constants.TestConstants;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class UserOnlineRuleTest {

	
	/**
	 * Test method for {@link com.jiazu.core.cache.rule.UserOnlineRule#UserOnlineRule(java.lang.String)}.
	 */
	@Test
	public void testUserOnlineRule() {
		UserOnlineRule rule = new UserOnlineRule();
		rule.setKey(TestConstants.uid);
		String path = "/users/online";
		assertEquals(path, rule.getPath());
		assertEquals(path + ":" + TestConstants.uid, rule.getKey());
		assertEquals("/users/online", rule.getCacheId());
	}

	@Test
	public void testUserOnlineRuleString() {
		UserOnlineRule rule = new UserOnlineRule(TestConstants.uid);
		String path = "/users/online";
		assertEquals(path, rule.getPath());
		assertEquals(path + ":" + TestConstants.uid, rule.getKey());
		assertEquals("/users/online", rule.getCacheId());
	}

	@Test
	public void testUserOnlineRule2Args() {
		int exp = 102;
		UserOnlineRule rule = new UserOnlineRule(TestConstants.uid, exp);
		String path = "/users/online";
		assertEquals(path, rule.getPath());
		String expected = path + ":" + TestConstants.uid;
		assertEquals(expected, rule.getKey());
		assertEquals(expected, rule.getKeys().toArray()[0]);
		assertEquals("/users/online", rule.getCacheId());
		assertEquals(exp, rule.getExpire());
		rule.setExpire(100);
		assertEquals(100, rule.getExpire());
		String key2 = "key222222";
		String expected2 = path + ":" + key2;
		rule.addKey(key2);
		assertEquals(2, rule.getKeys().size());
		assertTrue(rule.getKeys().contains(expected2));
	}

}

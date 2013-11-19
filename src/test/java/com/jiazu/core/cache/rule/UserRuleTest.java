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
 * Create at: 2012-8-13 下午10:33:21
 * ============================================================================
 */
package com.jiazu.core.cache.rule;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.core.cache.Rule;
import com.jiazu.global.constants.SysConstant;
import com.jiazu.global.constants.TestConstants;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class UserRuleTest {

	/**
	 * Test method for {@link com.jiazu.core.cache.rule.UserRule#UserRule(java.lang.String)}.
	 */
	@Test
	public void testUserRule() {
		Rule rule = new UserRule();
		rule.setKey(TestConstants.uid);
		String cacheId = "/users";
		String path = "/users";
		String expected = "/users" + ":" + TestConstants.uid;
		assertEquals(cacheId, rule.getCacheId());
		assertEquals(path, rule.getPath());
		assertEquals(expected, rule.getKey());
		assertEquals(expected, rule.toString());
	}

	@Test
	public void testUserRule1Args() {
		Rule rule = new UserRule(TestConstants.uid);
		String cacheId = "/users";
		String path = "/users";
		String expected = "/users" + ":" + TestConstants.uid;
		assertEquals(cacheId, rule.getCacheId());
		assertEquals(path, rule.getPath());
		assertEquals(expected, rule.getKey());
		assertEquals(expected, rule.toString());
	}
	
	@Test
	public void testUserRule2Args() {
		Rule rule = new UserRule(TestConstants.uid, 1);
		String cacheId = "/users";
		String path = "/users";
		String expected = path + ":" + TestConstants.uid;
		assertEquals(cacheId, rule.getCacheId());
		assertEquals(path, rule.getPath());
		assertEquals(expected, rule.getKey());
		assertEquals(expected, rule.getKeys().toArray()[0]);
		assertEquals(expected, rule.toString());
		assertEquals(1, rule.getExpire());
		String key2 = "key222222";
		String expected2 = path + ":" + key2;
		rule.addKey(key2);
		assertEquals(2, rule.getKeys().size());
		assertTrue(rule.getKeys().contains(expected2));
	}

}

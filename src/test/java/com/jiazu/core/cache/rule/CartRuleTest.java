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
 * Create at: 2012-11-7 下午6:28:36
 * ============================================================================
 */
package com.jiazu.core.cache.rule;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jiazu.core.cache.Rule;
import com.jiazu.global.utility.GlobalUtil;

/**
 * @author Architect.bian
 *
 */
public class CartRuleTest {

	/**
	 * Test method for {@link com.jiazu.core.cache.rule.CartRule#CartRule()}.
	 */
	@Test
	public void testCartRule() {
		Rule rule = new CartRule();
		System.out.println(rule.toString());
		String expected = "/users/cart:";
		assertEquals(expected, rule.toString());
	}

	/**
	 * Test method for {@link com.jiazu.core.cache.rule.CartRule#CartRule(java.lang.String)}.
	 */
	@Test
	public void testCartRuleString() {
		String uid = GlobalUtil.getUUID();
		Rule rule = new CartRule(uid);
		System.out.println(rule.toString());
		String expected = "/users/cart:" + uid;
		assertEquals(expected, rule.toString());
	}

	/**
	 * Test method for {@link com.jiazu.core.cache.rule.CartRule#CartRule(java.lang.String, int)}.
	 */
	@Test
	public void testCartRuleStringInt() {
		String uid = GlobalUtil.getUUID();
		Rule rule = new CartRule(uid, 30);
		System.out.println(rule.toString());
		String expected = "/users/cart:" + uid;
		assertEquals(expected, rule.toString());
	}

}

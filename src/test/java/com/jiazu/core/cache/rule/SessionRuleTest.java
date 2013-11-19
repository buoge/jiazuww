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
 * Create at: 2012-8-15 下午8:29:40
 * ============================================================================
 */
package com.jiazu.core.cache.rule;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jiazu.core.cache.Rule;
import com.jiazu.global.constants.TestConstants;

/**
 * @author Architect.bian
 *
 */
public class SessionRuleTest {

	@Test
	public void test() {
		Rule rule = new SessionRule(TestConstants.uid, TestConstants.userId);
		String expected = "/s/" + TestConstants.uid + ":" + TestConstants.userId;
		System.out.println(rule.toString());
		System.out.println(expected);
		assertEquals(expected, rule.getKey());
		assertEquals(expected, rule.toString());
	}

}

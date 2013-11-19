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
 * Create at: 2012-8-15 下午9:23:23
 * ============================================================================
 */
package com.jiazu.core.cache.impl;

import static org.junit.Assert.*;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.factory.SessionFactory;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class SessionImplTest {

	@Autowired
	HttpSession session;
	
	@Autowired
	HttpSession session2;
	
	/**
	 * Test method for {@link com.jiazu.core.cache.impl.SessionImpl#getCreationTime()}.
	 */
	@Test
	public void testGetCreationTime() {
		long time1 = session.getCreationTime();
		long time2 = session2.getCreationTime();
		assertEquals(time1, time2);
	}

	/**
	 * Test method for {@link com.jiazu.core.cache.impl.SessionImpl#getAttributeNames()}.
	 */
	@Test
	public void testAttribute() {
		session.setAttribute(TestConstants.uid, TestConstants.userId);
		assertEquals(session.getAttribute(TestConstants.uid), TestConstants.userId);
		assertEquals(session2.getAttribute(TestConstants.uid), TestConstants.userId);
		session2.removeAttribute(TestConstants.uid);
		assertNull(session.getAttribute(TestConstants.uid));
	}

}

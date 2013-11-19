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
 * Create at: 2012-10-6 下午1:16:36
 * ============================================================================
 */
package com.jiazu.web.platform.proxy;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class ZuPuPXTest {

	/**
	 * Test method for {@link com.jiazu.web.platform.proxy.ZuPuPX#getCreatedCount()}.
	 */
	@Test
	@Ignore
	public void testGetCreatedCount() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jiazu.web.platform.proxy.ZuPuPX#getLatest(int)}.
	 */
	@Test
	@Ignore
	public void testGetLatest() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jiazu.web.platform.proxy.ZuPuPX#getZuPuNews(int)}.
	 */
	@Test
	@Ignore
	public void testGetZuPuNews() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jiazu.web.platform.proxy.ZuPuPX#getIntroduce()}.
	 */
	@Test
	@Ignore
	public void testGetIntroduce() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jiazu.web.platform.proxy.ZuPuPX#getMembers(java.lang.String)}.
	 */
	@Test
	@Ignore
	public void testGetMembers() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jiazu.web.platform.proxy.ZuPuPX#getJsonMembers(java.lang.String)}.
	 */
	@Test
	public void testGetJsonMembers() {
		System.out.println(ZuPuPX.getJsonMembers("uid"));
		assertTrue(ZuPuPX.getJsonMembers("uid").length() > 0);
	}

}

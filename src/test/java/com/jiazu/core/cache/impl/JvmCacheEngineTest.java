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
 * Create at: 2012-8-12 下午3:20:31
 * ============================================================================
 */
package com.jiazu.core.cache.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.exception.MemcachedException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:**/applicationContext**.xml"})
public class JvmCacheEngineTest {

	@Autowired
	JvmCacheEngine cacheEngine;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cacheEngine.init();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		cacheEngine.stop();
	}
	
	/**
	 * Test method for {@link com.jiazu.core.cache.impl.JvmCacheEngine#init()}.
	 * @throws Exception 
	 */
	@Test
	public void testInit() throws Exception {
		cacheEngine.init();
		assertEquals(0, cacheEngine.size());
	}

	/**
	 * Test method for {@link com.jiazu.core.cache.impl.JvmCacheEngine#stop()}.
	 * @throws Exception 
	 */
	@Test(expected=NullPointerException.class)
	public void testStop() throws Exception {
		cacheEngine.stop();
		cacheEngine.size();
	}

	/**
	 * Test method for {@link com.jiazu.core.cache.impl.JvmCacheEngine#add(java.lang.String, java.lang.Object)}.
	 * @throws Exception 
	 */
	@Test
	public void testAddGetObject() throws Exception {
		String key = "asdhj234f";
		String value = "testAddStringObject";
		cacheEngine.set(key, value);
//		cacheEngine.add(key, value);
		assertEquals(value, cacheEngine.get(key));
	}

	/**
	 * Test method for {@link com.jiazu.core.cache.impl.JvmCacheEngine#remove(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testRemove() throws Exception {
		String key = "asdhjf";
		String value = "testAddStringStringObject";
		cacheEngine.set(key, value);
		cacheEngine.remove(key);
		assertNull(cacheEngine.get(key));
	}

	/**
	 * Test method for {@link com.jiazu.core.cache.impl.JvmCacheEngine#remove(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testGetValues() throws Exception {
		String key = "asdhjf";
		String value = "testAddStringStringObject";
		cacheEngine.set(key, value);
		assertEquals(value, cacheEngine.getValues().toArray()[0]);
	}
	
	@Test
	public void testGetKeys() throws Exception {
		String key = "asdhjf";
		String value = "testAddStringStringObject";
		cacheEngine.set(key, value);
		assertEquals(key, cacheEngine.getKeys().toArray()[0]);
	}

}

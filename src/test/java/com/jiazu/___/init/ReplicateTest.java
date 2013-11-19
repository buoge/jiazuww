/**
 * 多主从数据库测试
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
 * Create at: 2012-8-5 下午2:55:30
 * ============================================================================
 */
package com.jiazu.___.init;

import static org.junit.Assert.*;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.web.shop.dao.TestDao;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:**/applicationContext**.xml"})
public class ReplicateTest {

	@Autowired
	private TestDao testDao;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void mybatisInsertTest() {
		logger.info("-----------begin to invoke method: mybatisInsertTest");
		HashMap<String, String> parameter = new HashMap<>();
		parameter.put("value", "insert3306");
		testDao.insertTest(parameter);
	}

	@Test
	public void mybatisGetTest() {
		logger.info("-----------begin to invoke method: mybatisGetTest");
		assertEquals("insert3306", testDao.getTest(1).get("value"));
	}
}

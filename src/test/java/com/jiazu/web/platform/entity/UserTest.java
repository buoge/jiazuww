/**
 * user实体测试类
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
 * Create at: 2012-8-5 上午9:38:15
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.global.constants.EStatus;
import com.jiazu.global.utility.DateUtil;
import com.jiazu.global.utility.GlobalUtil;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:**/applicationContext**.xml"})
public class UserTest {
	
	@Autowired
	ApplicationContext context;
	
	@Test
	public void getUserTest() {
		User user = (User)context.getBean("user");
		assertNotNull(user);
	}
	
	@Test
	public void createUserTest(){
		User user = new User();
		assertNull(user.status);
		user.status = EStatus.enable;
		assertEquals(user.getStatus(), EStatus.enable);
		assertNull(user.getBirthday());
		assertEquals(0, user.getSalary());
		assertEquals(0, user.getEducount());
		assertNotNull(user.getUid());
		String uuid = GlobalUtil.getUUID();
		user.setUid(uuid);
		assertEquals(uuid.hashCode(), user.hashCode());
		assertTrue(DateUtil.isToday(user.getCreateTime().toDate()));
	}
}

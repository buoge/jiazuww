/**
 * GlobalUtil测试类
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
 * Create at: 2012-8-5 上午11:08:01
 * ============================================================================
 */
package com.jiazu.global.utility;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
/**
 * @author Architect.bian
 *
 */
public class GlobalUtilTest {
	@Test
	public void getUUIDTest() {
		assertNotNull(GlobalUtil.getUUID());
		assertThat(32, is(GlobalUtil.getUUID().length()));
		assertThat("Contain char '-'.", GlobalUtil.getUUID(), not(containsString("-")));
		assertThat(GlobalUtil.getUUID(), not(equalTo(GlobalUtil.getUUID())));
	}
}

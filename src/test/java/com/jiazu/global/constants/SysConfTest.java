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
 * Create at: 2012-10-16 上午8:28:15
 * ============================================================================
 */
package com.jiazu.global.constants;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.global.utility.StrUtil;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class SysConfTest {

	@Test
	public void test() {
//		File f = new File(ClassLoader.getSystemResource("").getFile());
//		f = f.getParentFile().getParentFile();
//		String expected = StrUtil.trim(f.getPath(),"/");
		String expected = SysConf.UserImgUploadPath;
		System.out.println(expected);
		assertTrue(StringUtils.isNotEmpty(expected));
	}

}

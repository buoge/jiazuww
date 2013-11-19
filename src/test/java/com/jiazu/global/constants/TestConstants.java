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
 * Create at: 2012-8-11 上午10:26:57
 * ============================================================================
 */
package com.jiazu.global.constants;

import static org.junit.Assert.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * @author Architect.bian
 *
 */
public class TestConstants {
	
	public static final String _123456 = "123456";

	public static final String pwd_123456 = DigestUtils.md5Hex(_123456);
	
	public static final String userId = "greathill";

	public static final String uid = "93483b04795f48d0a70b1f9004c1f98f";

	public static final String uidpk = "86883b04795f38d0a70b1f9004c1f989";

	public static final String uidpk2 = "d064a2fee9bb11e1b4b000fff2ed3093";
	
	public static final int oid = 1;


	/**
	 * 可测试常量之间关联是否正确
	 */
	@Test
	public void testUserConstant() {
		assertTrue(true);
	}

}

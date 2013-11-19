/**
 * 
 * ============================================================================
 * 声明：北京旺族互联网科技有限公司版权所有
 * ----------------------------------------------------------------------------
 * Official Website: http://www.jiazuww.com
 * ----------------------------------------------------------------------------
 * Copyright: ? 2012 JiaZuWW All Rights Reserved.
 * ----------------------------------------------------------------------------
 * @version: 1.0
 * ----------------------------------------------------------------------------
 * @author: Greatbsky
 * ----------------------------------------------------------------------------
 * @email: verygreat@126.com
 * ----------------------------------------------------------------------------
 * Create at: 2012-8-9 下午3:22:18
 * ============================================================================
 */
package com.jiazu.global.constants;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author GreatHost
 *
 */
public class EStatusTest {

	@Test
	public final void ToStringtest() {
		assertEquals("1", EStatus.enable.toString());
		assertEquals("0", EStatus.disable.toString());
	}
	
	@Test
	public final void ValueOfTest() {
//		Status status = Status.enable;
		assertEquals(EStatus.enable, EStatus.get(1));
		assertEquals(EStatus.disable, EStatus.get(0));
	}
	
	@Test
	public final void testGetName() {
		assertEquals("有效", EStatus.getName(EStatus.enable));
		assertEquals("无效", EStatus.getName(EStatus.disable));
		
	}

}

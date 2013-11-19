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
 * Create at: 2012-8-5 下午1:42:16
 * ============================================================================
 */
package com.jiazu.global.utility;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Architect.bian
 *
 */
public class StrUtilTest {

	@Test
	public void testSplitToIntArray() {
		String str = "6 1 3 5";
		int[] expecteds = new int[]{6, 1, 3, 5};
		assertArrayEquals(expecteds, StrUtil.splitToIntArray(str));
		str = "6 1 3 5 ";
		assertArrayEquals(expecteds, StrUtil.splitToIntArray(str));
		str = "  6   1   3   5         ";
		assertArrayEquals(expecteds, StrUtil.splitToIntArray(str));
	}
}

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
 * Create at: 2012-12-4 下午7:08:40
 * ============================================================================
 */
package com.jiazu.global.utility;

/**
 * @author Architect.bian
 *
 */
public class ConvertUtil {

	/**
	 * @param istop
	 * @return
	 */
	public static boolean toBoolean(String value) {
		if (value != null) {
			if (value.equalsIgnoreCase("true") || (StrUtil.isNumeric(value) && Integer.valueOf(value) > 0)) {
				return true;
			}
		}
		 return false;
	}

}

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
 * Create at: 2012-10-14 下午4:40:04
 * ============================================================================
 */
package com.jiazu.global.utility;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author Architect.bian
 *
 */
public class ListUtil {

	/**
	 * @param list
	 */
	public static void trim(List<?> list) {
		Collection<?> c = new HashSet<Object>();
		c.add(null);
		list.removeAll(c);
	}
	
	/**
	 * 还未测试，从list中删除指定值
	 * @param list
	 * @param params
	 */
	public static void trim(List<?> list, Object... params) {
		for (Object obj : params) {
			list.remove(obj);
		}
	}

}

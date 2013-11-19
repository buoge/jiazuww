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
 * Create at: 2012-8-17 上午8:33:19
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EWish {

	defaultwish("0");

	private static Map<EWish, String> map = new HashMap<EWish, String>();
	
	private final String value;
	
	private EWish(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}
	
	public static EWish get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EWish get(String str) {
		for (EWish e : values()) {
			if(e.toString().equals(str)) {
				return (EWish)e;
			}
		}
		return null;
	}

	public static String getName(EWish e) {
		if (map.size() == 0) {
			map.put(EWish.defaultwish, "");
		}
		return map.get(e);
	}
}

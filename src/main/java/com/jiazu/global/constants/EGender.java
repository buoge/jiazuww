/**
 * 性别枚举类型
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
 * Create at: 2012-8-4 下午8:24:54
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EGender {
	Lady("0"),Gentleman("1");

	private static Map<EGender, String> map = new HashMap<EGender, String>();
	
	private final String value;
	
	private EGender(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static EGender get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EGender get(String str) {
		for (EGender e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EGender e) {
		if (map.size() == 0) {
			map.put(EGender.Lady, "美女");
			map.put(EGender.Gentleman, "帅哥");
		}
		return map.get(e);
	}
}

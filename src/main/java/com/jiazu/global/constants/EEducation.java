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
 * Create at: 2012-8-17 上午7:56:41
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EEducation {
	
	Famous("0"), Professional("1"), Home("2"), Book("3");
	
	private static Map<EEducation, String> map = new HashMap<EEducation, String>();
	
	private final String value;
	
	private EEducation(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static EEducation get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	public static EEducation get(String str) {
		for (EEducation e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EEducation e) {
		if (map.size() == 0) {
			map.put(EEducation.Book, "教育教材");
			map.put(EEducation.Famous, "名门家教");
			map.put(EEducation.Home, "家族教育");
			map.put(EEducation.Professional, "专家理念");
		}
		return map.get(e);
	}
}

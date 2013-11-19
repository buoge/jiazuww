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
 * Create at: 2012-8-18 上午8:55:24
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonValue;

/**
 * @author Architect.bian
 *
 */
public enum EAddress {

	Default("0"), home("1"), office("2");

	private static Map<EAddress, String> map = new HashMap<EAddress, String>();
	
	private final String value;
	
	private EAddress(String v) {
		this.value = v;
	}
	
	@JsonValue
	public String toString() {
		return this.value;
	}

	public static EAddress get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EAddress get(String str) {
		for (EAddress e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EAddress e) {
		if (map.size() == 0) {
			map.put(EAddress.Default, "默认住址");
			map.put(EAddress.home, "家庭住址");
			map.put(EAddress.office, "办公地址");
		}
		return map.get(e);
	}
}

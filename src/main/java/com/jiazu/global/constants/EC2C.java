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
 * Create at: 2012-8-18 上午9:28:23
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EC2C {

	sell("0"),buy("1"),charity("2");
	
	private static Map<EC2C, String> map = new HashMap<EC2C, String>();
	static {
		map.put(EC2C.sell, "出售");
		map.put(EC2C.buy, "求购");
		map.put(EC2C.charity, "公益");
	}
	private final String value;
	
	private EC2C(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static EC2C get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	public static EC2C get(String str) {
		for (EC2C e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EC2C e) {
		return map.get(e);
	}
}

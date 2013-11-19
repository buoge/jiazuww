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
 * Create at: 2012-9-16 下午2:48:16
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EMark {

	initial("0"),read("1");

	private static Map<EMark, String> map = new HashMap<EMark, String>();
	static {
		map.put(EMark.initial, "初始");
		map.put(EMark.read, "已读");
	}
	
	private final String value;
	
	private EMark(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static EMark get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EMark get(String str) {
		for (EMark e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EMark e) {
		return map.get(e);
	}
}

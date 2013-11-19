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
 * Create at: 2012-8-17 上午8:18:50
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EEvent {
	event("0");

	private static Map<EEvent, String> map = new HashMap<EEvent, String>();
	
	private final String value;
	
	private EEvent(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static EEvent get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EEvent get(String str) {
		for (EEvent e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EEvent e) {
		if (map.size() == 0) {
			map.put(EEvent.event, "默认");
		}
		return map.get(e);
	}
}

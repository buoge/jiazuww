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
 * Create at: 2012-8-17 上午8:32:35
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EMsg {
	sys("0"), other("1");

	private static Map<EMsg, String> map = new HashMap<EMsg, String>();
	
	private final String value;
	
	private EMsg(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}
	
	public static EMsg get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EMsg get(String str) {
		for (EMsg e : values()) {
			if(e.toString().equals(str)) {
				return (EMsg)e;
			}
		}
		return null;
	}

	public static String getName(EMsg e) {
		if (map.size() == 0) {
			map.put(EMsg.sys, "系统消息");
		}
		return map.get(e);
	}
}

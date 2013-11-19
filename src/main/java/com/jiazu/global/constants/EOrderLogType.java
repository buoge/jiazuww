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
 * Create at: 2012-8-18 上午9:16:39
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EOrderLogType {
	
	submitted("0"),//已提交
	payed("1");//已付款

	private static Map<EOrderLogType, String> map = new HashMap<EOrderLogType, String>();
	
	private final String value;
	
	private EOrderLogType(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static EOrderLogType get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EOrderLogType get(String str) {
		for (EOrderLogType e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EOrderLogType e) {
		if (map.size() == 0) {
			map.put(EOrderLogType.submitted, "已提交");
			map.put(EOrderLogType.payed, "已付款");
		}
		return map.get(e);
	}
}

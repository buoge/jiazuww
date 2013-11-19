/**
 * 状态枚举类型，可使用Status.get(1)获得对应的值
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
 * Create at: 2012-8-4 下午8:35:11
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EStatus {
	init("2"), enable("1"), disable("0");
	
	private static Map<EStatus, String> map = new HashMap<EStatus, String>();
	
	private final String value;
	
	private EStatus(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}
	
	public static EStatus get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EStatus get(String str) {
		for (EStatus e : values()) {
			if(e.toString().equals(str)) {
				return (EStatus)e;
			}
		}
		return null;
	}
	
	public static String getName(EStatus status) {
		if (map.size() == 0) {
			map.put(EStatus.enable, "有效");
			map.put(EStatus.disable, "无效");
		}
		return map.get(status);
	}
}

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
 * Create at: 2012-8-18 上午9:14:11
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EShipping {
	
	packaged("0"), sending("1"), received("2"), init("-1");

	private static Map<EShipping, String> map = new HashMap<EShipping, String>();
	
	private final String value;
	
	private EShipping(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static EShipping get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EShipping get(String str) {
		for (EShipping e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EShipping e) {
		if (map.size() == 0) {
			map.put(EShipping.init, "初始");
			map.put(EShipping.packaged, "已打包");
			map.put(EShipping.sending, "派送中");
			map.put(EShipping.received, "已收到");
		}
		return map.get(e);
	}
}

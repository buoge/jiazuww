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
 * Create at: 2012-11-4 下午1:13:07
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EShow {

	none("-1"), text("0"), image("1");

	private static Map<EShow, String> map = new HashMap<EShow, String>();
	
	private final String value;
	
	private EShow(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static EShow get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EShow get(String str) {
		for (EShow e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EShow e) {
		if (map.size() == 0) {
			map.put(EShow.none, "隐藏");
			map.put(EShow.text, "文本");
			map.put(EShow.image, "图像");
		}
		return map.get(e);
	}
}

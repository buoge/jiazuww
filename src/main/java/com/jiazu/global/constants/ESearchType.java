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
 * Create at: 2012-9-16 下午2:44:53
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum ESearchType {

	All("0"),edu("1"),event("2"),b2c("3"),c2c("4");

	private static Map<ESearchType, String> map = new HashMap<ESearchType, String>();
	static {
		map.put(ESearchType.All, "全部");
		map.put(ESearchType.edu, "教育");
		map.put(ESearchType.event, "大事记");
		map.put(ESearchType.b2c, "文化产品");
		map.put(ESearchType.c2c, "互通有无");
	}
	
	private final String value;
	
	private ESearchType(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static ESearchType get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static ESearchType get(String str) {
		for (ESearchType e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(ESearchType e) {
		return map.get(e);
	}
}

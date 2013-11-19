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
 * Create at: 2012-8-18 上午8:51:14
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EB2C {

	book("0"),culture("1"),edutool("2"),software("3"),money("4");

	private static Map<EB2C, String> map = new HashMap<EB2C, String>();
	static {
		map.put(EB2C.book, "书籍");
		map.put(EB2C.culture, "文化产品");
		map.put(EB2C.edutool, "教具");
		map.put(EB2C.software, "软件");
		map.put(EB2C.money, "金币");
	}
	
	private final String value;
	
	private EB2C(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static EB2C get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	public static EB2C get(String str) {
		for (EB2C e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EB2C e) {
		return map.get(e);
	}
}

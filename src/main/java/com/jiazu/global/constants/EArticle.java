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
public enum EArticle {

	msg("0"),edu("1"),event("2");

	private static Map<EArticle, String> map = new HashMap<EArticle, String>();
	static {
		map.put(EArticle.msg, "消息");
		map.put(EArticle.edu, "教育");
		map.put(EArticle.event, "大事记");
	}
	
	private final String value;
	
	private EArticle(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static EArticle get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EArticle get(String str) {
		for (EArticle e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EArticle e) {
		return map.get(e);
	}
}

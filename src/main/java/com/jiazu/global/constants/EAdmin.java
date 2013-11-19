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
 * Create at: 2012-10-25 上午7:38:45
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EAdmin {

	Deny("-1"), False("0"), True("1"), Owner("2"), Systemer("3");

	private static Map<EAdmin, String> map = new HashMap<EAdmin, String>();
	
	private final String value;
	
	private EAdmin(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static EAdmin get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EAdmin get(String str) {
		for (EAdmin e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EAdmin e) {
		if (map.size() == 0) {
			map.put(EAdmin.Deny, "黑名单");
			map.put(EAdmin.False, "非管理员");
			map.put(EAdmin.True, "是管理员");
			map.put(EAdmin.Owner, "所有者");
			map.put(EAdmin.Systemer, "系统管理员");
		}
		return map.get(e);
	}
}

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
 * Create at: 2012-12-26 下午3:13:42
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EPageState {

	initial("0"),registered("1");

	private static Map<EPageState, String> map = new HashMap<EPageState, String>();
	static {
		map.put(EPageState.initial, "初始");
		map.put(EPageState.registered, "已注册");
	}
	
	private final String value;
	
	private EPageState(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static EPageState get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EPageState get(String str) {
		for (EPageState e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EPageState e) {
		return map.get(e);
	}
}

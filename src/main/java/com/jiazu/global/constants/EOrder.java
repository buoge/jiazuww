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
 * Create at: 2012-8-18 上午9:14:04
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EOrder {

	init("-1"),payed("1"), sending("2"), success("3"), failed("0");

	private static Map<EOrder, String> map = new HashMap<EOrder, String>();
	
	private final String value;
	
	private EOrder(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static EOrder get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EOrder get(String str) {
		for (EOrder e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EOrder e) {
		if (map.size() == 0) {
			map.put(EOrder.init, "已下单,待付款");
			map.put(EOrder.payed, "已付款,待发货");
			map.put(EOrder.sending, "已发货，待收货");
			map.put(EOrder.success, "成功");
			map.put(EOrder.failed, "失败");
		}
		return map.get(e);
	}
}

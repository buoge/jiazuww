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
 * Create at: 2012-8-18 上午9:14:21
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EPay {
	
	payed("0"), init("-1"), WAIT_SELLER_AGREE("3"), SELLER_REFUSE_BUYER("4"), WAIT_BUYER_RETURN_GOODS("5"), WAIT_SELLER_CONFIRM_GOODS("6"), REFUND_SUCCESS("7"), REFUND_CLOSED("8");

	private static Map<EPay, String> map = new HashMap<EPay, String>();
	
	private final String value;
	
	private EPay(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static EPay get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EPay get(String str) {
		for (EPay e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EPay e) {
		if (map.size() == 0) {
			map.put(EPay.init, "初始");
			map.put(EPay.payed, "已付款");
			
			map.put(EPay.WAIT_SELLER_AGREE, "退款协议等待卖家确认中");
			map.put(EPay.SELLER_REFUSE_BUYER, "卖家不同意协议，等待买家修改");
			map.put(EPay.WAIT_BUYER_RETURN_GOODS, "退款协议达成，等待买家退货");
			map.put(EPay.WAIT_SELLER_CONFIRM_GOODS, "等待卖家收货");
			map.put(EPay.REFUND_SUCCESS, "退款成功");
			map.put(EPay.REFUND_CLOSED, "退款关闭");
		}
		return map.get(e);
	}
}

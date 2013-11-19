/**
 * 网站内容枚举类型，广告 关于我门等等
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
 * Create at: 2012-8-18 上午9:33:15
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public enum EContent {
	
	ad("0"), notice("1"), rule_register("2"), friendLink_txt("3"), friendLink_img("4"), zupu_introduce("5"), hotsearch("6"), banner("7"), logo("8"), jisi("9"),
	aboutus("10"), charge("11"), service("12"), hr("13"), legal("14"), help("15"),
	email_pwdreset("20"),email_validate("21");

	private static Map<EContent, String> map = new HashMap<EContent, String>();
	
	static{
		map.put(EContent.ad, "广告");
		map.put(EContent.notice, "公告");
		map.put(EContent.rule_register, "注册条款");
		map.put(EContent.friendLink_txt, "文本友情链接");
		map.put(EContent.friendLink_img, "图像友情链接");
		map.put(EContent.zupu_introduce, "族谱介绍");
		map.put(EContent.hotsearch, "热门搜索");
		map.put(EContent.banner, "banner");
		map.put(EContent.logo, "Logo");
		map.put(EContent.jisi, "祭祀开头语");
		map.put(EContent.aboutus, "关于我们");
		map.put(EContent.charge, "充值服务");
		map.put(EContent.service, "客服中心");
		map.put(EContent.hr, "招贤纳士");
		map.put(EContent.legal, "网站声明");
		map.put(EContent.help, "帮助中心");
		map.put(EContent.email_pwdreset, "找回密码");
		map.put(EContent.email_validate, "验证邮箱");
	}
	
	private final String value;
	
	private EContent(String v) {
		this.value = v;
	}
	
	public String toString() {
		return this.value;
	}

	public static EContent get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	private static EContent get(String str) {
		for (EContent e : values()) {
			if(e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}

	public static String getName(EContent e) {
		return map.get(e);
	}
}

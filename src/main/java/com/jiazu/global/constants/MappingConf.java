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
 * Create at: 2012-8-28 上午7:39:50
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Architect.bian
 *
 */
@Component
public final class MappingConf extends BaseConstant {
	public static final Object USER_INTERCEPTOR_URL = "userinterceptorurl";
	public static final Object USER_LOGOUT_URL = "userlogouturl";
	private static final Object ADMIN_INTERCEPTOR_URL = "adminurls";
	public static Properties mappingProps;
	private static String[] loginNeedUrls = new String[]{};
	private static String[] adminUrls = new String[]{};
	
	@Value("#{mapping}")
	public void setMapping(Properties mapping) {
		MappingConf.mappingProps = mapping;
	}

	/**
	 * @return
	 */
	public static String[] getNeedLoginUrls() {
		if (loginNeedUrls.length == 0) {
			loginNeedUrls = MappingConf.mappingProps.get(MappingConf.USER_INTERCEPTOR_URL).toString().split(",");
		}
		return loginNeedUrls;
	}

	/**
	 * @return
	 */
	public static String[] getAdminUrls() {
		if (adminUrls.length == 0) {
			adminUrls = MappingConf.mappingProps.get(MappingConf.ADMIN_INTERCEPTOR_URL).toString().split(",");
		}
		return adminUrls;
	}
}

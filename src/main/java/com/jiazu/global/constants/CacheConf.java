/**
 * Cache的常量类,从cache.properties获取常量值
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
 * Create at: 2012-8-12 下午1:24:44
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
public final class CacheConf extends BaseConstant {

	public static String SPLITTER_KEY = ":";
	public static String SPLITTER_PATH = "/";
	public static final String DEFAULT_SERVER = "127.0.0.1:11211";
	public static final String DEFAULT_WEIGHT = "1";
	
	public static Properties cacheProps;
	
	@Value("#{cache}")
	public void setCacheId(Properties cache) {
		CacheConf.cacheProps = cache;
	}
}

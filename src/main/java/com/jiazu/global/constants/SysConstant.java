/**
 * 定义系统常量
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
 * Create at: 2012-8-4 下午4:58:56
 * ============================================================================
 */
package com.jiazu.global.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Architect.bian
 *
 */
@Component
public final class SysConstant extends BaseConstant {
	public static final String UTF8 = "UTF-8";
//	public static final String UTF16 = "UTF-16";
	public static final String GBK = "GBK";
	
	public static final String BASE = "base";
	public static final String BASECSSKEY = "basecss";
	public static final String BASEIMGKEY = "baseimg";
	public static final String BASEJSKEY = "basejs";
	public static final String SESSION_ID = "sid";
	public static final int SESSION_ID_LEN = 6;
	public static final String defaultNoImg_50_50 = "/imgs/default/noimg50_50.gif";
	public static final String ChinaCode = "000000";
	public static String baseCssRootPath;
	public static String baseImgRootPath;
	public static String baseJsRootPath;
	
	@Value("#{web.basecss}")
	public void setCssRootPath(String cssRootPath) {
		SysConstant.baseCssRootPath = cssRootPath;
	}

	@Value("#{web.baseimg}")
	public void setImgRootPath(String imgRootPath) {
		SysConstant.baseImgRootPath = imgRootPath;
	}

	@Value("#{web.basejs}")
	public void setJsRootPath(String jsRootPath) {
		SysConstant.baseJsRootPath = jsRootPath;
	}
}

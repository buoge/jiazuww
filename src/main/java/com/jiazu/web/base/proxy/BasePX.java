/**
 * 所有PX的基类，注入了ApplicationContext对象
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
 * Create at: 2012-8-11 上午9:25:08
 * ============================================================================
 */
package com.jiazu.web.base.proxy;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author Architect.bian
 *
 */
@Service
public class BasePX {
	protected static ApplicationContext spring;
	
	@Autowired(required=true)
	public void setContent( ApplicationContext content) {
		spring = content;
	}
	
	/**
	 * @param e
	 */
	public static void logException(Logger log, Exception e) {
		String error = StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString();
		log.error(error);
	}
}

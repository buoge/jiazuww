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
 * Create at: 2012-10-6 下午3:19:00
 * ============================================================================
 */
package com.jiazu.core.converters;

import org.springframework.core.convert.converter.Converter;

import com.jiazu.global.constants.EB2C;

/**
 * @author Architect.bian
 *
 */
public class StringToEB2CConverter implements Converter<String, EB2C> {
	
	@Override
	public EB2C convert(String source) {
		String value = source.trim();
		if ("".equals(value)) {
			return null;
		}
		return EB2C.get(Integer.parseInt(source));
	}

}

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

/**
 * @author Architect.bian
 *
 */
public class StringToDoubleConverter implements Converter<String, Double> {
	
	@Override
	public Double convert(String source) {
		String value = source.trim();
		if ("".equals(value)) {
			return null;
		}
		return Double.valueOf(source.replace(",", ""));
	}

}

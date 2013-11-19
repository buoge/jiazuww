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

import com.jiazu.global.constants.EC2C;

/**
 * @author Architect.bian
 *
 */
public class StringToEC2CConverter implements Converter<String, EC2C> {
	
	@Override
	public EC2C convert(String source) {
		String value = source.trim();
		if ("".equals(value)) {
			return null;
		}
		return EC2C.get(Integer.parseInt(source));
	}

}

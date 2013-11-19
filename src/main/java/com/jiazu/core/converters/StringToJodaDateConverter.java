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

import org.joda.time.LocalDate;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Architect.bian
 *
 */
public class StringToJodaDateConverter implements Converter<String, LocalDate> {
	
	@Override
	public LocalDate convert(String source) {
		String value = source.trim();
		if ("".equals(value)) {
			return null;
		}
		try {
			LocalDate date = ISODateTimeFormat.dateParser().parseDateTime(source).toLocalDate();
			return date;
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid joda LocalDate value '" + source + "',inner exception msg:" + e.getMessage());
		}
	}

}

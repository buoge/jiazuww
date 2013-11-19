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
 * Create at: 2012-8-5 下午1:40:02
 * ============================================================================
 */
package com.jiazu.global.utility;

import static org.junit.Assert.*;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Architect.bian
 *
 */
public class DateUtilTest {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void JodaLocalDateTest() {
		LocalDate date = new LocalDate();
		logger.info("-----------print local date:" + date.toString());
	}

	@Test
	public void JodaDateTimeTest() {
		DateTime dateTime = new DateTime();
		logger.info("-----------print date time:" + dateTime.toString(DateUtil.FORMAT_DATETIME_CHINA));
	}
	
	@Test
	public void StrToJodaDateTest() {
		LocalDate date = ISODateTimeFormat.dateParser().parseDateTime("2012-0909").toLocalDate();
		LocalDate expected = new LocalDate(2012, 9, 9);
		assertEquals(date, expected);
		
	}
	
	@Test
	public void testToday() {
		System.out.println(DateUtil.getToday());
		assertTrue(DateUtil.getToday().length() == 6);
	}
}

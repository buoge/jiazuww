/**
 * Java的基本语法测试
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
 * Create at: 2012-8-13 上午7:05:38
 * ============================================================================
 */
package com.jiazu.___.init;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jiazu.global.constants.EC2C;
import com.jiazu.global.utility.NumUtil;
import com.jiazu.global.utility.StrUtil;

/**
 * @author Architect.bian
 * 
 */
public class JavaTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSplitConvert() {
		String strweight = "1 3 5";
		String[] strs = StringUtils.split(strweight);
		int[] weights = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			weights[i] = Integer.parseInt(strs[i]);
		}
		assertArrayEquals(weights, new int[] { 1, 3, 5 });
	}

	@Test
	public void testStringFormat() {
		String str = String.format("/imgs/webimgs/pic%1d.gif", 1);
		assertEquals("/imgs/webimgs/pic1.gif", str);
		String str2 = String.format("{\"id\": \"%1s\",\"text\": \"%2s | %3s\"}", "uid", "name1", "name2");
		assertEquals("{\"id\": \"uid\",\"text\": \"name1 | name2\"}", str2);
		String str3 = String.format("%d_%d_%d_%d", 1, 2, 3, 4);
		assertEquals("1_2_3_4", str3);
	}

	@Test
	public void testArrayList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		assertEquals(new Integer(2), list.get(2));
		list.remove(2);
		list.add(0, -1);
		assertEquals(new Integer(1), list.get(2));
	}

	@Test
	public void testListRemove() {
		List<String> list = new ArrayList<>();
		list.add(null);
		list.add("");
		list.add("ssss");
		list.add(null);
		if (list.contains(null)) {
			Collection<Object> c = new ArrayList<Object>();
			c.add(null);
			c.add("");
			list.removeAll(c);
		}
		assertTrue(list.size() == 1);
	}

	@Test
	public void testEnumToString() {
		EC2C[] arr = new EC2C[3];
		arr[0] = EC2C.buy;
		arr[1] = EC2C.sell;
		arr[2] = EC2C.charity;
		StringBuffer sb = new StringBuffer();
		for (EC2C ec2c : arr) {
			sb.append(ec2c.toString());
			sb.append(",");
		}
		System.out.println(StrUtil.trim(sb.toString(), ","));
	}

	@Test(expected = NumberFormatException.class)
	public void testStringToDouble() {
		Double.valueOf("1,111");
	}

	@Test
	public void testDateTime() {
		DateTime d = new DateTime("2006-01-26T13:30:00-06:00");
		System.out.println(d);
		DateTime datetime = ISODateTimeFormat.dateTimeParser().parseDateTime("2012-11-20T12:35:57");
		assertNotNull(datetime);
	}

	@Test
	public void testCompareDateTime() {
		DateTime dateTime = new DateTime();
		dateTime = dateTime.minusSeconds(10);
		// System.out.println(dateTime);
		 System.out.println(dateTime.minusSeconds(10));
		// System.out.println(dateTime);
		assertTrue(dateTime.plusSeconds(8).isBeforeNow());
		dateTime = dateTime.minusMinutes(1);
		assertTrue(dateTime.plusMinutes(1).isBeforeNow());
		dateTime = dateTime.minusMinutes(10);
		assertTrue(dateTime.plusMinutes(10).isBeforeNow());
		dateTime = dateTime.minusMinutes(30);
		assertTrue(dateTime.plusMinutes(30).isBeforeNow());
		dateTime = dateTime.minusHours(1);
		assertTrue(dateTime.plusHours(1).isBeforeNow());
		dateTime = dateTime.minusHours(2);
		assertTrue(dateTime.plusHours(2).isBeforeNow());
		dateTime = dateTime.minusHours(3);
		assertTrue(dateTime.plusHours(3).isBeforeNow());
		dateTime = dateTime.minusDays(1);
		assertTrue(dateTime.plusDays(1).isBeforeNow());
		dateTime = dateTime.minusWeeks(1);
		assertTrue(dateTime.plusWeeks(1).isBeforeNow());
	}

	@Test
	public void testRegex() {
		Matcher m = Pattern.compile("\\w+").matcher("Evening is full of the linnet's wings");
		while (m.find())
			System.out.println(m.group());
		int i = 0;
		while (m.find(i)) {
			System.out.print(m.group() + " ");
			i++;
		}
		System.out.println();
		Matcher murl = Pattern.compile("/myhome/(.{32})").matcher("http://jiazu.projs.com:8080/jiazu/myhome/86883b04795f38d0a70b1f9004c1f999/sdkjfikd");
		if (murl.find()) {
			System.out.println(murl.group());
			System.out.println(murl.group(1));
		}
		System.out.println(Pattern.matches(".*/myhome/(.{32})\\S*", "http://jiazu.projs.com:8080/jiazu/myhome/86883b04795f38d0a70b1f9004c1f999/klsjdfke"));
	}
	
	@Test
	public void testDouble() {
		double totalprice = 15.1;
		double minusprice = 14.0;
		
		BigDecimal price = NumberUtils.createBigDecimal(String.valueOf(totalprice)).subtract(NumberUtils.createBigDecimal(String.valueOf(minusprice)));
		assertEquals(price.toString(), "1.1");
	}
}

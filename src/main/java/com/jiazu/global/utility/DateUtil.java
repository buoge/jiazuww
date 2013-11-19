/**
 * 日期工具类
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
 * Create at: 2012-8-5 上午9:59:47
 * ============================================================================
 */
package com.jiazu.global.utility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

/**
 * @author Architect.bian
 *
 */
public class DateUtil {
	
	public static final String FORMAT_DATETIME_CHINA = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_DATE_CHINA = "yyyy-MM-dd";
	private static final String FORMAT_DATE_TODAY = "yyMMdd";
	
	 /** 年月日时分秒(无下划线) yyyyMMddHHmmss */
    public static final String FORMAT_DATE_NOWID = "yyyyMMddHHmmss";
    
	/**
	 * 是否是今天。根据System.currentTimeMillis() / 1000 / 60 / 60 / 24计算。
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		long day = date.getTime() / 1000 / 60 / 60 / 24;
		long currentDay = System.currentTimeMillis() / 1000 / 60 / 60 / 24;
		return day == currentDay;
	}

	/**
	 * 
	 * @param date
	 *            判断是否是本周，取出日期，依据日期取出该日所在周所有日期，在依据这些日期是否和本日相等
	 * @return
	 */
	public static boolean isThisWeek(Date date) {
		List<Date> dates = dateToWeek(date);
		Boolean flag = false;
		for (Date d : dates) {
			if (isToday(d)) {
				flag = true;
				break;
			} else {
				continue;
			}
		}
		return flag;
	}

	/**
	 * 
	 * @param date
	 *            判断是否是本月的日期
	 * @return
	 */
	public static boolean isThisMonth(Date date) {
		long year = date.getYear();
		long month = date.getMonth();
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime().getYear() == year
				&& calendar.getTime().getMonth() == month;
	}

	/**
	 * 
	 * @param date
	 *            判断是否是本年的日期
	 * @return
	 */
	public static boolean isThisYear(Date date) {
		long year = date.getYear();
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime().getYear() == year;
	}

	/**
	 * 
	 * @param mdate
	 *            取出改日的一周所有日期
	 * @return
	 */
	public static List<Date> dateToWeek(Date mdate) {
		int day = mdate.getDay();
		Date fdate;
		List<Date> list = new ArrayList<>();
		Long fTime = mdate.getTime() - day * 24 * 3600000;
		for (int i = 0; i < 7; i++) {
			fdate = new Date();
			fdate.setTime(fTime + (i * 24 * 3600000));
			list.add(i, fdate);
		}
		return list;
	}

	public static Double diffTwoDate(Date begin, Date end) {
		return (end.getTime() - begin.getTime()) / 1000 / 60.0;
	}

	public static String parseDate(Date date, String format) {
		SimpleDateFormat formater = new SimpleDateFormat(format);
		return formater.format(date);
	}

	public static Date afterDate(Date date, Integer after) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + after);
		return calendar.getTime();
	}

	/**
	 * @return
	 */
	public static DateTime NowTime() {
		return new DateTime();
	}
	
	public static long Now() {
		return NowTime().getMillis();
	}

	/**得到今天:20151016
	 * @return
	 */
	public static String getToday() {
		return parseDate(new Date(), FORMAT_DATE_TODAY);
	}

	/**得到现在2012-10-25 21:57:36
	 * @return
	 */
	public static String getNow() {
		return parseDate(new Date(), FORMAT_DATE_CHINA);
	}
	
	/**得到现在20121025215736
	 * @return
	 */
	public static String getNowForID() {
		return parseDate(new Date(), FORMAT_DATE_NOWID);
	}
}

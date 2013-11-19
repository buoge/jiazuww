/**
 * 字符串类型工具类
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
 * Create at: 2012-8-5 上午10:00:48
 * ============================================================================
 */
package com.jiazu.global.utility;

import java.util.Random;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Architect.bian
 *
 */
public class StrUtil {
	
	private static final String JsonFormat = "{\"response\":\"%s\"}";
	private static char[] randomChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd',
			'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm' };
	/**
	 * 随机获取字符串
	 * 
	 * @param length
	 *            随机字符串长度
	 * 
	 * @return 随机字符串
	 */
	public static String getRandomString(int length) {
		if (length <= 0) {
			return "";
		}
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			stringBuffer.append(randomChar[Math.abs(random.nextInt()) % randomChar.length]);
		}
		return stringBuffer.toString();
	}
	
	/**
	 * splitToIntArray("123  632") = [123, 632]
	 * @param str
	 * @return
	 */
	public static int[] splitToIntArray(String str) {
		String[] arrstr = StringUtils.split(str);
		int[] result = new int[arrstr.length];
		for (int i = 0; i < arrstr.length; i++) {
			result[i] = Integer.parseInt(arrstr[i]); 
		}
		return result;
	}

	/**
	 * 判断str是否匹配regexStrs中任一一个正则
	 * @param str
	 * @param regexStrs
	 * @return
	 */
	public static boolean isMatchAny(String str, String... regexStrs) {
		for (String regex : regexStrs) {
			if (Pattern.matches(regex, str)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param file
	 * @param string
	 * @return
	 */
	public static String trim(String str, String remove) {
		return StringUtils.removeEnd(StringUtils.removeStart(str, remove), remove);
	}

	/**
	 * @param s
	 * @return
	 */
	public static boolean isNumeric(CharSequence cs) {
		if (cs == null || cs.length() == 0) {
            return false;
        }
        int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(cs.charAt(i)) == false) {
            	if (i != 0 || cs.charAt(i) != '-') {
            		return false;
				}
            }
        }
        return true;
	}

	/**
	 * @param string
	 * @return
	 */
	public static String toJson(String str) {
		return String.format(JsonFormat, str);
	}

	/**
	 * @param address
	 * @return
	 */
	public static String toJson(Object obj) {
		return String.format(JsonFormat, obj.toString());
	}

	/**
	 * @param text
	 * @param contains
	 * @return
	 */
	public static boolean isContainAny(String text, String... contains) {
		for (String str : contains) {
			if (text.contains(str)) {
				return true;
			}
		}
		return false;
	}

}

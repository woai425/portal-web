package com.h3c.framework.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.h3c.framework.core.annotation.NotProguard;

/**
 * *********************************************************************
 * 字符串内容识别辅助类
 * RecognitionUtil.java
 *
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2016年3月9日 下午3:31:45
 * @revision    $Id:  *
 **********************************************************************
 */
@NotProguard
public class RecognitionUtil {
	
	private RecognitionUtil(){}
	
	/**
	 * 检测是否存在有中文字符
	 * @param str 待检测的字符串
	 * @return 如果检测含有一个或多个中文字符,则返回true,否则,返回false
	 */
	public static boolean containsChinese(String str) {
		// 对每一个字符进行检测
		for (int i = 0; i < str.length(); i++) {
			// 如果字符在此区间，则认为含有中文字符，返回true
			if (str.substring(i, i + 1).matches("[\\u4e00-\\u9fa5]+"))
				return true;
		}
		return false;
	}
	
	/**
	 * 检测是否属于邮箱
	 * @param str 待检测的字符串
	 * @return 如果检测符合邮箱格式,则返回true,否则,返回false
	 */
	public static boolean checkEmail(String str) {
		boolean flag = false;
		try {
			String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(str);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * 检测是否含有@符号
	 * @param str 待检测的字符串
	 * @return 如果检测符合邮箱格式,则返回true,否则,返回false
	 */
	public static boolean containsEmailSymbol(String str) {
		return str.indexOf("@")!=-1;
	}

}

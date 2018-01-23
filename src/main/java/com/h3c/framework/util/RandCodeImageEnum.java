package com.h3c.framework.util;

import java.util.Random;

import com.h3c.framework.core.annotation.NotProguard;

/**
 * *********************************************************************
 * 验证码辅助类
 * RandCodeImageEnum.java
 *
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2016年3月8日 上午9:16:14
 * @revision    $Id:  *
 **********************************************************************
 */
@NotProguard
public enum RandCodeImageEnum {
	/**
	 * 混合字符串
	 */
	ALL_CHAR("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"),
	
	/**
	 * 混合字符串
	 */
	ALL_CHAR_LETTER("0123456789abcdefghijklmnopqrstuvwxyz"),
	
	/**
	 * 字符
	 */
	LETTER_CHAR("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"),
	/**
	 * 小写字母
	 */
	LOWER_CHAR("abcdefghijklmnopqrstuvwxyz"),
	/**
	 * 数字
	 */
	NUMBER_CHAR("0123456789"),
	/**
	 * 大写字符
	 */
	UPPER_CHAR("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	

	
	/**
	 * 待生成的字符串
	 */
	private String charStr;

	/**
	 * @param charStr
	 */
	private RandCodeImageEnum(final String charStr) {
		this.charStr = charStr;
	}

	/**
	 * 生产随机验证码
	 * @param codeLength 验证码的长度
	 * @return 验证码
	 */
	public String generateStr(final int codeLength) {
		final StringBuffer sb = new StringBuffer();
		final Random random = new Random();
		final String sourseStr = getCharStr();

		for (int i = 0; i < codeLength; i++) {
			sb.append(sourseStr.charAt(random.nextInt(sourseStr.length())));
		}

		return sb.toString();
	}

	/**
	 * @return the {@link #charStr}
	 */
	public String getCharStr() {
		return charStr;
	}
}

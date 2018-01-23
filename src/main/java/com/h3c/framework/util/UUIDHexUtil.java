package com.h3c.framework.util;

import java.util.UUID;

import com.h3c.framework.core.annotation.NotProguard;

/**
 * 模拟hibernate uuid.hex生成序列号
 * 
 * @author 周兆巍
 * @version 创建时间：2015年1月5日 下午4:28:32
 */
@NotProguard
public class UUIDHexUtil {
	@Deprecated
	public static String generate32bit() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	@Deprecated
	public static String generate36bit() {
		return UUID.randomUUID().toString();
	}
	/**
	 * 生成32个16进制uuid数-例如:001528c2a9aa480a90145868e5d09bd2
	 * 
	 * @since 2017年6月20日14时28分
	 * @author wfw2505
	 * @return
	 */
	public static String generate32HexNumber() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 生成36个16进制uuid数-例如:092d47df-fd92-46d0-b6f6-6201ffb5e4e2
	 * 
	 * @since 2017年6月20日14时28分
	 * @author wfw2505
	 * @return
	 */
	public static String generate36HexNumber() {
		return UUID.randomUUID().toString();
	}

}

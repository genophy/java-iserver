package com.eno.simple.iserver.web.tool.core;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException; 
/**
 * 通用类
 * 
 * @author duan.george.genophy.namphy
 *
 */
public class Util {

	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}

	public static boolean isBlank(String str) {
		if (null == str || "".equals(str)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param str
	 * @param regParams
	 *            if regParams contain the str's blank condition,return false
	 * @return
	 */
	public static boolean isNotBlank(String str, String... regParams) {
		return !isBlank(str, regParams);
	}

	/**
	 * 
	 * @param str
	 * @param regParams
	 *            if regParams contain the str's blank condition,return true
	 * @return
	 */
	public static boolean isBlank(String str, String... regParams) {
		if (!isBlank(str)) {
			for (String regParam : regParams) {
				if (regParam.equals(str)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 字符串首字母小写
	 * 
	 * @param str
	 * @return
	 */
	public static String parseStrToLowHead(String str) {
		return new StringBuffer()
				.append(String.valueOf(str.charAt(0)).toLowerCase())
				.append(str.substring(1, str.length())).toString();
	}
	
	
	/**
	 * 关闭流
	 * @param closes
	 */
	public static void closeStream(Closeable... closes) {

		for (Closeable c : closes) {
			if (null != c) {
				try {
					if (c instanceof Flushable) {
						((Flushable) c).flush();
					}
					c.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
 
}

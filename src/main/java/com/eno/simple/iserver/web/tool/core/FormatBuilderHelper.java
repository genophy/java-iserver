/**
 * JsonHelper.java
 *
 *  Created on: Sep 25, 2014 11:00:59 PM
 *      Author: duan.george.genophy.namphy
 * 
 */
package com.eno.simple.iserver.web.tool.core;

import java.util.Map;
import java.util.Map.Entry;

/**
 * json帮助类
 * 
 * @author duan.george.genophy.namphy
 *
 */
public class FormatBuilderHelper {
	/**
	 * 将XMLproperity构建成字符串 xxx="xxx" xxxx="xxxx"
	 * 
	 * @param map
	 * @return
	 */
	public static String buildXMLPropertiesKV(Map<String, String> map) {
		if (null == map || 0 == map.size()) {
			return "";
		}

		StringBuffer sbf = new StringBuffer();
		sbf.append(" ");
		for (Entry<String, String> entry : map.entrySet()) {
			sbf.append(entry.getKey()).append("=\"").append(entry.getValue())
					.append("\"").append(" ");
		}
		return sbf.toString();
	}

	public static String buildJSONPropertieeKV(Map<String, String> map) {
		if (null == map || 0 == map.size()) {
			return "";
		}

		StringBuffer sbf = new StringBuffer();

		sbf.append("{");
		for (Entry<String, String> entry : map.entrySet()) {
			sbf.append("\"").append(entry.getKey()).append("\"").append(":");
			if (entry.getValue().trim().startsWith("[")
					|| entry.getValue().trim().startsWith("{")) {
				sbf.append(entry.getValue());
			} else {
				sbf.append("\"").append(entry.getValue()).append("\"");
			}
		}
		sbf.append("}");
		return sbf.toString();
	}
}

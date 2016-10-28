/**
 * CoreService.java
 *
 *  Created on: Sep 25, 2014 1:18:03 AM
 *      Author: duan.george.genophy.namphy
 * 
 */
package com.eno.simple.iserver.web.tool.anno;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import com.eno.simple.iserver.web.tool.core.Constants;

/**
 * 核心服务程序。所有返回字符的服务，都经过这
 * 
 * @author duan.george.genophy.namphy
 *
 */
public class CoreService {

	/**
	 * 执行并且返回Json格式的字符串
	 * 
	 * @param paramters
	 * @return
	 * @throws Exception
	 */
	public static String executeAndReturnJsonString(ServletContext servletContext,Map<String, String> paramters)
			throws Exception {

		String beanName = paramters.get(Constants.ANNO_BEAN);
		//解析出pkgList
 		List<String> pkgList = null;
		if(AnnoServiceConfigParser.init(servletContext)){
			pkgList = AnnoServiceConfigParser.getPkgList();
		}
		
		String clazzName = ServiceBeanFactory.getClazzName(pkgList, beanName);
		return ServiceBeanFactory.execute(clazzName, paramters);
	}
 
}

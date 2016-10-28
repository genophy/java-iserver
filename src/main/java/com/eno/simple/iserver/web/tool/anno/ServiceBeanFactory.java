/**
 * ServiceTool.java
 *
 *  Created on: Sep 26, 2014 2:03:56 AM
 *      Author: duan.george.genophy.namphy
 * 
 */
package com.eno.simple.iserver.web.tool.anno;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eno.simple.iserver.web.module.anno.ServiceBean;
import com.eno.simple.iserver.web.tool.core.Constants;
import com.eno.simple.iserver.web.tool.core.Util;
import com.google.gson.Gson;

/**
 * @author duan.george.genophy.namphy
 *
 */
public class ServiceBeanFactory {

	private static List<Class<?>> clazzes = null;
	/**
	 * map 中存放 xxx.xxx.x.xx.xx.Xxxx
	 */
	private static Map<String, String> clazzNameMap = null;

	/**
	 * 初始化
	 * 
	 * @param path
	 * @param pkg
	 */
	private static void init(String rootPath, List<String> pkgList) {
		if (null == clazzes) {
			clazzes = AnnoUtil.getAllAnnoClazzes(rootPath, pkgList, ServiceBean.class);
			clazzNameMap = new HashMap<String, String>();
			// 初始化clazzNameMap
			initClazzNameMap();

		}
	}

	/**
	 * 初始化clazzNameMap
	 */
	private static void initClazzNameMap() {
		for (Class<?> clazz : clazzes) {
			clazzNameMap.put(Util.isBlank(clazz.getAnnotation(ServiceBean.class).name())
					? Util.parseStrToLowHead(clazz.getSimpleName())
					: Util.parseStrToLowHead(clazz.getAnnotation(ServiceBean.class).name()), clazz.getName());
		}
	}

	/**
	 * 获取制定的类名
	 * 
	 * @param path
	 *            src根路径
	 * @param pkg
	 *            基础包
	 * @param beanName
	 *            类名
	 * @return
	 */
	public static String getClazzName(String path, List<String> pkg, String beanName) {
		init(path, pkg);
		return clazzNameMap.get(beanName);
	}

	/**
	 * 获取制定的类名(默认根路径为web获取方式)
	 * 
	 * @param pkg
	 *            基础包
	 * @param beanName
	 *            类名
	 * @return
	 */
	public static String getClazzName(List<String> pkg, String beanName) {
		String path = AnnoUtil.global_src_root_path;
		return getClazzName(path, pkg, beanName);
	}

	/**
	 * 执行service的execute方法
	 * 
	 * @param clazzName
	 *            相对类名
	 * @param paramters
	 *            参数
	 * @return 执行的结果
	 * @throws Exception
	 */
	public static String execute(String clazzName, Map<String, String> paramters) throws Exception {
		if (Util.isBlank(clazzName)) {
			return String.format("ANNO is not exists ! about paramter: %s ", Constants.ANNO_BEAN);
		}
		Class<?> c = Class.forName(clazzName);
		Object oc = c.newInstance();
		Method m = c.getDeclaredMethod("execute", new Class[] { Map.class });
		Object obj = m.invoke(oc, paramters);
		// if ("xml".equals(type)) {
		// return parseObjToXMLObject(obj);
		// } else {
		return new Gson().toJson(obj);
		// }
	}
}

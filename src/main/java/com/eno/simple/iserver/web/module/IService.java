package com.eno.simple.iserver.web.module;

import java.util.Map;

/**
 * 
 * @author duan.george.genophy.namphy 5:37:04 PM
 *
 */
public interface IService {

	/**
	 * @param BeanName
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	Object execute(Map<String, String> params) throws Exception;
}

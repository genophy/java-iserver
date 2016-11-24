package com.eno.service;

import java.util.Map;

import com.eno.simple.iserver.web.module.IService;
import com.eno.simple.iserver.web.module.anno.ServiceBean;

@ServiceBean
public class GetData implements IService {

	@Override
	public Object execute(Map<String, String> params) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(params);
		return params;
	}

}

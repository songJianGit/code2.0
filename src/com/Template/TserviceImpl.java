package com.Template;


import com.utils.xxUtils;


public class TserviceImpl {

	public String outServiceImpl(){
		return xxUtils.getTemplate("./doc/","TserviceImpl.java");
	}

}

package com.Template;

import com.utils.xxUtils;

public class Tservice {

	public String outService(){
		return xxUtils.getTemplate("./doc/","Tservice.java");
	}

}

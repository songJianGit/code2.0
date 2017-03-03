package com.Template;

import com.utils.xxUtils;

public class Tcontroller {

	public String outController(){
		return xxUtils.getTemplate("./doc/","Tcontroller.java");
	}

}

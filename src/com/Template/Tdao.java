package com.Template;


import com.utils.xxUtils;

public class Tdao {

	public String outDao(){
		return xxUtils.getTemplate("./doc/","Tdao.java");
	}
}

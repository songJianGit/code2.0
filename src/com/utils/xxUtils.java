package com.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.entity.ConfigBean;

/**
 * @creator     songJian
 * @version 2016-9-2
 * @category 自己封装的一些工具
 * */
public class xxUtils {
	/**
	 * 将首字母大写
	 * @param 
	 * @return String
	 * 
	 * */
	public static String changFirstMax(String str){
		if (str.length()>0) {
			str=str.substring(0,1).toUpperCase()+str.substring(1);
		}
		return str;
		
//		byte[] items = str.getBytes();  
//	    items[0] = (byte) ((char) items[0] - 'a' + 'A');  
//	    return new String(items);
	}
	/**
	 * 将首字母小写
	 * @param 
	 * @return String
	 * 
	 * */
	public static String changFirstMin(String str){
		if (str.length()>0) {
			str=str.substring(0,1).toLowerCase()+str.substring(1);
		}
		return str;
		
	}
	/**
	 * 列名去掉前缀，并以 '_'下划线 分割开的单词全部变为小写        如c_name_user——>nameUser或C_NAME_USER——>nameUser
	 * @param prefix  前缀(可以为null,表示不去掉前缀)
	 * @param column  列名
	 * @param bool 去掉前缀后，第一个字母是否大写
	 * @return String
	 * */
	public static String getColumnName(String prefix,String column,boolean bool){
		String str="";
		if (prefix!=null && !prefix.equals("_")) {
			column=column.replaceAll(prefix, "");
		}
		String[] c=column.split("_");
		for (int i = 0; i < c.length; i++) {
			str+=changFirstMax(c[i].toLowerCase());
		}
		if (bool) {
			str=changFirstMax(str);
		}else{
			str=changFirstMin(str);
		}
		return str;
	}
	/**
	 * @param path 文件路径
	 * @param name 文件名
	 * @author String 替换后
	 * */
	public static String getTemplate(String path,String name){
		String str ="";
		StringBuilder en=new StringBuilder();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path,name)),"UTF-8"));
			while((str = reader.readLine()) != null) {
				en.append(CacheDataUtils.replaceKeyword(str));
				en.append("\r\n");
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return en.toString();
	}
	/**
	 * 生成文件
	 * @param path      文件生成路径
	 * @param cname     文件名
	 * @param operation 控制台打印信息
	 * @param suffix    文件后缀（类型）
	 * @param OutString 输出的文件字符
	 */
	public static void establish(String path, String cname, String operation, String suffix, String OutString) {
		try {
			File file = new File(path);
			if (!file.exists() && !file.isDirectory()) {
				System.out.println("创建" + operation + "目录");
				file.mkdirs();
			}
			BufferedWriter bw = new BufferedWriter(
			new OutputStreamWriter(new FileOutputStream(new File(path, cname + "." + suffix)),"UTF-8"));
			bw.write(OutString);
			bw.close();
		} catch (Exception e) {
			System.out.println(operation + "创建失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取配置文件信息
	 * @param path    配置文件路径
	 * @return ConfigBean
	 * */
	public static ConfigBean getConfigBean(String path){
		ConfigBean config = new ConfigBean();
		String str ="";
		BufferedReader reader;
		boolean begin=false;
		try {
			reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),"GBK"));
			while((str = reader.readLine()) != null) {
				if(begin)setConfigBean(str,config);
				if (str.indexOf("-")!=-1) {// 识别分割线
					begin=true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return config;
	}
	public static void setConfigBean(String str,ConfigBean config){
		int position1=str.indexOf("(")+1;
		int position2=str.indexOf(")");
		int position3=str.indexOf("[")+1;
		int position4=str.indexOf("]");
		if (position1==-1 || position2==-1 || position3==-1 || position4==-1) {
			return;
		}
		int flag=Integer.parseInt(str.substring(position1, position2).replaceAll(" ",""));
		String value=str.substring(position3, position4).replaceAll(" ","");
		switch (flag) {
		case 1:
			config.setDateIp(value);
			break;
		case 2:
			config.setDatePort(value);
			break;
		case 3:
			config.setDateName(value);
			break;
		case 4:
			config.setDatetable(value);
			break;
		case 5:
			config.setUserName(value);
			break;
		case 6:
			config.setUserPass(value);
			break;
		case 7:
			config.setCompanyName(value);
			break;
		case 8:
			config.setBusinessName(value);
			break;
		case 9:
			config.setControllerSuffix(value);
			break;
		case 10:
			config.setEntitySuffix(value);
			break;
		case 11:
			config.setDtoSuffix(value);
			break;
		case 12:
			config.setFormSuffix(value);
			break;
		case 13:
			config.setDaoSuffix(value);
			break;
		case 14:
			config.setDaoImplSuffix(value);
			break;
		case 15:
			config.setServiceSuffix(value);
			break;
		case 16:
			config.setServiceImplSuffix(value);
			break;
		case 17:
			config.setMapperSuffix(value);
			break;
		case 18:
			config.setPrefix(value);
			break;
		}
	}
}

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
 * @category �Լ���װ��һЩ����
 * */
public class xxUtils {
	/**
	 * ������ĸ��д
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
	 * ������ĸСд
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
	 * ����ȥ��ǰ׺������ '_'�»��� �ָ�ĵ���ȫ����ΪСд        ��c_name_user����>nameUser��C_NAME_USER����>nameUser
	 * @param prefix  ǰ׺(����Ϊnull,��ʾ��ȥ��ǰ׺)
	 * @param column  ����
	 * @param bool ȥ��ǰ׺�󣬵�һ����ĸ�Ƿ��д
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
	 * @param path �ļ�·��
	 * @param name �ļ���
	 * @author String �滻��
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
	 * �����ļ�
	 * @param path      �ļ�����·��
	 * @param cname     �ļ���
	 * @param operation ����̨��ӡ��Ϣ
	 * @param suffix    �ļ���׺�����ͣ�
	 * @param OutString ������ļ��ַ�
	 */
	public static void establish(String path, String cname, String operation, String suffix, String OutString) {
		try {
			File file = new File(path);
			if (!file.exists() && !file.isDirectory()) {
				System.out.println("����" + operation + "Ŀ¼");
				file.mkdirs();
			}
			BufferedWriter bw = new BufferedWriter(
			new OutputStreamWriter(new FileOutputStream(new File(path, cname + "." + suffix)),"UTF-8"));
			bw.write(OutString);
			bw.close();
		} catch (Exception e) {
			System.out.println(operation + "����ʧ��");
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ�����ļ���Ϣ
	 * @param path    �����ļ�·��
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
				if (str.indexOf("-")!=-1) {// ʶ��ָ���
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

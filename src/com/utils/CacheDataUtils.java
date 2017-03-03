package com.utils;

import java.util.ArrayList;
import java.util.List;

import com.entity.ColumnEntity;

/**
 * @creator  songJian
 * @version 2016-9-2
 * @category ����������PathAndNameUtile���ø����������
 * */
public class CacheDataUtils {
	public static List<ColumnEntity> listColumn = new ArrayList<ColumnEntity>();
	
	public static String tableName;
	public static String tableNameMin;// ����ȥ_��
	public static String tableNameMax;// ����-��ͷ��д
	
	public static String controllerClassName;// controller
	public static String entityClassName;// ʵ������(�����׺��)
	public static String dtoClassName;// ��ѯ������
	public static String formClassName;// �ύ������
	public static String serviceClassName;// ҵ��ӿ�����
	public static String serviceImplClassName;// ҵ��ʵ������
	public static String daoClassName;// dao����
	public static String daoImplClassName;// daoImpl����
	public static String mapperClassName;// ҵ��ʵ������
	// ������������ͷСд��
	public static String controllerClassNameMin;
	public static String entityClassNameMin;
	public static String dtoClassNameMin;
	public static String formClassNameMin;
	public static String serviceClassNameMin;
	public static String serviceImplClassNameMin;
	public static String daoClassNameMin;
	public static String daoImplClassNameMin;
	public static String mapperClassNameMin;
	// Package·��
	public static String controllerPackage;
	public static String entityPackage;
	public static String dtoPackage;
	public static String formPackage;
	public static String servicePackage;
	public static String serviceImplPackage;
	public static String daoPackage;
	
	// ��������(����������������getPrimaryKeys����ֻ�᷵�ص�һ��������Ϣ���������������Ȼ�Ǽ��ϣ����Ǵ���������size=1)
	public static List<String> keyList=new ArrayList<String>();
	
	public static void updateName(String name){
		tableName=name;
		tableNameMin=xxUtils.getColumnName(null, name, false);
		tableNameMax=xxUtils.changFirstMax(tableNameMin);
		controllerClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.controllerSuffix);// controller����
		entityClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.entitySuffix);// ʵ������
		dtoClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.dtoSuffix);// ��ѯ������
		formClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.formSuffix);// �ύ������
		serviceClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.serviceSuffix);// ҵ��ӿ�����
		serviceImplClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.serviceImplSuffix);// ҵ��ʵ������
		daoClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.daoSuffix);// dao����
		daoImplClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.daoImplSuffix);// daoImpl����
		mapperClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.mapperSuffix);// mybatis.xml������
		
		controllerClassNameMin=xxUtils.changFirstMin(controllerClassName);
		entityClassNameMin=xxUtils.changFirstMin(entityClassName);
		dtoClassNameMin=xxUtils.changFirstMin(dtoClassName);
		formClassNameMin=xxUtils.changFirstMin(formClassName);
		serviceClassNameMin=xxUtils.changFirstMin(serviceClassName);
		serviceImplClassNameMin=xxUtils.changFirstMin(serviceImplClassName);
		daoClassNameMin=xxUtils.changFirstMin(daoClassName);
		daoImplClassNameMin=xxUtils.changFirstMin(daoImplClassName);
		mapperClassNameMin=xxUtils.changFirstMin(mapperClassName);
		
		controllerPackage=PathAndNameUtils.packagePath+"."+entityClassName+PathAndNameUtils.controllerSuffix;
		entityPackage=PathAndNameUtils.packagePath+"."+entityClassName+PathAndNameUtils.entitySuffix;
		dtoPackage=PathAndNameUtils.packagePath+"."+entityClassName+PathAndNameUtils.dtoSuffix;
		formPackage=PathAndNameUtils.packagePath+"."+entityClassName+PathAndNameUtils.formSuffix;
		servicePackage=PathAndNameUtils.packagePath+"."+entityClassName+PathAndNameUtils.serviceSuffix;
		serviceImplPackage=PathAndNameUtils.packagePath+"."+entityClassName+PathAndNameUtils.serviceImplSuffix;
		daoPackage=PathAndNameUtils.packagePath+"."+entityClassName+PathAndNameUtils.daoSuffix;
	}
	/**
	 * �滻����
	 * @param str �ַ���
	 * @return String �滻��
	 * 
	 * */
	public static String replaceKeyword(String str){
		if (str==null||str.length()==0) {
			return "";
		}
		
		// �滻����
		str=str.replaceAll("\\$\\{tableNameMin\\}", tableNameMin);
		str=str.replaceAll("\\$\\{tableNameMax\\}", tableNameMax);
		str=str.replaceAll("\\$\\{controllerClassName\\}", controllerClassName);
		str=str.replaceAll("\\$\\{entityClassName\\}", entityClassName);
		str=str.replaceAll("\\$\\{dtoClassName\\}", dtoClassName);
		str=str.replaceAll("\\$\\{formClassName\\}", formClassName);
		str=str.replaceAll("\\$\\{serviceClassName\\}", serviceClassName);
		str=str.replaceAll("\\$\\{serviceImplClassName\\}", serviceImplClassName);
		str=str.replaceAll("\\$\\{daoClassName\\}", daoClassName);
		str=str.replaceAll("\\$\\{daoImplClassName\\}", daoImplClassName);
		str=str.replaceAll("\\$\\{mapperClassName\\}", mapperClassName);
		// �滻��������
		str=str.replaceAll("\\$\\{controllerClassNameMin\\}", controllerClassNameMin);
		str=str.replaceAll("\\$\\{entityClassNameMin\\}", entityClassNameMin);
		str=str.replaceAll("\\$\\{dtoClassNameMin\\}", dtoClassNameMin);
		str=str.replaceAll("\\$\\{formClassNameMin\\}", formClassNameMin);
		str=str.replaceAll("\\$\\{serviceClassNameMin\\}", serviceClassNameMin);
		str=str.replaceAll("\\$\\{serviceImplClassNameMin\\}", serviceImplClassNameMin);
		str=str.replaceAll("\\$\\{daoClassNameMin\\}", daoClassNameMin);
		str=str.replaceAll("\\$\\{daoImplClassNameMin\\}", daoImplClassNameMin);
		str=str.replaceAll("\\$\\{mapperClassNameMin\\}", mapperClassNameMin);
		// �滻package
		str=str.replaceAll("\\$\\{controllerPackage\\}", controllerPackage);
		str=str.replaceAll("\\$\\{entityPackage\\}", entityPackage);
		str=str.replaceAll("\\$\\{dtoPackage\\}", dtoPackage);
		str=str.replaceAll("\\$\\{formPackage\\}", formPackage);
		str=str.replaceAll("\\$\\{servicePackage\\}", servicePackage);
		str=str.replaceAll("\\$\\{serviceImplPackage\\}", serviceImplPackage);
		str=str.replaceAll("\\$\\{daoPackage\\}", daoPackage);
		return str;
	}
}

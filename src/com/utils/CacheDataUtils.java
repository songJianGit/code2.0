package com.utils;

import java.util.ArrayList;
import java.util.List;

import com.entity.ColumnEntity;

/**
 * @creator  songJian
 * @version 2016-9-2
 * @category 根据配置类PathAndNameUtile设置各个类的名字
 * */
public class CacheDataUtils {
	public static List<ColumnEntity> listColumn = new ArrayList<ColumnEntity>();
	
	public static String tableName;
	public static String tableNameMin;// 表名去_后
	public static String tableNameMax;// 表名-开头大写
	
	public static String controllerClassName;// controller
	public static String entityClassName;// 实体类名(添加了缀的)
	public static String dtoClassName;// 查询集类名
	public static String formClassName;// 提交集类名
	public static String serviceClassName;// 业务接口类名
	public static String serviceImplClassName;// 业务实现类名
	public static String daoClassName;// dao类名
	public static String daoImplClassName;// daoImpl类名
	public static String mapperClassName;// 业务实现类名
	// 类名变量（开头小写）
	public static String controllerClassNameMin;
	public static String entityClassNameMin;
	public static String dtoClassNameMin;
	public static String formClassNameMin;
	public static String serviceClassNameMin;
	public static String serviceImplClassNameMin;
	public static String daoClassNameMin;
	public static String daoImplClassNameMin;
	public static String mapperClassNameMin;
	// Package路径
	public static String controllerPackage;
	public static String entityPackage;
	public static String dtoPackage;
	public static String formPackage;
	public static String servicePackage;
	public static String serviceImplPackage;
	public static String daoPackage;
	
	// 主键集合(就算有联合主键，getPrimaryKeys还是只会返回第一列数据信息，所以这个变量虽然是集合，但是大多数情况下size=1)
	public static List<String> keyList=new ArrayList<String>();
	
	public static void updateName(String name){
		tableName=name;
		tableNameMin=xxUtils.getColumnName(null, name, false);
		tableNameMax=xxUtils.changFirstMax(tableNameMin);
		controllerClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.controllerSuffix);// controller类名
		entityClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.entitySuffix);// 实体类名
		dtoClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.dtoSuffix);// 查询集类名
		formClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.formSuffix);// 提交集类名
		serviceClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.serviceSuffix);// 业务接口类名
		serviceImplClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.serviceImplSuffix);// 业务实现类名
		daoClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.daoSuffix);// dao类名
		daoImplClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.daoImplSuffix);// daoImpl类名
		mapperClassName=tableNameMax+xxUtils.changFirstMax(PathAndNameUtils.mapperSuffix);// mybatis.xml的类名
		
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
	 * 替换配置
	 * @param str 字符串
	 * @return String 替换后
	 * 
	 * */
	public static String replaceKeyword(String str){
		if (str==null||str.length()==0) {
			return "";
		}
		
		// 替换类名
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
		// 替换类名变量
		str=str.replaceAll("\\$\\{controllerClassNameMin\\}", controllerClassNameMin);
		str=str.replaceAll("\\$\\{entityClassNameMin\\}", entityClassNameMin);
		str=str.replaceAll("\\$\\{dtoClassNameMin\\}", dtoClassNameMin);
		str=str.replaceAll("\\$\\{formClassNameMin\\}", formClassNameMin);
		str=str.replaceAll("\\$\\{serviceClassNameMin\\}", serviceClassNameMin);
		str=str.replaceAll("\\$\\{serviceImplClassNameMin\\}", serviceImplClassNameMin);
		str=str.replaceAll("\\$\\{daoClassNameMin\\}", daoClassNameMin);
		str=str.replaceAll("\\$\\{daoImplClassNameMin\\}", daoImplClassNameMin);
		str=str.replaceAll("\\$\\{mapperClassNameMin\\}", mapperClassNameMin);
		// 替换package
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

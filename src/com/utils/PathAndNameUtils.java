package com.utils;

import com.entity.ConfigBean;

/**
 * @creator     songJian
 * @version 2016-9-2
 * @category 存储配置文件内容
 * */
public class PathAndNameUtils {
	public static String prefix="C_";// 数据库字段前缀
	
	public static String path=".\\codeFile";// 生成路径
	
	public static String companyName="mstf";
	public static String businessName="work";
	public static String prefixPath="\\com\\"+companyName+"\\"+businessName;// 包路径+公司名
	public static String packagePath=prefixPath.replaceAll("\\\\", ".").substring(1);// package
	
	public static final String controllerPath=path+prefixPath+"\\controller";// controller
	public static String controllerSuffix="controller";// 文件名后缀（文件名=实体名+后缀）
	
	public static final String entityPath=path+prefixPath+"\\entity";// 实体
	public static String entitySuffix="";// 文件名后缀（文件名=实体名+后缀）
	
	public static final String dtoPath=path+prefixPath+"\\dto";// 查询集
	public static String dtoSuffix="condition";// 文件名后缀（文件名=实体名+后缀）
	
	public static final String formPath=path+prefixPath+"\\form";// 提交集
	public static String formSuffix="form";// 文件名后缀（文件名=实体名+后缀）
	
	public static final String daoPath=path+prefixPath+"\\dao";// 数据
	public static String daoSuffix="dao";// 文件名后缀（文件名=实体名+后缀）
	
	public static final String daoImplPath=path+prefixPath+"\\dao\\impl";// 数据
	public static String daoImplSuffix="daoImpl";// 文件名后缀（文件名=实体名+后缀）
	
	public static final String servicePath=path+prefixPath+"\\service";// 业务接口
	public static String serviceSuffix="service";// 文件名后缀（文件名=实体名+后缀）
	
	public static final String serviceImplPath=path+prefixPath+"\\service\\impl";// 业务实现类
	public static String serviceImplSuffix="serviceImpl";// 文件名后缀（文件名=实体名+后缀）
	
	public static final String mapperPath=path+prefixPath+"\\mapper";// mybatis xml
	public static String mapperSuffix="mapper";// 文件名后缀（文件名=实体名+后缀）
	/**
	 * 赋值配置信息
	 * */
	public static void setName(ConfigBean configBean){
		prefix=configBean.getPrefix();
		companyName=configBean.getCompanyName();
		businessName=configBean.getBusinessName();
		controllerSuffix = configBean.getControllerSuffix();
	    entitySuffix = configBean.getEntitySuffix();
	    dtoSuffix = configBean.getDtoSuffix();
	    formSuffix = configBean.getFormSuffix();
	    daoSuffix = configBean.getDaoSuffix();
	    daoImplSuffix = configBean.getDaoImplSuffix();
	    serviceSuffix = configBean.getServiceSuffix();
	    serviceImplSuffix = configBean.getServiceImplSuffix();
	    mapperSuffix = configBean.getMapperSuffix();
	}
}

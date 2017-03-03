package com.utils;

import com.entity.ConfigBean;

/**
 * @creator     songJian
 * @version 2016-9-2
 * @category �洢�����ļ�����
 * */
public class PathAndNameUtils {
	public static String prefix="C_";// ���ݿ��ֶ�ǰ׺
	
	public static String path=".\\codeFile";// ����·��
	
	public static String companyName="mstf";
	public static String businessName="work";
	public static String prefixPath="\\com\\"+companyName+"\\"+businessName;// ��·��+��˾��
	public static String packagePath=prefixPath.replaceAll("\\\\", ".").substring(1);// package
	
	public static final String controllerPath=path+prefixPath+"\\controller";// controller
	public static String controllerSuffix="controller";// �ļ�����׺���ļ���=ʵ����+��׺��
	
	public static final String entityPath=path+prefixPath+"\\entity";// ʵ��
	public static String entitySuffix="";// �ļ�����׺���ļ���=ʵ����+��׺��
	
	public static final String dtoPath=path+prefixPath+"\\dto";// ��ѯ��
	public static String dtoSuffix="condition";// �ļ�����׺���ļ���=ʵ����+��׺��
	
	public static final String formPath=path+prefixPath+"\\form";// �ύ��
	public static String formSuffix="form";// �ļ�����׺���ļ���=ʵ����+��׺��
	
	public static final String daoPath=path+prefixPath+"\\dao";// ����
	public static String daoSuffix="dao";// �ļ�����׺���ļ���=ʵ����+��׺��
	
	public static final String daoImplPath=path+prefixPath+"\\dao\\impl";// ����
	public static String daoImplSuffix="daoImpl";// �ļ�����׺���ļ���=ʵ����+��׺��
	
	public static final String servicePath=path+prefixPath+"\\service";// ҵ��ӿ�
	public static String serviceSuffix="service";// �ļ�����׺���ļ���=ʵ����+��׺��
	
	public static final String serviceImplPath=path+prefixPath+"\\service\\impl";// ҵ��ʵ����
	public static String serviceImplSuffix="serviceImpl";// �ļ�����׺���ļ���=ʵ����+��׺��
	
	public static final String mapperPath=path+prefixPath+"\\mapper";// mybatis xml
	public static String mapperSuffix="mapper";// �ļ�����׺���ļ���=ʵ����+��׺��
	/**
	 * ��ֵ������Ϣ
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

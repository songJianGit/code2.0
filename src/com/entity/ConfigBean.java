package com.entity;
/**
 * @creator    songJian
 * @version   2017-2-26
 * @category  配置文件对象
 *
 * */
public class ConfigBean {
	
	/**数据库前缀*/
	private String prefix;
	/**数据库IP*/
	private String dateIp;
	/**数据库端口*/
	private String datePort;
	/**数据库名字*/
	private String dateName;
	/**数据库表名字*/
	private String datetable;
	/**用户名*/
	private String userName;
	/**用户密码*/
	private String userPass;
	
	/**公司名*/
	private String companyName;
	/**业务包名*/
	private String businessName;
	
	/**控制器controller后缀*/
	private String controllerSuffix;
	/**实体entity后缀*/
	private String entitySuffix;
	/**查询集dto后缀*/
	private String dtoSuffix;
	/**提交集form后缀*/
	private String formSuffix;
	/**dao层接口后缀*/
	private String daoSuffix;
	/**daoImpl后缀*/
	private String daoImplSuffix;
	/**业务层接口后缀*/
	private String serviceSuffix;
	/**业务层实现类后缀*/
	private String serviceImplSuffix;
	/**mybatis的xml文件后缀*/
	private String mapperSuffix;
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getDateIp() {
		return dateIp;
	}
	public void setDateIp(String dateIp) {
		this.dateIp = dateIp;
	}
	public String getDatePort() {
		return datePort;
	}
	public void setDatePort(String datePort) {
		this.datePort = datePort;
	}
	public String getDateName() {
		return dateName;
	}
	public void setDateName(String dateName) {
		this.dateName = dateName;
	}
	public String getDatetable() {
		return datetable;
	}
	public void setDatetable(String datetable) {
		this.datetable = datetable;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getControllerSuffix() {
		return controllerSuffix;
	}
	public void setControllerSuffix(String controllerSuffix) {
		this.controllerSuffix = controllerSuffix;
	}
	public String getEntitySuffix() {
		return entitySuffix;
	}
	public void setEntitySuffix(String entitySuffix) {
		this.entitySuffix = entitySuffix;
	}
	public String getDtoSuffix() {
		return dtoSuffix;
	}
	public void setDtoSuffix(String dtoSuffix) {
		this.dtoSuffix = dtoSuffix;
	}
	public String getFormSuffix() {
		return formSuffix;
	}
	public void setFormSuffix(String formSuffix) {
		this.formSuffix = formSuffix;
	}
	public String getDaoSuffix() {
		return daoSuffix;
	}
	public void setDaoSuffix(String daoSuffix) {
		this.daoSuffix = daoSuffix;
	}
	public String getDaoImplSuffix() {
		return daoImplSuffix;
	}
	public void setDaoImplSuffix(String daoImplSuffix) {
		this.daoImplSuffix = daoImplSuffix;
	}
	public String getServiceSuffix() {
		return serviceSuffix;
	}
	public void setServiceSuffix(String serviceSuffix) {
		this.serviceSuffix = serviceSuffix;
	}
	public String getServiceImplSuffix() {
		return serviceImplSuffix;
	}
	public void setServiceImplSuffix(String serviceImplSuffix) {
		this.serviceImplSuffix = serviceImplSuffix;
	}
	public String getMapperSuffix() {
		return mapperSuffix;
	}
	public void setMapperSuffix(String mapperSuffix) {
		this.mapperSuffix = mapperSuffix;
	}
	
	
	
}

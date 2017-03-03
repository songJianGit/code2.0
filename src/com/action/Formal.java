package com.action;

import java.util.List;

import com.Template.Tcontroller;
import com.Template.Tdao;
import com.Template.Tdto;
import com.Template.Tentity;
import com.Template.Tform;
import com.Template.Tmapper;
import com.Template.Tservice;
import com.Template.TserviceImpl;
import com.entity.ColumnEntity;
import com.entity.ConfigBean;
import com.utils.CacheDataUtils;
import com.utils.PathAndNameUtils;
import com.utils.xxUtils;
import com.utils.DateUtils;

/**
 * @creator songJian
 * @version 2016-9-2
 */
public class Formal {
	
	/**配置文件路径*/
	private static String configPath = "./config/configFile.txt";

	public static void main(String[] args) {
		/**
		 * 1.获取配置信息
		 * 2.设置配置信息
		 * 3.连接数据库获取字段信息
		 * 4.生成文件
		 * */
		long a=System.currentTimeMillis();
		// 1
		ConfigBean config=xxUtils.getConfigBean(configPath);
		// 2
		PathAndNameUtils.setName(config);
		String url="jdbc:mysql://"+config.getDateIp()+":"+config.getDatePort()+"/"+config.getDateName()+"?useUnicode=true&amp;characterEncoding=UTF-8";
		// 3
		CacheDataUtils.listColumn = DateUtils.production(url, config.getUserName(), config.getUserPass(), config.getDatetable());// 链接数据库，获取和赋值数据
		List<ColumnEntity> listColumn=CacheDataUtils.listColumn;
		CacheDataUtils.updateName(listColumn.get(0).getTableName());// 赋值各个类的名字
		// 4
		xxUtils.establish(PathAndNameUtils.entityPath, CacheDataUtils.entityClassName, "entity", "java", new Tentity().outEntity());
		xxUtils.establish(PathAndNameUtils.dtoPath, CacheDataUtils.dtoClassName, "dto", "java", new Tdto().outDto());
		xxUtils.establish(PathAndNameUtils.formPath, CacheDataUtils.formClassName, "form", "java", new Tform().outForm());
		xxUtils.establish(PathAndNameUtils.daoPath, CacheDataUtils.daoClassName, "dao", "java", new Tdao().outDao());
		xxUtils.establish(PathAndNameUtils.servicePath, CacheDataUtils.serviceClassName, "service", "java", new Tservice().outService());
		xxUtils.establish(PathAndNameUtils.serviceImplPath, CacheDataUtils.serviceImplClassName, "serviceImpl", "java", new TserviceImpl().outServiceImpl());
		xxUtils.establish(PathAndNameUtils.controllerPath, CacheDataUtils.controllerClassName, "controller", "java", new Tcontroller().outController());
		xxUtils.establish(PathAndNameUtils.mapperPath, CacheDataUtils.mapperClassName, "mapper", "xml", new Tmapper().outMapper());
		System.out.println("文件生成成功！\r\n执行耗时 : "+(System.currentTimeMillis()-a)+" 毫秒 ");
	}

}
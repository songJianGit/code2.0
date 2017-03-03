package com.Template;

import java.util.List;

import com.entity.ColumnEntity;
import com.utils.CacheDataUtils;
import com.utils.PathAndNameUtils;
import com.utils.xxUtils;

/*
 ����֮���ŵĽṹ
����
private String columnName;

�޲ι��췽��
public className(){super();}

����
public String getColumnName() {
	return columnName;
}
public void setColumnName(String olumnName) {
	this.columnName = columnName;
}
*/
public class Tentity {

	public String outEntity(){
		return getTemplate(CacheDataUtils.listColumn);
	}

	private String getTemplate(List<ColumnEntity> listColumn){
		
		String entityClassName=CacheDataUtils.entityClassName;
		String entityPackage=CacheDataUtils.entityPackage;
		
		StringBuilder en=new StringBuilder();
		// ��ʼ�������
		en.append("package "+entityPackage+";\r\n\r\n");// package·��
		en.append("import java.util.Date;\r\n\r\n");// ���
		
		en.append("public class "+entityClassName+" {\r\n");
		
		// ����
		String type="";
		String name="";
		for (int i = 0; i <listColumn.size(); i++) {
			type=listColumn.get(i).getColumnClassName();
			name=xxUtils.getColumnName(PathAndNameUtils.prefix,listColumn.get(i).getColumnName(),false);
			en.append("	private "+type+" "+name+";\r\n");
		}
		
		// �޲ι��췽��
		en.append("	public "+entityClassName+"(){}\r\n");
		
		// ����
		String type1="";
		String name1="";
		String name2="";
		for (int i = 0; i < listColumn.size(); i++) {
			type1=listColumn.get(i).getColumnClassName();
			name1=xxUtils.getColumnName(PathAndNameUtils.prefix,listColumn.get(i).getColumnName(),true);
			name2=xxUtils.getColumnName(PathAndNameUtils.prefix,listColumn.get(i).getColumnName(),false);
			// get
			en.append("	public "+type1+" get"+name1+"() {\r\n");
			en.append("		return "+name2+";\r\n");
			en.append("	}\r\n");
			// set
			en.append("	public void set"+name1+"("+type1+" "+name2+") {\r\n");
			en.append("		this."+name2+"="+name2+";\r\n");
			en.append("	}\r\n");
		}
		en.append("}");
		
		return en.toString();
	}
}

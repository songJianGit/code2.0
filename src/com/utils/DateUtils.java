package com.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.ColumnEntity;
/**
 * @creator     songJian
 * @version 2016-9-2
 * @category 获取表格数据
 * */
public class DateUtils {
	
	
	private static Connection getConnection(String url,String user,String pass) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");// 把自己注册到DriverManager中去（java.sql.DriverManager.registerDriver(new Driver())）
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 
	 * */
	public static List<ColumnEntity> production(String url,String user,String pass,String aTableName) {
		List<ColumnEntity> listcloumnEntity=new ArrayList<ColumnEntity>();
		try {
			Connection conn = getConnection(url,user,pass);
			String sql = "SELECT * FROM " + aTableName+" WHERE 1=2";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData data = rs.getMetaData();
			
			DatabaseMetaData dbMeta =conn.getMetaData(); 
			ResultSet rsm =dbMeta.getPrimaryKeys(null, null, aTableName);  
			while( rsm.next() ) { 
				CacheDataUtils.keyList.add(String.valueOf(rsm.getObject(4)));// 主键集合
			} 
			
			for (int i = 1; i <= data.getColumnCount(); i++) {
				ColumnEntity e=new ColumnEntity();
				// 获得指定列的列名
				e.setColumnName(data.getColumnName(i));
				// 获得指定列的数据类型
				e.setColumnType(data.getColumnType(i));
				// 获得指定列的数据类型名
				e.setColumnTypeName(data.getColumnTypeName(i));
				// 所在的Catalog名字
				e.setCatalogName(data.getCatalogName(i));
				// 对应数据类型的类
				e.setColumnClassName(DataTypeUtils.getJavaType(data.getColumnTypeName(i)));
				// 在数据库中类型的最大字符个数
				e.setColumnDisplaySize(data.getColumnDisplaySize(i));
				// 默认的列的标题
				e.setColumnLabel(data.getColumnLabel(i));
				// 获得列的模式
				e.setSchemaName(data.getSchemaName(i));
				// 某列类型的精确度(类型的长度)
				e.setPrecision(data.getPrecision(i));
				// 小数点后的位数
				e.setScale(data.getScale(i));
				// 获取某列对应的表名
				e.setTableName(data.getTableName(i));
				// 是否自动递增
				e.setAutoInctement(data.isAutoIncrement(i));
				// 在数据库中是否为货币型
				e.setCurrency(data.isCurrency(i));
				// 是否为空
				e.setIsNullable(data.isNullable(i));
				// 是否为只读
				e.setReadOnly(data.isReadOnly(i));
				// 能否出现在where中
				e.setSearchable(data.isSearchable(i));
				listcloumnEntity.add(e);
			}
			rsm.close();
			stmt.cancel();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		return listcloumnEntity;
	}
}

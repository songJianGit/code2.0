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
 * @category ��ȡ�������
 * */
public class DateUtils {
	
	
	private static Connection getConnection(String url,String user,String pass) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");// ���Լ�ע�ᵽDriverManager��ȥ��java.sql.DriverManager.registerDriver(new Driver())��
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
			String sql = "SELECT * FROM " + aTableName+" LIMIT 0,1";// ֻҪһ�о͹���
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData data = rs.getMetaData();
			
			DatabaseMetaData dbMeta =conn.getMetaData(); 
			ResultSet rsm =dbMeta.getPrimaryKeys(null, null, aTableName);  
			while( rsm.next() ) { 
				CacheDataUtils.keyList.add(String.valueOf(rsm.getObject(4)));// ��������
			} 
			
			for (int i = 1; i <= data.getColumnCount(); i++) {
				ColumnEntity e=new ColumnEntity();
				// ���ָ���е�����
				e.setColumnName(data.getColumnName(i));
				// ���ָ���е���������
				e.setColumnType(data.getColumnType(i));
				// ���ָ���е�����������
				e.setColumnTypeName(data.getColumnTypeName(i));
				// ���ڵ�Catalog����
				e.setCatalogName(data.getCatalogName(i));
				// ��Ӧ�������͵���
				e.setColumnClassName(DataTypeUtils.getJavaType(data.getColumnTypeName(i)));
				// �����ݿ������͵�����ַ�����
				e.setColumnDisplaySize(data.getColumnDisplaySize(i));
				// Ĭ�ϵ��еı���
				e.setColumnLabel(data.getColumnLabel(i));
				// ����е�ģʽ
				e.setSchemaName(data.getSchemaName(i));
				// ĳ�����͵ľ�ȷ��(���͵ĳ���)
				e.setPrecision(data.getPrecision(i));
				// С������λ��
				e.setScale(data.getScale(i));
				// ��ȡĳ�ж�Ӧ�ı���
				e.setTableName(data.getTableName(i));
				// �Ƿ��Զ�����
				e.setAutoInctement(data.isAutoIncrement(i));
				// �����ݿ����Ƿ�Ϊ������
				e.setCurrency(data.isCurrency(i));
				// �Ƿ�Ϊ��
				e.setIsNullable(data.isNullable(i));
				// �Ƿ�Ϊֻ��
				e.setReadOnly(data.isReadOnly(i));
				// �ܷ������where��
				e.setSearchable(data.isSearchable(i));
				listcloumnEntity.add(e);
			}
			stmt.cancel();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ��");
			e.printStackTrace();
		}
		return listcloumnEntity;
	}
}

package test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 * @creator     songJian
 * ����
 * */
public class TestDemo {
	private static String datebase="";// ���ݿ���
	private static String tablename="";// ����
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");// ���Լ�ע�ᵽDriverManager��ȥ��java.sql.DriverManager.registerDriver(new Driver())��
			String url = "jdbc:mysql://localhost:3306/"+datebase;
			String user = "root";// �û���
			String pass = "root";// ����
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		Connection conn = getConnection();
		String sql = "select * from "+tablename;
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData data = rs.getMetaData();
			
			DatabaseMetaData dbMeta =conn.getMetaData(); 
			ResultSet rsm =dbMeta.getPrimaryKeys(null, null, tablename);  
			while( rsm.next() ) { 
				System.out.println("****** Comment ******"); 
				System.out.println("TABLE_CAT : "+rsm.getObject(1)); 
				System.out.println("TABLE_SCHEM: "+rsm.getObject(2)); 
				System.out.println("TABLE_NAME : "+rsm.getObject(3)); 
				System.out.println("COLUMN_NAME: "+rsm.getObject(4)); 
				System.out.println("KEY_SEQ : "+rsm.getObject(5)); 
				System.out.println("PK_NAME : "+rsm.getObject(6)); 
				System.out.println("****** ******* ******"); 
			} 
			while (rs.next()) {
				for (int i = 1; i <= data.getColumnCount(); i++) {
					// ��������е���Ŀ��ʵ������
					int columnCount = data.getColumnCount();
					// ���ָ���е�����
					String columnName = data.getColumnName(i);
					// ���ָ���е���ֵ
					String columnValue = rs.getString(i);
					// ���ָ���е���������
					int columnType = data.getColumnType(i);
					// ���ָ���е�����������
					String columnTypeName = data.getColumnTypeName(i);
					// ���ڵ�Catalog����
					String catalogName = data.getCatalogName(i);
					// ��Ӧ�������͵���
					String columnClassName = data.getColumnClassName(i);
					// �����ݿ������͵�����ַ�����
					int columnDisplaySize = data.getColumnDisplaySize(i);
					// Ĭ�ϵ��еı���
					String columnLabel = data.getColumnLabel(i);
					// ����е�ģʽ
					String schemaName = data.getSchemaName(i);
					// ĳ�����͵ľ�ȷ��(���͵ĳ���)
					int precision = data.getPrecision(i);
					// С������λ��
					int scale = data.getScale(i);
					// ��ȡĳ�ж�Ӧ�ı���
					String tableName = data.getTableName(i);
					// �Ƿ��Զ�����
					boolean isAutoInctement = data.isAutoIncrement(i);
					// �����ݿ����Ƿ�Ϊ������
					boolean isCurrency = data.isCurrency(i);
					// �Ƿ�Ϊ��
					int isNullable = data.isNullable(i);
					// �Ƿ�Ϊֻ��
					boolean isReadOnly = data.isReadOnly(i);
					// �ܷ������where��
					boolean isSearchable = data.isSearchable(i);
					System.out.println(columnCount);
					System.out.println("�����" + i + "���ֶ�����:" + columnName);
					System.out.println("�����" + i + "���ֶ�ֵ:" + columnValue);
					System.out.println("�����" + i + "������,����SqlType�еı��:" + columnType);
					System.out.println("�����" + i + "������������:" + columnTypeName);
					System.out.println("�����" + i + "���ڵ�Catalog����:" + catalogName);
					System.out.println("�����" + i + "��Ӧ�������͵���:" + columnClassName);
					System.out.println("�����" + i + "�����ݿ������͵�����ַ�����:" + columnDisplaySize);
					System.out.println("�����" + i + "��Ĭ�ϵ��еı���:" + columnLabel);
					System.out.println("�����" + i + "��ģʽ:" + schemaName);
					System.out.println("�����" + i + "���͵ľ�ȷ��(���͵ĳ���):" + precision);
					System.out.println("�����" + i + "С������λ��:" + scale);
					System.out.println("�����" + i + "��Ӧ�ı���:" + tableName);
					System.out.println("�����" + i + "�Ƿ��Զ�����:" + isAutoInctement);
					System.out.println("�����" + i + "�����ݿ����Ƿ�Ϊ������:" + isCurrency);
					System.out.println("�����" + i + "�Ƿ�Ϊ��:" + isNullable);
					System.out.println("�����" + i + "�Ƿ�Ϊֻ��:" + isReadOnly);
					System.out.println("�����" + i + "�ܷ������where��:" + isSearchable);
				}
			}
			stmt.cancel();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ��");
		}
	}
}
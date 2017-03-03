package com.entity;

/**
 * @creator     songJian
 * @version 2016-9-2
 * @category ���ݱ�ʵ��
 * */
public class ColumnEntity {
	// ��������е���Ŀ��ʵ������
	private int columnCount;
	// ���ָ���е�����
	private String columnName;
	// ���ָ���е���������
	private int columnType;
	// ���ָ���е�����������
	private String columnTypeName;
	// ���ڵ�Catalog����
	private String catalogName;
	// ��Ӧ�������͵���
	private String columnClassName;
	// �����ݿ������͵�����ַ�����
	private int columnDisplaySize;
	// Ĭ�ϵ��еı���
	private String columnLabel;
	// ����е�ģʽ
	private String schemaName;
	// ĳ�����͵ľ�ȷ��(���͵ĳ���)
	private int precision;
	// С������λ��
	private int scale;
	// ��ȡĳ�ж�Ӧ�ı���
	private String tableName;
	// �Ƿ��Զ�����
	private boolean isAutoInctement;
	// �����ݿ����Ƿ�Ϊ������
	private boolean isCurrency;
	// �Ƿ�Ϊ��
	private int isNullable;
	// �Ƿ�Ϊֻ��
	private boolean isReadOnly;
	// �ܷ������where��
	private boolean isSearchable;
	
	public ColumnEntity(){
		super();
	}
	
	public int getColumnCount() {
		return columnCount;
	}
	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public int getColumnType() {
		return columnType;
	}
	public void setColumnType(int columnType) {
		this.columnType = columnType;
	}
	public String getColumnTypeName() {
		return columnTypeName;
	}
	public void setColumnTypeName(String columnTypeName) {
		this.columnTypeName = columnTypeName;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	public String getColumnClassName() {
		return columnClassName;
	}
	public void setColumnClassName(String columnClassName) {
		this.columnClassName = columnClassName;
	}
	public int getColumnDisplaySize() {
		return columnDisplaySize;
	}
	public void setColumnDisplaySize(int columnDisplaySize) {
		this.columnDisplaySize = columnDisplaySize;
	}
	public String getColumnLabel() {
		return columnLabel;
	}
	public void setColumnLabel(String columnLabel) {
		this.columnLabel = columnLabel;
	}
	public String getSchemaName() {
		return schemaName;
	}
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	public int getPrecision() {
		return precision;
	}
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public boolean isAutoInctement() {
		return isAutoInctement;
	}
	public void setAutoInctement(boolean isAutoInctement) {
		this.isAutoInctement = isAutoInctement;
	}
	public boolean isCurrency() {
		return isCurrency;
	}
	public void setCurrency(boolean isCurrency) {
		this.isCurrency = isCurrency;
	}
	public int getIsNullable() {
		return isNullable;
	}
	public void setIsNullable(int isNullable) {
		this.isNullable = isNullable;
	}
	public boolean isReadOnly() {
		return isReadOnly;
	}
	public void setReadOnly(boolean isReadOnly) {
		this.isReadOnly = isReadOnly;
	}
	public boolean isSearchable() {
		return isSearchable;
	}
	public void setSearchable(boolean isSearchable) {
		this.isSearchable = isSearchable;
	}
	
	
}

package com.utils;
/**
 * @creator     songJian
 * @version 2016-9-2
 * @category ��mysql�����ݿ���������תΪjava��������
 * */
public class DataTypeUtils {
	enum databaseType{INT,BIGINT,FLOAT,DOUBLE,CHAR,VARCHAR,TEXT,LONGTEXT,DATETIME,DATE,TINYINT};// ���ݿ�����
	enum javaType{Integer,Long,Float,Double,String,Date,Boolean};// java����
	public static String getJavaType(String type){
		if (type.equals(databaseType.INT.toString())) {
			return javaType.Integer.toString();
		}else if(type.equals(databaseType.BIGINT.toString())){
			return javaType.Long.toString();
		}else if(type.equals(databaseType.FLOAT.toString())){
			return javaType.Float.toString();
		}else if(type.equals(databaseType.DOUBLE.toString())){
			return javaType.Double.toString();
		}else if(type.equals(databaseType.CHAR.toString())
			||type.equals(databaseType.VARCHAR.toString())
			||type.equals(databaseType.TEXT.toString())
			||type.equals(databaseType.LONGTEXT.toString())){
			return javaType.String.toString();
		}else if(type.equals(databaseType.DATETIME.toString())||type.equals(databaseType.DATE.toString())){
			return javaType.Date.toString();
		}else if(type.equals(databaseType.TINYINT.toString())){
			return javaType.Boolean.toString();
		}
		return javaType.String.toString();
	};
}

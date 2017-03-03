package com.Template;

import java.util.ArrayList;
import java.util.List;

import com.entity.ColumnEntity;
import com.utils.CacheDataUtils;
import com.utils.PathAndNameUtils;
import com.utils.xxUtils;

/*
 生成之后大概的结构
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.tocersoft..dao.IAaDao">
	<resultMap type="aa" id="aaResultMap">
		<id property="id" column="id" />
		<result property="name" column="c_name" />
	</resultMap>

	<sql id="allColumnSql">
		o.id,
		o.name
	</sql>

	<sql id="searchConditionSql">
		<if test="condition.name != null and condition.name != ''">
			AND o.name like '%${condition.name}%' 
		</if>
	</sql>

	<select id="listAaByPage" resultMap="aaResultMap">
		SELECT <include refid="allColumnSql"/>
		FROM aa o
		WHERE 1=1 <include refid="searchConditionSql"/> 
	</select>
	<select id="listAaByPageCount" resultType="int">
		SELECT count(1) FROM aa o
		WHERE 1=1 <include refid="searchConditionSql"/> 
	</select>

	<select id="getAaById" resultMap="aaResultMap">
		SELECT <include refid="allColumnSql"/>
		FROM aa o
		WHERE o.ID = #{id}
	</select>

	<insert id="add" parameterType="aa">
		INSERT INTO aa
		(
		id,
		name
		)
		VALUES
		(
		#{id},
		#{name}
		)
	</insert>

	<update id="update" parameterType="aa" >
		UPDATE aa SET
		name = #{name}
		WHERE ID = #{id}
	</update>

	<delete id="delByIds">
		DELETE FROM aa 
		WHERE ID IN 
		<foreach collection="array" index="index" item="item" open="(" separator="," close=")">
			#{item}
		</foreach>
	</delete>
</mapper>
*/
public class Tmapper {
	private static final String tableAlias="o";
	
	public String outMapper(){
		return getTemplate(CacheDataUtils.listColumn);
	}

	private String getTemplate(List<ColumnEntity> listColumn){
		String entityClassName=CacheDataUtils.entityClassName;
		String tableName=CacheDataUtils.tableName;
		String tableNameMin=CacheDataUtils.tableNameMin;
		String daoPackage=CacheDataUtils.daoPackage;
		List<String> ketList=CacheDataUtils.keyList;
		List<ColumnEntity> listColumnStr=new ArrayList<ColumnEntity>();
		// 剔除非String列
		for (int i = 0; i < listColumn.size(); i++) {
			if (listColumn.get(i).getColumnClassName().equals("String")) {
				listColumnStr.add(listColumn.get(i));
			}
		}
		
		
		StringBuilder en=new StringBuilder();
		// 开始构造代码
		en.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
		en.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n");
		en.append("<mapper namespace=\""+daoPackage+"\">\r\n");
		en.append("	<resultMap type=\""+tableNameMin+"\" id=\""+tableNameMin+"ResultMap\">\r\n");
		for (int i = 0; i < listColumn.size(); i++) {
			for (int j = 0; j < ketList.size(); j++) {
				if (ketList.get(j).equals(listColumn.get(i).getColumnName())) {
					en.append("		<id property=\""+xxUtils.getColumnName(PathAndNameUtils.prefix,ketList.get(j),false)+"\" column=\""+ketList.get(j)+"\" />\r\n");
				}else{
					en.append("		<result property=\""+xxUtils.getColumnName(PathAndNameUtils.prefix,listColumn.get(i).getColumnName(),false)+"\" column=\""+listColumn.get(i).getColumnName()+"\" />\r\n");
				}
			}
		}
		en.append("	</resultMap>\r\n\r\n");
		
		en.append("	<sql id=\"allColumnSql\">\r\n");
		for (int i = 0; i < listColumn.size(); i++) {
			en.append("		"+tableAlias+"."+listColumn.get(i).getColumnName());
			if (i<listColumn.size()-1) {
				en.append(",\r\n");
			}else{
				en.append("\r\n");
			}
		}
		en.append("	</sql>\r\n\r\n");
		
		en.append("	<sql id=\"searchConditionSql\">\r\n");
		String strCondition="";
		for (int i = 0; i < listColumnStr.size(); i++) {
			strCondition=xxUtils.getColumnName(PathAndNameUtils.prefix,listColumn.get(i).getColumnName(),false);
			en.append("	<if test=\"condition."+strCondition+" != null and condition."+strCondition+" != ''\">\r\n");
			en.append("	AND "+tableAlias+".name like '%${condition."+strCondition+"}%' \r\n");
			en.append("	</if>\r\n");
		}
		en.append("	</sql>\r\n\r\n");
		
		en.append("	<select id=\"list"+entityClassName+"ByPage\" resultMap=\""+tableNameMin+"ResultMap\">\r\n");
		en.append("		SELECT <include refid=\"allColumnSql\"/>\r\n");
		en.append("		FROM "+tableName+" "+tableAlias+"\r\n");
		en.append("		WHERE 1=1 <include refid=\"searchConditionSql\"/>\r\n");
		en.append("	</select>\r\n");
		
		en.append("	<select id=\"list"+entityClassName+"ByPageCount\" resultType=\"int\">\r\n");
		en.append("		SELECT count(1) FROM "+tableName+" "+tableAlias+"\r\n");
		en.append("		WHERE 1=1 <include refid=\"searchConditionSql\"/>\r\n");
		en.append("	</select>\r\n\r\n");
	
		en.append("	<select id=\"get"+tableNameMin+"ById\" resultMap=\""+tableNameMin+"ResultMap\">\r\n");
		en.append("		SELECT <include refid=\"allColumnSql\"/>\r\n");
		en.append("		FROM "+tableName+" "+tableAlias+"\r\n");
		en.append("		WHERE "+tableAlias+".ID = #{id}\r\n");
		en.append("	</select>\r\n\r\n");
		
		en.append("	<insert id=\"add\" parameterType=\""+tableNameMin+"\">\r\n");
		en.append("	INSERT INTO "+tableName+"\r\n");
		en.append("	(\r\n");
		for (int i = 0; i < listColumn.size(); i++) {
			en.append("	"+listColumn.get(i).getColumnName());
			if (i<listColumn.size()-1) {
				en.append(",\r\n");
			}else{
				en.append("\r\n");
			}
		}
		en.append("	)VALUES(\r\n");
		for (int i = 0; i < listColumn.size(); i++) {
			en.append("	#{"+xxUtils.getColumnName(PathAndNameUtils.prefix,listColumn.get(i).getColumnName(),false)+"}");
			if (i<listColumn.size()-1) {
				en.append(",\r\n");
			}else{
				en.append("\r\n");
			}
		}
		en.append("	)\r\n");
		en.append("	</insert>\r\n\r\n");
		
		en.append("	<update id=\"update\" parameterType=\""+tableNameMin+"\" >\r\n");
		en.append("	UPDATE "+tableName+" SET\r\n");
		
		for (int i = 0; i <listColumn.size(); i++) {
			en.append("	"+listColumn.get(i).getColumnName()+" = #{"+xxUtils.getColumnName(PathAndNameUtils.prefix,listColumn.get(i).getColumnName(),false)+"}\r\n");
		}
		en.append("	WHERE "+ketList.get(0)+" = #{"+xxUtils.getColumnName(PathAndNameUtils.prefix,ketList.get(0),false)+"}\r\n");
		en.append("	</update>\r\n\r\n");
		
		en.append("	<delete id=\"delByIds\">\r\n");
		en.append("	DELETE FROM "+tableName+"\r\n");
		en.append("	WHERE "+ketList.get(0)+" IN\r\n");
		en.append("	<foreach collection=\"array\" index=\"index\" item=\"item\" open=\"(\" separator=\",\" close=\")\">\r\n");
		en.append("	#{item}\r\n");
		en.append("	</foreach>\r\n");
		en.append("	</delete>\r\n\r\n");
		en.append("</mapper>");
		
		return en.toString();
	}
}

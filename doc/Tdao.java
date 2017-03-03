package ${daoPackage};

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import ${entityPackage};
import ${dtoPackage};

@Repository("${daoImplClassNameMin}")
public interface ${daoClassName} {

	List<Aa> list${entityClassName}ByPage(RowBounds bounds,@Param("condition") ${dtoClassName} condition);

	int list${entityClassName}ByPageCount(@Param("condition") ${dtoClassName} condition);

	${entityClassName} get${entityClassName}ById(@Param("id") String id);
	// 增加
	void add(${entityClassName} item);
	// 修改
	void update(${entityClassName} item);
	// 删除
	void delByIds(String[] ids);

}


package ${servicePackage};

import java.util.List;

import ${entityPackage};
//这边少一个page类包，一般是项目内定义的一个泛型类

import ${dtoPackage};

public interface ${serviceClassName} {

	void list${entityClassName}ByPage(Page<${entityClassName}> page,${dtoClassName} condition);

	${entityClassName} get${entityClassName}ById(String id);
	// 增加
	void add(${entityClassName} item);
	// 修改
	void update(${entityClassName} item);
	// 删除
	void delByIds(String[] ids);

}


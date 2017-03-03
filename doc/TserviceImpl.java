package ${serviceImplPackage};

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//�����һ��page�����һ������Ŀ�ڶ����һ��������
import ${daoPackage};
import ${entityPackage};
import ${servicePackage};

import ${dtoPackage};

@Service("${serviceImplClassNameMin}")
@Transactional(value = "transactionManager")
public class ${serviceImplClassName} implements ${serviceClassName}{

	@Resource(name = "${daoImplClassNameMin}")
	private ${daoClassName} ${daoClassNameMin};

	public void list${entityClassName}ByPage(Page<${entityClassName}> page,${dtoClassName} condition){
		int rows = ${daoClassNameMin}.list${entityClassName}ByPageCount(condition);
		page.setRows(rows);

		RowBounds rowBounds = new RowBounds(page.getCurrentPageIndex(),page.getPageSize());
		List<${entityClassName}> list = ${daoClassNameMin}.list${entityClassName}ByPage(rowBounds,condition);
		page.setList(list);
	}

	public ${entityClassName} get${entityClassName}ById(String id){
		return ${daoClassNameMin}.get${entityClassName}ById(id);
	}
	// ����
	public void add(${entityClassName} item){
		${daoClassNameMin}.add(item);
	}
	// �޸�
	public void update(${entityClassName} item){
		${daoClassNameMin}.update(item);
	}
	// ɾ��
	public void delByIds(String[] ids){
		${daoClassNameMin}.delByIds(ids);
	}

}


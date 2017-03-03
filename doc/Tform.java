package ${formPackage};


import ${entityPackage};

import ${dtoPackage};

public class ${formClassName} {

	private ${entityClassName} item = new ${entityClassName}();

	private ${dtoClassName} condition = new ${dtoClassName}();

	public ${formClassName}() {}

	public ${entityClassName} getItem() {
		return item;
	}

	public void setItem(${entityClassName} item) {
		this.item = item;
	}

	public ${dtoClassName} getCondition() {
		return condition;
	}

	public void setCondition(${dtoClassName} condition) {
		this.condition = condition;
	}

}

package ${controllerPackage};

import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//这边少一个page类包，一般是项目内定义的一个泛型类

import ${formPackage};
import ${entityPackage};
import ${servicePackage};


@Controller("${controllerClassNameMin}")
@Scope("prototype")
@RequestMapping("/admin/${entityClassName}")
public class ${controllerClassName} {

	@Resource(name = "${serviceImplClassNameMin}")
	private ${serviceClassName} ${serviceClassNameMin};



	@RequestMapping(value = "/index.htm")
	public String index(){
		return "/admin/${tableNameMin}_index";
	}

	
	@RequestMapping(value = "/list${entityClassName}ByPage.htm")
	public ModelAndView list${entityClassName}ByPage(@ModelAttribute ${formClassName} ${formClassNameMin},HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ModelAndView view = new ModelAndView();
		view.setViewName("list视图");
		Map<String,Object> data = view.getModel();
		Page<${controllerClassName}> page=${formClassNameMin}.getPage();// 获取page
		${dtoClassName} ${dtoClassNameMin}=${formClassNameMin}.getCondition(); 
		${serviceClassNameMin}.list${entityClassName}ByPage(page,condition);
		data.put("page",page);

		return view;
	}

	
	@RequestMapping(value = "/edit.htm")
	public ModelAndView edit(@ModelAttribute ${formClassName} ${formClassNameMin},HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ModelAndView view = new ModelAndView();
		view.setViewName("编辑视图");
		Map<String,Object> data = view.getModel();
		if(StringUtils.isNotBlank(${formClassNameMin}.getItem().getId())){
			Aa item = ${serviceClassNameMin}.getAaById(${formClassNameMin}.getItem().getId());
			data.put("item", item);
		}

		return view;
	}

	@RequestMapping(value = "/save.htm")
	@TokenValidate
	public ModelAndView save(@ModelAttribute ${formClassName} ${formClassNameMin},HttpServletRequest request,HttpServletResponse response,HttpSession session){
		try {
			if(StringUtils.isBlank(${formClassNameMin}.getItem().getId())){
				${serviceClassNameMin}.add(${formClassNameMin}.getItem());
			}else{
				${serviceClassNameMin}.update(${formClassNameMin}.getItem());
			}
			return ajaxJSON(Status.success,"保存成功");// 这边一般在baseController里面有个定义的方法
		} catch (Exception e) {
			String msg = "保存时发生异常" + e.getMessage();
			logger.error(msg,e);
			return ajaxJSON(Status.error, "保存失败");// 这边一般在baseController里面有个定义的方法		
		}
	}
	
	@RequestMapping(value = "/del.htm")
	public ModelAndView del(@ModelAttribute ${formClassName} ${formClassNameMin},HttpServletRequest request,HttpServletResponse response,HttpSession session){
		try {
			${serviceClassNameMin}.delByIds(${formClassNameMin}.getSelIds().split(","));
			return ajaxJSON(Status.success,"删除成功");// 这边一般在baseController里面有个定义的方法
		} catch (Exception e) {
			String msg = "删除时发生异常" + e.getMessage();
			logger.error(msg,e);
			return ajaxJSON(Status.error, "删除失败");// 这边一般在baseController里面有个定义的方法
		}
	}
}


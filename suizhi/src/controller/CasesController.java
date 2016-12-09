package controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.pojo.Cases;
import service.CasesService;

@Controller
@RequestMapping("/view")
public class CasesController {

	@Autowired
	private CasesService service;

	//后台增加案例
	@RequestMapping(value="/admin/addCases",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> addCases(@RequestBody Cases cases) throws Throwable{
		service.addCases(cases);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", cases.getId());
		return map;
	}
	
	
	
	
	//后台修改案例
	@RequestMapping(value="/admin/updateCases",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateCases(@RequestBody Cases cases) throws Throwable{
		service.updateCases(cases);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", cases.getId());
		return map;
	}
	
	//后台删除案例
	@RequestMapping(value="/admin/deleteCases",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> deleteCases(HttpServletRequest request,HttpServletResponse response
			,@RequestParam(value="id")int id)throws Throwable{
		
			service.deleteCases(id);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("status", "OK");
		
		return map;
	}
	
	//后台显示案例 
	@RequestMapping(value="/admin/listCases",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> listCases(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("cases", service.listAll());
			return map;
	
	}
	
	//前端显示案例  
	@RequestMapping(value="/listCases",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> listCase(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("cases", service.listAll());
			return map;
	
	}
}

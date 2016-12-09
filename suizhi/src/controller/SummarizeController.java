package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonFormat;

import model.pojo.Summarize;
import service.SummarizeService;

@Controller
@RequestMapping("/view")
public class SummarizeController {

	@Autowired
	private SummarizeService service;
	
	//后台更改公司介绍
	@RequestMapping(value="/admin/updateSummarize",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> updateSummarize(HttpServletRequest request,HttpServletResponse response
			,@ModelAttribute Summarize summarize)throws Throwable{
		summarize.setId(1);

		service.updateSummarize(summarize);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("status", "OK");
		return map;
	}
	
	//后台显示公司概括
	@RequestMapping(value="/admin/viewSummarize",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> viewSummarize(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("summarize", service.getSummarize(1));
		return map;
	}
	
	//前端显示公司概括
	@RequestMapping(value="viewSummarize",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> viewSummarizes(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("summarize", service.getSummarize(1));
		return map;
	}
}

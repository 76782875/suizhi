package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import model.pojo.Teamintroduction;
import service.TeamItdService;
import util.ConfigUtil;

@Controller
@RequestMapping("/view")
public class TeamItdController {

	@Autowired
	private TeamItdService service;
	
	//前端成员介绍
	@RequestMapping(value="/viewMember",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> viewMembers(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("member", service.listAll());
		return map;
	}
	
	
	//后台成员介绍
	@RequestMapping(value="/admin/viewMember",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> viewMember(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("member", service.listAll());
		return map;
	}
	
	//后台添加成员
	@RequestMapping(value="/admin/addMember",method=RequestMethod.POST)
	public @ResponseBody String addMember(HttpServletRequest request,HttpServletResponse response
			,@RequestParam(value="name") String name,@RequestParam(value="expertise")String expertise,
			@RequestParam(value="profession")String profession,@RequestParam(value="pic") MultipartFile pic
			,@RequestParam(value="content") String content){
		try {
			 Teamintroduction member= new Teamintroduction();
			member.setName(name);
			member.setExpertise(expertise);
			member.setProfesion(profession);
			member.setContent(content);
			//保存相对路径到数据库，图片写入服务器
			if(pic!=null&&!pic.isEmpty()){
				//获取图片的文件名
				String fileName = pic.getOriginalFilename();
				//获取图片的扩展名
				String extensionName = fileName.substring(fileName.lastIndexOf("."));
				//新的图片文件名
				String indexpic=UUID.randomUUID().toString()+extensionName.replace("\"","");
				FileOutputStream file = new FileOutputStream(ConfigUtil.getValue("uploadpath")+indexpic);
				file.write(pic.getBytes());
				member.setPic(indexpic);
			}
			service.addMemeber(member);
			request.setAttribute("id", member.getId());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "OK";
	}
	
	//后台删除成员
	@RequestMapping(value="/admin/deleteMember",method=RequestMethod.GET)
	public @ResponseBody String deleteMember(@RequestParam("id") int id){
		try {
			service.deleteMember(id);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "OK";
	}
	
	//后台修改成员
	@RequestMapping(value="/admin/updateMember",method=RequestMethod.POST)
	public @ResponseBody String updateMember(HttpServletRequest request,HttpServletResponse response
			,@RequestParam(value="name") String name,@RequestParam(value="expertise")String expertise,
			@RequestParam(value="profession")String profession,@RequestParam(value="pic") MultipartFile pic
			,@RequestParam(value="content") String content,@RequestParam(value="id")int id){
		try {
			 Teamintroduction member= service.getMemeber(id);
			member.setName(name);
			member.setExpertise(expertise);
			member.setProfesion(profession);
			member.setContent(content);
			//保存相对路径到数据库，图片写入服务器
			if(pic!=null&&!pic.isEmpty()){
				//获取图片的文件名
				String fileName = pic.getOriginalFilename();
				//获取图片的扩展名
				String extensionName = fileName.substring(fileName.lastIndexOf("."));
				//新的图片文件名
				String indexpic=UUID.randomUUID().toString()+extensionName.replace("\"","");
				FileOutputStream file = new FileOutputStream(ConfigUtil.getValue("uploadpath")+indexpic);
				file.write(pic.getBytes());
				member.setPic(indexpic);
			}
			service.updateMember(member);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "OK";
	}
	
	
	//后台修改成员
		@RequestMapping(value="/admin/updateMemberWitdOutImage",method=RequestMethod.POST)
		public @ResponseBody String updateMemberWitdOutImage(HttpServletRequest request,HttpServletResponse response
				,@RequestParam(value="name") String name,@RequestParam(value="expertise")String expertise,
				@RequestParam(value="profession")String profession
				,@RequestParam(value="content") String content,@RequestParam(value="id")int id){
			try {
				 Teamintroduction member= service.getMemeber(id);
				member.setName(name);
				member.setExpertise(expertise);
				member.setProfesion(profession);
				member.setContent(content);
				
				service.updateMember(member);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "OK";
		}
	
	
//	@RequestMapping(value="/admin/test",method=RequestMethod.POST)
//	public String test(@RequestParam("test")String test){
//		System.out.println(test);
//		return test;
//	}
	
}

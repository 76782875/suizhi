package controller;

import java.util.HashMap;
import java.util.List;
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

import model.pojo.ContactUs;
import service.ContactUsService;

/*
 * 联系方式的controller
 */
@Controller
@RequestMapping("/view")
public class ContactUsController {

	@Autowired
	private ContactUsService service;
	
	//前端
	@RequestMapping(value = "/index")
	public @ResponseBody Map<String, Object> ListContactUs3(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contact", service.listAll());
		// 第一个字符串参数，由后台页面部分的默认.txt文件中的json数据放到浏览器中解析得到
		return map;
	}
	
	// 按列表显示的两种方式
	@RequestMapping(value = "/admin/index")
	public @ResponseBody Map<String, Object> ListContactUs(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contact", service.listAll());
		// 第一个字符串参数，由后台页面部分的默认.txt文件中的json数据放到浏览器中解析得到
		return map;
	}

	@RequestMapping(value = "/admin/index2", method = RequestMethod.GET)
	public @ResponseBody List<ContactUs> ListContactUs2(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contact", service.listAll());
		@SuppressWarnings("unchecked")
		List<ContactUs> list = (List<ContactUs>) map.get("contact");
		// 返回list的话，就不带key为contact，直接是值
		// 可以在浏览器上用 路径+.action访问测试，会弹出.txt的json数据文本保存对话框
		return list;
	}

	@RequestMapping(value = "/admin/select")
	public @ResponseBody ContactUs viewCu(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") int id) throws Exception {
		System.out.println("~~~~~~~~~~~~~~~~~公司联系方式");

		ContactUs cu = service.viewCu(id);
		return cu;
	}

	// 后台修改联系方式-初始（用cu传参）
	@RequestMapping(value = "/admin/contactUsUpdate")
	public @ResponseBody ContactUs updateCu(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute ContactUs cu) throws Exception {
		System.out.println("~~~~~~~~~~联系方式更新~~~" + request.getParameter("address"));

		try {

			service.updateCu(cu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cu;
	}

	@RequestMapping(value = "/admin/contactUsAdd")
	public @ResponseBody Map<String, Object> addCu(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute ContactUs cu) throws Exception {
		System.out.println("~~~~~~~~~~新增联系方式");

		service.addCu(cu);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", cu.getId());
		// 第一个字符串参数，由后台页面部分的默认.txt文件中的json数据放到浏览器中解析得到
		return map;
	}

	// 后台删除联系方式
	@RequestMapping(value = "/admin/contactUsDelete")
	public @ResponseBody void deleteCu(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") int id) throws Exception {
		service.deleteCu(id);
	}

}

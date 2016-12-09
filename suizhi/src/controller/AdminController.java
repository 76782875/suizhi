package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AdminService;

@Controller
@RequestMapping("/view")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	/**
	 * 登录验证
	 * @param map
	 * @param request
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/admin/login",method=RequestMethod.POST)
	public @ResponseBody Map<String, String> checklogin(@RequestBody Map<String,String> map,
			HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Map<String, String> retrunMap=new HashMap<String, String>();
		
		Admin admin = new Admin();
		admin.setUsername(map.get("username"));
		admin.setPassword(map.get("password")); 
		
		Admin adminEntity = adminService.checklogin(admin);
		
		if (adminEntity != null) {
			HttpSession ss = request.getSession();
			ss.setAttribute("loginflag", "success");
			System.out.println("session设置完毕");
			//登录成功
			retrunMap.put("message",map.get("username"));
			return retrunMap;
		}
		
		//登录失败
		retrunMap.put("message","fail");
		return retrunMap;
	}

	/**
	 * 退出登录
	 * @param httpReq
	 * @param httpRes
	 * @throws IOException
	 */
	@RequestMapping("/admin/logout")
	public void logout(HttpServletRequest httpReq,HttpServletResponse httpRes) throws IOException{
		HttpSession ss=httpReq.getSession();
		//清除session
		ss.removeAttribute("loginflag");
		String path = httpReq.getContextPath();
		String basePath = httpReq.getScheme()+"://"+httpReq.getServerName()+":"+httpReq.getServerPort()+path+"/";
		//重定向登录页面
		httpRes.sendRedirect(basePath+"login.html");
	}
	
}

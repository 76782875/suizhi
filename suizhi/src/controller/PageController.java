package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")
public class PageController {
	@RequestMapping("/message")
	public String goMessage(){
		return "admin-message";
	}
	@RequestMapping("/index")
	public String goIndex(){
		return "admin-index";
	}
	@RequestMapping("/team")
	public String goTeam(){
		return "admin-team";
	}
	@RequestMapping("/contact")
	public String goCantact(){
		return "admin-contact";
	}
	@RequestMapping("/company")
	public String goCompany(){
		return "admin-company";
	}
	@RequestMapping("/case")
	public String goCase(){
		return "admin-case";
	}
}

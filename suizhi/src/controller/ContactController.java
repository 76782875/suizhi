package controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import model.pojo.Contact;
import model.pojo.ContactVo;
import service.ContactService;
import util.ValidatePhone;

@Controller
@RequestMapping("/view")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	

	/**
	 * 前端获取留言
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value="/getContacts",method=RequestMethod.GET)
	public @ResponseBody ContactVo getAllContacts(
			@RequestParam(value = "pageNo") int pageNo){
		Contact contact=new Contact();
		ContactVo contactVo=new ContactVo();
		contactVo=contactService.queryByPage(contact, pageNo,20,false);
		return contactVo;
		
	}
	
	/**
	 * 前端添加留言
	 * @param contact
	 * @param request
	 * @param response
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping(value="/addContact",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> addContact(@ModelAttribute Contact contact){
		Map<String, Object> map=new HashMap<String, Object>();
		String phone=contact.getPhone();
		String question=contact.getQusetion();
		System.out.println(!phone.equals(""));
		System.out.println(phone!=null);
		System.out.println(ValidatePhone.isMobileNum(phone));
		if(!phone.equals("") && phone!=null && ValidatePhone.isMobileNum(phone)){
				if (!question.equals("")&&question!=null) {
					contactService.insert(contact);
					map.put("code", 1);
					map.put("message", "留言成功!");
					return map;
				}else {
					map.put("code", -1);
					map.put("message", "留言内容格式不正确！");
					return map;
				}
			
		}else{
			map.put("code", -1);
			map.put("message", "手机号码格式不正确！");
			return map;
		}
	}
	
	/**
	 * 管理员通过状态来分页获取留言
	 * @param pageNo
	 * @param status
	 * @param phone
	 * @return
	 */
	@RequestMapping(value="/admin/getContactsByStatus",method=RequestMethod.GET)
	public @ResponseBody ContactVo getContactsByStatus(
			@RequestParam(value = "pageNo") int pageNo,
			@RequestParam(value = "status") int status,
			@RequestParam(value = "phone") String phone){
		Contact contact=new Contact();
		contact.setStatus(status);
		/*if(phone.equals("false")){
			contact.setPhone(null);
		}else{
			contact.setPhone(phone);
		}*/
		contact.setPhone(phone);
		ContactVo contactVo=new ContactVo();
		contactVo=contactService.queryByPage(contact, pageNo,10,true);
		
		return contactVo;
		
	}
	
	/**
	 * 管理员删除留言
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/admin/deleteContactsById",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getContactsByStatus(
			@RequestParam(value = "id") int id){
		 Map<String, Object> map=new HashMap<String, Object>();
		contactService.deleteByPrimaryKey(id);
		map.put("code", 1);
		map.put("message", "删除留言成功！");
		return map;
		
	}
	
	/**
	 * 管理员回复留言
	 * @param id
	 * @param answer
	 * @return
	 */
	@RequestMapping(value="/admin/updataContactsById",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getContactsByStatus(
			@RequestParam(value = "id") int id,
			@RequestParam(value = "answer") String answer){
		Map<String, Object> map=new HashMap<String, Object>();
		contactService.updateByPrimaryKey(id,answer);
		map.put("code", 1);
		map.put("message", "回复留言成功！");
		return map;
		
	}
}

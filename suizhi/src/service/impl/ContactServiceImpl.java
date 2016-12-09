package service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.ContactMapper;
import model.pojo.Contact;
import model.pojo.ContactVo;
import service.ContactService;

public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactMapper contactMapper;

	/**
	 * 添加留言
	 */
	@Override
	public void insert(Contact contact) {
		
		contactMapper.insert(contact);

	}
	
	/**
	 * 分页查询
	 */
	public ContactVo queryByPage(Contact contact, Integer pageNo,Integer pageSize,boolean isAdmin) {
		pageNo = pageNo == null?1:pageNo;
		PageHelper.startPage(pageNo, pageSize);
		List<Contact> list = contactMapper.selectContactByStatus(contact);
		//用PageInfo对结果进行包装
		PageInfo<Contact> page = new PageInfo<Contact>(list);
		List<Contact> lists=page.getList();
		if(!isAdmin){
			for(Contact contactInList:lists){
				String phone=contactInList.getPhone();
				String replaceStr=phone.substring(3,8);
				contactInList.setPhone(phone.replace(replaceStr, "*****"));
				
			}
		}
		ContactVo contactVo=new ContactVo();
		contactVo.setMessages(lists);
		contactVo.setPage(page.getPageNum());
		contactVo.setPages(page.getPages());
		contactVo.setTotal(page.getTotal());
		
		return contactVo;
	}

	/**
	 * 删除留言
	 */
	public void deleteByPrimaryKey(Integer id){
		contactMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 *回复留言 
	 */
	public void updateByPrimaryKey(int id,String answer){
		Contact contact=contactMapper.selectByPrimaryKey(id);
		contact.setAnswer(answer);
		if(!answer.equals("")){
			contact.setStatus(1);
		}
		contactMapper.updateByPrimaryKey(contact);
	}
	
	

}

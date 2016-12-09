package service;

import model.pojo.Contact;
import model.pojo.ContactVo;

public interface ContactService {
	
	/**
	 * 新增留言
	 * @param contact
	 */
	public void insert(Contact contact);
	
	/**
	 * 分页查找留言
	 * @param contact
	 * @param pageNo
	 * @param pageSize
	 * @param isAdmin
	 * @return
	 */
	public ContactVo queryByPage(Contact contact, Integer pageNo,Integer pageSize,boolean isAdmin);
	
	/**
	 * 删除留言
	 * @param id
	 */
	public void deleteByPrimaryKey(Integer id);
	
	/**
	 * 回复留言
	 * @param id
	 * @param answer
	 */
	public void updateByPrimaryKey(int id,String answer);
	
}

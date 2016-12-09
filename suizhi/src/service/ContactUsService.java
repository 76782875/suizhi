package service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.transaction.annotation.Transactional;


import model.pojo.ContactUs;
import model.pojo.ContactUsCustom;
import model.pojo.ContactUsQueryVo;


/*
 * 联系方式管理
 */
public interface ContactUsService {

	//根据id来查找联系方式
	public ContactUs viewCu(Integer id) throws Exception;
	
	//更新联系方式
	public boolean updateCu(ContactUs cu) throws Exception;
	
	//更新id为参数值的记录为cu
//	public boolean updateCu(ContactUs cu,int id) throws Exception;
	
	//新增联系方式
	public boolean addCu(ContactUs cu) throws Exception;
	
	//删除联系方式
	public boolean deleteCu(int id) throws Exception;
	
	//联系方式列表
//	public List<ContactUs> listAll(int pid) throws Exception;
	public List<ContactUs> listAll() throws Exception;
	
//	//根据id查询联系方式
//	public ContactUsCustom findContactUsById(ContactUs id) throws Exception;
//	
//	//查询联系方式
//	public ContactUs selectByPrimaryKey(ContactUs id)throws Exception;
//	
//	//修改联系方式
//	public boolean updateContactUs(ContactUs id,ContactUs contactUs) throws Exception;
//	
//	//删除联系方式
//	public boolean deleteContactUs(Integer id) throws Exception;
//	
//	//新增联系方式
//	public boolean addContactUs(ContactUs contactUs) throws Exception;
//	
//	
//	//更新联系方式
//	public boolean updateId(ContactUs id) throws Throwable;


}

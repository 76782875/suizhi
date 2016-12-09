package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.ContactUsMapper;
import mapper.ContactUsMapperCustom;
import model.pojo.ContactUs;
import service.ContactUsService;

/*
 * 联系方式管理
 */
@Service
public class ContactUsServiceImpl implements ContactUsService{
	
	@Autowired
	private ContactUsMapperCustom daoCustom;//拓展类，字段增加时使用
	
	@Autowired
	private ContactUsMapper dao;
	
//	@Autowired
//	private ContactUsMapper2 dao2;
	
	@Override
	public ContactUs viewCu(Integer id) throws Exception {
		
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateCu(ContactUs cu) throws Exception {
		
		return dao.updateByPrimaryKeySelective(cu)==1;
	}


	@Override
	public boolean addCu(ContactUs cu) throws Exception {
		
		return dao.insertSelective(cu)==1;
	}
	
	@Override
	public boolean deleteCu(int id) throws Exception{
		
		return dao.deleteByPrimaryKey(id)== 1;
	}


//	@Override
//	public List<ContactUs> listAll(int pid) throws Exception {
//		// TODO Auto-generated method stub
//		return dao.selectAll();
//	}
	
	@Override
	public List<ContactUs> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}
	
	//这里用的是dao，所以用的sql语句是——List<ContactUs> selectAll();
	//而不是	public List<ContactUs> getList(int pid);
	//所以这种方式是不用父级id的
	
	//当然你考虑多设一个pid的字段，全部默认值相同以此为传参也是可以实现的
	





}

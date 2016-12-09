package test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mapper.ContactUsMapper;
import model.pojo.ContactUs;
import service.ContactUsService;


@RunWith(SpringJUnit4ClassRunner.class)
//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:/spring/applicationContext-*.xml" })

public class ContactUsServiceImplTest{
	
	@Resource
	private ContactUsMapper CuDao =null;
	
//	@Resource
//	private ContactUsMapper2 CuDao2 =null;
	
	@Autowired
	private ContactUsService contactUsService;
	
	@Test
	public void testViewCu() throws Exception{
		//查找id为特定值的ContactUs实例
		Integer id = 2;
		ContactUs cu = contactUsService.viewCu(id);
		//ContactUs cu = CuDao.selectByPrimaryKey(id);
		System.out.println(cu.getId());
		System.out.println(cu.getName());
		System.out.println(cu.getAddress());
		System.out.println(cu.getPhone());
	}	
	
	@Test
	public void testUpdateCu(){
		//更新id为2的ContactUs实例
		Integer id = 2;
		ContactUs cu = CuDao.selectByPrimaryKey(id);
		cu.setName("谷歌");
		cu.setAddress("海王星");
		cu.setPhone("2002");
		CuDao.updateByPrimaryKeySelective(cu);
		ContactUs cu2 = CuDao.selectByPrimaryKey(id);
		System.out.println(cu2.getId());
		System.out.println(cu2.getName());
		System.out.println(cu2.getAddress());
		System.out.println(cu2.getPhone());
	}
	
	@Test
	public void testAddCu(){
		//增加id为3的ContactUs实例
		ContactUs cu3 = new ContactUs();
		cu3.setId(3);
		cu3.setName("阿里");
		cu3.setAddress("冥王星");
		cu3.setPhone("2001");
		CuDao.insertSelective(cu3);
		System.out.println(cu3.getId());
		System.out.println(cu3.getName());
		System.out.println(cu3.getAddress());
		System.out.println(cu3.getPhone());
	}
	
	@Test
	public void testDeleteCu(){
		
		Integer id = 3;
//		ContactUs cu3 = CuDao.selectByPrimaryKey(id);
//		System.out.println(cu3.getId());
//		System.out.println(cu3.getName());
//		System.out.println(cu3.getAddress());
//		System.out.println(cu3.getPhone());
		CuDao.deleteByPrimaryKey(id);
	}
	
//	@Test
//	public void testListAll(){
//		ContactUs cu5 = new ContactUs();
//		cu5.setId(5);
//		cu5.setName("阿里");
//		cu5.setAddress("冥王星");
//		cu5.setPhone("2001");
//		CuDao.insertSelective(cu5);
//		//列出所有成员信息
//		System.out.println("---------");
//		List<ContactUs> cont = CuDao2.getList(0);
//		System.out.println("~~~~~~~~listAll测试");
//		System.out.println(cont);
//	}
	
	@Test
	public void testListAll() throws Exception{
		//测试传pid的列表显示方法需要把前面的某些注解打开，数据库里面加字段
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("contact", contactUsService.listAll());
		System.out.println("~~~~~~~~~~测试的是不传参的列表显示方法~~~~~~~");
		for(int i=0;i<map.size();i++){
			System.out.println(map);
		}
		
	}
	
	@Test//只是方法调用者和上述不同，一个service层的调用，另一个是dao层的调用
	public void testListAll2() throws Exception{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("contact",CuDao.selectAll()); 
		System.out.println("~~~~~~~~~~测试的依然是不传参的列表显示方法~~~~~~~");
		for(int i=0;i<map.size();i++){
			System.out.println(map);
		}
		
	}
}
		





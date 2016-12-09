package test;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mapper.TeamIntroductionMapper2;
import mapper.TeamintroductionMapper;
import model.pojo.Teamintroduction;
import model.pojo.TeamintroductionExample;
import service.TeamItdService;

@RunWith(SpringJUnit4ClassRunner.class)
//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:/spring/applicationContext-*.xml" })
public class TeamItdServiceImplTest {
	
	@Autowired
	private TeamItdService service;
	
	@Resource
	private TeamintroductionMapper Titd = null;
	
	@Resource
	private TeamIntroductionMapper2 Titd2 = null;
	
	@Test
	public void Test(){
		//增加成员测试
//		Teamintroduction member = new Teamintroduction();
//		member.setId(2);
//		member.setName("刘泽钝");
//		member.setContent("更帅");
//		member.setProfesion("专业律师");
//		member.setExpertise("耍酷");
//		member.setPic("345");
//		Titd.insert(member);
		
		//修改成员测试
//		TeamIntroduction member = Titd.selectByPrimaryKey(2);
//		member.setPic("666");
//		Titd.updateByPrimaryKey(member);
		
		//删除成员测试
//		Titd.deleteByPrimaryKey(2);
		
		//列出所有成员信息
		TeamintroductionExample example = new TeamintroductionExample();
		example.createCriteria().andIdIsNotNull();
		Map<Teamintroduction,String> members = (HashMap<Teamintroduction, String>) Titd.selectByExample(example);
	
		System.out.println(members);
	}
	
	@Test
	public void  viewMember() throws Throwable{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("member", service.listAll());
		System.out.println(map);
	}
	
	
}

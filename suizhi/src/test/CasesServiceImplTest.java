package test;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mapper.CasesMapper;
import mapper.CasesMapper2;
import model.pojo.Cases;

@RunWith(SpringJUnit4ClassRunner.class)
//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:/spring/applicationContext-*.xml" })
public class CasesServiceImplTest {

	@Resource
	private CasesMapper dao=null;
	@Resource
	private CasesMapper2 dao2 = null;
	
	@Test
	public void Test(){
		//添加案例测试
//		Cases cases = new Cases();
//		cases.setId(1);
//		cases.setAnalysis("哈哈哈");
//		cases.setContent("哈哈哈2");
//		cases.setTitle("呵呵呵");
//		cases.setType("123132131");
//		dao.insert(cases);
		
		//遍历测试
//		CasesExample example = new CasesExample();
//		List<Cases> cases = dao.selectByExample(example);
//		example.createCriteria().andIdIsNotNull();
//
//		System.out.println(cases);
//		List<Cases> cases = dao2.listAll();
//		System.out.println(cases);
		
		Cases cases = dao.selectByPrimaryKey(1);
		cases.setAnalysis("哈哈哈 ");
		cases.setContent("呵呵呵");
		dao.updateByPrimaryKey(cases);
		
	}
}

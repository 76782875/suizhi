package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.CasesMapper;
import mapper.CasesMapper2;
import model.pojo.Cases;
import service.CasesService;

@Service
public class CasesServiceImpl implements CasesService {


	@Autowired
	private CasesMapper dao;
	@Autowired
	private CasesMapper2 dao2;

	@Override
	public boolean addCases(Cases cases) throws Throwable {
		// TODO Auto-generated method stub
		return dao.insert(cases)==1;
	}

	@Override
	public void deleteCases(int id) throws Throwable {
		// TODO Auto-generated method stub
		dao.deleteByPrimaryKey(id);
	}

	@Override
	public boolean updateCases(Cases cases) throws Throwable {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(cases)==1;
	}

	@Override
	public Cases getCases(int id) throws Throwable {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}
	
	@Override
	public List<Cases> listAll() throws Throwable {
		// TODO Auto-generated method stub
		return dao2.listAll(); 
	}
}

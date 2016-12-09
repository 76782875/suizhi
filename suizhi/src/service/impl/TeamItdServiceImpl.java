package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.TeamintroductionMapper;
import mapper.TeamIntroductionMapper2;
import model.pojo.Teamintroduction;
import service.TeamItdService;

@Service
public class TeamItdServiceImpl implements TeamItdService {


	@Autowired
	private TeamintroductionMapper dao;
	
	@Autowired
	private TeamIntroductionMapper2 dao2;
	@Override
	public boolean updateMember(Teamintroduction member) throws Throwable {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(member)==1;
	}

	@Override
	public boolean deleteMember(int id) throws Throwable {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id)==1;
	}

	@Override
	public boolean addMemeber(Teamintroduction member) throws Throwable {
		// TODO Auto-generated method stub
		return dao.insert(member)==1;
	}


	@Override
	public Teamintroduction getMemeber(int id) throws Throwable {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}


	@Override
	public List<Teamintroduction> listAll() throws Throwable {
		// TODO Auto-generated method stub
		
		return dao2.getList();
	}
}

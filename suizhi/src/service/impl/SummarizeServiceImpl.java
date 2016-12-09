package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.SummarizeMapper;
import mapper.SummarizeMapper2;
import model.pojo.Summarize;
import service.SummarizeService;
@Service
public class SummarizeServiceImpl implements SummarizeService {



	@Autowired
	private SummarizeMapper dao;
	
	@Autowired
	private SummarizeMapper2 dao2;
	
	
	@Override
	public boolean updateSummarize(Summarize summarize) throws Throwable {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(summarize)==1;
	}


	
	@Override
	public Summarize getSummarize(int id) throws Throwable {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}





}

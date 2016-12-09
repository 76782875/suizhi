package service;

import java.util.List;

import model.pojo.Summarize;

public interface SummarizeService {
	
	public boolean updateSummarize(Summarize summarize)throws Throwable;
	
	
	public Summarize getSummarize(int id)throws Throwable;
	
}

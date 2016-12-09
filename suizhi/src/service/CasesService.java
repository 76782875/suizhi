package service;

import java.util.List;

import model.pojo.Cases;


public interface CasesService {

	//增加案例
	public boolean addCases(Cases cases) throws Throwable;
	
	//删除案例
	public void deleteCases(int id) throws Throwable;
	
	//修改案例
	public boolean updateCases(Cases cases) throws Throwable;
	
	//查询案例
	public Cases getCases(int id) throws Throwable;
	
	//遍历案例
	public List<Cases> listAll() throws Throwable;
}

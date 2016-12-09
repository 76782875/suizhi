package service;

import java.util.List;

import model.pojo.Teamintroduction;

public interface TeamItdService {
	
	//更新成员介绍
	public boolean updateMember(Teamintroduction member) throws Throwable;
	
	//删除成员
	public boolean deleteMember(int id) throws Throwable;
	
	//增加成员
	public boolean addMemeber(Teamintroduction member) throws Throwable;
	
	//获取成员
	public Teamintroduction getMemeber(int id) throws Throwable;
	
	//遍历成员 
	public List<Teamintroduction> listAll() throws Throwable;
}

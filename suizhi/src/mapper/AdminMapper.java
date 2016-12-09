package mapper;

import model.pojo.Admin;

public interface AdminMapper {

	Admin selectByUsername(String username);
	
}
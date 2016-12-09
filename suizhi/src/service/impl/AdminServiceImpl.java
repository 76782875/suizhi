package service.impl;

import mapper.AdminMapper;
import model.pojo.Admin;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import service.AdminService;
import util.HexUtil;

public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper adminMapper;
	
	
	@Override
	public Admin checklogin(Admin admin) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Admin adminEntity=adminMapper.selectByUsername(admin.getUsername());
		if(adminEntity!=null){
			String dbPassword=adminEntity.getPassword();
			//MD5验证
			if(HexUtil.validPasswd(admin.getPassword(),dbPassword)){
				return adminEntity;
			}
		}
		return null;
	}

}

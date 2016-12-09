package service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import model.pojo.Admin;

public interface AdminService {

	/**
	 * 验证密码
	 * @param admin
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public Admin checklogin(Admin admin) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	
}

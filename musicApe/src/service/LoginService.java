package service;

import dao.LoginDAO;
import model.User;

public class LoginService {

	LoginDAO dao = new LoginDAO();
	
	public User usernamePassCheck(String username, String password) {
		// TODO Auto-generated method stub
		return dao.usernamePassCheck(username,password);
	}

}

package service;

import commonValidationMethods.ValidationMethods;
import dao.RegistrationDAO;
import model.User;

public class RegistrationService {

	ValidationMethods validation = new ValidationMethods();
	RegistrationDAO dao = new RegistrationDAO();
	
	
	public boolean passwordCheck(String password) {
		
		return validation.passwordCheck(password);
	}


	public boolean emailCheck(String email) {
		
		return validation.emailCheck(email);
	}


	public boolean repeatedPassCheck(String password, String repeatedPassword) {
		
		return validation.repeatedPassCheck(password, repeatedPassword);
	}


	public User setupUser(String username, String password, String email) {
		
		return validation.setupUser(username, password, email);
	}


	public boolean saveUserInDB(User user) {
		
		return dao.saveUserInDB(user);
	}


	public User uniqueUsernameCheck(User userCheck) {
		
		return dao.uniqueUsernameCheck(userCheck);
	}


}

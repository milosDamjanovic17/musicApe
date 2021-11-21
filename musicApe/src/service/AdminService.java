package service;

import java.util.List;

import dao.AdminDAO;
import model.User;

public class AdminService {
	
	AdminDAO dao = new AdminDAO();

	public List<User> returnAllUsers() {

		return dao.returnAllUsers();
	}
	
	
	
}

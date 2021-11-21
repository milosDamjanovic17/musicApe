package service;

import dao.EditProfileDAO;
import model.ProfileDetails;
import model.User;

public class EditProfileService {

	EditProfileDAO dao = new EditProfileDAO();

	public User returnUserFromID(String id) {
		// TODO Auto-generated method stub
		return dao.returnUserFromID(id);
	}

	public ProfileDetails returnProfileDetailsFromUser(User user) {
		// TODO Auto-generated method stub
		return dao.returnProfileDetailsFromUser(user);
	}

	public boolean updateProfileDetails(String name, String djName, String description, String soundcloud, String genre,
			ProfileDetails details) {

		return dao.updateProfileDetails(name, djName, description, soundcloud, genre, details);
	}
	
}

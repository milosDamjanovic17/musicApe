package commonValidationMethods;

import model.User;
import model.UserType;

public class ValidationMethods {

	public boolean passwordCheck(String password) {     //password has to have at least 2 digits and minimum 8 characters
		
		int length = password.length();
		int digitCounter = 0;
		
		
		if(length < 8) {
			
			System.out.println("Password has to have minimum 8 characters!");
			return false;
		}
		
		for(int i=0; i<length; i++) {
			
			char localChar = password.charAt(i);
			if(Character.isDigit(localChar)) {
				digitCounter++;
			}
		}
		
		if(digitCounter >= 2) {
			System.out.println("Password is ok!");
			return true;
		}else {
			System.out.println("Password needs to have at least 2 digits!");
			return false;
		}
	}

	public boolean emailCheck(String email) { //generic nesto samo da ima bar 1 @, i bar jednu tacku
		
		int length = email.length();
		int monkeyCounter = 0;
		
		
		for(int i = 0; i < length; i++) {
			
			char localChar = email.charAt(i);
			if(localChar == '@') {
				monkeyCounter++;
			}
			
		}
		
		if(monkeyCounter == 1) {
			System.out.println("Email is valid!");
			return true;
		}else {
			System.out.println("Email is not valid!");
			return false;
		}
		
	}

	public boolean repeatedPassCheck(String password, String repeatedPassword) {
		
		if(password.equals(repeatedPassword)) {
			return true;
		}else {
			return false;
		}
		
	}

	public User setupUser(String username, String password, String email) {
		
		User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setUsertype(UserType.USER);
		
		return user;
	}

	public boolean checkEditProfileParameterInputs(String name, String djName, String description, String soundcloud,
			String genre) {
		
		if(name.isEmpty() || djName.isEmpty() || description.isEmpty() || soundcloud.isEmpty() || genre.isEmpty()) {
			return false;
		}else {
			return true;
		}

	}
	
	
	
	
	

}

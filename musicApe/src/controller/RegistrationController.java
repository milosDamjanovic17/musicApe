package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.RegistrationService;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet(description = "kontroler za podatke iz REGISTER viewa", urlPatterns = { "/RegistrationController" })
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrationController() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegistrationService service = new RegistrationService();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repeatedPassword = request.getParameter("repeatedPassword");
		String email = request.getParameter("email");
		
		User userCheck = new User();
			userCheck.setUsername(username);
			userCheck.setPassword(password);
			userCheck.setEmail(email);
		
		boolean passwordCheck = service.passwordCheck(password);
		boolean emailCheck = service.emailCheck(email);
		boolean repeatedPassCheck = service.repeatedPassCheck(password, repeatedPassword);
		User uniqueUsernameCheck =service.uniqueUsernameCheck(userCheck);
		
		if(passwordCheck && emailCheck && repeatedPassCheck && uniqueUsernameCheck != null) {
			
			User user = service.setupUser(username, password, email);
				if(user != null) {
					boolean saveUserInDB = service.saveUserInDB(user);
					if(saveUserInDB) {
						response.sendRedirect("RegistrationLogin/LoginPageSuccessfulSignup.html");
					}
				}else {
					response.sendRedirect("RegistrationLogin/ErrorRegistration.html");
				}
		}else {
			response.sendRedirect("RegistrationLogin/ErrorRegistration.html");
		}
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

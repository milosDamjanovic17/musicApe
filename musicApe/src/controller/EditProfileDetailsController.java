package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commonValidationMethods.ValidationMethods;
import model.ProfileDetails;
import model.User;
import service.EditProfileService;

/**
 * Servlet implementation class EditProfileDetailsController
 */
@WebServlet("/EditProfileDetailsController")
public class EditProfileDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditProfileDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EditProfileService service = new EditProfileService();
		ValidationMethods validation = new ValidationMethods();
		
		String name = request.getParameter("name");
		String djName = request.getParameter("djname");
		String description = request.getParameter("description");
		String soundcloud = request.getParameter("soundcloud");
		String genre = request.getParameter("genre");
		String id = request.getParameter("id");
		
		boolean inputCheck = validation.checkEditProfileParameterInputs(name, djName, description, soundcloud, genre);
		
		if(inputCheck) {
			//pronalazim u bazi Usera kog cu spojiti sa ProfileDetailsom...
			User user = service.returnUserFromID(id);
			ProfileDetails details = service.returnProfileDetailsFromUser(user);
		
			if(details != null) {
				//setovanje i update ProfileDetailsa
				boolean updateProfileDetails = service.updateProfileDetails(name, djName, description, soundcloud, genre, details);
				if(updateProfileDetails) {
				response.sendRedirect("jsp/editProfileDetailsSuccess.jsp");
				}
			}else {
				response.sendRedirect("jsp/editProfileDetailsFail.jsp");
			}
		
		}else {
			response.sendRedirect("jsp/editProfileDetailsFail.jsp");
		}
	}

}

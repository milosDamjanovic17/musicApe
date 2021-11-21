package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserType;
import service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "servlet samo za login stranu", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginService service = new LoginService();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User usernamePassCheck = service.usernamePassCheck(username, password);
		
		if(usernamePassCheck != null) {
			//ako user postoji preusmeri ga na njegovu personalizovanu stranu pomocu HttpSession objecta
			HttpSession session = request.getSession();
			//ubacivanje usera u session object
			session.setAttribute("userKey", usernamePassCheck);
			if(usernamePassCheck.getUsertype().equals(UserType.USER)) {
				response.sendRedirect("jsp/LoginSuccess.jsp");
			}else {
				response.sendRedirect("jsp/AdminLogin.jsp");
			}
			
		}else {
			response.sendRedirect("RegistrationLogin/LoginPageFailed.html");
		}

	}

}

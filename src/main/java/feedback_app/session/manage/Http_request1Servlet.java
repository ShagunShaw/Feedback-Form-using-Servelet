package feedback_app.session.manage;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// @WebServlet("/httpServlet1")
// this time instead of mapping it directly here, we will map this through we.xml file
public class Http_request1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username= "Shagun";
		int userID= 1256;
		
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		session.setAttribute("userID", userID);
		session.setMaxInactiveInterval(10 * 60);	// 10 * 60 secs = 10 min 
	}
	
}

package feedback_app.session.manage;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookieServlet1")
public class Cookie_request1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username= "Shagun";
		int userID= 1256;
		
		Cookie userCookie = new Cookie("username", username);
		Cookie idCookie = new Cookie("userID", String.valueOf(userID));

		// set expiry time 
		userCookie.setMaxAge(60 * 60);    // max age is set in terms of seconds i.e. 60 * 60 secs = 1 hour
		idCookie.setMaxAge(60 * 60);

		// add them to response
		resp.addCookie(userCookie);
		resp.addCookie(idCookie);
	}
	
}

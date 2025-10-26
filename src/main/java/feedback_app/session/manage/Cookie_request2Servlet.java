package feedback_app.session.manage;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookieServlet2")
public class Cookie_request2Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter writer= resp.getWriter();
		
		Cookie[] cookies = req.getCookies(); 
		
		if(cookies != null)
		{
			for(Cookie c: cookies)
			{
				
				// NOTE: the type of 'c.getName()' and 'c.getValue()' is always string, even if you pass integer
				// value (or any value other than string). Java automatically converts it to string.
				
				if (c.getName().equals("username")) {
			        String user = c.getValue();
			        writer.println("<h2> Username is " + user + ". </h2>");
			    }
				else if (c.getName().equals("userID")) {
			        int id = Integer.parseInt(c.getValue());
			        writer.println("<h2> User ID is %d </h2>".formatted(id));
			    }
			}	
		}
		else
		{
			writer.println("<h5> No cookies found. </h5>");
		}
	}
	
}

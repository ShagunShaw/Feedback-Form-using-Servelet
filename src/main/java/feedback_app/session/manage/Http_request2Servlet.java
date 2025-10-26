package feedback_app.session.manage;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// @WebServlet("/httpServlet2")
// this time instead of mapping it directly here, we will map this through we.xml file
public class Http_request2Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter writer= resp.getWriter();
		
		HttpSession session = req.getSession(false);	// Using 'false' prevents accidentally creating a new session (if no session exists), when you only want to read existing data
		
		if (session != null) 
		{
		    java.util.Enumeration<String> attributeNames = session.getAttributeNames();

		    while (attributeNames.hasMoreElements()) {
		        String name = attributeNames.nextElement();
		        Object valueObj = session.getAttribute(name);         // the return type of this function is an Object
	            String value = (valueObj != null) ? valueObj.toString() : "null"; 		
		        
		        writer.println("<h2>" + name + " = " + value + "</h2>");
		    }
		}
		else
		{
			writer.println("<h2> No sessions are present in this request </h2>");
		}
	}
	
}

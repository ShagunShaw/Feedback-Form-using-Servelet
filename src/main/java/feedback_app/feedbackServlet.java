package feedback_app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/feedback")
public class feedbackServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email= req.getParameter("email");
		String phone= req.getParameter("phone");
		String feedback= req.getParameter("feedback_message");
		
		resp.setContentType("text/html");
		PrintWriter writer= resp.getWriter();
		
		// write an code here, to naviagte to your next html page, where you ca print the email, phone
		// and feedback. Not here
	}

}

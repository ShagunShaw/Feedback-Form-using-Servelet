package feedback_app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/feedback")
public class feedbackServlet extends HttpServlet {
	
    /* Getting values of url, user and password from my .env file. Before this we need to configure our
	   'dotenv-java-3.0.0.jar' file in our 'feedback_app/src/main/webapp/WEB-INF/lib' folder.   */
	
	 private static final Dotenv dotenv = Dotenv.configure()
			 									.directory("F:\\Spring (Java)\\feedback_app")
			 									.load(); 			// loads .env file from the specified path
	 
	 private static final String URL = dotenv.get("DB_URL");
	 private static final String USER = dotenv.get("DB_USER");
	 private static final String PASSWORD = dotenv.get("DB_PASSWORD");
	 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email= req.getParameter("email");
		String phone= req.getParameter("phone");
		String feedback= req.getParameter("feedback_message");

        // Storing the feedback in our db.
	    
        /* Before connecting your db to your application, you need to copy-paste the 'mysql-connector-j-9.4.0.jar' file
           in my 'feedback_app/src/main/webapp/WEB-INF/lib' folder.  */
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");
        } 
        catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
        }
        
        
        try 
        {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database.");

            // Creating our Query Statement
            String Query = "insert into feedbacks (email_id, phone, feedback) values (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(Query);
            
            ps.setString(1, email);     
            ps.setBigDecimal(2, new java.math.BigDecimal(phone)); 	// phone → DECIMAL(10,0)
            ps.setString(3, feedback);  

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0) {
                System.out.println("Insert successful, rows affected: " + rowsAffected);
            } 
            else {
                System.out.println("No rows inserted.");
            }

            // Closing the resources
            ps.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
        
        
        
        // you can also set cookies in this part, before going to the next page. To learn how we set cookies
        // and later how to retrieve it, go to the 'feedback_app.session.manage' package. Upon the two methods
        // shown there (i.e. the cookie management and http management), you can pick any one.
        // But here, instead of setting cookies, we are sending the datas manually as shown below.
		
        
        // send data to JSP
        req.setAttribute("email", email);
        req.setAttribute("phone", phone);
        req.setAttribute("feedback", feedback);
        
        // navigate to output page
        req.getRequestDispatcher("/comp_folder/feedbackOutput.jsp").forward(req, resp);
	}

}

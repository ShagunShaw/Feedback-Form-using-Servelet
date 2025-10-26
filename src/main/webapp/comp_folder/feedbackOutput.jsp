<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Feedback Application</title>
    
    <%@include file="./links.jsp" %>
  </head>
  <body>
  	<%@include file="./header.jsp" %>
  	
  	<div>
  		<h2>You have sucessfully submitted your feedback and the feedback details are: </h2>
  		
  		<!-- Now we can access the values of 'email', 'phone' and 'feedback' sent from the 
  		     feedbackServlet.java file via: ${email} , ${phone} and ${feedback} -->
  		<p><span class="fw-bold fs-3">Email:</span> <span class="fs-5">${email}</span></p>
		<p><span class="fw-bold fs-3">Phone:</span> <span class="fs-5">${phone}</span></p>
		<p><span class="fw-bold fs-3">Feedback:</span> <span class="fs-5">${feedback}</span></p>
  	</div>
  	
  	<%@include file="./scripts.jsp" %>
  </body>
</html>
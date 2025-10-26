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
  	
  	<div class="content_container py-4 d-flex flex-column justify-content-center align-items-center">
  		
  		<h3>Fill the feedback form</h3>
  		
  		<form action="<%= application.getContextPath() %>/feedback" method="post">
  		  <!-- Email Section -->
		  <div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">Email address</label>
		    <input placeholder="Enter here" name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
		    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
		  </div>
		  
		  <!-- Phone Section -->
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Phone Number</label>
		    <input placeholder="Enter here" type="text" name="phone" class="form-control" id="exampleInputPassword1">
		  </div>
		  
		  <!-- Phone Section -->
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Your FeedBack Message</label>
			<textarea name="feedback_message" rows="10" placeholder="Enter here" cols="" class="form-control"></textarea>
		  </div>
		  
		  <!-- Submit Button -->
		  <div class="container text-center">
		  	<button type="submit" class="btn btn-warning">Submit</button>
		  	<button type="submit" class="btn btn-light">Reset</button>
		  </div>
		  
		</form>

  	</div>
  	
  	<%@include file="./scripts.jsp" %>
  </body>
</html>
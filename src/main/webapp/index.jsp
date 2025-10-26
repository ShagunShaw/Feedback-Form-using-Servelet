<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Feedback Application</title>
    
    <%@include file="./comp_folder/links.jsp" %>
  </head>
  <body>
  	<%@include file="./comp_folder/header.jsp" %>
  	
  	<div style="height:80vh" class="content_container py-4 d-flex flex-column justify-content-center align-items-center">
	  <a href="<%= application.getContextPath() %>/comp_folder/feedback.jsp" class="btn btn-dark">
	    Give us Feedback
	  </a>
	</div>
  	
  	<%@include file="./comp_folder/scripts.jsp" %>
  </body>
</html>
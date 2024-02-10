<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% String message = (String)request.getAttribute("message"); %>
<% if(message != null) { %>
<%= message %>
<%} %>

<form action="adminSignUp" method="post" enctype="multipart/form-data">
Admin-Id : <input type="text" name="adminId" required autofocus placeholder="Enter the Id"> <br><br>
Admin-Name : <input type="text" name="adminName" required placeholder="Enter the Name"> <br><br>
Admin-Contact : <input type="text" name="adminContact" required placeholder="Enter the Contact"> <br><br>
Admin-Email : <input type="text" name="adminEmail" required placeholder="Enter the Email"> <br><br>
Admin-Password : <input type="password" name="adminPassword" required> <br><br>
Admin-Image : <input type="file" name="adminImage" required> <br><br>
<a href="Admin.jsp"><input type="button" value="Cancel"></a>
<input type="reset">
<input type="submit">

</form>

</body>
</html>
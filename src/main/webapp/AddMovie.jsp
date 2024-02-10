<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Movie</title>
</head>
<body>


<% String message = (String)request.getAttribute("message"); %>
<% if(message != null) { %>
<%= message %>
<%} %>

<form action="addmovie" method="post" enctype="multipart/form-data">
Movie Id : <input type="text" name="movieId" required autofocus placeholder="Enter the Id"> <br><br>
Movie Name : <input type="text" name="movieName" required placeholder="Enter the Name"> <br><br>
Movie Cost : <input type="text" name="moviePrice" required placeholder="Enter the Cost"> <br><br>
Movie Rating : <input type="text" name="movieRating" required placeholder="Enter the Rating"> <br><br>
Movie General : <input type="text" name="movieGeneral" required placeholder="Enter the Genere"> <br><br>
Movie Language : <input type="text" name="movieLanguage" required placeholder="Enter the Language">  <br><br>
Poster : <input type="file" name="movieImage" required> <br><br>
<a href="AdminHome.jsp"><input type="button" value="Cancel"></a>
<input type="reset">
<input type="submit">

</form>


</body>
</html>
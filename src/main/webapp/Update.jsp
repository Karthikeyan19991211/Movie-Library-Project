<%@page import="java.util.Base64"%>
<%@page import="dto.Movie_DTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% String error = (String)request.getAttribute("error"); %>
<%if(error != null) { %>
<%= error %>
<% } %>

<% Movie_DTO movie = (Movie_DTO)request.getAttribute("message"); %>

<form action="updatemovie" method="post" enctype="multipart/form-data">
Movie Id : <input type="text" name="movieId" value="<%= movie.getMovieId() %>" readonly> <br><br>
Movie Name : <input type="text" name="movieName" value="<%= movie.getMovieName() %>" > <br><br>
Movie Cost : <input type="text" name="moviePrice" value="<%= movie.getMovieCost() %>" > <br><br>
Movie Rating : <input type="text" name="movieRating" value="<%= movie.getMovieRating() %>" > <br><br>
Movie General : <input type="text" name="movieGeneral" value="<%= movie.getMovieGeneral() %>" > <br><br>
Movie Language : <input type="text" name="movieLanguage" value="<%= movie.getMovieLanguage() %>" >  <br><br>
Poster : <input type="file" name="movieImage"> <br><br>
<%String image = new String(Base64.getEncoder().encodeToString(movie.getMovieImage())); %>
<img alt="" src="data:image/jpeg;base64,<%= image%>" height="150px" width="150px"> <br><br>
<a href="AdminHome.jsp"><input type="button" value="Cancel"></a>
<input type="reset">
<input type="submit">

</form>

</body>
</html>
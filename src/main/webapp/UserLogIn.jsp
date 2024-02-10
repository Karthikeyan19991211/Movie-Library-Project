<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

#form{
border: 1px solid black;
height:270px;
width:420px;
position: relative;
left:450px;
top:100px;
text-align: center;
padding-top: 50px;
background: transparent;
backdrop-filter: blur(20px);
box-shadow: 0 0 10px rgba(0,0,0,.6); 
}

.admin{
border: 1px solid black;
height:25px;
width:200px;
}

.para{
font-size: 30px;
}

.button{
border:1px solid black;
width:150px;
height:40px;
background-color: grey;
font-size: 20px;
border-radius: 15px;

}

#button2{
margin-left:30px;
}

.button:hover {
	border: 3px solid red;
	color: white;
	font-size:25px;
	background-color: black; 
	cursor: pointer;
}

#error{
border: 1px solid black;
color: red;
background-color: yellow;
width:70px;
height:20px;
font-size: 20px;
font-family: sans-serif;
padding: 5px;
}

#info{
font-size: 17px;
font-family: sans-serif;
}

</style>

</head>
<body>

<form action="userlogin" method="post" id="form">

<% String message = (String)request.getAttribute("message"); %>
<% if(message != null) { %>
<span id="error"><%= message %></span> <br><br>
<%} %>

<span class="para">Email : </span><input type="text" name="userEmail" required autofocus class="admin"> <br><br>
<span class="para">Password : </span><input type="password" name="userPassword" required class="admin"> <br><br>

<input type="submit" class="button" >
<a href="User.jsp" target="_self"><input type="button" value="Cancel" class="button" id="button2"> </a>

<p style="color:black;" id="info">Don't have an account?<a href="UserSignUp.jsp">Sign up</a></p>	

</form>

</body>
</html>
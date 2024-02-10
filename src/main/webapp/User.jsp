<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>


<style>

#div{
border : 1px solid black;
width : 60vh;
height : 80vh;
position: absolute;
top:70px;
left:470px;
text-align: center;
background: transparent;
backdrop-filter: blur(20px);
box-shadow: 0 0 10px rgba(0,0,0,.2);
}

.button {
border:1px solid white;
width:250px;
height:70px;
font-size: 30px;
font-family: 'Playfair Display', serif;
position: relative;
top:0px;
background-color: black;
color:white;
border-radius: 15px;
}

.button:hover {
border:2px solid red;
background-color: #c5bcc2;
color: black;
font-size: 40px;	
}

#para{
text-indent: 5px;
font-size: 50px;
color:white;
}

#main{
background-image: url("https://t3.ftcdn.net/jpg/04/17/77/78/240_F_417777825_v7o8RvkQhxpZkE0ZBD4xwzri5hGFHkO3.jpg");
background-size: 100% 100%;
background-repeat: no-repeat;
height:97.3vh;
}

</style>

</head>
<body id="main">

<div id="div">
<p id="para">Welcome User!</p>
<a href="UserLogIn.jsp" target="_self"><input type="button" value="Log-In" class="button"></a> <br><br>
<a href="UserSignUp.jsp" target="_self"><input type="button" value="Sign-Up" class="button"></a>

</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>

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
top:120px;
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

#main{
background-image: url("https://t4.ftcdn.net/jpg/06/28/29/89/240_F_628298957_fhUiZLDrpN3KjDsstX4raUkwMkzOBm1d.jpg");
background-size: 100%;
background-repeat: no-repeat;
}


</style>


</head>
<body id="main">

<div id="div">

<a href="Admin.jsp" target="_self"><input type="button" value="Admin" class="button"></a> <br><br>
<a href="User.jsp" target="_self"><input type="button" value="User" class="button"></a>

</div>

</body>
</html>
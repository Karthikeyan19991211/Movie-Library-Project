<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="userSignUp" method="post">
User-Id : <input type="text" name="userId" required autofocus placeholder="Enter the Id"> <br><br>
User-Name : <input type="text" name="userName" required placeholder="Enter the Name"> <br><br>
User-Contact : <input type="text" name="userContact" required placeholder="Enter the Contact"> <br><br>
User-Email : <input type="text" name="userEmail" required placeholder="Enter the Email"> <br><br>
User-Password : <input type="password" name="userPassword" required> <br><br>
<a href="User.jsp"><input type="button" value="Cancel"></a>
<input type="reset">
<input type="submit">
</form>

</body>
</html>
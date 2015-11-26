<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div>
	<form method="post" action="${request.contextPath}LoginController/login.do">
		<table>
		<tr>
			<td>UserID : <input type="text" name="userID"/> </td>
		</tr>
		<tr>
			<td>UserPassword : <input type="password" name="userPassword"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="로그인"/></td>
		</tr>
		</table>
	</form>
</div>
</body>
</html>

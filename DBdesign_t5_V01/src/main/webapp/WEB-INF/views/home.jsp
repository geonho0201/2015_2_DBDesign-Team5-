<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	프람트 솔루션
</h1>

<div>
	<span style="background-color: #D99; color:white;">${errormsg}</span>
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
	<a href="${pageContext.request.contextPath}/join">회원가입</a>
</div>
</body>
</html>

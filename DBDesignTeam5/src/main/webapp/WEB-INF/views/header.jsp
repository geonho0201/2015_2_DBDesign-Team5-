<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
</head>
<body>
<div style="background-color: #9C9; width: 100%">
	<table><tr>
	<td>${sessionScope.user.getName()} 님, 환영합니다!</td>
	<td><a href="${pageContext.request.contextPath}/LoginController/logout.do">로그아웃</a></td>
	</tr></table>
</div>
</body>
</html>
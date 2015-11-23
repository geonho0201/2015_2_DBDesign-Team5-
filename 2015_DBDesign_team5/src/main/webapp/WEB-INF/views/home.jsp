<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>프람트솔루션 프로젝트 5조</title>
</head>
<body>

<div style="margin:0 auto; border:1 solid">
	<h1>	</h1>
	<P>  The time on the server is ${serverTime}. </P>
	
	<div style="margin:5px; padding: 3px; border:1 solid">
		<form action="loginController/login.do" method="post">
			UserID : <input type="text" name="userID"/><br/>
			UserPassword : <input type="password" name="userPassword"/><br/>
			<input type="submit" value="로그인">	
		</form>
	</div>
	<a href="${pageContext.request.contextPath}/join">회원가입</a>
</div>
</body>
</html>

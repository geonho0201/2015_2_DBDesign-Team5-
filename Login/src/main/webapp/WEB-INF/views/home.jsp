<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Home 60102365 이건호</title>
</head>
<body>

<div style="margin:0 auto; border:1 solid">
	<div style="margin:5px; padding: 3px; border:1 solid; background-color: #88f">
	<h1>
		명지대학교 수강신청 시스템  
	</h1>
	
	<P>  The time on the server is ${serverTime}. </P>
	<P> Oracle DB로 작업했습니다.</P>
	</div>
	
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

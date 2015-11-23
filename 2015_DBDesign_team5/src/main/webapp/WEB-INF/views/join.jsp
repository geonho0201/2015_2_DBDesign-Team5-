<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>회원가입 페이지</title>
</head>
<body>
<div style="margin:0 auto; border:1 solid">
	<div style="margin:5px; padding: 3px; border:1 solid; background-color: #88f">
		<h1>
			명지대학교 수강신청 시스템  
		</h1>
	</div>
	
	<div style="margin:5px; padding: 3px; border:1 solid">
		<form action="${pageContext.request.contextPath}/loginController/join.do" method="post">
		<table>
			<tr>
				<td>아이디 : </td>
				<td><input type="text" name="userID"></td>
			</tr>
			<tr>
				<td>패스워드 : </td>
				<td><input type="password" name="userPW"></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>분류</td>
				<td><input type="radio" name="userType" value="교수" checked>교수
				<input type="radio" name="userType" value="학생">학생
				<input type="radio" name="userType" value="관리자">관리자
				</td>
			</tr>
			<tr>
				<td rowspan="2"><input type="submit" value="회원가입"></td>
			</tr>
		</table>
		</form>
	</div>
</div>
</body>
</html>
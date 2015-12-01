<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
 integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" 
integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
 integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>
</head>
<body style="background-color: #fafafa">
	<jsp:include page="header.jsp"></jsp:include>
	<div style="float:left;">
		<jsp:include page="navigator.jsp"></jsp:include>
		<div class="col-md-9">
			<form method = "post" action="${pageContext.request.contextPath}/MyInfoController/modify.do">
			<h2>내 정보</h2>
			<table class="table">
			<tr><td><h4>ID:</h4> </td>		<td><h4>${user.getId()}</h4></td></tr>
			<tr><td><h4>NAME:</h4> </td>		<td><h4>${user.getName()}</h4></td></tr>
			<tr><td><h4>SSN:</h4> </td>		<td><h4>${user.getSSN().substring(0,6)}-${user.getSSN().substring(6,13)}</h4></td></tr>
			<tr><td><h4>AGE:</h4> </td>		<td><h4>${user.getAge()}세</h4></td></tr>
			<tr><td><h4>PHONE:</h4> </td>	<td><h4>${user.getPhone_number()}</h4></td></tr>
			<tr><td><h4>ADDRESS:</h4> </td>	<td><h4>${user.getAddress()}</h4></td></tr>
			<tr><td><h4>EMAIL:</h4> </td>	<td><h4>${user.getEmail()}</h4></td></tr>
			<tr><td><h4>Signup Date:</h4> </td><td><h4>${user.getSignup_date()}</h4></td></tr>
			<tr><td><h4>Department:</h4> </td>	
			<td><c:choose>
				<c:when test="${user.getWorks_department()=='01'}"><h4>경영관리부 </h4></c:when>
				<c:when test="${user.getWorks_department()=='02'}"><h4>인사부 </h4></c:when>
				<c:when test="${user.getWorks_department()=='03'}"><h4>재무회계부 </h4></c:when>
				<c:when test="${user.getWorks_department()=='04'}"><h4>마케팅부 </h4></c:when>
				<c:when test="${user.getWorks_department()=='05'}"><h4>디자인부 </h4></c:when>
				<c:when test="${user.getWorks_department()=='06'}"><h4>영업기획부 </h4></c:when>
				<c:when test="${user.getWorks_department()=='07'}"><h4>연구개발부 </h4></c:when>
				<c:when test="${user.getWorks_department()=='08'}"><h4>개발부 </h4></c:when>
			</c:choose> </td></tr>
			<tr><td><h4>Position:</h4> </td>	<td><h4>${user.getPosition()}</h4></td></tr>
			<tr><td><input type="submit" class="btn btn-default" value="정보수정"></td><td></td></tr>
			</table>
			<div style="float:right;">
				<input type="button" value="홈으로" class="btn btn-default"  onclick="location.href='/mju/main'"/></div>
			</form>
		</div>
		 </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../css/css.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	내 정보<br/>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	</div>
	

	<form method = "post" action="${pageContext.request.contextPath}/MyInfoController/modify.do">
	<table class="table">
	<tr><td>ID: </td>		<td>${user.getId()}</td></tr>
	<tr><td>NAME: </td>		<td>${user.getName()}</td></tr>
	<tr><td>SSN: </td>		<td>${user.getSSN().substring(0,6)}-${user.getSSN().substring(6,13)}</td></tr>
	<tr><td>AGE: </td>		<td>${user.getAge()}세</td></tr>
	<tr><td>PHONE: </td>	<td>${user.getPhone_number()}</td></tr>
	<tr><td>ADDRESS: </td>	<td>${user.getAddress()}</td></tr>
	<tr><td>EMAIL: </td>	<td>${user.getEmail()}</td></tr>
	<tr><td>Signup Date: </td><td>${user.getSignup_date()}</td></tr>
	<tr><td>Department: </td>	
	<td><c:choose>
		<c:when test="${user.getWorks_department()=='01'}">경영관리부 </c:when>
		<c:when test="${user.getWorks_department()=='02'}">인사부 </c:when>
		<c:when test="${user.getWorks_department()=='03'}">재무회계부 </c:when>
		<c:when test="${user.getWorks_department()=='04'}">마케팅부 </c:when>
		<c:when test="${user.getWorks_department()=='05'}">디자인부 </c:when>
		<c:when test="${user.getWorks_department()=='06'}">영업기획부 </c:when>
		<c:when test="${user.getWorks_department()=='07'}">연구개발부 </c:when>
		<c:when test="${user.getWorks_department()=='08'}">개발부 </c:when>
	</c:choose> </td></tr>
	<tr><td>Position: </td>	<td>${user.getPosition()}</td></tr>
	<tr><td><input type="submit" class="btn btn-default" value="정보수정"></td><td><input type="button" class="btn btn-default" value="홈으로" onclick="location.href='/mju/main'"/></td></tr>
	</table>
	</form>
	
</body>
</html>

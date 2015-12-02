<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
 integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" 
integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
 integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
</head>
<body>
 	<nav class="navbar navbar-default role="navigation">
 		<div class="navbar-form navbar-left">
 		 <a class="navbar-brand" href="#">
			<c:choose>
				<c:when test="${sessionScope.user.getWorks_department()=='01'}">경영관리부 </c:when>
				<c:when test="${sessionScope.user.getWorks_department()=='02'}">인사부 </c:when>
				<c:when test="${sessionScope.user.getWorks_department()=='03'}">재무회계부 </c:when>
				<c:when test="${sessionScope.user.getWorks_department()=='04'}">마케팅부 </c:when>
				<c:when test="${sessionScope.user.getWorks_department()=='05'}">디자인부 </c:when>
				<c:when test="${sessionScope.user.getWorks_department()=='06'}">영업기획부 </c:when>
				<c:when test="${sessionScope.user.getWorks_department()=='07'}">연구개발부 </c:when>
				<c:when test="${sessionScope.user.getWorks_department()=='08'}">개발부 </c:when>
			</c:choose></a><p class="navbar-text">
			${sessionScope.user.getName()} 
			${sessionScope.user.getPosition()}님, 환영합니다!</p>
		</div>
		<div class="navbar-form navbar-right">
			<a class="btn btn-default "  href="${pageContext.request.contextPath}/LoginController/logout.do">로그아웃</a>
		</div>
	</nav>
</body>
</html>
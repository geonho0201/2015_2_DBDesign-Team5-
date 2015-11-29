<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/css.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
</head>
<body>
 	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
 		<div class="navbar-form navbar-left">
			<c:choose>
				<c:when test="${sessionScope.user.getWorks_department()=='01'}">경영관리부 </c:when>
				<c:when test="${sessionScope.user.getWorks_department()=='02'}">인사부 </c:when>
				<c:when test="${sessionScope.user.getWorks_department()=='03'}">재무회계부 </c:when>
				<c:when test="${sessionScope.user.getWorks_department()=='04'}">마케팅부 </c:when>
				<c:when test="${sessionScope.user.getWorks_department()=='05'}">디자인부 </c:when>
				<c:when test="${sessionScope.user.getWorks_department()=='06'}">영업기획부 </c:when>
				<c:when test="${sessionScope.user.getWorks_department()=='07'}">연구개발부 </c:when>
				<c:when test="${sessionScope.user.getWorks_department()=='08'}">개발부 </c:when>
			</c:choose>
			${sessionScope.user.getName()} 
			${sessionScope.user.getPosition()}님, 환영합니다!
		</div>
		<div class="navbar-form navbar-right">
			<a class="btn btn-danger" href="${pageContext.request.contextPath}/LoginController/logout.do">로그아웃</a>
		</div>
	</nav>
</body>
</html>
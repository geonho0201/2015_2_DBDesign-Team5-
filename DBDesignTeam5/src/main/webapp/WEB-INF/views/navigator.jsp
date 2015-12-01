<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Navigator</title>
</head>
<body style="background-color: #fafafa">
<div class="container">	
	        <div class="row">
	           <div class="col-md-3">
	           		<div class="list-group">
	                    <a href="${pageContext.request.contextPath}/MyInfoController/myInfo.do" class="list-group-item">내정보</a>
	                    <c:choose>
	                    	<c:when test="${sessionScope.user.getWorks_department() =='01'}">							
									<a href="${pageContext.request.contextPath}/EmployeeController/employee.do"class="list-group-item">직원관리</a>
									<a href="${pageContext.request.contextPath}/ProjectController/projectLoad.do"class="list-group-item">사내프로젝트조회</a>
									<a href="${pageContext.request.contextPath}/Controller/.do"class="list-group-item">평가내역조회</a>
									<a href="${pageContext.request.contextPath}/Controller/.do"class="list-group-item">기술조회</a>
								</c:when>
								<c:when test="${sessionScope.user.getWorks_department() =='02'}">
									<a href="${pageContext.request.contextPath}/EmployeeController/employee.do"class="list-group-item">직원관리</a>
									<a href="${pageContext.request.contextPath}/ProjectController/projectLoad.do"class="list-group-item">사내프로젝트조회</a>
									<a href="${pageContext.request.contextPath}/Controller/.do"class="list-group-item">평가내역조회</a>
									<a href="${pageContext.request.contextPath}/Controller/.do"class="list-group-item">기술조회</a>
								</c:when>
								<c:when test="${sessionScope.user.getWorks_department() =='03'}">
									<a href="${pageContext.request.contextPath}/EmployeeController/employee.do"class="list-group-item">직원검색</a>
								</c:when>
								<c:when test="${sessionScope.user.getWorks_department() =='04'}">
									<a href="${pageContext.request.contextPath}/EmployeeController/employee.do"class="list-group-item">직원검색</a>
								</c:when>
								<c:when test="${sessionScope.user.getWorks_department() =='05'}">
									<a href="${pageContext.request.contextPath}/ProjectController/projectLoad.do"class="list-group-item">내 프로젝트</a>
									<a href="#" class="list-group-item">내 기술</a>
								</c:when>
								<c:when test="${sessionScope.user.getWorks_department() =='06'}">
									<a href="${pageContext.request.contextPath}/EmployeeController/employee.do"class="list-group-item">직원검색</a>
									<a href="${pageContext.request.contextPath}/ProjectController/projectLoad.do"class="list-group-item">사내프로젝트조회</a>
									<a href="${pageContext.request.contextPath}/Controller/.do"class="list-group-item">평가내역조회</a>
									<a href="${pageContext.request.contextPath}/Controller/.do"class="list-group-item">기술조회</a>
									<a href="${pageContext.request.contextPath}/ProjectController/.do"class="list-group-item">프로젝트생성</a>
								</c:when>
								<c:when test="${sessionScope.user.getWorks_department() =='07'}">
									<a href="${pageContext.request.contextPath}/EmployeeController/employee.do"class="list-group-item">직원검색</a>
								</c:when>
								<c:when test="${sessionScope.user.getWorks_department() =='08'}">
									<a href="${pageContext.request.contextPath}/ProjectController/projectLoad.do"class="list-group-item">내 프로젝트</a>
									<a href="#" class="list-group-item">내 기술</a>
								</c:when>
	                    </c:choose>
	                </div>
	                </div>
	           

</body>
</html>
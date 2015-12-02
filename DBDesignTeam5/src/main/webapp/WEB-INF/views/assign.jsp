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
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	<div class="col-md-9">	
	<h2>투입직원 목록</h2>
	<form method ="post" action = "${pageContext.request.contextPath}/EvalController/eval.do">
	<table class="table">
	<tr><td><h4>직원 이름</h4></td><td><h4>직원 번호</h4></td><td><h4>프로젝트 번호</h4></td><td><h4>투입일</h4></td><td><h4>투출일</h4></td><td><h4>직책</h4></td>
	<c:if test="${sessionScope.user.getWorks_department()=='05' || sessionScope.user.getWorks_department()=='08'}">
		<td>평가</td>
		</c:if></tr>
	<c:forEach items="${list}" var="result">
		<tr>
		<td><h4><c:out value="${result.name}"/></h4></td>
		<td><h4><c:out value="${result.employee_number}"/></h4></td>
		<td><h4><c:out value="${result.project_number}"/></h4></td>
		<td><h4><c:out value="${result.assign_date}"/></h4></td>
		<td><h4><c:out value="${result.abort_date}"/></h4></td>
		<td><h4><c:out value="${result.job}"/></h4></td>
		<c:if test="${sessionScope.user.getWorks_department()=='05' || sessionScope.user.getWorks_department()=='08'}">
		<td><h4>
			<c:if test="${result.employee_number!=sessionScope.user.getEmployee_number()}"></h4>
			<div class="col-xs-3"><input type="radio" class="form-control"name="employee_number" checked="checked" value="${result.employee_number}"/></div>
			<input type="hidden" class="form-control"name="project_number" value=<c:out value="${result.project_number}"/>/>
			</c:if>
		</td>
		</c:if>
		</tr> 
	</c:forEach>
	</table>
	<input type="submit" class="btn btn-default"value="평가하기"/>
	<input type="button" class="btn btn-default"value="홈으로" onclick="location.href='/mju/main'" />
	</form>	
	<c:if test="${job=='01'}">
	<form method = "POST" action="${pageContext.request.contextPath}/AssignController/createForm.do">
	<input type="hidden" name="project_number" value="${project_number}"/>
	<input type="submit" class="btn btn-default" value="직원 투입/삭제"/>
	</c:if>
	</form>
	</div>
</div>
</body>

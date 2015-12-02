<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>
</head>
<body style="background-color: #888">
	<jsp:include page="header.jsp"></jsp:include>
	투입직원 목록<br/>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	</div>
	
	<div>
	<form method ="post" action = "${pageContext.request.contextPath}/EvalController/eval.do">
	<table border="1">
	<tr>
		<td>직원 이름</td><td>직원 번호</td><td>프로젝트 번호</td><td>투입일</td><td>투출일</td><td>직책</td>
		<c:if test="${sessionScope.user.getWorks_department()=='05' || sessionScope.user.getWorks_department()=='08'}">
		<td>평가</td>
		</c:if>
	</tr>
	<c:forEach items="${list}" var="result">
		<tr>
		<td><c:out value="${result.name}"/></td>
		<td><c:out value="${result.employee_number}"/></td>
		<td><c:out value="${result.project_number}"/></td>
		<td><c:out value="${result.assign_date}"/></td>
		<td><c:out value="${result.abort_date}"/></td>
		<td><c:out value="${result.job}"/></td>
		<c:if test="${sessionScope.user.getWorks_department()=='05' || sessionScope.user.getWorks_department()=='08'}">
		<td>
			<c:if test="${result.employee_number!=sessionScope.user.getEmployee_number()}">
			<input type="radio" name="employee_number" checked="checked" value="${result.employee_number}"/>
			<input type="hidden" name="project_number" value=<c:out value="${result.project_number}"/>/>
			</c:if>
		</td>
		</c:if>
		</tr>
	</c:forEach>
	
	</table>
	<c:if test="${sessionScope.user.getWorks_department()=='05' || sessionScope.user.getWorks_department()=='08'}">
	<input type="submit" value="평가하기"/>
	</c:if>
	<input type="button" value="홈으로" onclick="location.href='/mju/main'" />
	</form>
	<c:if test="${job=='01'}">
	<form method = "POST" action="${pageContext.request.contextPath}/AssignController/createForm.do">
	<input type="hidden" name="project_number" value="${project_number}"/>
	<input type="submit" value="직원 투입/삭제"/>
	</form>
	</c:if>
	</div>

</body>
</html>
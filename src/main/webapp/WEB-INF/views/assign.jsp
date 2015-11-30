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
	<table border="1">
	<tr><td>직원 이름</td><td>직원 번호</td><td>프로젝트 번호</td><td>투입일</td><td>투출일</td><td>직책</td></tr>
	<c:forEach items="${list}" var="result">
		<tr>
		<td><c:out value="${result.name}"/></td>
		<td><c:out value="${result.employee_number}"/></td>
		<td><c:out value="${result.project_number}"/></td>
		<td><c:out value="${result.assign_date}"/></td>
		<td><c:out value="${result.abort_date}"/></td>
		<td><c:out value="${result.job}"/></td>
		</tr> 
	</c:forEach>
	</table>
	<input type="button" value="홈으로" onclick="location.href='/mju/main'" />
	</div>

</body>
</html>
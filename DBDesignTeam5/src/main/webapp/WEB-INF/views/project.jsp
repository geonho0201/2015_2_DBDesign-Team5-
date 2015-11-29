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
	내 프로젝트<br/>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	</div>
	<div>
	<table border="1">
	<tr><td>프로젝트 번호</td><td>프로젝트 이름</td><td>시작일</td><td>만료일</td><td>고객처</td><td>프로젝트 설명</td><td>상세</td></tr>
	<c:forEach items="${list}" var="result">
	<form method="post" action="${pageContext.request.contextPath}/ProjectController/assign.do">
		<tr>
		<td><c:out value="${result.project_number}"/></td>
		<td><c:out value="${result.project_name}"/></td>
		<td><c:out value="${result.start_date}"/></td>
		<td><c:out value="${result.due_date}"/></td>
		<td><c:out value="${result.orderer}"/></td>
		<td><c:out value="${result.project_desc}"/></td>
		
		<td><input type="hidden" name="project_number" value=<c:out value="${result.project_number}"/>/>
			<input type="submit" value="*" /></td>
		</tr>
		</form>
	</c:forEach>
	</table>
	
	</div>
</body>
</html>
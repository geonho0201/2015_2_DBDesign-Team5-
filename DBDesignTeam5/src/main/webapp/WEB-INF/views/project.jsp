<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>
</head>
<body style="background-color: #fafafa">
	<jsp:include page="header.jsp"></jsp:include>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
<<<<<<< HEAD
	</div>
	${message}	<!-- 직원투입 또는 삭제시 메시지 -->
	<div>
	<table border="1">
	<tr><td>프로젝트 번호</td><td>프로젝트 이름</td><td>시작일</td><td>만료일</td><td>고객처</td><td>프로젝트 설명</td><td>상세</td></tr>
=======
	<div style="float: left;">
	<div class="col-md-16">	
	<h2>내 프로젝트</h2>
	<table class="table">
>>>>>>> 9dadab3618e8668b514c3c496e7158abb8ea9a4e
	<c:forEach items="${list}" var="result">
	<form method="post" action="${pageContext.request.contextPath}/ProjectController/assign.do">
	<tr><td><h4>프로젝트 번호</h4></td><td><h4>프로젝트 이름</h4></td><td><h4>시작일</h4></td></tr>
	<tr><td><h4><c:out value="${result.project_number}"/></h4></td>
		<td><h4><c:out value="${result.project_name}"/></h4></td>
		<td><h4><c:out value="${result.start_date}"/></h4></td></tr>
	<tr><td><h4>만료일</h4></td><td><h4>고객처</h4></td><td><h4>프로젝트 설명</h4></td><td><h4>상세</h4></td></tr>
		<tr>
		<td><h4><c:out value="${result.due_date}"/></h4></td>
		<td><h4><c:out value="${result.orderer}"/></h4></td>
		<td><h4><c:out value="${result.project_desc}"/></h4></td></tr>
		<tr>
		<td><input type="hidden" name="project_number" value=<c:out value="${result.project_number}"/>/>
			<button type="submit" class="btn btn-default" value="*" />*</button></td><td></td><td></td></tr>

		</form>
	</c:forEach>
	</table>
<<<<<<< HEAD
	${message}<!-- 평가실패시 나타나는 message box -->
=======
	</div>
>>>>>>> 9dadab3618e8668b514c3c496e7158abb8ea9a4e
	</div>
</body>
</html>
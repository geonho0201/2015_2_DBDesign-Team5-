<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>createdPro</title>

</head>
<body style="background-color: #888">
	<jsp:include page="header.jsp"></jsp:include>
	프로젝트 생성<br/>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	</div>
	${message}
	<div>
	<form action="${pageContext.request.contextPath}/ProjectController/deletePro.do" name="form">
	<table>
	<tr>
		<td>프로젝트 번호</td>
		<td>프로젝트 이름</td>
		<td>시작일</td>
		<td>만료일</td>
		<td>고객처</td>
		<td>프로젝트 설명</td>
		<td>기획자</td>
	</tr>
	<c:forEach items="${list}" var="project">
	<tr><td><input type="radio" name="project_number" checked="checked" value = "${project.project_number}"/></td>
	<td>${project.project_number}</td>
	<td>${project.project_name}</td>
	<td>${project.start_date}</td>
	<td>${project.due_date}</td>
	<td>${project.orderer}</td>
	<td>${project.project_desc}</td>
	<td>${project.constructor_number}</td>
	</tr>
	</c:forEach>
	
	<tr><td><input type="button" value="프로젝트 만들기" onclick="location.href('${pageContext.request.contextPath}/ProjectController/createForm.do')"/></td>
		<td><input type="submit" value="프로젝트 삭제" onclick="document.form.submit();"/>
		<td><input type="button" value="홈으로" onclick="location.href('/mju/main')"/>	</tr>
	</table>
	
	</form>
	</div>
</body>


</html>
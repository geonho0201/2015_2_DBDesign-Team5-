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
		<div class="col-md-9">
		<h2>직원보유기술</h2>
		<table class="table">
			<tr>
				<td><h4>직원사번</h4></td>
				<td><h4>부서</h4></td>
				<td><h4>이름</h4></td>
				<td><h4>직급</h4></td>
			</tr>
			<tr>
				<td><h4>${user.getEmployee_number()}</h4></td>
				<td><h4>${user.getWorks_department()}</h4></td>
				<td><h4>${user.getName()}</h4></td>
				<td><h4>${user.getPosition()}</h4></td>
			</tr>
		</table>
		
		<table class="table">
			<tr>
				<td><h4>기술번호</h4></td>
				<td><h4>기술이름</h4></td>
				<td><h4>경력</h4></td>
			</tr>
			<c:forEach items="${skillsetlist}" var="result">
			<tr>
				<td><h4>${result.getSkill_number()}</h4></td>
				<td><h4>${result.getSkill_name()}</h4></td>
				<td><h4>${result.getSkill_level()}</h4></td>
			</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath}/SkillsetController/skillset_list.do" class="btn btn-default">홈으로</a>
	</div>
	</div>
</body>
</html>
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
	직원보유기술<br/>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	</div>
	<div>
		<table>
			<tr>
				<td>직원사번</td>
				<td>부서</td>
				<td>이름</td>
				<td>직급</td>
			</tr>
			<tr>
				<td>${user.getEmployee_number()}</td>
				<td>${user.getWorks_department()}</td>
				<td>${user.getName()}</td>
				<td>${user.getPosition()}</td>
			</tr>
		</table>
		
		<table>
			<tr>
				<td>기술번호</td>
				<td>기술이름</td>
				<td>경력</td>
			</tr>
			<c:forEach items="${skillsetlist}" var="result">
			<tr>
				<td>${result.getSkill_number()}</td>
				<td>${result.getSkill_name()}</td>
				<td>${result.getSkill_level()}</td>
			</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath}/SkillsetController/skillset_list.do"><input type="button" value="홈으로"/></a>
	</div>
</body>
</html>
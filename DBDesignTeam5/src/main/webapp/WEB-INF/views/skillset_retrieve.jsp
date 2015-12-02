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
	기술검색<br/>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	</div>
	<div>
	<form method="post" action="${pageContext.request.contextPath}/SkillsetController/skillset_userlist.do">
		<select name="skill_number">
			<c:forEach items="${skillsetlist}" var="result">
			<option value="${result.getSkill_number()}">
			<c:catch var="skillname"> ${result.getSkill_name()}</c:catch>
			</option>
			</c:forEach>
		</select>
		<select name="skillset_level">
			<%for(int i=0; i<=500; i++){ %><option><%=i%></option><%} %>
		</select>
		개월
		<select name="more_or_under">
			<option>이상</option>
			<option>이하</option>
		</select>
		<input type="submit" value="조회">
	</form>
	</div>
	
	<div>
	<table>
		<tr>
			<td>직원사번</td>
			<td>부서</td>
			<td>이름</td>
			<td>직급</td>
			<td>기술경력</td>
			<td>상세</td>
		</tr>
		<c:forEach items="${skillset_userlist}" var="result2">
		<form method="post" action="${pageContext.request.contextPath}/SkillsetController/get_of_skillset.do">
		<tr>
			<td>${result2.getEmployee_number()}
			<input type="hidden" value="${result2.getEmployee_number()}" name="employee_number"/></td>
			<td>${result2.getWorks_department()}
			<input type="hidden" value="${result2.getWorks_department()}" name="works_department"/></td>
			<td>${result2.getName()}
			<input type="hidden" value="${result2.getName()}" name="name"/></td>
			<td>${result2.getPosition()}
			<input type="hidden" value="${result2.getPosition()}" name="position"/></td>
			<td>${result2.getPrevious_career()}개월
			<input type="hidden" value="${result2.getPrevious_career()}" name="employee_number"/></td>
			<td><input type="submit" value="보유기술"/></td>
		</tr>
		</form>
		</c:forEach>
	</table>
	</div>
	
</body>
</html>
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
	<div class="col-md-6">	
	<h2>기술검색</h2>
	<form method="post" action="${pageContext.request.contextPath}/SkillsetController/skillset_userlist.do">
		<select name="skill_number"class="form-control">
			<c:forEach items="${skillsetlist}" var="result">
			<option value="${result.getSkill_number()}">
			<c:catch var="skillname"> ${result.getSkill_name()}</c:catch>
			</option>
			</c:forEach>
		</select>
		<select name="skillset_level" class="form-control">
			<%for(int i=0; i<=500; i++){ %><option><%=i%></option><%} %>
		</select>
		<h4>개월</h4>
		<select name="more_or_under"class="form-control">
			<option>이상</option>
			<option>이하</option>
		</select>
		<button type="submit" class="btn btn-default"value="조회">조회</button>
	</form>
	
	<table class="table">
		<tr>
			<td><h4>직원사번</h4></td>
			<td><h4>부서</h4></td>
			<td><h4>이름</h4></td>
			<td><h4>직급</h4></td>
			<td><h4>기술경력</h4></td>
			<td><h4>상세</h4></td>
		</tr>
		<c:forEach items="${skillset_userlist}" var="result2">
		<form method="post" action="${pageContext.request.contextPath}/SkillsetController/get_of_skillset.do">
		<tr>
			<td><h4>${result2.getEmployee_number()}
			<input type="hidden" value="${result2.getEmployee_number()}" name="employee_number"/></h4></td>
			<td><h4>${result2.getWorks_department()}
			<input type="hidden" value="${result2.getWorks_department()}" name="works_department"/></h4></td>
			<td><h4>${result2.getName()}
			<input type="hidden" value="${result2.getName()}" name="name"/></h4></td>
			<td><h4>${result2.getPosition()}
			<input type="hidden" value="${result2.getPosition()}" name="position"/></h4></td>
			<td><h4>${result2.getPrevious_career()}개월
			<input type="hidden" value="${result2.getPrevious_career()}" name="employee_number"/></td>
			<td></td>
		</tr>
		<tr><td><button type="submit" class="btn btn-default"value="보유기술">보유기술</button></td><td></td><td></td><td></td><td></td><td></td></tr>
		</form>
		</c:forEach>
	</table>
	</div>
	</div>
</body>
</html>
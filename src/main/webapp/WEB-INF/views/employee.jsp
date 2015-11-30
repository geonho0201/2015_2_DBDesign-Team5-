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
	직원검색페이지<br/>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	</div>
	<div>
	검색옵션
	<form method="POST" action="${pageContext.request.contextPath}/EmployeeController/employeeRetrieve.do">
		<select name="retrieveOption">
		<option value="00">전체</option>
		<option value="01">경영관리</option>
		<option value="02">인사</option>
		<option value="03">재무회계</option>
		<option value="04">마케팅</option>
		<option value="05">디자인</option>
		<option value="06">영업기획</option>
		<option value="07">연구개발</option>
		<option value="08">개발팀</option>
		</select>
		<input type="submit" value="조회">
	</form>
	
	<table>
		<tr>
			<td>직원사번</td>
			<td>이름</td>
			<td>부서</td>
			<td>직급</td>
			<td>나이</td>
			<td>주민등록번호</td>
			<td>연락처</td>
			<td>주소</td>
			<td>이메일</td>
			<td>입사일</td>
			<td>가입일</td>
			<td>최종학력</td>
			<td>입사전경력</td>
			<td>연봉(만 원)</td>
		</tr>
		<c:forEach items="${userList}" var="result">
		<tr>
			<td>${result.getEmployee_number()}</td>
			<td>${result.getName()}</td>
			<td>${result.getWorks_department()}</td>
			<td>${result.getPosition()}</td>
			<td>${result.getAge()}</td>
			<td>${result.getSSN()}</td>
			<td>${result.getPhone_number()}</td>
			<td>${result.getAddress()}</td>
			<td>${result.getEmail()}</td>
			<td>${result.getHired_date()}</td>
			<td>${result.getSignup_date()}</td>
			<td>${result.getFinal_education()}</td>
			<td>${result.getPrevious_career()}</td>
			<td>${result.getSalary()}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>
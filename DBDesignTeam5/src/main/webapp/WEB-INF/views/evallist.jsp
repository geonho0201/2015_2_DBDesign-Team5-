<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>evallist</title>
</head>
<body style="background-color: #888">
	<jsp:include page="header.jsp"></jsp:include>
	평가내역<br/>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	</div>
	<div>
		<form method="post" action="${pageContext.request.contextPath}/EvalController/getevalList.do">
		직원선택 : 
		<select name="employee_number">
			<c:forEach items="${develList}" var="result">
			<option value="${result.getEmployee_number()}">
				${result.getEmployee_number()} ${result.getWorks_department()} ${result.getName()} ${result.getPosition()}
			</option>
			</c:forEach>
		</select>
		<input type="submit" value="평가내역조회"/>
		</form>
	<table>
		<tr>
			<td>피평가자사번</td>
			<td>프로젝트번호</td>
			<td>평가자 사번</td>
			<td>평가종류</td>
			<td>업무수행평가점수</td>
			<td>업무수행평가내용</td>
			<td>커뮤니케이션평가점수</td>
			<td>커뮤니케이션평가내용</td>
		</tr>
		<c:forEach items="${getEvalList}" var="result2">
		<tr>
			<td>${result2.getEvaluatee_number()}</td>
			<td>${result2.getProject_number()}</td>
			<td>${result2.getEvaluater_number()}</td>
			<td>${result2.getEval_type()}</td>
			<td>${result2.getBusiness_score()}</td>
			<td>${result2.getBusiness_eval()}</td>
			<td>${result2.getCommunication_score()}</td>
			<td>${result2.getCommunication_eval()}</td>
		</tr>
		</c:forEach>
	</table>
	
	</div>
</body>
</html>
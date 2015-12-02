<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>evallist</title>
</head>
<body style="background-color: #fafafa">
	<jsp:include page="header.jsp"></jsp:include>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
		<div class="col-md-9">
		<h2>평가내역</h2>
		<form method="post" action="${pageContext.request.contextPath}/EvalController/getevalList.do">
		<h4>직원선택 :</h4> 
		<select name="employee_number"class="form-control">
			<c:forEach items="${develList}" var="result">
			<option value="${result.getEmployee_number()}">
				${result.getEmployee_number()} ${result.getWorks_department()} ${result.getName()} ${result.getPosition()}
			</option>
			</c:forEach>
		</select>
		<input type="submit" class="btn btn-default" value="평가내역조회"/>
		</form>
	<table class="table">
		<tr>
			<td><h5>피평가자사번</h5></td>
			<td><h5>프로젝트번호</h5></td>
			<td><h5>평가자 사번</h5></td>
			<td><h5>평가종류</h5></td>
			<td><h5>업무수행평가점수</h5></td>
			<td><h5>업무수행평가내용</h5></td>
			<td><h5>커뮤니케이션평가점수</h5></td>
			<td><h5>커뮤니케이션평가내용</h5></td>
		</tr>
		<c:forEach items="${getEvalList}" var="result2">
		<tr>
			<td><h5>${result2.getEvaluatee_number()}</h5></td>
			<td><h5>${result2.getProject_number()}</h5></td>
			<td><h5>${result2.getEvaluater_number()}</h5></td>
			<td><h5>${result2.getEval_type()}</h5></td>
			<td><h5>${result2.getBusiness_score()}</h5></td>
			<td><h5>${result2.getBusiness_eval()}</h5></td>
			<td><h5>${result2.getCommunication_score()}</h5></td>
			<td><h5>${result2.getCommunication_eval()}</h5></td>
		</tr>
		</c:forEach>
	</table>
	</div>
	</div>
</body>
</html>
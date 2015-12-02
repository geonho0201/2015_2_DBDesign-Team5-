<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
 integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" 
integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
 integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>
</head>
<body style="background-color: #fafafa">
	<jsp:include page="header.jsp"></jsp:include>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
		<div class="col-md-9">	
		<h2>직원검색페이지</h2>
	<h3>검색옵션</h3>
	<form method="POST" class="form-inline" action="${pageContext.request.contextPath}/EmployeeController/employeeRetrieve.do">
		<select name="retrieveOption"class="form-control">
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
		<button class="btn btn-default" type="submit" value="조회">조회</button>
	</form>
	<table class="table table-bordered">
		<tr>
         <td><h6>직원사번</h6></td>
         <td><h6>이름</h6></td>
         <td><h6>부서</h6></td>
         <td><h6>직급</h6></td>
         <td><h6>나이</h6></td>
         <td><h6>주민등록번호</h6></td>
         <td><h6>연락처</h6></td>
         <td><h6>주소</h6></td>
      </tr><tr>  
         <td><h6>최종학력</h6></td>
         <td><h6>연봉(만 원)</h6></td>
         <td><h6>입사전경력</h6></td>
         <td colspan="2"><h6>입사일</h6></td>
         <td colspan="2"><h6>가입일</h6></td>
         <td><h6>이메일</h6></td>
      </tr>
      <c:forEach items="${userList}" var="result">
      <tr>
      <td class="active"><h6>${result.getEmployee_number()}</h6></td>
         <td class="active"><h6>${result.getName()}</h6></td>
         <td class="active"><h6>${result.getWorks_department()}</h6></td>
         <td class="active"><h6>${result.getPosition()}</h6></td>
         <td class="active"><h6>${result.getAge()}</h6></td>
         <td class="active"><h6>${result.getSSN()}</h6></td>
         <td class="active"><h6>${result.getPhone_number()}</h6></td>
         <td class="active"><h6>${result.getAddress()}</h6></td>
      </tr><tr>
         <td class="active"><h6>${result.getFinal_education()}</h6></td>
         <td class="active"><h6>${result.getSalary()}</h6></td>
         <td class="active"><h6>${result.getPrevious_career()}</h6></td>
         <td colspan="2" class="active"><h6>${result.getHired_date()}</h6></td>
         <td colspan="2" class="active"><h6>${result.getSignup_date()}</h6></td>
         <td class="active"><h6>${result.getEmail()}</h6></td>
      </tr>
		</c:forEach>
	</table>
	</div>
	</div>
</body>
</html>
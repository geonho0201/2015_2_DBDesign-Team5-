<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h1>회원가입</h1>
	<form method="POST" action="${pageContext.request.contextPath}/LoginController/join.do">
	<table class="table">
	<tr>
		<td><h4>아이디</h4></td>
		<td> <div class="col-xs-3"><input type="text" class="form-control"name="userID"/></div></td>
	</tr>
	<tr>
		<td><h4>비밀번호</h4></td>
		<td><div class="col-xs-3"><input type="password" class="form-control"name="userPassword"/></div></td>
	</tr>
	<tr>
		<td><h4>비밀번호확인</h4></td>
		<td><div class="col-xs-3"><input type="password" class="form-control" name="userPasswordCheck"/></div></td>
	</tr>
	<tr>
		<td><h4>이름</h4></td>
		<td><div class="col-xs-3"><input type="text" class="form-control" name="name"/></div></td>
	</tr>
	<tr>
		<td><h4>나이</h4></td>
		<td><div class="col-xs-3"><select name="age" class="form-control">
		<%for(int i=20;i<99;i++){ %><option><%=i %></option><%} %>
		</select></div></td>
	</tr>
	<tr>
		<td><h4>연락처</h4></td>
		<td><div class="col-xs-3">
		<input type="text" class="form-control" name="phone_number"/><h6>구분선없이 입력하세요</h6>
		</div></td>
	</tr>
	<tr>
		<td><h4>주소</h4></td>
		<td><div class="col-xs-3"><input type="text" class="form-control" name="address"/></div></td>
	</tr>
	<tr>
		<td><h4>이메일</h4></td>
		<td><div class="col-xs-3"><input type="text" name="email" class="form-control"></div></td>
	</tr>
	<tr>
		<td><h4>주민등록번호</h4></td>
		<td><div class="col-xs-2"><input type="text" name="SSN1" class="form-control"/></div><div class="col-xs-2"><input type="password" name="SSN2" class="form-control"/></div></td>
	</tr>
	<tr>
		<td><h4>근무부서</h4></td>
		<td><div class="col-xs-3">
		<select name="works_department" class="form-control">
			<option>경영관리</option>
			<option>인사</option>
			<option>재무회계</option>
			<option>마케팅</option>
			<option>디자인</option>
			<option>영업기획</option>
			<option>연구개발</option>
			<option>개발팀</option>		
		</select>
		</div></td>
	</tr>
	<tr>
		<td><h4>직급</h4></td>
		<td><div class="col-xs-3">
		<select class="form-control">
			<option>CEO</option>
			<option>CTO</option>
			<option>전무</option>
			<option>상무</option>
			<option>이사</option>
			<option>부장</option>
			<option>차장</option>
			<option>과장</option>
			<option>대리</option>
			<option>주임</option>
			<option>사원</option>
		</select>
		</div></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" class="btn btn-default" value="등록">
		<input type="button" class="btn btn-default" value="취소" onclick="history.back(-1);">
		</td>
	</tr>
	</table>
	</form>


</body>
</html>
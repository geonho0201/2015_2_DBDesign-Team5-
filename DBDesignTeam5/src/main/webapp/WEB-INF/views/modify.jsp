<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form method="post" action="${pageContext.request.contextPath}/MyInfoController/updateData.do" name="modify">
	<h2>정보수정</h2>
	<table class = "table">
	<tr><td><h4>ID:</h4> </td>		<td><h4>${user.getId()}</h4></td></tr>
	<tr><td><h4>PASSWORD:</h4> </td>	<td><div class="col-xs-3"><input type="password" name="password" class="form-control"value="${user.getPassword()}"/></div></td></tr>
	<tr><td><h4>SSN:</h4> </td>		<td><div class="col-xs-3"><input type="text" name="SSN1" class="form-control"value="${user.getSSN().substring(0,6)}"/></div><div class="col-xs-3"><input type="password" name="SSN2" class="form-control"value = "${user.getSSN().substring(6,13)}"/></div></td></tr>
	<tr><td><h4>NAME:</h4> </td>		<td><div class="col-xs-3"><input type="text" name="name" class="form-control"value="${user.getName()}"/></div></td></tr>
	<tr><td><h4>AGE:</h4> </td>		<td><div class="col-xs-3"><input type="text" name="age" class="form-control"value="${user.getAge()}"/></div><tr/>
	<tr><td><h4>PHONE:</h4> </td>	<td><div class="col-xs-4"><input type="text" name="phone_number" class="form-control"value="${user.getPhone_number()}"/></div></td></tr>
	<tr><td><h4>ADDRESS:</h4> </td>	<td><div class="col-xs-5"><input type="text" name="address" class="form-control"value="${user.getAddress()}"/></div></td></tr>
	<tr><td><h4>EMAIL:</h4> </td>	<td><div class="col-xs-3"><input type="text" name="email1"class="form-control" value="${user.getEmail()}"/></div> 
								<div class="col-xs-3"><select name=email_support class="form-control">
									<option value="0" selected>선택하세요</option>
									<option value="gmail.com">gmail.com</option>
									<option value="naver.com">naver.com</option>
									<option value="nate.com">nate.com</option>
									<option value="hanmail.net">hanmail.net</option>
									<option value="daum.net">daum.net</option>
								</select></div><div class="col-xs-3"><input type="text" placeholder="직접입력" value="직접입력" class="form-control" name="email2"/></div></td> 
							
	<tr><td><h4>Signup Date:</h4> </td><td><h4>${user.getSignup_date()}</h4></td></tr>
	<tr><td><h4>Department:</h4> </td>
		<td>
		<div class="col-xs-3">
		<select name="works_department"class="form-control">
			<option value ="01">경영관리</option>
			<option value ="02">인사</option>
			<option value ="03">재무회계</option>
			<option value ="04">마케팅</option>
			<option value ="05">디자인</option>
			<option value ="06">영업기획</option>
			<option value ="07">연구개발</option>
			<option value ="08">개발팀</option>		
		</select></div>
		</td>
	</tr>
	<tr>
		<td><h4>Position: </h4></td>
		<td><div class="col-xs-3">
		<select name="position"class="form-control">
			<option value="CEO">CEO</option>
			<option value="CTO">CTO</option>
			<option value="전무">전무</option>
			<option value="상무">상무</option>
			<option value="이사">이사</option>
			<option value="부장">부장</option>
			<option value="차장">차장</option>
			<option value="과장">과장</option>
			<option value="대리">대리</option>
			<option value="주임">주임</option>
			<option value="사원">사원</option>
		</select></div>
		</td></tr>
	<tr><td><button type="submit" class="btn btn-default" value="완료">완료</button>     <input type="button" value="취소" class="btn btn-default"onclick="history.back(-1)"/></td><td></td></tr>
	</table>
	</form>
	</div>
	</div>
</body>
</html>


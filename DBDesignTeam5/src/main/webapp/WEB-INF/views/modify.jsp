<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/css.css" rel="stylesheet">
<title>title</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	정보수정<br/>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	</div>
	<div>
	<form method="post" action="${pageContext.request.contextPath}/MyInfoController/updateData.do" name="modify">
		  <div class="form-group">
		    <label>ID</label>
		    <input type="text" id="disabledTextInput" class="form-control" placeholder="${user.getId()}">
		  </div>
		  <div class="form-group">
		    <label>Password</label>
		    <input type="password" class="form-control"name="password" value="${user.getPassword()}">
		  </div>
		  <div class="form-group">
		    <label>SSN</label>
		    <input type="text" class="form-control" name="SSN1" value="${user.getSSN().substring(0,6)}">
		  </div>
		   <div class="form-group">
		    <label>NAME</label>
		    <input type="text" class="form-control" name="name" value="${user.getName()}">
		  </div>  
		  <div class="form-group">
		    <label>AGE</label>
		    <input type="text" class="form-control" name="age" value="${user.getAge()}">
		  </div>  
		  <div class="form-group">
		    <label>PHONE</label>
		    <input type="text" class="form-control" name="phone_number" value="${user.getPhone_number()}">
		  </div>  
		  <div class="form-group">
		    <label>ADDRESS</label>
		    <input type="text" class="form-control" name="address" value="${user.getAddress()}">
		  </div>  
		  <div class="form-group">
		    <label>EMAIL</label>
		    <input type="text" class="form-control" name="email" value="${user.getEmail()}"> @
		   			 <select name=email_support class="form-control">
									<option value="0" selected>선택하세요</option>
									<option value="gmail.com">gmail.com</option>
									<option value="naver.com">naver.com</option>
									<option value="nate.com">nate.com</option>
									<option value="hanmail.net">hanmail.net</option>
									<option value="daum.net">daum.net</option>
					</select>
		  </div>
		  <button type="submit" class="btn btn-default">Submit</button>
	</form>
	
	<table class="table">
	<tr><td>ID: </td>		<td>${user.getId()}</td></tr>
	<tr><td>PASSWORD: </td>	<td><input type="password" name="password" value="${user.getPassword()}"/></td></tr>
	<tr><td>SSN: </td>		<td><input type="text" name="SSN1" value="${user.getSSN().substring(0,6)}"/>-<input type="password" name="SSN2" value = "${user.getSSN().substring(6,13)}"/></td></tr>
	<tr><td>NAME: </td>		<td><input type="text" name="name" value="${user.getName()}"/></td></tr>
	<tr><td>AGE: </td>		<td><input type="text" name="age" value="${user.getAge()}"/>세<tr/>
	<tr><td>PHONE: </td>	<td><input type="text" name="phone_number" value="${user.getPhone_number()}"/></td></tr>
	<tr><td>ADDRESS: </td>	<td><input type="text" name="address" value="${user.getAddress()}"/></td></tr>
	<tr><td>EMAIL: </td>	<td><input type="text" name="email1" value="${user.getEmail()}"/> @ 
								<select name=email_support>
									<option value="0" selected>선택하세요</option>
									<option value="gmail.com">gmail.com</option>
									<option value="naver.com">naver.com</option>
									<option value="nate.com">nate.com</option>
									<option value="hanmail.net">hanmail.net</option>
									<option value="daum.net">daum.net</option>
								</select></td> <td><input type="text" value="직접입력" name="email2"/></td></tr>
	<tr><td>Signup Date: </td><td>${user.getSignup_date()}</td></tr>
	<tr><td>Department: </td>
		<td>
		<select name="works_department">
			<option value ="01">경영관리</option>
			<option value ="02">인사</option>
			<option value ="03">재무회계</option>
			<option value ="04">마케팅</option>
			<option value ="05">디자인</option>
			<option value ="06">영업기획</option>
			<option value ="07">연구개발</option>
			<option value ="08">개발팀</option>		
		</select>
		</td>
	</tr>
	<tr>
		<td>Position: </td>
		<td>
		<select name=position>
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
		</select>
		</td></tr>
	<tr><td><input type="submit" value="완료"></td><td><input type="button" value="취소" onclick="history.back(-1)"/></td></tr>
	</table>
	</form>
	</div>
</body>
</html>


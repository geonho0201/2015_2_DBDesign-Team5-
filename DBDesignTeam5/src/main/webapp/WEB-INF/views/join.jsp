<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>
</head>
<body>
<h1>회원가입</h1>
	<form method="POST" action="${pageContext.request.contextPath}/LoginController/join.do">
	<table>
	<tr>
	<th colspan="2">내용입력</th>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="userID"/></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="userPassword"/></td>
	</tr>
	<tr>
		<td>비밀번호확인</td>
		<td><input type="password" name="userPasswordCheck"/></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name"/></td>
	</tr>
	<tr>
		<td>나이</td>
		<td><select name="age">
		<%for(int i=20;i<99;i++){ %><option><%=i %></option><%} %>
		</select></td>
	</tr>
	<tr>
		<td>연락처</td>
		<td>
		<input type="text" name="phone_number"/>구분선없이 입력하세요
		</td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input type="text" name="address"/></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td>주민등록번호</td>
		<td><input type="text" name="SSN1"/>-<input type="password" name="SSN2"/></td>
	</tr>
	<tr>
		<td>근무부서</td>
		<td>
		<select name="works_department">
			<option>경영관리</option>
			<option>인사</option>
			<option>재무회계</option>
			<option>마케팅</option>
			<option>디자인</option>
			<option>영업기획</option>
			<option>연구개발</option>
			<option>개발팀</option>		
		</select>
		</td>
	</tr>
	<tr>
		<td>직급</td>
		<td>
		<select>
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
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="등록">
		<input type="button" value="취소" onclick="history.back(-1);">
		</td>
	</tr>
	</table>
	</form>


</body>
</html>
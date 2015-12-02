<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
	<div style="color:red">${errorMessage}</div>
	<form method="POST" action="${pageContext.request.contextPath}/LoginController/join.do">
	<table>
	<tr>
	<th colspan="2">내용입력</th>
	</tr>
	<tr>
		<td>직원번호</td>
		<td><input type="text" name="employeeNumber"/></td>
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
		<input type="text" name="phoneNumber"/>구분선없이 입력하세요
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
		<td><input type="text" name="ssnPrefix"/>-<input type="password" name="ssnSuffix"/></td>
	</tr>
	<tr>
		<td>근무부서</td>
		<td>
		<select name="worksDepartment">
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
		<select name = position>
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
		<td>입사일</td>
		<td><input type="date" name="hiredDate"/></td>
	</tr>
	<tr>
		<td>이전 경력</td>
		<td><input type="text" name="previousCareer"/></td>
	</tr>
	<tr>
		<td>최종학력</td>
		<td>
		<select name="finalEducation">
			<option>초졸</option>
			<option>중졸</option>
			<option>고졸</option>
			<option>대졸</option>
			<option>석사</option>
			<option>박사</option>	
		</select>
		</td>
	</tr>
	<tr>
		<td>보유기술</td>
		<td>
		<select name="skillName">
			<option>DB연동어플리케이션 개발</option>
			<option>Android 개발</option>
			<option>IOS 개발</option>
			<option>웹 스크립트 개발</option>
			<option>서버 관리</option>
			<option>UI/UX 디자인</option>
			<option>보안 관리</option>
			<option>프로젝트 관리</option>
		</select>
		</td>
		<td>기술등급</td>
		<td><input type="text" name="skillLevel"/></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="등록">
		<input type="button" value="취소" onclick="location.href='/mju'">
		<input type="button" value="리셋" onclick="history.back(-1);">
		</td>
	</tr>
	</table>
	</form>


</body>
</html>
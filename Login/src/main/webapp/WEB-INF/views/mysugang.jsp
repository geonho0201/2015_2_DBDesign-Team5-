<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MySugang</title>
</head>
<body>

<table>
	<tr>
		<td>강좌번호</td>
		<td>과목명</td>
		<td>담당교수</td>
		<td>개설연도</td>
		<td>학년</td>
		<td>학점</td>
		<td>정원</td>
		<td>평점</td>
	</tr>
	<c:forEach items="${result}" var="result">
	<tr>
		<td>${result.getSugangID()}</td>
		<td>${result.getSugangName()}</td>
		<td>${result.getSugangGyosu()}</td>
		<td>${result.getSugangYear()}</td>
		<td>${result.getSugangGrade()}</td>
		<td>${result.getSugangCredit()}</td>
		<td>${result.getSugangMember()}</td>
		<td>${result.getSugangMyCredit()}</td>
	</tr>	
	</c:forEach>
</table>

<a href="${pageContext.request.contextPath}/SugangController/sugangClose">뒤로가기</a><br/>

</body>
</html>
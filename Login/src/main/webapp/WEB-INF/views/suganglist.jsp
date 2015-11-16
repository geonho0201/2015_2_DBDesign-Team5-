<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SugangList</title>
</head>
<body>

<table border="1">
	<tr>
		<td>강좌번호</td>
		<td>과목명</td>
		<td>담당교수</td>
		<td>연도</td>
		<td>학년</td>
		<td>학점</td>
		<td>정원</td>
		<td>신청</td>
	</tr>
<c:forEach items="${result}" var="result">
	<form action="${pageContext.request.contextPath}/SugangController/sugangSincheong.do" method="post">
	<tr>
		<td>${result.getKangjwaID()}</td>
		<td>${result.getKangjwaName()}</td>
		<td>${result.getKangjwaGyosu()}</td>
		<td>${result.getKangjwaYear()}</td>
		<td>${result.getKangjwaGrade()}</td>
		<td>${result.getKangjwaCredit()}</td>
		<td>${result.getKangjwaMember()}</td>
		<td>
		<input type="hidden" value="${userSession.getID()}" name="SID">
		<input type="hidden" value="${result.getKangjwaID()}" name="KID">
		<input type="submit" value="수강신청"/></td>
	</tr>
	</form>
</c:forEach>
</table>

<a href="${pageContext.request.contextPath}/SugangController/sugangClose">뒤로가기</a><br/>
</body>
</html>
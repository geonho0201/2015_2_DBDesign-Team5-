<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>myKangjwa</title>
</head>
<body>

<table border="1">
	<tr>
		<td>강좌번호</td>
		<td>과목명</td>
		<td>개설연도</td>
		<td>학년</td>
		<td>정원</td>
		<td>학점</td>
		<td>성적부여</td>
	</tr>
<c:forEach items="${result}" var="result">
	<form action="${pageContext.request.contextPath}/KangjwaController/seongjeok.do" method="post">
	<tr>
		<td>${result.getKangjwaID()}</td>
		<td>${result.getKangjwaName()}</td>
		<td>${result.getKangjwaYear()}</td>
		<td>${result.getKangjwaGrade()}</td>
		<td>${result.getKangjwaMember()}</td>
		<td>${result.getKangjwaCredit()}</td>
		<td>
		<input type="hidden" value="${result.getKangjwaID()}" name="KID"/>
		<input type="submit" value="성적부여"/></td>
	</tr>
	</form>
</c:forEach>
</table>

<a href="${pageContext.request.contextPath}/KangjwaController/kangjwaClose">뒤로가기</a><br/>
</body>
</html>
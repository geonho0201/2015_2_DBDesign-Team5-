<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>seongjeok</title>
</head>
<body>

<table border="1">
	<tr>
		<td>학생</td>
		<td>성적</td>
		<td>성적부여</td>
	</tr>
<c:forEach items="${result}" var="result">
	<form action="${pageContext.request.contextPath}/KangjwaController/seongjeokBuyeo.do" method="post">
	<tr>
		<td>${result.getSugangName()}</td>
		<td>${result.getSugangMyCredit()}</td>
		<td><input type="text" name="SJK"/></td>
		<td><input type="hidden" value="${result.getSugangID()}" name="SID"/>
		<input type="hidden" value="${result.getSugangGyosu()}" name="KID"/>
		<input type="submit" value="성적부여"/></td>
	</tr>
	</form>
</c:forEach>
</table>

<a href="${pageContext.request.contextPath}/KangjwaController/kangjwaClose">뒤로가기</a><br/>
</body>
</html>
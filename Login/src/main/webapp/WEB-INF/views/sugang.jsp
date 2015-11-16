<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sugang</title>
</head>
<body>

<h1>수강신청 화면</h1>

${userSession.getID()}님 로그인.<br/>
${userSession.getName()}학생님 안녕하세요!<br/>

<a href="${pageContext.request.contextPath}/SugangController/sugang">수강신청</a><br/>
<form action="${pageContext.request.contextPath}/SugangController/mySugang.do" method="POST">
<input type="hidden" value="${userSession.getID()}" name="SugangID"/>
<input type="submit" value="내 수강"></form><br/>
<a href="${pageContext.request.contextPath}/loginController/logout">로그아웃</a>

</form>
</body>
</html>
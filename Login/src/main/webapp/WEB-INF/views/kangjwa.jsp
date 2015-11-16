<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kangjwa</title>
</head>
<body>

<h1>강좌개설 화면</h1>

${userSession.getID()}님 로그인.<br/>
${userSession.getName()} 교수님 안녕하세요!<br/><br/>

	<form action="${pageContext.request.contextPath}/KangjwaController/kangjwagaseol.do" method="post">
		강좌번호 : <input type="text" name="kangjwaNumber"/><br/>
		강좌명 : <input type="text" name="kangjwaName"/><br/>
		연도: <input type="text" name="kangjwaYear"/><br/>
		해당학년: <input type="text" name="kangjwaGrade"/><br/>
		수강정원: <input type="text" name="kangjwaMember"/><br/>
		학점: <input type="text" name="kangjwaCredit"/><br/>
		<input type="hidden" value="${userSession.getID()}" name="professorID"/>
		<input type="hidden" value="${userSession.getName()}" name="professorName"/>
		<input type="submit" value="강좌개설">
	</form>
	<form action="${pageContext.request.contextPath}/KangjwaController/mykangjwa.do" method="post">
		<input type="hidden" value="${userSession.getID()}" name="PID">
		<input type="submit" value="내 강의">
	</form>
	

<a href="${pageContext.request.contextPath}/loginController/logout">로그아웃</a>

</body>
</html>
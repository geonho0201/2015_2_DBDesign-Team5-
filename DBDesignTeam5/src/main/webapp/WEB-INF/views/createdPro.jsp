<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>

</head>
<body style="background-color: #888">
	<jsp:include page="header.jsp"></jsp:include>
	프로젝트 생성<br/>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	</div>
	${message}
	<div>
	<form action="${pageContext.request.contextPath}/ProjectController/deletePro.do" name="form">
	<table>
	<c:forEach items="${list}" var="project">
	<tr><td><input type="radio" name="project_number" value = "${project.project_number}"/></td>
	<td>프로젝트 번호: </td><td>${project.project_number}</td>
	<td>프로젝트 이름: </td><td>${project.project_name}</td>
	<td>시작일: </td><td>${project.start_date}</td>
	<td>만료일: </td><td>${project.due_date }</td>
	<td>고객처: </td><td>${project.orderer }</td>
	<td>프로젝트 설명: </td><td>${project.project_desc }</td>
	<td>기획자 : </td><td>${project.constructor_number }</td>
	<c:forEach items="${pm}" var="PM">
	<c:if test="${PM.substring(8,16)==project.project_number }">
	<td>PM설정 : </td><td>${PM.substring(0,8)}</td>
	</c:if>
	</c:forEach>
	</tr>
	</c:forEach>
	
	<tr><td><input type="button" value="프로젝트 만들기" onclick="location.href('${pageContext.request.contextPath}/ProjectController/createForm.do')"/></td>
		<td><input type="submit" value="프로젝트 삭제" onclick="checkNull(); false;"/>
		<td><input type="button" value="홈으로" onclick="location.href('/mju/main')"/>	</tr>
	</table>
	
	</form>
	</div>
</body>
<script type="text/javascript">
function checkNull()
{
	var limit = document.form.project_number.length;
	for(var i=0; i<limit; ++i){
	if(document.form.project_number[i].checked == true){
		return document.form.submit();
	}
	}
	alert('선택 된 프로젝트가 없습니다.');
	return;
	}


</script>
</html>
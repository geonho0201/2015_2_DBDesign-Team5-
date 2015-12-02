<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>

</head>
<body style="background-color: #fafafa">
	<jsp:include page="header.jsp"></jsp:include>
	프로젝트 생성<br/>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	<div class="col-md-9">	
	<h2>${message}</h2>
	<form action="${pageContext.request.contextPath}/ProjectController/deletePro.do" name="form">
	<table class="table">
	<c:forEach items="${list}" var="project">
	<tr><td><div class="col-xs-3"><input type="radio" class="form-control"name="project_number" value = "${project.project_number}"/></div></td>
	<td><h5>프로젝트 번호:</h5> </td><td><h5>${project.project_number}</h5></td>
	<td><h5>프로젝트 이름:</h5> </td><td><h5>${project.project_name}</h5></td>
	<td><h5>시작일:</h5> </td><td><h5>${project.start_date}</h5></td>
	<td><h5>만료일:</h5> </td><td><h5>${project.due_date }</h5></td>
	<td><h5>고객처:</h5> </td><td><h5>${project.orderer }</h5></td>
	<td><h5>프로젝트 설명:</h5> </td><td><h5>${project.project_desc }</h5></td>
	<td><h5>기획자 :</h5> </td><td><h5>${project.constructor_number }</h4></td>
	<c:forEach items="${pm}" var="PM">
	<c:if test="${PM.substring(8,16)==project.project_number }">
	<td><h5>PM설정 :</h5> </td><td><h5>${PM.substring(0,8)}</h5></td>
	</c:if>
	</c:forEach>
	</tr>
	</c:forEach>
	
	<tr><td><div class="col-xs-3"><input type="button" class="btn btn-default" value="프로젝트 만들기" onclick="location.href('${pageContext.request.contextPath}/ProjectController/createForm.do')"/></td>
		<td><div class="col-xs-3"><button type="submit" class="btn btn-default" value="프로젝트 삭제" onclick="checkNull(); false;">프로젝트 삭제</button>
		<td><div class="col-xs-3"><input type="button" class="btn btn-default" value="홈으로" onclick="location.href('/mju/main')"/>	</tr>
	</table>
	
	</form>
	</div>
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
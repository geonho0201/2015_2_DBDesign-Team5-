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
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	<div class="col-md-9">
	<h2>평가하기</h2>
	<h3>${message}</<!-- 평가완료시/실패시 나타나는 message box -->
	<form method="POST" action="${pageContext.request.contextPath}/EvalController/addEval.do" name="form">
	<table class="table">
	<c:forEach items="${list}" var="result">

			<c:if test="${selectedEmp==result.employee_number}">
			
			<tr><td><h5>평가직원 번호</h5></td>
				<td><h5>${selectedEmp}</h5><div class="col-xs-3"><input type="hidden" class="form-control" name="evaluatee_number" value="${selectedEmp}"/></div></td></tr>
			<tr><td><h5>평가직원 이름</h5></td>
				<td><h5>${result.name}</h5><div class="col-xs-3"><input type="hidden" class="form-control" name="project_number" value="${result.project_number}"/></div>
								<div class="col-xs-3"><input type="hidden" class="form-control" name="evaluater_number" value="${sessionScope.user.getEmployee_number()}"/></div></td></tr>
			<tr><td><h5>평가종류</h5></td>
				<td><div class="col-xs-3"><select name="eval_type"class="form-control" ></div>
					<option value="동료평가">동료평가</option>
					<c:if test="${myJob=='PM' }">
						<option value="PM평가">PM평가</option>
						<option value="고객평가">고객평가</option>
					</c:if>		
			</select></td></tr>
			<tr><td><h5>비즈니스 점수</h5></td>
				<td><div class="col-xs-3"><input type="text" class="form-control" name="business_score" value="100" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' style='ime-mode:disabled;'/></div></td></tr>
			<tr><td><h5>비즈니스 평가</h5></td>
				<td><div class="col-xs-3"><input type="text" class="form-control" name="business_eval"/></td></tr>
			<tr><td><h5>커뮤니케이션 점수</h5></td>
				<td><div class="col-xs-3"><input type="text"class="form-control"  name="communication_score" value="100" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' style='ime-mode:disabled;'/></div></td></tr>
			<tr><td><h5>커퓨티케이션 평가</h5></td>
				<td><div class="col-xs-3"><input type="text" class="form-control" name="communication_eval"/></div></td></tr>
			</c:if>
		</c:forEach>

	<tr><td><input type="submit" class="btn btn-default" value="제출" onclick="constraint(); return false;"/>   <input type="button" value="홈으로" onclick="location.href='/mju/main'"/></td></tr>
	</table>
	</form>
	</div>
	</div>
</body>

<script type="text/javascript">
function onlyNumber(event){
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
		return;
	else
		return false;
}
function removeChar(event) {
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
		return;
	else
		event.target.value = event.target.value.replace(/[^0-9]/g, "");
}
function constraint(){
	if(document.form.business_score.value<0 ||document.form.business_score.value>100||
		document.form.communication_score.value<0||document.form.communication_score.value>100){
			alert('점수는 0~100의 자연수만 입력 할 수 있습니다.');
			return;
		}else{
			return document.form.submit();
		}
}

</script>





</html>
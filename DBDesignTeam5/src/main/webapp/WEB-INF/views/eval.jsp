<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>eval</title>
</head>
<body style="background-color: #888">
	<jsp:include page="header.jsp"></jsp:include>
	평가하기<br/>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	</div>
	<div>
	${message}<!-- 평가완료시/실패시 나타나는 message box -->
	<form method="POST" action="${pageContext.request.contextPath}/EvalController/addEval.do" name="form">
	<table>
	<c:forEach items="${list}" var="result">

			<c:if test="${selectedEmp==result.employee_number}">
			
			<tr><td>평가직원 번호</td>
				<td>${selectedEmp}<input type="hidden" name="evaluatee_number" value="${selectedEmp}"/></td></tr>
			<tr><td>평가직원 이름</td>
				<td>${result.name}<input type="hidden" name="project_number" value="${result.project_number}"/>
								<input type="hidden" name="evaluater_number" value="${sessionScope.user.getEmployee_number()}"/></td></tr>
			<tr><td>평가종류</td>
				<td><select name="eval_type">
					<option value="동료평가">동료평가</option>
					<c:if test="${myJob=='PM' }">
						<option value="PM평가">PM평가</option>
						<option value="고객평가">고객평가</option>
					</c:if>		
			</select></td></tr>
			<tr><td>비즈니스 점수</td>
				<td><input type="text" name="business_score" value="100" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' style='ime-mode:disabled;'/></td></tr>
			<tr><td>비즈니스 평가</td>
				<td><input type="text" name="business_eval"/></td></tr>
			<tr><td>커뮤니케이션 점수</td>
				<td><input type="text" name="communication_score" value="100" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' style='ime-mode:disabled;'/></td></tr>
			<tr><td>커퓨티케이션 평가</td>
				<td><input type="text" name="communication_eval"/></td></tr>
			</c:if>
		</c:forEach>

	<tr><td><input type="submit" value="제출" onclick="constraint(); return false;"/></td>
		<td><input type="button" value="홈으로" onclick="location.href='/mju/main'"/></td></tr>
	</table>
	</form>
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
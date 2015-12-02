<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>
	<script type="text/javascript">
		function checkemail() {
			if(document.getElementsByName("of_skillset_number")[0].value =="0000"){
				document.getElementsByName("newskillname")[0].style.display = "";
			}else{
				document.getElementsByName("newskillname")[0].style.display = "none";
			}
			
		}
	</script>
</head>
<body style="background-color: #fafafa">
	<jsp:include page="header.jsp"></jsp:include>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	<div class="col-md-9">
	<h2>내기술</h2>
	<form method="post" action="${pageContext.request.contextPath}/SkillsetController/new_of_skillset.do">
	<table class="table">
		<tr>
			<td><h4>보유기술 추가등록</h4></td>
		</tr>
		<tr>
			<td>
				<select name="of_skillset_number" class="form-control"onchange="checkemail()">
					<c:forEach items="${skillsetlist}" var="result">
					<option value="${result.getSkill_number()}">
					<c:catch var="skillname"> ${result.getSkill_name()}</c:catch>
					</option>
					</c:forEach>
					<option value="0000">직접입력</option>
				</select>
				<div class="col-xs-3"><input type="hidden" class="form-control"name="of_skillset_name" value="${skillname}"/></div>
			</td>
			<td>
				<h4>기술을 선택하세요</h4>
			</td>
		</tr>
		<tr name="newskillname">
			<td>
				<div class="col-xs-16"><input type="text" class="form-control"name="new_of_skillset_name"></div>
			</td>
			<td>
				<h4>기술명을 입력하세요</h4>
			</td>
		</tr>	
		<tr>
			<td>
				<div class="col-xs-4"><select class="form-control"name="of_skillset_level">
					<%for(int i=0; i<=500; i++){ %>
					<option><%=i%></option>
					<%} %>
				</select></div>
			</td>	
			<td>
				<h4>경험한 개월수를 선택하세요</h4>
			</td>
			<td>
				<button type="submit" class="btn btn-default"value="등록" >등록</button>
			</td>
		</tr>
	</table>
	</form>
	<div>
	<h2>내기술목록</h2>
	<table class="table">
		<tr>
			<td><h4>기술번호</h4></td>
			<td><h4>기술이름</h4></td>
			<td><h4>내 기술경력</h4></td>
		</tr>
		<c:forEach items="${of_skillset}" var="result">
		<tr>
			<td><h4>${result.getSkill_number()}</h4></td>
			<td><h4>${result.getSkill_name()}</h4></td>
			<td><h4>${result.getSkill_level()}</h4></td>
			<td>
			<form method="post" action="${pageContext.request.contextPath}/SkillsetController/delete_of_skillset.do">
			<input type="hidden" class="form-control"value="${result.getSkill_number()}" name="of_skillset"/>
			<button type="submit" class="btn btn-default"value="삭제" >삭제</button>
			</form>
			</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>
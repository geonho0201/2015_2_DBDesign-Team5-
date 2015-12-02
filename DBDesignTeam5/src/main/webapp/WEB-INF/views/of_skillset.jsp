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
<body style="background-color: #888">
	<jsp:include page="header.jsp"></jsp:include>
	내 기술<br/>
	<div style="float: left;">
		<jsp:include page="navigator.jsp"></jsp:include>
	</div>
	<div>
	<form method="post" action="${pageContext.request.contextPath}/SkillsetController/new_of_skillset.do">
	<table>
		<tr>
			<td colspan="3">보유기술 추가등록</td>
		</tr>
		<tr>
			<td>
				<select name="of_skillset_number" onchange="checkemail()">
					<c:forEach items="${skillsetlist}" var="result">
					<option value="${result.getSkill_number()}">
					<c:catch var="skillname"> ${result.getSkill_name()}</c:catch>
					</option>
					</c:forEach>
					<option value="0000">직접입력</option>
				</select>
				<input type="hidden" name="of_skillset_name" value="${skillname}"/>
			</td>
			<td>
				기술을 선택하세요
			</td>
		</tr>
		<tr name="newskillname" style="display: none;">
			<td>
				<input type="text" name="new_of_skillset_name">
			</td>
			<td>
				기술명을 입력하세요
			</td>
		</tr>	
		<tr>
			<td>
				<select name="of_skillset_level">
					<%for(int i=0; i<=500; i++){ %>
					<option><%=i%></option>
					<%} %>
				</select>
			</td>	
			<td>
				경험한 개월수를 선택하세요
			</td>
			<td>
				<input type="submit" value="등록" style="height: 45px">
			</td>
		</tr>
	</table>
	</form>
	</div>
	<div>
	내기술목록
	<table>
		<tr>
			<td>기술번호</td>
			<td>기술이름</td>
			<td>내 기술경력</td>
		</tr>
		<c:forEach items="${of_skillset}" var="result">
		<tr>
			<td>${result.getSkill_number()}</td>
			<td>${result.getSkill_name()}</td>
			<td>${result.getSkill_level()}</td>
			<td>
			<form method="post" action="${pageContext.request.contextPath}/SkillsetController/delete_of_skillset.do">
			<input type="hidden" value="${result.getSkill_number()}" name="of_skillset"/>
			<input type="submit" value="삭제"/>
			</form>
			</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>
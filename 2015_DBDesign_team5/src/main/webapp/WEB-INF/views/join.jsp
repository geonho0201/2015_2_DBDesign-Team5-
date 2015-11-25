<%@ page language="java" contentType="text/html; charset=UTF-8" 
   pageEncoding="UTF-8"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/css.css" rel="stylesheet">
<title>프람트솔루션</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h3 class="text-center login-title">회원가입</h3>
            <div class="account-wall">
                <form class="form-signin" action="${pageContext.request.contextPath}/loginController/join.do"> 
                <input type="text" class="form-control" name="userID" placeholder="아이디" > 
                <input type="text" class="form-control" name="userPW" placeholder="비밀번호"> 
                <input type="text" class="form-control" name="userName" placeholder="이름" > 
                <input type="text" class="form-control" id="userResident" placeholder="주민번호(XXXXXX-XXXXXXX)" >
                <input type="text" class="form-control" id="userAddress" placeholder="주소" > 
                <select class="form-control" placeholder="부서">
					  <option name="01">경영관리</option>
					  <option name="02">인사</option>
					  <option name="03">재무회계</option>
					  <option name="04">마케팅</option>
					  <option name="05">디자인</option>
					  <option name="06">영업기획</option>
					  <option name="07">연구개발</option>
					  <option name="08">개발팀</option>
				</select>
				<select class="form-control" placeholder="직급">
					<option name="CEO">CEO</option>
					<option name="CTO">CTO</option>
					<option name="전무">전무</option>
					<option name="상무">상무</option>
					<option name="이사">이사</option>
					<option name="부장">부장</option>
					<option name="차장">차장</option>
					<option name="과장">과장</option>
					<option name="대리">대리</option>
					<option name="주임">주임</option>
					<option name="사원">사원</option>
				</select>
                <!-- 나머지 더 추가예정 -->
                <button class="btn btn-lg btn-primary btn-block" type="submit">회원가입</button>
                </form>
            </div>
            <a href="home.jsp" class="text-center new-account">로그인화면으로 </a> <!-- 회원가입이라는 페이지로 넘어갑니다 -->
        </div>
    </div>
</div>

</body>
</html>
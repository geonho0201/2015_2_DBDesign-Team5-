<%@ page language="java" contentType="text/html; charset=UTF-8" 
   pageEncoding="UTF-8" import="java.util.*" import="java.sql.*" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/css.css" rel="stylesheet">
<title>프람트솔루션</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h3 class="text-center login-title">회원가입</h3>
            <div class="account-wall">
                <form class="form-signin" action=""> <!-- 회원가입을 눌렀을떄 action에 디비삽입 페이지로 넘어갑니다 .아이디나 패스워드 logic은 밑에 id값을 이용해서 하시면 될거같습니다--> 
                <input type="text" class="form-control" id="id" placeholder="아이디" > <!-- id라는 값이 넘어갑니다 -->
                <input type="text" class="form-control" id="password" placeholder="비밀번호"> <!-- password라는 값이 넘어값니다 -->
                <input type="text" class="form-control" id="name" placeholder="이름" > <!-- name라는 값이 넘어갑니다 -->
                <input type="text" class="form-control" id="resident" placeholder="주민번호(XXXXXX-XXXXXXX)" > <!-- resident라는 값이 넘어갑니다 -->
                <input type="text" class="form-control" id="address" placeholder="주소" > <!-- address라는 값이 넘어갑니다 -->
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
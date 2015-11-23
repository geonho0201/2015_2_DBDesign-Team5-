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
            <h3 class="text-center login-title">프람트솔루션</h3>
            <div class="account-wall">
                <form class="form-signin" action="main.jsp"> <!-- 로그인을 눌렀을떄 action에 디비조회 페이지로 넘어갑니다 -->
                <input type="text" class="form-control" id="id" placeholder="아이디" > <!-- id라는 값이 넘어갑니다 -->
                <input type="password" class="form-control" id="password" placeholder="비밀번호"> <!-- password라는 값이 넘어값니다 -->
                <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
                </form>
            </div>
            <a href="register.jsp" class="text-center new-account">회원가입 </a> <!-- 회원가입이라는 페이지로 넘어갑니다 -->
        </div>
    </div>
</div>

</body>
</html>
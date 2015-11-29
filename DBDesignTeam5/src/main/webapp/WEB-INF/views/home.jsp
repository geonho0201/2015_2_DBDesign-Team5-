<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../css/css.css" rel="stylesheet" type="text/css">
	<title>Home</title>
</head>
<body>
	<span style="background-color: #D99; color:white;">${errormsg}</span>
	<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h3 class="text-center login-title">프람트솔루션</h3>
            <div class="account-wall">
                <form class="form-signin" action="loginController/login.do"> 
                <input type="text" class="form-control" name="userID" placeholder="아이디" >
                <input type="password" class="form-control" name="userPassword" placeholder="비밀번호">
                <button class="btn btn-lg btn-primary btn-block" type="submit" value="로그인">로그인</button>
                </form>
            </div>
            <a href="${pageContext.request.contextPath}/join" class="text-center new-account">회원가입 </a> 
        </div>
    </div>
</div>
</body>
</html>

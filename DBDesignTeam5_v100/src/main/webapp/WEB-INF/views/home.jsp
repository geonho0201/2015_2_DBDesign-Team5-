<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
 integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" 
integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
 integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	<title>Home</title>
</head>
<body>
	<form method="post" class="form-horizontal" action="${request.contextPath}LoginController/login.do">
	<div class="col-md-4"></div>
		<div class="col-md-4">
			</br>
			</br>
			</br>
			</br>
			</br>
		<h1 class="text-center">프람트 솔루션</h1>
			</br>
			</br>
			<span style="background-color: #D99; color:white;">${errormsg}</span>
	  		<div class="form-group">
	    		<label class="col-sm-3 control-label">아이디</label>
	    		<div class="col-sm-10">
	     		 	<input type="text" class="form-control input-lg" name="userID"/>
	   		 	</div>
	 		</div>
	  			</br>
	  		<div class="form-group">
	    		<label class="col-sm-3 control-label">비밀번호</label>
	    		<div class="col-sm-10">
	      			<input type="password" class="form-control input-lg" name="userPassword"/>
	    		</div>
	  		</div>
				</br>
				</br>
 			 <div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10">
      				<button type="submit" class="btn btn-default btn-lg" value="로그인">로그인</button>
      				<button type="button" class="btn btn-default btn-lg" value="회원가입" onclick="location.href='/mju/join'">회원가입</button>
    			</div>
  			</div>
  		</div>
	</form>
</body>
</html>
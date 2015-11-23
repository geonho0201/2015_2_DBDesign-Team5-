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
  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="navbar-form navbar-left">
			<h6><%=session.getAttribute("id") %>님</h6><!-- 이부분은 id를 받아와서 쓰면 될거같습니다. -->
		</div>
		<div class="navbar-form navbar-right">
			<a class="btn btn-danger" href="home.jsp" role="button">로그아웃</a>
  		</div>
  </nav>
  <div class="container">
	
	        <div class="row">
	
	            <div class="col-md-3">
	            <!-- 여기서 if문을 써서 직무에따라서 나오는 리스트를 다릏게 하면될거 같습니다 -->
	                <div class="list-group">
	                    <a href="#" class="list-group-item">프로젝트관리</a>
	                    <a href="#" class="list-group-item">내 기술</a>
	                    <a href="#" class="list-group-item">내 평가</a>
						<a href="#" class="list-group-item">직원관리</a>
						<a href="#" class="list-group-item">직원검색</a>
	                </div>
	            </div>
	        </div>
</body>
</html>
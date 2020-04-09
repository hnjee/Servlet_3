<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- Nav -->
	<nav class="navbar navbar-inverse">
	 <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">HJ SCHOOL</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="#">Home</a></li>
	      
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="#"></a></li>
	          <li><a href="#">Page 1-2</a></li>
	          <li><a href="#">Page 1-3</a></li>
	        </ul>
	      </li>
	      
	      <li><a href="${pageContext.request.contextPath}/point/pointList">Point</a></li>
	    </ul>
	    
	    <ul class="nav navbar-nav navbar-right">
		<c:if test="${empty member}">
	      <li><a href="${pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      <li><a href="${pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span> Log in</a></li>
	    </c:if>
	    <c:if test="${not empty member}">
	      <li><a href="${pageContext.request.contextPath}/member/memberPage"><span class="glyphicon glyphicon-user"></span> MyPage</a></li>
	      <li><a href="${pageContext.request.contextPath}/member/memberLogout"><span class="glyphicon glyphicon-user"></span> Log out</a></li>
	    </c:if>
	    </ul>
	  </div>
	</nav>

	<!-- Nav -->
	<div class="container">
	  <div class="jumbotron">
	    <h1>WELCOME</h1>      
	    <p>학생 정보와 점수를 관리할 수 있는 홈페이지입니다.</p>
	  </div>
	  <p>학생정보를 확인하고 수정, 삭제하세요.</p>      
	  <p>학생점수를 확인하고 수정, 삭제하세요.</p>
	</div>
	
</body>

</html>
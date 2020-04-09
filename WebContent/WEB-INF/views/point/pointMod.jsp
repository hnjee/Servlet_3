<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">HJ SCHOOL</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="#">Page 1-1</a></li>
	          <li><a href="#">Page 1-2</a></li>
	          <li><a href="#">Page 1-3</a></li>
	        </ul>
	      </li>
	      <li><a href="${pageContext.request.contextPath}/point/pointList">Point</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	    </ul>
	  </div>
	</nav>
	<!-- Nav -->
	
	<div class="container">
	  <div class="jumbotron">
	    <h1>Point Modification</h1>      
	    <p>선택한 학생의 점수를 수정합니다.</p>
	  </div>
	</div>
	<div class="container">
	  <h1>Point Modification</h1>
	  <form action="./pointMod" method="post">
	    <div class="form-group">
	      <label for="Name">Name:</label>
	      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name" value="${dto.name}" readonly>
	    </div>
	
	    <div class="form-group">
	      <input type="hidden" class="form-control" id="num" placeholder="Enter Num" name="num" value="${dto.num}">
	    </div>    
	    
	    <div class="form-group">
	      <label for="Kor">Kor: </label>
	      <input type="text" class="form-control" id="kor" placeholder="Enter kor" name="kor" value="${dto.kor}">
	    </div>  
	      
	    <div class="form-group">
	      <label for="Eng">Eng: </label>
	      <input type="text" class="form-control" id="eng" placeholder="Enter eng" name="eng" value="${dto.eng}">
	    </div> 
	    
	     <div class="form-group">
	      <label for="Math">Math: </label>
	      <input type="text" class="form-control" id="math" placeholder="Enter math" name="math" value="${dto.math}">
	    </div> 
	    <button type="submit" class="btn btn-default">Submit</button>
	  </form>
	</div>
</body>
</html>
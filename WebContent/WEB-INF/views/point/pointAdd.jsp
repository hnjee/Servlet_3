<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<c:import url = "../template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="container">
		<div class="jumbotron">
		    <h1>Bootstrap Tutorial</h1>      
		    <p>Bootstrap is the most popular HTML, CSS, and JS framework for developing responsive, mobile-first projects on the web.</p>
		 </div>
		  <p>This is some text.</p>      
		  <p>This is another text.</p>      
	</div>
		
	<div class="container">
		<h1>Point Input</h1>
		<form action="./pointAdd" method="post">
		    <div class="form-group">
		      <label for="Name">Name:</label>
		      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
		    </div>
		
		    <div class="form-group">
		      <label for="Num">Num: </label>
		      <input type="text" class="form-control" id="num" placeholder="Enter Num" name="num">
		    </div>    
		    
		    <div class="form-group">
		      <label for="Kor">Kor: </label>
		      <input type="text" class="form-control" id="kor" placeholder="Enter kor" name="kor">
		    </div>  
		      
		    <div class="form-group">
		      <label for="Eng">Eng: </label>
		      <input type="text" class="form-control" id="eng" placeholder="Enter eng" name="eng">
		    </div> 
		    
		    <div class="form-group">
		      <label for="Math">Math: </label>
		      <input type="text" class="form-control" id="math" placeholder="Enter math" name="math">
		  	</div> 
		   
		    <button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>
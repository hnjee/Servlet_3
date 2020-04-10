<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
	<meta charset="UTF-8">
	<c:import url = "./template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>
	
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
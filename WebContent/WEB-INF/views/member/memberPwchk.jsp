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
			<h1>PW Check</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
	</div>
	<div class="container">
	  <h1>비밀번호를 한번 더 입력해주세요</h1>
	  <form action="./memberUpdate" method="post">
	    <div class="form-group">
	      <label for="id">아이디:</label>
	      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id" value="${member.id}" disabled>
	    </div>
	
	    <div class="form-group">
	      <label for="pw">비밀번호: </label>
	      <input type="password" class="form-control" id="pw" placeholder="Enter pw" name="pw">
	    </div>    
	     
	    <button class="btn btn-primary" id="update">확인</button>
	  </form>

	</div>
	<script type="text/javascript">
		$("#update").click(function(){
			location.href = "./memberUpdate";
		});
		$("#delete").click(function(){
			var res = confirm("정말 탈퇴하시겠습니까?");
			if(res) {
				location.href = "./memberDelete";
			} 
		});
	</script>
	
</body>
</html>
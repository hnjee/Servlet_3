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
	    <h1>Notice Add</h1>      
	    <p>공지사항을 작성하세요.</p>
	  </div>
	 </div>
	
	<div class="container">
	    <form action="./noticeAdd" method="post">
	      <div class="form-group">
	        <label for="subject">제목</label>
	        <input type="text" class="form-control" id="subject" name="subject" placeholder="제목을 입력하세요.">
	      </div>
	      <div class="form-group">
	        <label for="writer">작성자</label>
	        <input type="text" class="form-control" id="name" name="name" placeholder="내용을 입력하세요.">
	      </div>
	      <div class="form-group">
	        <label for=content>내용</label>
	        <textarea class="form-control" id="contents" name="contents" rows="3"></textarea>
	      </div>
	      <button type="submit" class="btn btn-primary">작성</button>
	    </form>
	</div>
</body>
</html>
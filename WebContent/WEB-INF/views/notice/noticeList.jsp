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
	    <h1>Notice List</h1>      
	    <p>공지사항입니다.</p>
	  </div>
	 
	</div>
	
	<div class="container">
		<div class="row">
			<h1>Notice List</h1>
			<table class="table table-hover">
				<tr>
					<td>NO</td>
					<td>SUBJECT</td>
					<td>NAME</td>
					<td>DATE</td>
					<td>HIT</td>
				</tr>
				
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.no}</td>
						<td><a href="./noticeSelect?no=${dto.no}" >${dto.subject}</a></td>
						<td>${dto.name}</td>
						<td>${dto.day}</td>
						<td>${dto.hit}</td>
					</tr>
				</c:forEach> 
			</table>
			<a href="./noticeAdd" class="btn btn-primary">Add</a>
		</div>
	</div>
</body>
</html>
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
	    <h1>Point Select</h1>      
	    <p>선택한 학생의 점수를 볼 수 있습니다.</p>
	  </div>
	</div>
	
	<div class="container">
		<div class="row">
			<h1>Point Select</h1>
			<table class="table table-hover">
				<tr class="danger">
					<td>이름</td>
					<td>번호</td>
					<td>국어</td>
					<td>영어</td>
					<td>수학</td>
					<td>평균</td>
					<td>총점</td>
				</tr>
					<tr class="input">
						<td>${dto.name}</td>
						<td>${dto.num}</td>
						<td>${dto.kor}</td>
						<td>${dto.eng}</td>
						<td>${dto.math}</td>
						<td>${dto.tot}</td>
						<td>${dto.avg}</td>
					</tr>
			</table>
			<a href="./pointMod?num=${dto.num}" class="btn btn-primary">Update</a>
			<a href="./pointDelete?num=${dto.num}" class="btn btn-danger">Delete</a>
		</div>
	</div>
</body>
</html>
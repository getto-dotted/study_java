<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>commandObject</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
	<h2>Form 값 받기</h2>
	
	<h3>커맨드객체를 이용해서 폼값 한번에 받기</h3>
	
	<ul>
		<li>이름 : ${memberDTO.name }</li>
		<li>아이디 : ${memberDTO.id }</li>
		<li>패스워드 : ${memberDTO.pw }</li>
		<li>이메일 : ${memberDTO.email }</li>
	</ul>
</body>
</html>
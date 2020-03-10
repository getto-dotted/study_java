<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requestParam.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
	<h2>Form값 받기</h2>
	
	<h3>@RequestParam 어노테이션으로 폼값 받기</h3>
	
	<ul>
		<li>이름 : ${memberInfo.name }</li>
		<li>아이디 : ${memberInfo.id }</li>
		<li>패스워드 : ${memberInfo.pw }</li>
		<li>이메일 : ${memberInfo.email }</li>
	</ul>
</body>
</html>
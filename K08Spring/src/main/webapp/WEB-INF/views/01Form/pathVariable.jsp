<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
	<h2>Form 데이터 받기</h2>
	
	<h3>@PathVariable 어노테이션으로 폼값 받기</h3>
	<ul>
		<li>이름 : ${m_name }</li>
		<li>아이디 : ${m_id }</li>
		<li>패스워드 : ${m_pw }</li>
		<li>이메일 : ${m_email }</li>
	</ul>
	
	<h3>상대경로</h3>
	<img src="../../../../images/3.png" alt="" />	
	
	<h4>절대경로</h4>
	<img src="/k08spring/images/4.png" alt="" />	
</body>
</html>
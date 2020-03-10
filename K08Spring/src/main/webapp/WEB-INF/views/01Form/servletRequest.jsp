<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>servletRequest</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
	<h2>HttpServletRequest로 폼값받기(Get방식)</h2>
	
	<ul>
		<li>아이디 : ${id }</li>
		<li>패스워드 : ${pw }</li>
		<li>메세지 : ${message }</li>
	</ul>
</body>
</html>
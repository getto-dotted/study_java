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
	<a href="./anno.do?param1=Hello&param2=어노테이션">메시지 출력</a>
	
	<h1>${m1 }</h1>
	<h2>${m2 }</h2>
	<ul>
		<li>파라미터1 : ${a }</li>
		<li>파라미터2 : ${b }</li>
	</ul>
</body>
</html>
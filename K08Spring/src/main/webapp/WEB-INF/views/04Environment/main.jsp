<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
	<h2>Environment 객체를 위용한 외부파일 읽어오기</h2>
	
	<h3>오라클 접속정보 읽어오기</h3>
	
	<ul>
		<li>드라이버 : ${driver }</li>
		<li>URL : ${url }</li>
	</ul>
</body>
</html>
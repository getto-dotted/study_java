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
	<h2>@RequestMapping 어노테이션</h2>
	
	<h3>GET방식으로 전송된 검색 파라미터</h3>
	
	<ul>
		<li>검색필드 : ${sColumn }</li>
		<li>검색단어 : ${sWord }</li>
	</ul>
</body>
</html>
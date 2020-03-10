<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modelAttribute</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
	<h2>@RequestMapping 어노테이션</h2>
	
	<h3>@ModelAttribute 어노테이션을 사용하여 커맨드 객체명 변경</h3>
	
	<ul>
		<li>이름 : ${si.name }</li>
		<li>나이 : ${si.age }</li>
		<li>학년 : ${si.gradeNum }</li>
		<li>학급 : ${si.classNum }</li>
	</ul>
</body>
</html>
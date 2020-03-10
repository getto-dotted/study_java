<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myCalculator</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
	<h2>DI(의존주입)을 활용한 간단한 사칙연산 계산기</h2>
	
	<h3>200과 100의 사칙연산 결과는?</h3>
	
	<ul>
		<li>덧셈결과 : ${addResult }</li>
		<li>뺄셈결과 : ${subResult }</li>
		<li>곱셈결과 : ${mulResult }</li>
		<li>나눗셈결과 : ${divResult }</li>
	</ul>
</body>
</html>
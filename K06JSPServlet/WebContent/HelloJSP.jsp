<%@page import="test.Test"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelloJSP.jsp</title>
</head>
<body>
	<h2>HelloJSP</h2>
	<%
		out.println("처음 실행해보는 JSP");
	
		Test test = new Test(); 
		int result = test.add(100,200);
		out.print("합은?"+result);
	%>
</body>
</html>
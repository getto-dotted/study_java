<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ObjectParam.jsp</title>
</head>
<body>
	<h2>객체를 파라미터로 전달하기</h2>
	<%
		//페이지 포워드(전달)전 request영역에 객체저장
		request.setAttribute("dtoObj", new MemberDTO("KoreaVC", "1234", "한직전", null));
		request.setAttribute("strObj", "String객체");
		request.setAttribute("integerObj", new Integer(100));

		RequestDispatcher dis = request.getRequestDispatcher("ObjectResult.jsp?num1=10&num2=20");
		dis.forward(request, response);
	%>

</body>
</html>
<%@page import="util.JsFunction"%>
<%@page import="practice.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입중입니다</title>
</head>
<body>
	<h2>회원가입 폼값 받기</h2>
<%
	request.setCharacterEncoding("UTF-8");

	String driver = application.getInitParameter("JDBCDriver");
	String url = application.getInitParameter("ConnectionURL");
	
	//DAO객체 생성 및 DB연결
	MemberDAO dao = new MemberDAO(driver, url);
	
	dao.joinMember(request.getParameter("id"), request.getParameter("pass"), request.getParameter("name"));	
		
	out.println(JsFunction.jsAlertLocation("회원가입되었습니다.", "BoardList.jsp"));    
%>
</body>
</html>
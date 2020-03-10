<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="dataObject.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	String driver = application.getInitParameter("JDBCDriver");
	String url = application.getInitParameter("ConnectionURL");
	
	//DAO객체 생성 및 DB연결
	MemberDAO dao = new MemberDAO(driver, url);
	
	//파라미터를 저장할 컬렉션 생성
	Map param = new HashMap();
	
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel1") +"-"+ request.getParameter("tel2") +"-"+ request.getParameter("tel3");
	String mobile = request.getParameter("mobile1")+"-"+request.getParameter("mobile2")+"-"+request.getParameter("mobile3");
	String email = request.getParameter("email_1")+"@"+request.getParameter("email_2");
	String zipcode = request.getParameter("zipcode");
	String addr = request.getParameter("addr1");
	String addr2 = request.getParameter("addr2");
	String email_open = request.getParameter("open_email");
	int grade = 0;
	
	param.put("id", id);
	param.put("pass", pass);
	param.put("name", name);
	param.put("tel", tel);
	param.put("mobile", mobile);
	param.put("email", email);
	param.put("zipcode", zipcode);
	param.put("addr", addr);
	param.put("email_open", email_open);
	param.put("grade", grade);
	param.put("addr2", addr2);
	
	
	dao.joinMember(id, pass, name, tel, mobile, email, zipcode, addr, email_open, grade, addr2);
	
	
%>
<script>
	var name = '<%=name %>';
	alert( name + '님 회원가입을 환영합니다.');
	location.href='../main/main';
</script>	
	
</body>
</html>
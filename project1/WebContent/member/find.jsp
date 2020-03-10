<%@page import="dataObject.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<%
request.setCharacterEncoding("UTF-8");

String driver = application.getInitParameter("JDBCDriver");
String url = application.getInitParameter("ConnectionURL");

//DAO객체 생성 및 DB연결
MemberDAO dao = new MemberDAO(driver, url);

String fname = request.getParameter("name");
String femail = request.getParameter("email");
String id = "";		
id = dao.findId(fname, femail);		
%>
	<script>
		alert("<%=fname%> 회원님의 아이디는 <%=id%> 입니다.");
		window.close();
	</script>
<%
MemberDAO dao2 = new MemberDAO(driver, url);
String wname = request.getParameter("name2");
String wemail = request.getParameter("email2");
String wid =  request.getParameter("id");
String fPw= "";		
fPw = dao2.findPw(wid, wname, wemail);	

%>
	<script>
		alert("<%=wname%> 회원님의 비밀번호는 <%=wemail%> 로 전송되었습니다. <%=fPw%>");	
		window.close();
	</script>

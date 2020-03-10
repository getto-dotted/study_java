<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Logout.jsp -->
<% 
	//세션영역에 저장된 속성을 제거함
	session.removeAttribute("USER_ID");
	//로그인 페이지로 이동
	response.sendRedirect("../main/main");
%>
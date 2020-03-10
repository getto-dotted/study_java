<%@page import="model.BbsDAO"%>
<%@page import="model.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/isLogin.jsp"%>

<%
request.setCharacterEncoding("UTF-8");


String title = ""; 
String content = "";

for(int i =30; i<=35; i++){
	title += (i+"호");
	content += (i+"입니다.");

	BbsDTO dto = new BbsDTO();
	dto.setTitle(title);
	dto.setContent(content);
	dto.setId(session.getAttribute("USER_ID").toString());

	BbsDAO dao = new BbsDAO(application);

	
}
%>
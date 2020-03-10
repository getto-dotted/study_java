<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- PostLogin1.jsp --%>
<%@ page trimDirectiveWhitespaces="true" %>       
<%
String user_id = request.getParameter("user_id");
String user_pw = request.getParameter("user_pw");
if(user_id.equals("koreavc") && user_pw.equals("1234")){
%>{
		'user_id':'koreavc',
		'user_name':'한직전',
		'user_pw':'1234',
		'result':1
}<%	
}
else
{
%>{
		'result':0
}<%	
}
%>
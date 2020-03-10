<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.catalina.filters.SetCharacterEncodingFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<%-- 서버와 통신시 XML 혹은 JSON으로 콜백해야 하는 경우
페이지 상단에 필요없는 공백은 반드시 제거해주는 것이 좋다. --%>
<%@ page trimDirectiveWhitespaces="true" %>
<%-- PrintToday.jsp --%>  
<%
request.setCharacterEncoding("UTF-8");

String msg = request.getParameter("msg");
String varStr = request.getParameter("varStr");
String today = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

out.println("<h2>메시지: "+msg+"</h2>");
out.println("<h2>varStr: "+varStr+"</h2>");
out.println("<h2>오늘날짜: "+today+"</h2>");
%>
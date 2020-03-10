<%@page import="java.util.Collection"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/*  
브라우저가 가지고 있는 캐쉬기능을 사용하지 않겠다는 의미.
새로운 내용을 db에 추가해도 변경된 내용이 출력되지 않는 경우에
사용된다.
*/
	response.setHeader("Pragma", "no-cache");
	response.setHeader("cache-control", "no-cache");
/*  
파일 다운로드 구현시 사용하는 응답헤더 설정으로 웹브라우저가
인식하지 못하는 타입을 강제적으로 설정하면 브라우저는 파일다운로드
창을 띄우게 된다.
*/
	//response.setContentType("binary/octect-stream");
/*  
응답헤더 추가 설정하기
	add계열 : 기존 헤더명이 존재할경우 계속 추가한다.
		없을 경우에는 새롭게 생성한다.
	set계열 : 기존 헤더명이 존재할 경우 기존헤더의 값을 변경한다.
		없을 경우에는 새롭게 생성한다.
*/
	long time = new Date().getTime();
	System.out.println("time=" + time);
	response.setDateHeader("currentDate", time);//날짜관련 응답헤더 추가

	SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	time = simple.parse("2017-12-25 10:30").getTime();
	System.out.println("time=" + time);
	response.setDateHeader("currentSimple", time);

	response.setIntHeader("studentOfKoreavc", 24);//숫자관련 응답헤더 추가
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ResponseHeader</title>
</head>
<body>
	<h2>응답헤더 정보 출력하기</h2>
	<%
		Collection<String> headerNames = response.getHeaderNames();

		for (String headerName : headerNames) {
			String headerValue = response.getHeader(headerName);
	%>
	<li><%=headerName%> : <%=headerValue%></li>

	<%
		}
	%>


</body>
</html>
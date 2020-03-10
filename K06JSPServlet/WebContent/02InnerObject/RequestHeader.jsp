<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>요청 헤더정보 출력하기</h2>
	<% 
	/*  
	getHeaderNames() :
		request 내장객체의 getHeaderNames() 메소드를 통해 요청헤더의
		정보 전체를 받아올 수 있다.		
		해당 함수는 열거형 클래스인 Enumeration타입의 반환값을 가진다.
		관련메소드 : 
			hasMoreElements() : 다음 항목이 있는지 검사한다.
			nextElement() : 다음 항목을 꺼내온다.
	*/
	
	Enumeration headers = request.getHeaderNames();
	while(headers.hasMoreElements()){
		//헤더명을 얻어온다
		String headerName = (String)headers.nextElement();
		//헤더명을 이용해서 헤더값을 얻어온다.
		String headerValue = request.getHeader(headerName);
		out.println(String.format("헤더명:%s, 헤더값:%s<br/>", headerName, headerValue));
		
	}
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestInfo.jsp</title>
</head>
<body>
	<%
	/* 
	get방식이나 post방식으로 전송할 경우 영문과 숫자를 제외한 나머지 문자는
	깨질 수 있으므로 깨짐방지를 위해 아래 함수를 통해 인코딩을 설정한다.
	*/
	request.setCharacterEncoding("UTF-8");
	%>
	<h2>사용자 요청과 관련된 정보들 출력하기</h2>
	<!-- ul>li*9 -->
	<ul>
		<li>데이터전송방식 : <%=request.getMethod()%></li>
		<li>전체URL : <%=request.getRequestURL()%></li>
		<li>도메인을 제외한 URL : <%=request.getRequestURI()%></li>
		<li>프로토콜 : <%=request.getProtocol()%></li>
		<li>서버명 : <%=request.getServerName()%></li>
		<li>서버포트 : <%=request.getServerPort()%></li>
		<li>사용자IP주소 : <%=request.getRemoteAddr()%></li>
		<li>QueryString : <%=request.getQueryString()%></li>

		<li>전송된 값 확인 : <%=request.getParameter("paramHan")%></li>
	</ul>
</body>
</html>
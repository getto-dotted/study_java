<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07Redirect.jsp</title>
</head>
<body>
	<!-- 
	redirect태그
		: redirect방식으로 새로운 페이지에 대한 요청이므로
		request영역은 공유되지 않는다.
		import태그와 마찬가지로 절대경로로 url속성 지정시
		컨텍스트루트 경로는 제외한다.
	 -->
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<c:set var="requestVar" scope="request">리퀘스트영역저장</c:set>

	<h3>자바 코드로 리다이렉트</h3>
	<%
		/*  
		영어와 숫자를 제외한 나머지 문자들은 Get방식(쿼리스트링)으로
		값을 전달할 때 깨짐현상이 발생할 수 있으므로, 아래와 같이 인코딩 처리후
		전달하는 것이 좋다.
		
		String p1 = URLEncoder.encode("Korea[한국]");
		String p2 = URLEncoder.encode("Fighting[화이팅]");
		response.sendRedirect(request.getContextPath()+"/common/ImportPage.jsp?user_id="+p1+"&user_pw="+p2);
		*/
	%>

	<h3>JSTL로 리다이렉트</h3>
	<c:redirect url="/common/ImportPage.jsp">
		<c:param name="user_id" value="Korea[한국]" />
		<c:param name="user_pw" value="Germany[독일]" />
	</c:redirect>


</body>
</html>
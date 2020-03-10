<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08URL.jsp</title>
</head>
<body>
<!-- 
	url태그
		: url생성시 사용한다.
		절대경로로 생성시에는 컨텍스트루트 경로를 제외한다.
		var속성을 미지정하는 겨웅 해당 위치에 url이 문자열로 출력된다.
 -->
	<h3>var속성 미지정</h3>
	<c:url value="/common/ImportPage.jsp">
		<c:param name="user_id">korea</c:param>
		<c:param name="user_pw">vc</c:param>
	</c:url>
	
	<h3>var속성 지정</h3>
	<c:url value="/common/ImportPage.jsp" var="url">
		<c:param name="user_id">hong</c:param>
		<c:param name="user_pw">gildong</c:param>
	</c:url>
	
	<h3>var속성 지정후 원하는 위치에 url설정</h3>
	<a href="${url }">ImportPage.jsp바로가기</a>
	
	<h3>HTML 태그에 직접 JSTL로 절대경로 지정하기</h3>
	<a href="<c:url value='/common/ImportPage.jsp?user_id=Lee&user_pw=7777'/>" >ImportPage바로가기</a>
</body>
</html>
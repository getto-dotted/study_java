<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestScopeResult.jsp</title>
</head>
<body>
	<h1>RequestScopeResult.jsp 파일입니다.</h1>
	<h2>이전 페이지에서 리퀘스트 영역에 저장된 속성읽기</h2>
	
	<h3>
		Main페이지에서 페이지 이동(a태그, JS의 location객체 등)을 한
		경우에는 request영역이 공유되지 않아 아래부분은 null로 표시된다.
		<br />
		포워드 한 경우 request영역이 공유되어 정상적으로 표시된다.
	</h3>
	
	<li>Integer타입 : <%=request.getAttribute("requestNumber")%></li>
	<li>String타입 : <%=request.getAttribute("requestString")%></li>
</body>
</html>
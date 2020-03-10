<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>09Out.jsp</title>
</head>
<body>
	<h2>out태그</h2>
	
	<c:set var="htmlStr"><h3>h3태그로 감싼 문자열</h3></c:set>
	
	
	<!-- 기본값이거나 true일때는 HTML이 해석되지 않고 태그까지
	그대로 출력된다. JS의 innerText()와 동일하다. -->
	<h3>escapeXml=true(기본값)일때</h3>
	<c:out value="${htmlStr }" escapeXml="true"></c:out>
	<br />
	\${htmlStr } : ${htmlStr }
	
	<!-- HTML이 해석되어서 화면에 출력된다. JS의 innerHTML()과 동일하다. -->
	<h3>escapeXml=false일때</h3>
	<c:out value="${htmlStr }" escapeXml="false"></c:out>
	<br />
	\${htmlStr } :↓ ${htmlStr }
	
	<!-- 
		out태그에 value속성이 null일때 default속성에 지정한 값이 출력된다.
		단, 빈문자열("")인 경우에는 값이 있는 것으로 간주되어 
		default값은 출력되지 않는다.
	 -->
	<h3>default속성</h3>	
	<h4>값이 빈 문자열 : 값이 있는 경우에 해당</h4>
	출력 : <c:out value="" default="값이 빈 문자열인 경우 기본값을 출력"></c:out>
	
	<h4>값이 null인 경우 : 값이 없는 경우에 해당</h4>
	출력 : <c:out value="${null }" default="값이 null인 경우 기본값을 출력"></c:out>
	
	<!-- 
	파리미터로 nowPage가 없는 경우라면 default값인 1이 삽입되고,
	있는 경우에는 해당 값이 삽입된다. 즉 default값은 null인 경우에만 활용된다.
	 -->
	<h3>페이지 링크에 응용하기</h3>
	<c:url value="/06BoardPaging/BoardList.jsp?nowPage="/>
	<c:out value="${param.nowPage }" default="1" />
	<hr />
	<a href="<c:url value="/06BoardPaging/BoardList.jsp?nowPage="/><c:out value="${param.nowPage }" default="1"/>">회원제게시판 리스트 바로가기</a>
	
	
	<a href="<c:url value="../../PersonalPractice/Board/BoardList.jsp"/>">회원제게시판 리스트 바로가기</a>
	<h3>외부프로젝트</h3>
	<iframe src="../../PersonalPractice/Board/BoardList.jsp" frameborder="1"
		style="width: 100%; height: 500px;"></iframe>
	
	
	
	
	
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02Remove.jsp</title>
</head>
<body>
	<h2>remove 태그</h2>
	
	<c:set var="pageVar" value="페이지영역"/>
	<c:set var="pageVar" value="리퀘스트영역1번" scope="request"/>
	<c:set var="requestVar" value="리퀘스트영역2번" scope="request"/>
	<c:set var="sessionVar" value="세션영역" scope="session"/>
	<c:set var="appVar" value="어플리케이션영역" scope="application"/>
	
	<h3>삭제전 출력하기</h3>
	<ul>
		<li>페이지 : ${pageVar }</li>
		<li>리퀘스트1 : ${requestScope.pageVar }</li>
		<li>리퀘스트2 : ${requestVar }</li>
		<li>세션 : ${sessionVar }</li>
		<li>어플리케이션 : ${appVar }</li>		
	</ul>
	
	<h3>remove로 삭제하기 : 속성명은 존재하나 영역이 다르면 삭제되지 않는다.</h3>
	<c:remove var="requestVar" scope="session"/>
	
	<h3>영역이 다른 속성명 삭제후 출력하기</h3>
	<ul>
		<li>페이지 : ${pageVar }</li>
		<li>리퀘스트1 : ${requestScope.pageVar }</li>
		<li>리퀘스트2 : ${requestVar }</li>
		<li>세션 : ${sessionVar }</li>
		<li>어플리케이션 : ${appVar }</li>		
	</ul>
	
	<h3>remove로 삭제하기 : 동일한 속성명이 여러 영역에 존재할때는 동시에 삭제된다.(※주의요함)</h3>
	<c:remove var="pageVar"/>
	
	
	
	<h3>스코프 미지정 후 같은 속성명 삭제후 출력하기</h3>
	<ul>
		<li>페이지 : ${pageVar }</li>
		<li>리퀘스트1 : ${requestScope.pageVar }</li>
		<li>리퀘스트2 : ${requestVar }</li>
		<li>세션 : ${sessionVar }</li>
		<li>어플리케이션 : ${appVar }</li>		
	</ul>
	
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05ForEachBasic.jsp</title>
</head>
<body>
	<h2>일반 for문 형태의 forEach태그</h2>
	<!-- 
		JSTL의 forEach문(기본형)
			begin : 시작값/ end : 종료값/ var : 변수명
			: 변수가 begin부터 end 까지 증가하면서 반복한다.
	 -->
	<h3>JSTL 및 EL로 Hn태그 출력하기</h3>
	<c:forEach begin="1" end="6" var="i">
		<h${i }>난 H${i }태그입니다.</h${i }>
	</c:forEach>
	
	<h3>varStatus속성 살펴보기</h3>
	<!-- 
	일반 forEach문에서의 varStatus속성
		: 반복과 관련된 정보를 추상화한 클래스인 LoopTagStatus객체를
		통해 반복과 관련된 정보를 제공한다.
		
		count : 실제 반복횟수(1~마지막)
		index : 변수 i의 변화값
		first : loop의 처음일때 true, 나머지는 false
		last : loop의 마지막일때 true, 나머지는 false
		current : 현재 loop의 변수값(var속성에 지정된 변수)
		
	 -->
	<c:forEach begin="3" end="5" var="i" varStatus="loop">
		<h4>${loop.count }번째 반복입니다</h4>
		<ul>
			<li>index : ${loop.index }</li>
			<li>first : ${loop.first }</li>
			<li>last : ${loop.last }</li>
			<li>current : ${loop.current }</li>			
		</ul>	
	</c:forEach>

	<h3>1에서 100까지의 정수중 홀수의 합</h3>
	<c:forEach begin="1" end="100" var="j">
		<c:if test="${j mod 2 ne 0 }">
			<c:set var="sum" >${sum+j }</c:set>
		</c:if> 
	</c:forEach>
	1~100사이의 정수중 홀수의 합은? ${sum }
	<br />
	<br />
	<h3>if문을 통한 출력</h3>
	<c:forEach begin="1" end="5" var="i">
		<c:forEach begin="1" end="5" var="j">
			<c:if test="${i==j }">1&nbsp;</c:if>
			<c:if test="${i!=j }">0&nbsp;</c:if>
<%-- 		<c:if test="${i==j }" var="result">1&nbsp;</c:if>
			<c:if test="${not result}">0&nbsp;</c:if> --%>
		</c:forEach>
			<br />	
	</c:forEach>
	<br />
	<br />
	<!-- JSTL태그 사이에는 HTML 주석을 사용하지 않는 것이 좋다.
	사용할 경우 JSTL태그로 인식하게 되어 에러가 발생할 수 있다. -->
	<h3>choose문을 통한 출력</h3>
	<c:forEach begin="1" end="5" var="i">
		<c:forEach begin="1" end="5" var="j">
			<c:choose>
				<c:when test="${i==j }">1&nbsp;</c:when>
				<c:otherwise>0&nbsp;</c:otherwise>
			</c:choose>
		</c:forEach>
			<br />	
	</c:forEach>
	<br />
	<br />
		<h3>if문을 통한 출력</h3>
	<c:forEach begin="1" end="5" var="i">
		<c:forEach begin="1" end="5" var="j">			
			<c:if test="${i+j==6 }" var="result">1&nbsp;</c:if>
			<c:if test="${not result}">0&nbsp;</c:if> 
		</c:forEach>
			<br />	
	</c:forEach>
	<br />
	<br />
		<h3>choose문을 통한 출력</h3>
	<c:forEach begin="1" end="5" var="i">
		<c:forEach begin="1" end="5" var="j">
			<c:choose>
				<c:when test="${i+j==6 }">1&nbsp;</c:when>
				<c:otherwise>0&nbsp;</c:otherwise>
			</c:choose>
		</c:forEach>
			<br />	
	</c:forEach>
</body>
</html>
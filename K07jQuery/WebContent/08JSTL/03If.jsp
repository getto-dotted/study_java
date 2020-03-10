<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03If.jsp</title>
</head>
<body>
	<h2>if태그</h2>
	<!-- 
	if태그 : JSTL의 if문은 시작태그와 종료태그를 통해 조건을 판단한다
		else문이 없기 때문에 조건이 여러개인 경우 사용이 어렵다.
		이때는 choose문을 주로 사용한다.
		
		test : 조건식
		var : 조건에 대한 결과값
	 -->
	<c:set var="numVar" value="100"/>
	<c:set var="strVar" value="JAVA"/>
	
	<h3>JSTL의 if태그로 짝수/홀수 판단하기</h3>
	<c:if test="${numVar mod 2 eq 0 }" var="result"	>
		${numVar }는 짝수입니다. <br />
	</c:if>
	\${result } : ${result } <br />
	
	<h3>위 if문을 EL식의 삼항식으로 표현</h3>
	\${numVar } : ${numVar mod 2 == 0 ? "는 짝수" : "는 홀수" }
	
	<!-- if문에 else가 없기때문에 참 or 거짓의 형태로 만들고 싶을때는
	아래와 같이 참의 조건, 거짓의 조건을 각각 만들어서 판단한다. -->
	<h3>문자열 비교</h3> 
	<c:if test="${strVar eq '자바' }">${strVar }는 자바다 <br /></c:if>
	<c:if test="${strVar ne '자바' }">${strVar }는 자바가 아니다 <br /></c:if>

	<h2>if문 사용시 주의사항</h2>
	<!-- 
	-test속성에 EL식이 아닌 일반값이 들어가면 무조건 false를 반환
	-EL식이더라도 {} 양쪽에 공백이 들어간다면 무조건 false를 반환
	-단, 일반값이라도 TRUE(대소문자 구분없음)인 경우에는 true를 반환
	 -->
	<h3>항상 출력되거나 출력되지 않는 조건식</h3>
	<c:if test="${true }">
		난 항상 출력됨
	</c:if>
	<c:if test="${false }">
		난 절대 출력 안됨
	</c:if>
	
	<h3>test속성에 일반값으로 조건지정</h3>
	<c:if test="100" var="result">
		100은 일반값이므로 무조건 false반환	
	</c:if>
	\${result } : ${result } <br />
		
	<c:if test="tRuE" var="result">
		TRUE(true) 대소문자 구분없음. 항상참임. <br />	
	</c:if>
		\${result } : ${result } <br />
		
	<h3>EL식으로 조건판단시 {}양쪽에 공백이 있으면 무조건 false로 판단됨</h3>
	<c:if test="${true } " var="result">
		빈 공백이 있어서 무조건 false처리됨 
	</c:if>
		\${result } : ${result } <br />

	<h3>연습문제 : if태그</h3>
	<!-- 
	파라미터로 아이디와 비밀번호를 받아서 각각 koreavc, 1234인 경우는
	"로그인 성공" 틀린경우 "로그인 실패"를 출력하는 프로그램을
	JSTL의 if태그만을 이용해서 구현하시오.
	 -->
	<form method="get">
		아이디 : <input type="text" name="id" /> 
		<br />
		패스워드 : <input type="password" name="pass"/>
		<br />
		<input type="submit" value="로그인"/>	
	</form>
	
	<!-- 첫 실행시에는 아래 결과가 보이지 않고, 로그인을 시도했을때만
	실행결과가 보이게 처리한다. -->
	<c:if test="${not empty param.id }">
		<c:if test="${param.id == 'koreavc' and param.pass eq '1234'}"
				var="result">로그인 성공 <br />
		</c:if>
		<c:if test="${not result }">
			로그인 실패<br />
		</c:if>
	</c:if>
	








































</body>
</html>
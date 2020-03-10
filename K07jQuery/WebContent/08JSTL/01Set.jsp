<%@page import="model.MemberDTO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
JSP문서에서 JSTL을 사용하기 위해 가장 먼저 선언해야 하는 부분으로
taglib 지시어를 사용하고 접두어와 지원 URL을 기술한다.
 -->	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01Set.jsp</title>
</head>
<body>
	<h2>set태그</h2>
	<h3>set태그로 EL에서 사용할 변수 설정하기</h3>
	<!-- 
		set태그 속성
			var : 변수명을 설정, 문자열만 가능.
			value : 변수에 할당할 값 지정. 표현식, EL식 모두 사용가능.
			scope : 영역의 이름 지정. 미 지정시 가장 좁은 page영역 선택.
	
	JSP의 setAttribute()와 같은 역할.			
	 -->
	<ul>
		<li>1.value속성에 직접 값 대입: <c:set var="directVar" value="100" />
		</li>
		<li>2.value속성에 EL로 값 대입: <c:set var="elVar"
				value="${directVar mod 5 }" />
		</li>
		<li>3.value속성에 표현식으로 값 대입: <c:set var="expVar"
				value="<%=new Date() %>" />
		</li>
		<li>4.시작태그와 종료태그 사이에 값 설정: <c:set var="betweenVar">변수값 요렇게 설정</c:set>
		</li>
	</ul>
	<!-- scope 속성을 사용하지 않았으므로 위의 변수는 모두 페이지 영역에 생성됨. -->
	
	<h3>set태그로 설정한 데이터 표현식으로 출력</h3>
	<ul>
		<li>directVar : <%=pageContext.getAttribute("directVar") %></li>
		<li>elVar : <%=pageContext.getAttribute("elVar") %></li>
		<li>expVar : <%=pageContext.getAttribute("expVar") %></li>
		<li>betweenVar : <%=pageContext.getAttribute("betweenVar") %></li>
	</ul>
	
	<!-- EL로 영역을 읽어올때 xxxScope를 생략하면 가장 작은 영역을
	읽어오므로 아래는 모두 page영역에서 속성을 가져온다. -->
	<h3>EL로 출력</h3>
	<ul>
		<li>directVar : ${directVar }</li>
		<li>elVar : ${elVar }</li>
		<li>expVar ${expVar }:</li>
		<li>betweenVar : ${betweenVar }</li>
	</ul>

	<h2>set태그로 각 영역에 객체 저장하기</h2>
	<c:set var="pageVar" scope="page">"페이지영역"</c:set>
	<c:set var="requestVar" scope="request">"리퀘스트영역"</c:set>
	<c:set var="sessionVar" scope="session">"세션영역"</c:set>
	<c:set var="applicationVar" scope="application">"어플리케이션영역"</c:set>


	<h3>JSP코드로 출력</h3>
	<ul>
		<li>pageVar:<%=pageContext.getAttribute("pageVar") %></li>
		<li>requestVar:<%=request.getAttribute("requestVar") %></li>
		<li>sessionVar:<%=session.getAttribute("sessionVar") %></li>
		<li>applicationVar:<%=application.getAttribute("applicationVar") %></li>

	</ul>

	<h3>EL로 출력[xxxScope사용]</h3>
	<ul>
		<li>pageVar: ${pageScope.pageVar }</li>
		<li>requestVar: ${requestScope.requestVar }</li>
		<li>sessionVar: ${sessionScope.sessionVar }</li>
		<li>applicationVar: ${applicationScope.applicationVar }</li>
	</ul>
	<!-- 
		영역에 속성저장시 모두 다른 이름으로 저장했으므로 아래와 같이
		영역을 지정하지 않은 상태로 출력하는 것이 일반적이다.
	 -->
	<h3>EL로 출력[xxxScope미사용]</h3>
	<ul>
		<li>pageVar: ${pageVar }</li>
		<li>requestVar: ${requestVar }</li>
		<li>sessionVar: ${sessionVar }</li>
		<li>applicationVar: ${applicationVar }</li>
	</ul>
	
	<h2>set태그로 자바빈 객체설정</h2>
		
	<h3>인자생성자로 설정</h3>
	<c:set var="argsMember" 
		value='<%=new MemberDTO("KIM", "1111", "김태희", null) %>'
		scope="request" />
			
	
	<h3>JSP코드로 출력</h3>
	<ul>
		<li>아이디: <%=((MemberDTO)request.getAttribute("argsMember")).getId() %></li>
		<li>이름 : <%=((MemberDTO)request.getAttribute("argsMember")).getName() %></li>
	</ul>
	<!-- 
		영역에 저장된 속성을 java코드로 읽어올 때는 형변환후 사용해야 하지만,
		EL을 이용하면 자동으로 형변환되고영역 미지정시 가장 좁은 영역을 읽어오므로
		훨씬 더 간단히 표현할 수 있다.
	 -->
	<h3>EL로 출력</h3>
	<ul>
		<li>아이디:${requestScope.argsMember.id } </li>
		<li>이름 : ${argsMember.name }</li>
	</ul>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>
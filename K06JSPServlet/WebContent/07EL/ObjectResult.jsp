<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ObjectResult.jsp</title>
</head>
<body>
	<h2>EL의 param 내장객체로 파라미터읽기</h2>
	<h3>자바코드로 영역 및 파라미터 읽기</h3>
	<h4>영역에 저장된 값</h4>
	<%
	/*  
	Java코드를 통해 영역의 속성을 가져올때는
		1.getAttribute()로 가져온다.
		2.해당 타입으로 형변환한다.
		3.getter()메소드를 통해 저장된 값을 가져와 출력한다.
	*/
	MemberDTO member = (MemberDTO)request.getAttribute("dtoObj");
	%>
	<ul>
		<li>MemberDTO객체 : <%=String.format("아이디:%s,"+"비번:%s, 이름:%s", 
					member.getId(), member.getPass(), member.getName())	%>
		</li>
		<!-- String, Integer와 같은 기본객체는 형변환 없이 출력이 가능하다. -->
		<li>
			String객체 : <%=request.getAttribute("strObj") %>
		</li>
		<li>
			Integer객체 : <%=request.getAttribute("integerObj") %>
		</li>
	</ul>

	<h4>파라미터로 전달된 값 읽기</h4>
	<%
	/*  
	파라미터로 전달되는 값은 항상 문자열이므로 산술연산을 위해서는
	반드시 숫자로 변환해야 한다.
	*/
	int fNum = Integer.parseInt(request.getParameter("num1"));
	int sNum = Integer.parseInt(request.getParameter("num2"));
	%>
	두 파라미터의 합 :
	<%=fNum+sNum %>

	<h3>EL로 영역과 파라미터로 전달된 값 읽기</h3>
	<h4>영역에 저장된 값</h4>
	<ul>
	<!-- EL을 통해 DTO객체를 출력할때는 내부적으로는 getter()메소드를
	통해서 출력하게 되므로 만약 getter()가 선언되어 있지 않으면 예외가 발생한다.
	단, 접근시에는 아래와 같이 멤버변수명만 기술하면 된다. -->
		<li>MemberDTO객체 : <br />
			아이디 : ${dtoObj.id }, 비번 : ${dtoObj.pass },	이름 : ${dtoObj.name }
		</li>
		<!-- 가장 좁은 영역에 존재하는 속성을 읽어오므로, 속성명이
		다르다면 영역을 지정하지 않아도 된다. -->
		<li>String객체 : ${requestScope.strObj }</li>
		<li>Integer객체 : ${integerObj }</li>
	</ul>
	<%--
		EL의 param내장객체를 통해 파라미터를 읽을때
			1.param.폼이름
			2.param.['폼이름']
			3.param.["폼이름"]
		세가지 표현 모두 가능하다.
	 --%>
	<h4>파라미터로 전달된 값의 합</h4>
	<ul>
		<li>${param.num1 + param['num2'] } => 결과:30</li>
		<li>${param.num1 }+ ${param['num2'] } => 결과:10+20</li>
	</ul>

</body>
</html>
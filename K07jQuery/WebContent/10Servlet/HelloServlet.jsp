<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!-- 
서블릿(컨트롤러) 작성규칙

1. 서블릿으로 제작되는 클래스는 반드시 public으로 선언한다.
2. HttpServlet 클래스를 상속받는다.
3. doGet() 혹은 doPost()메소드를 오버라이딩 한다.(service()메소드를 사용해도 된다. 해당 메소드는
   get방식, post방식 둘다 처리할 수 있다.)
4. 3번에서 메소드 오버라이딩시 ServletException, IOException에 대한 예외처리를 한다.
5. 서블릿은 사용자의 요청을 받아서 서블릿 클래스에 정의된 doGet()/doPost()메소드를 호출하게 된다.
   이때 사용자의 요청과 서버의 응답은 HttpServletRequest, HttpServletResponse 객체를 통해 처리된다.

서블릿 작성순서

1. 요청명을 생성한다.
	생성시 컨텍스트 루트를 제외한 /(슬러시)로 시작하는 경로를 요청명으로 생성해야 한다.
2. 1에서 생성한 요청명을 이용해서 web.xml에 서블릿 매핑을 한다.
	<url-pattern> : 지정한 요청명을 입력한다.
 	<servlet-name> : 요청명에 해당하는 서블릿의 이름을 결정한다.
 					단 서블릿의 이름은 반드시 유일해야 한다.
 	<servlet-class> : 서블릿의 이름에 해당하는 서블릿클래스를 결정한다.
3. 2번에서 결정된 서블릿을 해당 패키지에 생성한다.
4. doGet(), doPost()메소드에서 비즈니스로직을 작성한다.

-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelloServlet.jsp</title>
</head>
<body>
	<h2>서블릿(Servlet) 만들기</h2>
	
	<h3>First Servlet</h3>
	<a href="./NoJSPServlet.do">
		JSP파일 없이 화면에 내용 출력하기(Servlet에서 바로 출력)
	</a>
	
	<br />
	
	<h3>${message } - ${HELLO }</h3>
	<h3><%=request.getAttribute("message") %></h3>
	<h3>HelloServlet</h3>
	<a href="HelloServlet.do">
		JSP파일(View)에서 화면 출력하기
	</a>
	
	<h3>WebServlet - 어노테이션으로 매핑하기</h3>
	<a href="../10Servlet/AnnoWebServlet.do">AnnoWebServlet.do 바로가기</a>
	
	<h3>서블릿으로 간단한 계산기 만들기</h3>
	<form action="<%=request.getContextPath()%>/10Servlet/Calculate.korea" method="get">
		<input type="text" name="firstNum" size="10"/>
		<select name="operator">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>		
		</select>
		<input type="text" name="secondNum" size='10'/>
		<input type="submit" value="연산결과는?"/>
		<!-- 리퀘스트 영역에 저장된 속성을 EL식으로 출력 -->
		<h4 style="color:red; font-size: 1.5em">${calResult }</h4>
	</form>
	
	
	
	
	
	
	
	
</body>
</html>
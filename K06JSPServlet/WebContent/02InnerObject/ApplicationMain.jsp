<%@page import="test.Application"%>
<%@page import="test.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ApplicationMain.jsp</title>
</head>
<body>
	<h2>application 내장객체의 주요 메소드</h2>

	<h3>web.xml에 설정한 내용 읽어오기</h3>
	<ul>
		<li>오라클 드라이버 : <%=application.getInitParameter("JDBCDriver")%></li>
		<li>오라클접속URL : <%=application.getInitParameter("ConnectionURL")%></li>
	</ul>

	<h3>위 연결정보를 통해 JDBC 연결 테스트</h3>

	<%
		String drv = application.getInitParameter("JDBCDriver");
		String url = application.getInitParameter("ConnectionURL");
		DBConnect dbconn = new DBConnect(drv, url);
		System.out.println("콘솔에서 연결여부 확인");
	%>
	<!-- 
	서버의 물리적경로는 파일업로드시 주로 사용된다.
	우리가 제작한 웹어플리케이션은 서버의 특정위치에 세팅되게
	되는데 파일의 경우 드라이브명을 포함한 물리적경로가
	있어야 저장이 가능하다.
	
	getRealPath() 메소드를 통해 서버의 물리적 경로를 얻어올 수 있다.
	사용시 "Context루트"를 제외한 /로 시작하는 경로를 입력해야 한다.
	-->
	<h2>서버의 물리적 경로 얻어오기</h2>

	<ul>
		<li>application내장객체 : <%=application.getRealPath("/images")%></li>
		<li>request내장객체 : <%=request.getServletContext().getRealPath("/images")%></li>
		<li>request내장객체(주로 서블릿에서 사용함) : <%=request.getRealPath("/images")%></li>
		<li>session내장객체 : <%=session.getServletContext().getRealPath("/images")%></li>
		<li>config내장객체 : <%=config.getServletContext().getRealPath("/images")%></li>
		<li>this키워드(주로 선언부에서 사용) : <%=this.getServletContext().getRealPath("/images")%></li>
	</ul>

	<%-- 
	JSP 웹 어플리케이션은 java영역과 jsp영역으로 나눠져있고
	java영역에서는 jsp의 내장객체를 사용하는 것이 불가능하다.
	그러므로 jsp내장객체를 매개변수 형태로 전달해서 사용하게 되는데
	아래부분은 java영역에서 물리적 경로를 얻어오는 방법이다.
	 --%>
	<h2>선언부에서 물리적경로 사용하기</h2>
	<%!String getRealPath() {
		return this.getServletContext().getRealPath("/images");
	}

	ServletContext application;

	String getRealPathStr() {
		return application.getRealPath("/images");
	}%>
	<ul>
		<li>this 키워드사용 : <%=getRealPath()%></li>
		<li>매개변수전달 : <%
			Application app = new Application();
			out.println(app.getRealPath(application));
		%>
		</li>
		<li>
			<%
				this.application = application;
			%> 멤버변수 : <%=getRealPathStr()%></li>
	</ul>
</body>
</html>
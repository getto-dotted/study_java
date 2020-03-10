<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Vector"%>
<%@page import="model.MemberDTO"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 
application 영역에 속성 저장
	-어플리케이션 영역에 저장된 속성은 모든 JSP페이지에서 공유된다.
	-링크를 통해 새로운 페이지에 대한 요청이나, 포워드, 인클루드 등
		모든 페이지에서 공유된다. 이런 페이지들은 하나의 웹어플리케이션(컨텍스트)에
		존재하기 때문에 공유되는 것이다.
 --%>	
<%
	/*  
	현재날짜 입력하기. util패키지에서 날짜를 생성후 sql패키지의 
	Date타입으로 변환한다. 이처럼 하는 이유는 Java에서 사용하는
	날짜포맷과 오라클에서 사용하는 날짜포맷이 서로 다르기 때문이다.
	*/
	java.util.Date myUtilDate = new java.util.Date();
	System.out.println("myUtilDate="+myUtilDate);
	java.sql.Date mySqlDate = new Date(myUtilDate.getTime());
	System.out.println("mySqlDate="+ mySqlDate);
	
	
	MemberDTO first = new MemberDTO("Kim", "1111", "김길동", mySqlDate);
	MemberDTO second = new MemberDTO("Park", "2222", "박길동", null);
	MemberDTO third = new MemberDTO("Lee", "3333", "이길동", null);
	//리스트 계열의 컬렉션에 객체 저장
	List<MemberDTO> lists = new Vector<MemberDTO>();
	lists.add(first);
	lists.add(second);
	lists.add(third);
	//맵 계열의 컬렉션에 객체 저장
	Map<String, MemberDTO> maps = new HashMap<String, MemberDTO>();
	maps.put("member1", first);
	maps.put("member2", second);
	maps.put("member3", third);
	//어플리케이션 영역에 컬렉션 저장
	application.setAttribute("lists", lists);//리스트 컬렉션 영역저장
	application.setAttribute("maps", maps);//맵 컬렉션 영역저장
	
	pageContext.setAttribute("pageMember", first);//페이지영역저장
	request.setAttribute("requestMember", first);//리퀘스트영역 저장
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ApplicationScopeMain.jsp</title>
</head>
<body>
	<h2>어플리케이션 영역의 공유</h2>

	<h3>사용자 클릭에 의한 이동</h3>

	<a href="ApplicationResult.jsp">사용자클릭</a>

	<h3>포워드로 페이지 전달하기</h3>
	<%
request.getRequestDispatcher("ApplicationResult.jsp").forward(request, response);
%>

	<!-- 외부파일 인클루드 -->
	<%@ include file="ApplicationInclude.jsp"%>

</body>
</html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.MemberDTO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--  
JSP에서의 모든 영역(페이지, 리퀘스트, 세션, 어플리케이션)에는
모든 타입의 객체를 저장하는 것이 가능하다.

1.page영역
-page영역에 저장한 속성은 해당 페이지를 벗어나면 소멸된다.
-단, include된 페이지에서는 page영역이 공유된다.
-속성을 저장할때는 pageContext 내장객체를 사용한다.
--%>
<%
	/*  
	각 영역에 속성을 저장할 때 사용하는 메소드	
		형식] 영역명.setAttribute("속성명", "속성값");
		※속성값으로는 모든 객체를 사용할 수 있다.
		즉 영역에는 모든 타입의 객체를 저장할 수 있다.
	*/
	pageContext.setAttribute("pageNumber", 1000);
	pageContext.setAttribute("pageString", "페이지영역에 저장한 문자열");
	pageContext.setAttribute("pageDate", new Date());

	//MemberDTO클래스를 통한 member1 인스턴스 생성
	MemberDTO member1 = new MemberDTO();
	member1.setId("koreavc");
	member1.setName("한국직업전문학교");
	member1.setPass("1234");
	member1.setRegidate(java.sql.Date.valueOf("2002-12-25"));
	pageContext.setAttribute("pageMember1", member1);

	pageContext.setAttribute("pageMember2", new MemberDTO("Nakja", "1234", "낙자쌤", null));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PageScopeMain.jsp</title>
</head>
<body>
	<h2>page영역에 저장된 속성값 읽어오기</h2>
	<%
	/*  
	각 영역에 저장된 속성값 읽어오기
		형식] 영역명.getAttribute("속성명");
		※ 영역에는 모든 객체가 Object타입으로 저장되므로 읽어와서
		사용할때는 형변환(다운캐스팅) 해야한다.
	*/
		Object obj = pageContext.getAttribute("pageDate");
		String dateString = "";
		if (obj instanceof Date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			dateString = sdf.format((Date) obj);
		}
		MemberDTO m1 = (MemberDTO) pageContext.getAttribute("pageMember1");
		String m1Str = String.format("아이디:%s, 비번:%s, 이름:%s, 가입일:%s", m1.getId(), m1.getPass(), m1.getName(),
				m1.getRegidate());
		MemberDTO m2 = (MemberDTO) pageContext.getAttribute("pageMember2");
	%>

	<ul>
		<li>Integer타입 : <%=pageContext.getAttribute("pageNumber")%></li>
		<li>String타입 : <%=pageContext.getAttribute("pageString")%></li>
		<li>Date타입 : <%=dateString%></li>
		<li>MemberDTO타입1 : <%=m1Str%></li>
		<li>MemberDTO타입2 : 아이디 : <%=m2.getId()%>, 비번:<%=m2.getPass()%>,
			이름:<%=m2.getName()%>, 가입일:<%=m2.getRegidate()%></li>
	</ul>
	<!--  
	페이지영역에 저장된 값은 다른 페이지로 이동하면 모두 파괴되어 소멸된다.
	즉 다른 페이지와 공유되지 않으므로 아래 링크에서는
	아무런 내용도 출력되지 않는다.
	-->
	<h2>페이지 이동</h2>
	<a href="PageScopeResult.jsp">page영역의 공유확인을 위한 링크</a>

	<!--  
	다른 파일을 인클루드(해당 문서에 다른 문서포함) 하게되면 원본파일
	그대로 해당 문서에 포함시킨 후 컴파일되기 때문에 같은 페이지로
	취급되어 page속성값이 파괴되지 않고 공유된다.
	-->
	<h2>페이지 include</h2>
	<%@ include file="PageInclude.jsp"%>
</body>
</html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.MemberDTO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setAttribute("requestNumber", 1000);
request.setAttribute("requestString", "리퀘스트영역에 저장한 문자열");
request.setAttribute("requestDate", new Date());

//MemberDTO클래스를 통한 member1 인스턴스 생성
MemberDTO member1 = new MemberDTO();
member1.setId("koreavc");
member1.setName("한국직업전문학교");
member1.setPass("1234");
member1.setRegidate(java.sql.Date.valueOf("2002-12-25"));
request.setAttribute("requestMember1", member1);

request.setAttribute("requestMember2", new MemberDTO("Nakja", "1234", "낙자쌤", null));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestScopeMain.jsp</title>
</head>
<body>
<h2>requset영역에 저장된 속성값 읽어오기</h2>
	<%
	/*  
	각 영역에 저장된 속성값 읽어오기
		형식] 영역명.getAttribute("속성명");
		※ 영역에는 모든 객체가 Object타입으로 저장되므로 읽어와서
		사용할때는 형변환(다운캐스팅) 해야한다.
	*/
		Object obj = request.getAttribute("requestDate");
		String dateString = "";
		if (obj instanceof Date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			dateString = sdf.format((Date) obj);
		}
		MemberDTO m1 = (MemberDTO) request.getAttribute("requestMember1");
		String m1Str = String.format("아이디:%s, 비번:%s, 이름:%s, 가입일:%s", m1.getId(), m1.getPass(), m1.getName(),
				m1.getRegidate());
		MemberDTO m2 = (MemberDTO) request.getAttribute("requestMember2");
	%>

	<ul>
		<li>Integer타입 : <%=request.getAttribute("requestNumber")%></li>
		<li>String타입 : <%=request.getAttribute("requestString")%></li>
		<li>Date타입 : <%=dateString%></li>
		<li>MemberDTO타입1 : <%=m1Str%></li>
		<li>MemberDTO타입2 : 아이디 : <%=m2.getId()%>, 비번:<%=m2.getPass()%>,
			이름:<%=m2.getName()%>, 가입일:<%=m2.getRegidate()%></li>
	</ul>
	 <!-- 
	 	아래 세가지 방법을 통한 페이지 이동은 이동은 새로운 페이지에 대한 요청이므로
	 	request영역은 공유되지 않는다. 즉 page영역과 request영역에
	 	저장된 데이터는 새로운 페이지로 이동했을때는 모두 소멸된다.
	  -->
	<h2>페이지 이동1 -a태그 이용</h2>
	<a href="RequestScopeResult.jsp">Request영역의 공유확인을 위한 링크</a>
	
	<h2>페이지 이동2 - JavaScript 이용</h2>
	<script>
		/* alert('JS의 location객체를 이용해서 이동합니다.');
		location.href = 'RequestScopeResult.jsp'; */
	</script>
	<h2>페이지 이동3 - response내장객체의 sendRedirect()사용</h2>
	<%		
		/* 
		JS와 JSP코드가 동시에 기술되는 경우 JSP코드가 우선순위가 높으므로
		JS는 실행되지 않는다. 해당 코드의 경우 위에 기술된
		alert()는 동작하지 않고 sendRedirect()를 통해 페이지 이동이 되므로
		사용시 주의해야 한다.
		*/
		/* response.sendRedirect("RequestScopeResult.jsp"); */
	%>
	<!-- 
	JSP에서는 페이지 이동과는 달리  request영역이 공유되는 포워드(페이지 전달)를 제공한다.
	주소창에는 최초 요청한 URL만 보여지므로 사용자는 페이지가 이동되었는지 인지하지 못하지만,
	내부적으로는 페이지가 전달되어 URL과 다른 페이지가 보여지게 된다.
	포워드는 로그인 처리와 같은 곳에 주로 사용된다.
	 -->
	<h2>페이지 포워드</h2>
	<%
		request.getRequestDispatcher("RequestScopeResult.jsp").forward(request, response);	
		/* RequestDispatcher dis = request.getRequestDispatcher("RequestScopeResult.jsp");
		dis.forward(request, response);	 */
	%>
</body>
</html>
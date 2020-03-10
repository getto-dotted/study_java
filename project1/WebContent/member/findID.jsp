<%@page import="dataObject.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String driver = application.getInitParameter("JDBCDriver");
String url = application.getInitParameter("ConnectionURL");

//DAO객체 생성 및 DB연결
MemberDAO dao = new MemberDAO(driver, url);

String fname = request.getParameter("name");
String femail = request.getParameter("email");
String id = "";		
id = dao.findId(fname, femail);		
dao.close();

MemberDAO dao2 = new MemberDAO(driver, url);

String id2 =  request.getParameter("id");
String name = request.getParameter("name2");
String email = request.getParameter("email2");
String Pw= "";		
Pw = dao2.findPw(id2, name, email);	
dao2.close();
if(id2 != null){
%>
<script>		
	alert("<%=name%> 회원님의 비밀번호는 <%=email%> 로 전송되었습니다. <%=Pw%>");
	location.href="../main/main";
	</script>
<%}else{%>	
<script>
	alert("<%=fname%> 회원님의 아이디는 <%=id%> 입니다.");	
	location.href="../main/main";
</script>
<%}%>

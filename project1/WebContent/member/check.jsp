<%@page import="java.sql.ResultSet"%>
<%@page import="dataObject.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("UTF-8");

String driver = application.getInitParameter("JDBCDriver");
String url = application.getInitParameter("ConnectionURL");

//DAO객체 생성 및 DB연결
MemberDAO dao = new MemberDAO(driver, url);

String id = request.getParameter("id");

int rs = dao.IDCheck(id);
out.println("rs="+rs);

if(rs==1){
	//중복된것임
%>
	<script>
		alert('중복된 아이디가 있습니다. 다시 확인해주세요');
		location.href="IdCheckForm.jsp?overFlag=1";
	</script>
<%
}
else {
	//중복안된것임
%>
	<script>
		alert('사용가능한 아이디입니다.');
		location.href="IdCheckForm.jsp?overFlag=0&id=<%=id%>";
	</script>
<%	
}
%>

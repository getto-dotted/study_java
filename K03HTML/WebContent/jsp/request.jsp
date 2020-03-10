<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String p1 = request.getParameter("param1");
String p2 = request.getParameter("param2");
out.println("전송된 값1="+p1);
%>

<br/>
전송된 값2=<%=p2 %>
<%
int result = Integer.parseInt(p1)+Integer.parseInt(p2);
System.out.println("결과="+result);
out.println("결과="+result);
%>	

</body>
</html>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//서버의 물리적 경로 가져오기
	String saveDirectory = application.getRealPath("/Upload");
	//경로를 인자로 파일객체 생성
	File file = new File(saveDirectory);
	//파일목록 가져오기 - File형 배열로 가져옴.
	File[] fileList = file.listFiles();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FileList.jsp</title>
</head>
<body>
	<h2>업로드된 파일 리스트 보기(디렉토리 읽어오기)</h2>
	<ul>
<%
	int fileCnt = 1;
	for(File f : fileList){
%>
		<li>파일명 : <%=f.getName() %> &nbsp; 
			파일크기 : <%=(int)Math.ceil(f.length()/1024.0) %>Kb &nbsp; 
			<a href="Download1.jsp?fileName=<%=URLEncoder.encode(f.getName(), "UTF-8")%>">
			[다운로드1-1]</a>&nbsp; 
			<a href="Download2.jsp?sfileName=<%=URLEncoder.encode(f.getName(), "UTF-8")%>&ofileName=<%=URLEncoder.encode("원본파일명.jpg", "UTF-8")%>">
			[다운로드2-1]</a>
		</li>
<%
		fileCnt++;
	}
%>
	</ul>
</body>
</html>
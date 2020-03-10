<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.multipart.FileRenamePolicy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//한글처리
	request.setCharacterEncoding("UTF-8");
	
	//파일이 업로드 될 서버의 물리적경로 가져오기 
	String saveDirectory = application.getRealPath("/Upload");
	
	/* 업로드할 파일의 최대용량 설정(바이트단위)
	단 파일이 여러개 업로드 되는 경우에는 각각을 합친용량이 최대용량이 된다.*/
	int maxPostSize = 1024 * 5000;//5Mb설정
	
	//인코딩 타입설정
	String encoding = "UTF-8";
	
	/* 파일명 중복처리
	해당 클래스는 파일명이 중복되는 경우 자동으로 인덱스를 부여해준다.*/
	FileRenamePolicy policy = new DefaultFileRenamePolicy();

	//전송된 폼값을 저장하기 위한 변수생성
	MultipartRequest mr = null;
	String name = null;
	String title = null;
	StringBuffer inter = new StringBuffer();

	//저장된 파일명을 변경하기 위한 객체생성
	File oldFile = null;
	File newFile = null;
	String realFileName = null;

	try {/*  
			파일업로드를 위한 Multipart객체 생성
			위에서 준비한 인자들을 이용하여 객체를 생성하고, 예외가 발생하지 않는다면
			파일업로드는 즉시 완료된다. 만약 예외가 발생한다면 최대용량초과 혹은 물리적경로 설정이
			잘못된 경우가 대부분이다.*/
		mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);

		//파일이외에 폼값을 받아서 변수에 저장
		name = mr.getParameter("name");
		title = mr.getParameter("title");
		String[] interArr = mr.getParameterValues("inter");
		int count =0;
		for (String s : interArr) {
			if(count<interArr.length-1){ 
				inter.append(s + ",&nbsp;");
			}
			else{
				inter.append(s);			
			} 
			count++;
		}
	} catch (Exception e) {
		request.setAttribute("errorMessage", "파일업로드오류");
		request.getRequestDispatcher("FileUploadMain.jsp").forward(request, response);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UploadProc.jsp</title>
</head>
<body>
	<h2>파일 업로드 결과</h2>
	<ul>
		<li>작성자 : <%=name%></li>
		<li>제목 : <%=title%></li>
		<li>관심사항 : <%=inter%></li>
	</ul>
	
	<h2>첨부파일1</h2>
	<ul>
		<li>원본파일명 : <%=mr.getOriginalFileName("chumFile1")%></li>
		<li>서버에 저장된 파일명(old) : <%=mr.getFilesystemName("chumFile1")%></li>
		<li>컨텐츠타입 : <%=mr.getContentType("chumFile1")%></li>
		<li>파일크기 : <%=(int) Math.ceil(mr.getFile("chumFile1").length() / 1024.0)%>Kb</li>
		<li>이미지 표현 : 
		<img src="../Upload/<%=mr.getFilesystemName("chumFile1")%>" width="200" /></li>
	</ul>
	
	<h2>첨부파일2</h2>
	<ul>
		<li>원본파일명 : <%=mr.getOriginalFileName("chumFile2")%></li>
		<li>서버에 저장된 파일명(old) : <%=mr.getFilesystemName("chumFile2")%></li>
		<li>컨텐츠타입 : <%=mr.getContentType("chumFile2")%></li>
		<li>파일크기 : <%=(int) Math.ceil(mr.getFile("chumFile2").length() / 1024.0)%>Kb</li>
		<li>이미지 표현 : 
		<img src="../Upload/<%=mr.getFilesystemName("chumFile2")%>" width="200" /></li>
	</ul>
</body>
</html>
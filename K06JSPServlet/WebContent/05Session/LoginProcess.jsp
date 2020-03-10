<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--LoginProcess2.jsp --%>
<%
	//폼값받기
   	String id = request.getParameter("user_id");
	String pw = request.getParameter("user_pw");
	
	//web.xml에 정의한 값을 application객체를 통해 가져옴.
	String driver = application.getInitParameter("JDBCDriver");
	String url = application.getInitParameter("ConnectionURL");
	
	//DAO객체 생성 및 DB연결
	MemberDAO dao = new MemberDAO(driver, url);
	//DAO에서 반환한 값을 받아서 로그인 처리
	boolean isMember = dao.isMember(id, pw);
	if(isMember==true){
		//로그인에 성공했다면 세션영역에 아이디 저장 및 이동
		session.setAttribute("USER_ID", id);
		response.sendRedirect("Login.jsp");		
	}
	else{
		//로그인에 실패했다면 리퀘스트 영역에 문자열 저장 및 포워드
		request.setAttribute("ERROR_MSG", "회원이 아니시네요");
		request.getRequestDispatcher("Login.jsp").forward(request, response);
		
	}
%>
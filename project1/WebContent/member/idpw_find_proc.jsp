<%@page import="email.MailSending"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<%
request.setCharacterEncoding("UTF-8");

String user_name = request.getParameter("user_name");
String user_email = request.getParameter("user_email");
String user_id = request.getParameter("user_id");
String mode = request.getParameter("mode");

if(mode.equals("pw_find")){
	String from = "ejrl123@naver.com";
	String to = "ejrl123@gmail.com";
	String subject = "패스워드 알림";
	//String content = "문의하신 패스워드는 1234";
	String content = ""
	+"<table border='1'>"
	+"<tr>"
	+"	<td>이미지</td>"
	+"	<td><img src='http://www.dragonvillage.net/assets/data/board/humor/2018_02_08/20180208_0a5708061f16471532616b4d0456b046/0472169385_1518089134607474.jpeg'  width='600' /></td>"
	+"</tr>"
	+"<tr>"
	+"	<td>내용</td>"
		+"	<td>문의하신 패스워드는 1234</td>"
		+"	</tr>"
		+"</table>";
	
	//메일발송 파라미터 정리
	Map<String, String> mailParam = new HashMap<String, String>();
	mailParam.put("from",from);
	mailParam.put("to",to);
	mailParam.put("subject",subject);
	mailParam.put("content",content);
	
	//이메일 발송객체생성
	MailSending ms = new MailSending();
	boolean sendOk = ms.emailSending(mailParam);
	if(sendOk==true){
		System.out.println("메일전송 성공");
	}
	else{
		System.out.println("메일전송 실패");	
	}
}

%>
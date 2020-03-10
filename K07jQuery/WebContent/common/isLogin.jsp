<%@page import="util.JsFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 파일명 : isLogin.jsp --%>
<%
	if (session.getAttribute("USER_ID") == null) {
		/* 
		static으로 선언된 메소드이므로 별도의 객체생성 없이
		클래스명으로 즉시 호출하는 것이 가능하다.
		*/
		String js = JsFunction.jsAlertLocation("로그인 후 이용해주세요", "../05Session/Login.jsp");

		out.println(js);
		return;//JSP와 JAVA를 쪼갰을때 하단의 JSP코드가 먼저 실행되는것을 방지
	}
%>
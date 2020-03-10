<%@page import="oracle.net.aso.b"%>
<%@page import="model.BbsDAO"%>
<%@page import="model.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--파일명 : DeleteProc.jsp--%>
<%@ include file="../common/isLogin.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");

	//삭제할 게시물의 일련번호
	String num = request.getParameter("num");

	BbsDTO dto = new BbsDTO();
	BbsDAO dao = new BbsDAO(application);

	//작성자 본인확인을 위해 기존 게시물의 내용을 가져온다.
	dto = dao.selectView(num);

	//세션에 저장된 회원 아이디를 String으로 가져온다.
	String session_id = session.getAttribute("USER_ID").toString();

	int affected = 0;

	//세션아이디와 작성자 아이디가 동일한 경우에만 삭제처리
	if (session_id.equals(dto.getId())) {
		dto.setNum(num);
		affected = dao.delete(dto);
	} else {
		JsFunction.jsAlertBack("본인만 삭제가능합니다.", out);
		return;
	}
	if (affected == 1) {
		out.println(JsFunction.jsAlertLocation("삭제되었습니다.", "BoardList.jsp"));
	} else {
		JsFunction.jsAlertBack("삭제실패하였습니다", out);
	}
%>
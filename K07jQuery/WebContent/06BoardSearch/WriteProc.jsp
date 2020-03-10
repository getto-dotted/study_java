<%@page import="model.BbsDAO"%>
<%@page import="model.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/isLogin.jsp"%>
<%--파일명 WriteProc.jsp  --%>
<%
request.setCharacterEncoding("UTF-8");

String title = request.getParameter("title");//제목
String content = request.getParameter("content");//내용

//DAO객체로 전달할 DTO객체 선언 및 세팅
BbsDTO dto = new BbsDTO();
dto.setTitle(title);
dto.setContent(content);
dto.setId(session.getAttribute("USER_ID").toString());/*  
		세션영역에 저장된 속성은 Object타입이므로
		String으로 형변환하기 위해 toString()메소드를 사용한다.
		
DB연결정보를 생성자에서 직접 가져오게 하기위해 
application 내장객체를 매개변수로 전달한다.
*/
BbsDAO dao = new BbsDAO(application);
int affected = dao.insertWrite(dto);
/* int affected = 0; */
if(affected==1){//글쓰기에 성공했을때..
	response.sendRedirect("BoardList.jsp");
}
else{//글쓰기에 실패했을때..
	JsFunction.jsAlertBack("글쓰기에 실패하였습니다.", out);
}%>
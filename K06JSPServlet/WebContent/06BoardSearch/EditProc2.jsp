<%@page import="model.BbsDAO"%>
<%@page import="model.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/isLogin.jsp"%>

<%
	//한글처리
	request.setCharacterEncoding("UTF-8");
	//폼값받기
	String num = request.getParameter("num");
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	BbsDTO dto = new BbsDTO();
	BbsDAO dao = new BbsDAO(application);	
	
	dto = dao.selectView(num);
	String session_id = session.getAttribute("USER_ID").toString();
	if (!session_id.equals(dto.getId())) {
		JsFunction.jsAlertBack("본인만 수정가능합니다.", out);
		return;
	}
	
	//폼값 채우기
	dto.setNum(num);
	dto.setTitle(title);
	dto.setContent(content);
	
	int affected = dao.updateEdit(dto);
	if (affected == 1) {
		response.sendRedirect("BoardView.jsp?num="+dto.getNum());
	}
	else{
	%>
		<script>
			alert("수정하기에 실패하였습니다.");
			history.go(-1);
		</script>
	<%	
	}
	%>
	
	
<%-- 

	BbsDTO dto = new BbsDTO();
	BbsDTO dto2 = new BbsDTO();
	BbsDAO dao2 = new BbsDAO(application);
	
	dto.setNum(num);
	dto.setTitle(title);
	dto.setContent(content);
	
	BbsDAO dao = new BbsDAO(application);	
	
	dto2 = dao2.selectView(num);
	String session_id = session.getAttribute("USER_ID").toString();
	
	if (session_id.equals(dto2.getId())) {
		int affected = dao.updateEdit(dto);
		if (affected == 1) {
			response.sendRedirect("BoardView.jsp?num="+dto.getNum());
		}
		else{
	%>
		<script>
			alert("수정하기에 실패하였습니다.");
			history.go(-1);
		</script>
	<%
	}}
	else{		
		%>
		<script>			
			alert("본인만 수정가능합니다.");
			location.href="BoardList.jsp";
		</script>
		<%
		
		/* response.sendRedirect("BoardList.jsp"); */
		
	}
	%> --%>
<%@page import="practice.BbsDAO"%>
<%@page import="practice.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/isLogin.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 검증</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	
	String num = request.getParameter("num");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BbsDTO dto = new BbsDTO();
	dto.setNum(num);
	dto.setTitle(title);
	dto.setContent(content);
	
	BbsDAO dao = new BbsDAO(application);
	
	int affected = dao.updateEdit(dto);
	
	if(affected==1){
	    //수정하기에 성공했을때는 상세보기 화면으로 돌아간다.
	    response.sendRedirect("BoardView.jsp?num="+dto.getNum());
	}
	else{//수정하기에 실패했을때
%>
    <script>
        alert("글수정에 실패하였습니다.");
        history.go(-1);
    </script>
<%    
}
%>
</body>
</html>
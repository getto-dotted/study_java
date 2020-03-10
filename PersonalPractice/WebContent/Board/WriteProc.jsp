<%@page import="practice.BbsDAO"%>
<%@page import="practice.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 검증</title>
</head>
<body>
	<%-- 로그인 확인하기 : 글작성중 세션정보가 제거될수	있으므로 
	insert처리전 반드시 세션정보 유무를 확인해야 한다. --%>    
	
<%
	request.setCharacterEncoding("UTF-8");
	
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BbsDTO dto = new BbsDTO();
	
	dto.setTitle(title);
	dto.setContent(content);
	dto.setId(session.getAttribute("USER_ID").toString());
	
	BbsDAO dao = new BbsDAO(application);
	
	int affected = dao.insertWrite(dto);
	
	if(affected==1){//글쓰기에 성공했을때
	    response.sendRedirect("BoardList.jsp");
	}
	
	else{//글쓰기에 실패했을때
%>
		<script>
			alert("글쓰기에 실패하였습니다.");
			history.go(-1);
		</script>
<%    
	}
%>

</body>
</html>
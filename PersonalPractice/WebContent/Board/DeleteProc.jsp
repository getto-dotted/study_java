<%@page import="practice.BbsDAO"%>
<%@page import="practice.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제하기</title>
</head>
<body>
<%@ include file="../common/isLogin.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	
	String num = request.getParameter("num");
	
	BbsDTO dto = new BbsDTO();
	BbsDAO dao = new BbsDAO(application);
	
	//삭제전 작성자 아이디와 비교후 삭제여부판단
	dto = dao.selectView(num);
	
	//세션영역에 저장된 아이디 가져오기
	String session_id = session.getAttribute("USER_ID").toString();
	
	int affected = 0;
	
	//세션아이디와 작성자아이디가 동일할때 삭제처리
	if(session_id.equals(dto.getId())){
		dto.setNum(num);
	    affected = dao.delete(dto);
	}
	else{
	    JsFunction.jsAlertBack("본인만 삭제가능합니다.", out);
	    return;
	}
	
	if(affected==1){
	    //삭제에 성공했을때...(JAVA파일에서 내용출력)
	   out.println(JsFunction.jsAlertLocation("삭제되었습니다", "BoardList.jsp"));    
	}
	else{
	    //삭제에 실패했을때...(JSP에서 내용출력)    
	  	JsFunction.jsAlertBack("삭제실패하였습니다", out);
	}
%>
</body>
</html>
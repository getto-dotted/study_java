<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//폼값받기
    String userid = request.getParameter("user_id");
    String userpw = request.getParameter("user_pw");
    String id_save = request.getParameter("id_save");/*
    		checkbox의 경우 여러항목이 전송된다면 getParameterValues()로
    		폼값을 받아야 한다. 하지만 전송항목이 1개라면 이와같이
    		getParameter()로 받을 수 있다.*/
    
    if("koreavc".equals(userid) && "1234".equals(userpw)){
    	
    	if(id_save==null){
    		/*  
    		체크박스를 체크하지 않은 상태라면 쿠키를 지워준다.
    		쿠키를 지울때는 쿠키가 빈값을 가지게 만들어주면 된다.
    		*/
    		Cookie ck = new Cookie("USER_ID", "");
    		ck.setPath(request.getContextPath());
    		ck.setMaxAge(0);
    		response.addCookie(ck);
    	}
    	else{
    		/*  
    		체크가 된 경우에는 전송된 아이디를 아래와 같이 쿠키로 생성한다.
    		유효시간은 100일로 지정했다.
    		*/
    		Cookie ck = new Cookie("USER_ID", userid);
    		System.out.println(request.getContextPath());
    		ck.setPath(request.getContextPath());
    		ck.setMaxAge(60*60*24*100);
    		response.addCookie(ck);
    		
    	}
    	response.sendRedirect("ExamIndex.jsp");
    }
    else{    	
    	/*  
    	로그인에 실패한 경우 리퀘스트 영역에 속성을 저장한 후 로그인 페이지로 포워드한다.
    	포워드 된 페이지는 리퀘스트 영역을 공유하므로 아래 속성값을 출력할 수 있다.
    	*/
    	request.setAttribute("ERROR_MSG", "회원이 아닙니다");
    	request.getRequestDispatcher("ExamIndex.jsp").forward(request, response);
    }
%>
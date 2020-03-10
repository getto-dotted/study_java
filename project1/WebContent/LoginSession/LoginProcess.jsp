<%@page import="java.io.PrintWriter"%>
<%@page import="dataObject.MemberDTO"%>
<%@page import="dataObject.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--LoginProcess.jsp --%>
<%

	//세션 유지시간을 설정함. 초단위 이므로 60초*60분.
	session.setMaxInactiveInterval(7200);
	//세션영역에 USER_ID 속성값이 없는 경우(로그아웃 상태)
	if (session.getAttribute("USER_ID") == null) {
		//폼값받기
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String id_save = request.getParameter("id_save");

		//web.xml에 정의한 값을 application객체를 통해 가져옴.
		String driver = application.getInitParameter("JDBCDriver");
		String url = application.getInitParameter("ConnectionURL");

		//DAO객체 생성 및 DB연결
		MemberDAO dao = new MemberDAO(driver, url);
		//DAO에서 반환한 값을 받아서 로그인 처리
		MemberDTO dto = dao.getMemberDTO(id, pw);
		
		if (dto.getId() != null) {
			//로그인에 성공했다면 세션영역에 아이디 저장 및 이동
			session.setAttribute("USER_NAME", dto.getName());
			session.setAttribute("USER_ID", id);
			
			//쿠키생성
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
	    		유효시간은 10일로 지정했다.
	    		*/	    		
	    		Cookie ck = new Cookie("USER_ID", id);	    		
	    		ck.setPath(request.getContextPath());
	    		ck.setMaxAge(60*60*24*10);
	    		response.addCookie(ck);
	    		
	    	}	    
			
			response.sendRedirect("../main/main");
			
		} else {
			//로그인에 실패했다면 경고창 및 메인으로
			
			PrintWriter out2 = response.getWriter();
			
			out.println("<script>alert('아이디와 비밀번호를 확인해주세요.'); location.href='../main/main';</script>");

		}
	} 
	else {
%>
	<!-- 세션영역에 USER_ID 속성값이 있는 경우 : 로그인 상태 -->
	<table border="1" width="400">
		<tr>
			<td><%=session.getAttribute("USER_NAME")%> (<%=session.getAttribute("USER_ID")%>)님, 어서오세요 <br /> 
			<%response.sendRedirect("../main/main"); %>			
			<a href="Logout.jsp">로그아웃</a></td>
		</tr>
	</table>
<%
	}

%>
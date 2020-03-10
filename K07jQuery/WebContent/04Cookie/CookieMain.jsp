<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CookieMain.jsp</title>
</head>
<body>
	<h2>쿠키(Cookie)</h2>
	<h3>쿠키 설정</h3>
	<%
	/*  
	1.쿠키객체생성 : new Cookie(쿠키명, 쿠키값)
		:쿠키명을 설정하는 setName()메소드가 없기 때문에 반드시
		생성자를 통해서 쿠키값을 설정해야 한다.
	*/
	Cookie cookie = new Cookie("UserID", "koreavc");
	/*  
	2.쿠키가 적용되는 경로설정
		: 웹어플리케이션 내의 특정 경로에서만 동작하도록 설정할 수 있다.
		아래는 웹어플리케이션 전체에서 쿠키를 사용할 수 있도록 설정하고 있다.
	*/
	System.out.println("request.getContextPath()"+request.getContextPath());
	
	cookie.setPath(request.getContextPath());
	/*  
	3. 쿠키의 유효시간 설정(초단위)
	-유효시간이 설정되지 않으면 웹브라우저를 닫을때 쿠키도 같이 삭제된다.
	-유효시간을 설정하는 경우 웹브라우저와 상관없이 유효시간이
	지났을때 삭제된다.
	*/
	cookie.setMaxAge(3600);//60초*60분=1시간 으로 설정함
			
	/*  
	4. 생성된 쿠키를 응답헤더에 추가한다. 단 이때 클라이언트측에
	쿠키가 생성되므로 서버에서는 생성여부를 바로 확인하지 못한다.
	*/
	response.addCookie(cookie);
	
	%>
	<h2>쿠키를 설정하는 현재페이지에서 쿠키값 확인하기</h2>

	<%
	/* 
	첫 실행시에는 UserID값이 보이지 않는다. 클라이언트측으로 응답헤더에 실어서 보낸
	쿠키는 클라이언트가 다시 요청할때 요청헤더에 실어서 서버로 전송하게 되고 그때
	서버는 쿠키가 생성된 것을 확인하기 때문이다.
	※즉 쿠키는 생성과 동시에 확인되지 않는다.
	
	클라이언트에 생성된 모든 쿠키를 가져온다. */
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		for(Cookie c : cookies){
			String cookieName = c.getName();//쿠키명을 가져옴
			String cookiValue = c.getValue();//쿠키값을 가져옴
			
			out.println(String.format("%s : %s<br/>", cookieName, cookiValue));
		}
	}
	%>
	<h2>페이지 이동후 쿠키값 확인하기</h2>
	<a href="CookieResult.jsp"> 쿠키값 다음 페이지에서 확인하기 </a>
</body>
</html>
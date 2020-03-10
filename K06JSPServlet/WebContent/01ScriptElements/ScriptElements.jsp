<%-- JSP --%>
<!-- HTML -->
<%--  
JSP 스크립트 요소 (Scripting Elements)
지시자(Directive): 페이지 속성을 지정하거나 외부문서를 include할때 사용한다.
@을 사용한다.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 선언부(Declaration) : 스크립트렛이나 표현식에서 사용할 메소드를 선언할때 사용된다.
!를 사용한다. 
--%>
<%!public int add(int a, int b) {
		int result = a + b;
		return result;
	}

	public int subtract(int a, int b) {
		int result = a - b;
		return result;
	}

	public void showPrint(String str, JspWriter out) {
		try {
			out.println("받은 문자열:" + str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ScriptElements.jsp</title>
</head>
<body>
	<h2>JSP의 스크립트 요소들(Scripting Elements)</h2>
	<%-- 외부 jsp파일을 현재 문서에 포함한다. --%>
	<%@ include file="../common/IncludePage.jsp"%>

	<%
	/*  
	스크립트렛(Scriptlet) : 주로 jsp코드를 작성하고 실행할때 사용하는 영역이다.
	<%만 사용한다.
	*/
		int value1 = 3;
		int value2 = 9;

		int addResult = add(value1, value2);
		int subResult = subtract(value1, value2);
	%>

	<%--  
	표현식(Expression) : 변수를 웹브라우저상에 출력할때 사용한다.
	사용시 주의할점은 변수뒤에 세미콜론을 반드시 생략해야 한다는 점이다.
	--%>
	<%for(int i=1; i<7; i++){
		%>
	<h <%=i%>>JSP for문으로 6회반복</h<%=i%>>
	<%		
	}
	%>



	<h3>표현식으로 변수를 화면에 출력하기</h3>
	<%=value1%>
	+
	<%=+value2%>
	=
	<%=addResult%>
	<br />
	<%=value1%>
	-
	<%=+value2%>
	=
	<%=subResult%>
	<br />
	<%
		showPrint("우리는 한직전", out);
	%>
	<br /> 오늘 날짜는 :
	<%=todayStr%>[인클루드 된 파일에서 가져옴]

</body>
</html>
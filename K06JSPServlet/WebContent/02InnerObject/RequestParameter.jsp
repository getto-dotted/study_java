<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestParameter.jsp</title>
</head>
<body>
	<%
		//한글깨짐 방지. 폼값을 받아 처리하는 부분에는 무조건 사용하면 좋다.
		request.setCharacterEncoding("UTF-8");
		/*  
		전송방식(get/post)에 상관없이 폼값을 받을 수 있다. 만약 값이 입력되지
		않으면 길이가 0인 String객체를 반환하고, 파라미터명이 틀리거나
		아예 없는 경우에는 null을 반환하게 된다.
		즉 폼값에 대한 오류가 발생하면 input태그의 name속성을 반드시 확인해야 한다.
		*/
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		if (!(name == null || name.equals(""))) {
			out.println("이름 : " + name);
		} else {
			out.println("<script>");
			out.println("alert('이름을 입력하세요');");
			out.println("history.back();");
			out.println("</script>");
		}
		/*  
		radio의 경우 하나의 항목만 선택가능하므로 getParameter()로
		폼값을 받을 수 있다. 또한 getParameterValues()도 사용가능하다.
		단, 하나의 항목만 전송되므로 인덱스는 무조건0이 된다.
		*/
		//String sexStr = request.getParameter("sex");
		String[] sex = request.getParameterValues("sex");
		String sexStr = null;
		if (sex != null)
			sexStr = sex[0];

		/*  
		체크박스는 여러항목을 선택할 수 있으므로 getParameterValues()를
		통해 폼값을 받아 String타입의 배열로 반환한다. 단 여러항목중
		체크가 된 항목만 전송하게 된다. 만약 체크된 항목이 없으면
		null을 반환한다.
		*/
		String[] favo = request.getParameterValues("favorite");
		String favStr = "";
		//선택한 항목이 하나도 없다면 아래 문장은 실행되지 않는다.
		if (favo != null) {
			for (int i = 0; i < favo.length; i++) {
				//체크한 항목을 문자열로 연결시 마지막은 콤마를 제거
				if (i == favo.length - 1) {
					favStr += favo[i];
				} else {
					favStr += favo[i] + ",";
				}
			}
		}
		/*  
		textarea를 통해 입력받은 값은 엔터키(\r\n)가 포함되므로, 웹브라우저에
		출력할땐s <br/>태그로 변환해야 한다.
		*/
		String self_intro = request.getParameter("self_intro").replace("\r\n", "<br/>");
	%>
	<ul>
		<li>이름 : <%=name%></li>
		<li>아이디 : <%=id%></li>
		<li>성별 : <%=sexStr%></li>
		<li>관심사항 : <%=favStr%></li>
		<li>자기소개 : <%=self_intro%></li>
	</ul>
</body>
</html>
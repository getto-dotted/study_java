<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
	※주의 : 만약 해당 주석을 HTML주석으로 변경하게 되면 JSON데이터 이외에
		필요없는 문자열이 포함되므로 정상적인 통신이 되지 않는다.
		반드시 '소스보기'를 통해 불필요한 문자열이나 공백이 포함되어 있지 않은지
		확인해야 한다.
--%>
<%-- PostLogin2.jsp --%>
<%@ page trimDirectiveWhitespaces="true" %>       
<%
String user_id = request.getParameter("user_id");
String user_pw = request.getParameter("user_pw");

  
//JSON 객체를 생성한다. 기본적인 사용법은 Map컬렉션과 동일하다.
JSONObject jsonObj = new JSONObject();

if(user_id.equals("koreavc") && user_pw.equals("1234")){
	//각각의 Key값에 Value를 저장해서 JSON객체를 만든다.
	jsonObj.put("user_id", user_id);
	jsonObj.put("user_name", "한직전");
	jsonObj.put("user_pw", user_pw);
	jsonObj.put("result", 1);	
}
else{
	jsonObj.put("result", 0);
}
//JSON객체를 웹브라우저에 출력하기 위해 String으로 형변환한다.
String jsonTxt = jsonObj.toJSONString();
System.out.println(jsonTxt);
out.print(jsonTxt);
%>
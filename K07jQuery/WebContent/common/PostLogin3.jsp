<%-- <%@page import="model.MemberDTO"%>
<%@page import="model.MemberDAO"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	※주의 : 만약 해당 주석을 HTML주석으로 변경하게 되면 JSON데이터 이외에
		필요없는 문자열이 포함되므로 정상적인 통신이 되지 않는다.
		반드시 '소스보기'를 통해 불필요한 문자열이나 공백이 포함되어 있지 않은지
		확인해야 한다.

PostLogin3.jsp
<%@ page trimDirectiveWhitespaces="true" %>       
<%
String id = request.getParameter("user_id");
String pw = request.getParameter("user_pw");

MemberDAO dao = new MemberDAO(application);
MemberDTO dto = dao.getMemberDTO(id, pw);  

JSONObject jsonObj = new JSONObject();

if(dto.getId()==null){
	jsonObj.put("result", 0);
}

else{
	//각각의 Key값에 Value를 저장해서 JSON객체를 만든다.
	jsonObj.put("user_id", dto.getId());
	jsonObj.put("user_name", dto.getName());
	jsonObj.put("user_pw", dto.getPass());
	jsonObj.put("result", 1);	
}
//JSON객체를 웹브라우저에 출력하기 위해 String으로 형변환한다.
String jsonTxt = jsonObj.toJSONString();
System.out.println(jsonTxt);
out.print(jsonTxt);
%> --%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="model.MemberDTO"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05ForEachExtend.jsp</title>
</head>
<body>
	<!-- 
		확장for문의 속성 : items 및 var 속성
		-배열이나 컬렉션에서 값을 가져올때 주로 사용함.
		-varStatus에 지정한 index속성은 0부터 시작함.
	 -->
	<h2>확장 for문 형태의 forEach태그</h2>
	<%
	String[] colors = {"red", "green", "blue", "#573838"};
	%>
	<h3>JSP코드로 배열출력</h3>
	<%for(String c: colors){ %>
		<h4 style="color:<%=c %>;">JSP코드로 출력</h4>
	<%} %>
	
	<h3>JSTL 및 EL로 배열출력</h3>
	<!-- JSp에서 선언한 변수를 EL에서 사용하기 위해 변수재선언(영역에 저장) -->
	
	
	<%-- <c:set var="colors"><%=colors %></c:set> --%>
	<c:set var="colors" value="<%=colors %>"/>
	<c:forEach items="${colors }" var="c">
		<h4 style="color:${c};">JSTL로 출력</h4>	
	</c:forEach>
	
	
	<!-- 
	확장형 forEach문의 varStatus속성
		index : 현재 루프내에서의 인덱스를 표시한다. 0부터 시작.
		first : 첫번째 인덱스일때 true
		last : 마지막 인덱스일때 true
		current : 현재 루프의 실제 요소를 반환함
		count : 현재 루프의 실제 반복횟수를 반환함
	 -->
	<h3>varStatus속성 알아보기</h3>
	<c:forEach items="${colors }" var="c" varStatus="loop"> 
		<h4>${loop.count }번째 반복</h4>
		<ul>
			<li>index : ${loop.index }</li>
			<li>first : ${loop.first }</li>
			<li>last : ${loop.last }</li>
			<li>current : ${loop.current }</li>
		</ul>	
	</c:forEach>



	<h3>리스트 계열의 컬렉션</h3>
	<%
	List lists = new Vector();
	lists.add(new MemberDTO("Hong", "1111", "홍씨", null));
	lists.add(new MemberDTO("Park", "2222", "박씨", null));
	lists.add(new MemberDTO("Sung", "3333", "성씨", null));
	lists.add(new MemberDTO("Kim", "4444", "김씨", null));
	%>
	<c:set var="lists" value="<%=lists %>"/>
	
	<h3>일반 for문 형태의 JSTL의 forEach태그</h3>
	<ul>
		<!-- 일반형 forEach문을 통해 출력. 이때는 컬렉션의 index값 사용.
		컬렉션의 크기는 size()를 통해 얻어온다. -->
		<c:forEach begin="0" end="${lists.size()-1 }" var="i">
		<li>
			아이디: ${lists[i].id }
			패스워드: ${lists[i].pass }
			이름: ${lists[i].name }
		</li>
		</c:forEach>
	</ul>

	<h3>확장 for문 형태의 JSTL의 forEach태그</h3>
	<ul>
		<!-- 확장형 for문에서는 컬렉션의 크기만큼 자동반복 -->
		<c:forEach items="${lists }" var="list"> 
		<li>
			아이디: ${list.id }
			패스워드: ${list.pass }
			이름: ${list.name }
		</li>
		</c:forEach>
	</ul>
	
	<h3>맵 계열 컬렉션 사용</h3>
	<%
	Map maps = new HashMap();
	/* list컬렉션에 저장된 DTO객체를 가져와서 Map컬렉션에 저장함.
	list는 get(인덱스)를 통해 접근할 수 있다.*/
	maps.put("first", lists.get(0));
	maps.put("second", lists.get(1));
	maps.put("third", lists.get(2));	
	maps.put("fourth", lists.get(3));	
	%>
	<c:set var="maps" value="<%=maps %>"/>

	<h4>확장 for문 사용</h4>
		<%-- 
			루프내에서 객체를 전달한 변수 map을 통해 맵의 key와
			value를 얻어올 수 있다.
			-키값 : ${맵의 이름.key}
			-밸류값: ${맵의 이름.value}
		 --%>
	<ul>
		<c:forEach items="${maps }" var="map">
			<li>
				<dl>
					<dt>Key값:${map.key }</dt>
					<dd>Value값 =>
							아이디 : ${map.value.id }, 
							비번 : ${map.value.pass }, 
							이름: ${map.value.name }
					</dd>
				</dl>
			</li>
		</c:forEach>
	</ul>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06Import.jsp</title>
</head>
<body>
	<!-- 
	JSTL의 import태그
	: include 지시어와 같이 외부의 문서를 현재 문서에 포함시킨다.
	url속성에 절대경로로 지정시 컨텍스트 루트명은 제외하고 기술한다.
	
	include지시어와의 차이점
		include 지시어 : 외부문서를 먼저 포함한 후 컴파일 한다.
			따라서 동일한 페이지로 인식하여 페이지영역이 공유된다.
		import 태그 : 외부문서를 컴파일 한 후 결과를 해당 문서에
			포함시킨다. 서로 다른 페이지로 인식하기 때문에 페이지
			영역이 공유되지 않는다.
	 -->
	<h2>import 태그</h2>
	<!--페이지영역, 리퀘스트영역에 속성 저장  -->
	<c:set var="pageVar" scope="page">페이지영역</c:set>
	<c:set var="requestVar" scope="request">리퀘스트영역</c:set>

	<h3>var속성 미지정 - 해당위치에 바로 삽입됨.(include 지시어와 동일)</h3>
	<c:import url="/common/ImportPage.jsp">
		<c:param name="user_id">koreavc</c:param>
		<c:param name="user_pw" value="1234" />
	</c:import>

	<!-- 
		var속성을 사용하면 포함된 문서가 변수에 저장되고,
		차후 원하는 위치에서 EL변수를 출력하는 형태로 사용된다. 
		HTML소스가 좀 더 간결해지는 장점이 있다.
	 -->

	<h3>var속성 지정 - 선언후 원하는 위치에 삽입할때</h3>
	<c:import url="/common/ImportPage.jsp" var="contents">
		<c:param name="user_id">Hong</c:param>
		<c:param name="user_pw" value="9876" />
	</c:import>

	<h3>import선언은 위에서, 삽입은 아래서 처리</h3>
	${contents }

	<h3>외부(원격지)에 있는 내용 삽입하기</h3>
	<iframe src="../common/ImportNate.jsp" frameborder="1"
		style="width: 100%; height: 500px;"></iframe>
































</body>
</html>
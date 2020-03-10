<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestMain.jsp</title>
<script>
	function checkForm(f) {
		if (f.id.value == "") {
			alert("아이디를 입력해주세요");
			f.id.focus();
			return false;
		}
	}
</script>

</head>
<body>
	<h2>전송방식(Post, Get) 테스트</h2>

	<h3>Get방식 전송</h3>
	<a href="RequestInfo.jsp?paramNum=123&paramEng=Hello&paramHan=안녕">Get방식</a>

	<h3>Post방식 전송</h3>
	<form action="RequestInfo.jsp" method="post">
		문자열입력 : <input type="text" name="paramHan" /> <input type="submit"
			value="Post방식" />
	</form>
	
	<h2>간단한 회원가입 폼</h2>
	
	<form method="post" name="regFrm" action="RequestParameter.jsp"
		onsubmit="return checkForm(this);">
		이름 : <input type="text" name="name" value="홍길동" /> <br /> 아이디 : <input
			type="text" name="id" value="" /> <br /> 관심사항 : <input
			type="checkbox" name="favorite" value="sport" checked="checked" />스포츠
		<input type="checkbox" name="favorite" value="ecomomic" />경제 <input
			type="checkbox" name="favorite" value="politics" checked="checked" />정치
		<br /> 성별 : <input type="radio" name="sex" value="man" />남자 <input
			type="radio" name="sex" value="woman" checked="checked" />여자 <br />
		자기소개:
		<textarea name="self_intro" cols="30" rows="10">나는 부유한 집안에서 태어나서	대충 사라씸...</textarea>

		<br /> <input type="submit" value="POST방식" />
	</form>

	<h2>요청헤더 출력하기</h2>
	<a href="RequestHeader.jsp">
		RequestHeader.jsp페이지바로가기
	</a>
	<!--  
	referer정보를 이용하면 해당 클라이언트가 어떤 경로를 통해
	유입되었는지 알 수 있기 때문에 주로 로그분석에 많이 활용된다.
	그외 요청헤더에는 host정보, 웹브라우저 정보, 쿠키 정보 등이 저장되어 있다.
	-->
	<div style="color:blue;">
		위 파일을 단독으로 실행하면 보이지 않던 referer항목이
		위 링크를 타고 들어가면 추가적으로 보이게 된다.
	</div>
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>
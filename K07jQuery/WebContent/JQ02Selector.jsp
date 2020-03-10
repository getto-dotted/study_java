<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ02Selector.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){
	
	/*
	정규표현식을 통한 DOM 선택
		* : 문자열이 포함된 모든 태그 선택
		$ : 해당 문자열로 끝나는 태그 선택
		^ : 해당 문자열로 시작하는 태그선택	
	*/
		$("a[href*='naver']").click(function(){
			alert("나는 네이버");
			return;
		});	
	
		$("a[href$='.net']").click(function(){
			alert("나는 다음 임");
			return;
		});	
	
		$("a[href^='www']").click(function(){
			alert("한직전");
			return;
		});	
	
		/*  
		contains : 태그사이에 특정 문자열이 포함된 엘리먼트를 선택
		#아이디 : 아이디 선택자
		last-child : 요소중 마지막 엘리먼트를 선택
		eq(인덱스) : 해당 인덱스의 엘리먼트를 선택. 인덱스는 0부터 시작		
		*/
		
		$('li:contains("사전")').css("color","blue");
		$("#naver_size").click(function(){
			alert("네이버는 "+$('#naver li').length+"개의 li 엘리먼트를 가지고 있습니다.");
		});
		$('#naver li:last-child').css("color", "green");
		$('#naver li:eq(3)').css("color", "red").css("fontSize", "2em");
		/*  
		even : '짝수'번째 요소를 선택
		odd : '홀수'번째 요소를 선택
		*/
		$('#daum li:even').css("color", "pink");
		$("#daum li:odd").css("color", "blue");
		/*  
		선택자를 지정한 후 함수를 실행하므로 해당 함수내에서는
		$(this)로 해당 엘리먼트를 선택할 수 있다.
		*/
		$('#myTitle').click(function(){
			var ans = confirm("글자를 파란색으로 바꿀까요?");
			if(ans==true){
				$(this).css("color","blue")
						.css("fontSize","1.5em");
			}
		});
});
</script>
</head>

<body>
	<h2>jQuery 셀렉터(선택자, 선택기, Selector)</h2>
	<ul>
		<li><a href="http://naver.com">네이버</a></li>
		<li><a href="http://daum.net">다음</a></li>
		<li><a href="www.koreavc.or.kr/">한직전</a></li>
	</ul>
		
	<h2>네이버</h2>
	<ul id="naver">
		<li>사전</li>
		<li>뉴스</li>
		<li>증권</li>
		<li>부동산</li>
		<li>지도</li>
		<li>영화</li>
	</ul>
	<p id="naver_size">
		여기를 클릭하면 id="naver"의 엘리먼트 갯수를
		알수있습니다.
	</p>
	
	<h2>다음</h2>
	<ul id="daum">
		<li>카페</li>
		<li>메일</li>
		<li>뉴스</li>
		<li>지도</li>
		<li>증권</li>
		<li>쇼핑</li>
		<li>카카오</li>
	</ul>
 
	<h2>클릭하면 파란색으로 변경되요</h2>
	<h3 id="myTitle" style="cursor:pointer;">
		Hello jQuery(클릭하세요)
	</h3>
</body>

</html>
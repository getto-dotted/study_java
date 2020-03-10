<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ15Post.jsp</title>
<script src="./js/jquery-3.4.1.js"></script>
<script>
function checkFrm(){
	var f = document.getElementById("loginFrm");
	f.method = "post";
	f.action = "./common/PostLogin1.jsp"
}
$(function(){
	
	$('#btnLogin2').click(function(){
		$.post('./common/PostLogin2.jsp',//1.요청경로
				{
					'user_id':$('#user_id').val(),
					'user_pw':$('#user_pw').val()
				},//2.파라미터
				function(responseData){//3.콜백메소드
					/*  
					콜백데이터가 JSON형태일때는 JSON.parse()함수를 통해
					파싱후 데이터를 추출한다.
					*/
					var rData = JSON.parse(responseData);
					if(rData.result==1){
						alert('로그인 성공입니다.');
						var disTxt = 
							"<h3>"+ rData.user_name + "("+ rData.user_id+")님 반갑습니다.</h3>";
							//성공한경우 로그인폼을 위 내용으로 교체함
							$('#loginTable').html(disTxt);
					}
					else{
						alert('로그인 실패입니다.');
						var disTxt = "<h3>로그인 실패 ㅜㅠ;</h3>";
						$('#jsonDisplay').html(disTxt);
					}
				}
		);
	});
	/*  
	파라미터 조립하기
		: jQuery의 Ajax관련 메소드를 사용할때 서버로 전송할
		파라미터가 있으면 반드시 JSON형태로 조립후 전송해야 한다.
		양이 많을 때는 조립자체가 어려우므로 serialize()함수를 
		사용해서 한꺼번에 조립할 수 있다.
		단, 이때 <form>태그의 name속성을 반드시 선언해야 하고,
		하위태그 <input>, <select>도 name속성이 반드시 있어야 한다.
		
		사용법
			var 변수 = $('#폼의 name속성값').serialize();
	*/
	$('#btnLogin3').click(function(){
		var params = $('#loginFrm').serialize();
		$.post('./common/PostLogin3.jsp',//1.요청경로
				params , //2.파라미터
				function(responseData){//3.콜백메소드
					/*  
					콜백데이터가 JSON형태일때는 JSON.parse()함수를 통해
					파싱후 데이터를 추출한다.
					*/
					var rData = JSON.parse(responseData);
					if(rData.result==1){
						alert('로그인 성공입니다.');
						var disTxt = 
							"<h3>"+ rData.user_name + "("+ rData.user_id+")님 반갑습니다.</h3>";
							//성공한경우 로그인폼을 위 내용으로 교체함
							$('#loginTable').html(disTxt);
					}
					else{
						alert('로그인 실패입니다.');
						var disTxt = "<h3>로그인 실패 ㅜㅠ;</h3>";
						$('#jsonDisplay').html(disTxt);
					}
				}
		);
	});
});

</script>
</head>
<body>
	<h2>$.post() 메소드 사용하기</h2>
	
	<h3>로그인 구현하기</h3>
	<div class="row" id="loginTable">
		<form name="loginFrm" id="loginFrm" onsubmit="return checkFrm();">
			<table class="table table-bordered">
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" id="user_id" 
							name="user_id" value="koreavc" />
					</td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td>
						<input type="password" id="user_pw" 
							name="user_pw" value="1234" />
					</td>
				</tr>
			</table>
			<button type="submit" class="btn btn-danger" 
				id="btnLogin1">
				로그인하기1</button>
			&nbsp;&nbsp;
			<button type="button" class="btn btn-success" 
				id="btnLogin2">
				로그인하기2</button>
			&nbsp;&nbsp;
			<button type="button" class="btn btn-success" 
				id="btnLogin3">
				로그인하기3</button>
		</form>
	</div>
	<br/>
	<div class="row" id="jsonDisplay">
		Login결과출력
	</div>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQ13Form2.jsp</title>
<script src="./js/jquery-3.4.1.js"></script>
<script>
$(function(){
	/*  
	시나리오] 비밀번호 확인기능 구현하기
	1. 암호1을 입력할때 무조건 암호2 부분을 비워준다.
	2. 암호2 부분을 입력할때 암호가 일치하게 되면
	<span id = "msg">부분의 텍스트를 빨간색으로 표녛난다.
	3. 암호가 틀렸을때 - > 암호가 틀립니다.(검은색)
	암호가 일치할떄 -> 암호가 일치합니다.(빨간색)
	*/
	//조건1
	$("#pwd1").keyup(function(){
		$("#pwd2").val('');
		$("#msg").text('');//html('')사용해도 무방
	});
	//조건2
	$("#pwd2").keyup(function(){
		var compareStr1 = $("#pwd1").val();
		var compareStr2 = $(this).val();
		
		if(compareStr1==compareStr2){
			$('#msg').html('<b style="color:red;">암호가 일치합니다.</b>');
		}
		else{
			$('#msg').html('<b>암호가 틀립니다.</b>');
			$('#msg').css('color','black');
		}
	});
	/*  
	시나리오] 이메일의 도메인 부분을 선택했을때의 값을 이메일의 두번째 항목에 삽입
	*/
	$('#selectEmail').change(function(){
		//option태그 사이의 값을 가져옴
		var text = $('#selectEmail option:selected').text();
		//value속성에 입력된 값을 가져옴.
		var value = $('#selectEmail option:selected').val();
	
		alert("선택한 항목의 text: "+ text+", value:" + value);
		//위에서 선택한 값을 도메인 부분에 입력한다.
		$('#email2').val(value);
		/* $('#email2').val($('#selectEmail option:selected').val()); */
	});
	
});

</script>
</head>
<body>
	<h3>비밀번호 확인기능</h3>
	<span id="msg"></span>
	<br/>
	암호입력 : <input type="password" id="pwd1" />
	<br/>
	암호확인 : <input type="password" id="pwd2" />
	
	
	<h3>선택상자에서 선택된값을 텍스트상자에 출력하기</h3>
	이메일 : <input type="text" id="email1" style="width:100px;"/>
	@ <input type="text" id="email2" style="width:150px;"/>
	<select id="selectEmail">
		<option value="naver.com">네이버</option>
		<option value="hanmail.net">다음(한메일)</option>
		<option value="gmail.com">구글(gmail)</option>
	</select>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<script>
$(function(){
	//로그인 버튼클릭
	
	$('#loginBtn').click(function(){
		
		var f = document.loginForm; 
		 
		if(f.id.value==""){
			alert("아이디를 입력하세요");
			f.id.focus();
			return false;
		}
		if(f.pass.value==""){
			alert("패스워드를 입력하세요"); 
			f.pass.focus();
			return false;
		}		
		
		$.ajax({
	   		 url: './loginAction.do',
	   		 dataType : "json",
	   		 type : "post",//post방식
	   		 contentType : "application/x-www-form-urlencoded;charset:utf-8",
	   		 data : {
	   			 id : $('#id').val(),//user_id폼에 입력된 value값을 파라미터로 전송
	   			 pass : $('#pass').val()//user_pw폼에 입력된 value값을 파라미터로 전송
	   		 },
	   		 success : function(d){
	   			 //alert("성공"+d)
	   			 if(d.loginResult==0){
	   				 alert(d.loginMessage);
	   			 }
	   			 else{
	   				 //로그인 성공시 메시지 출력 후 리스트로 이동
	   				 alert(d.loginMessage);
	   				 //location.href='login.do';
	   				 $('#loginTable').html(d.loginHtml);
	   			 }
	   		 },
	   		 error : function(e){
	   			 alert("실패"+e);
	   		 }
	   	 });
	    });    
});


</script>
<div class="container"> 
	<h3>Ajax와 JSON을 활용한 로그인</h3> 
	<c:choose>
		<c:when test="${not empty sessionScope.siteUserInfo }">
			<div class="row" style="border:2px solid #cccccc;padding:10px;">			
				<h4>아이디:${sessionScope.siteUserInfo.id }</h4>
				<h4>이름:${sessionScope.siteUserInfo.name }</h4>
				<br /><br />
				<button class="btn btn-danger" 
					onclick="location.href='logout.do';">
					로그아웃</button>
				
			</div>
		</c:when>
		<c:otherwise>
			<form name="loginForm" method="post" id="loginTable">				
				<table class="table-bordered" style="width:50%;">
					<tr>
						<td><input type="text" class="form-control" name="id" id="id" placeholder="아이디" tabindex="1"></td>
						<td rowspan="2" style="width:80px;">
						<button id="loginBtn" type="button" class="btn btn-primary" style="height:77px; width:77px;"  tabindex="3">로그인</button></td>
					</tr>
					<tr>
						<td><input type="password" class="form-control" name="pass" id="pass" placeholder="패스워드" tabindex="2"></td>
					</tr>
				</table>
			</form>
		</c:otherwise>
	</c:choose>
</div>


<h2>비동기 방식으로 콜백데이터 확인하기</h2>
<form name="loginForm" method="post" action="loginAction.do">				
				<table class="table-bordered" style="width:50%;" >
					<tr>
						<td><input type="text" class="form-control" name="id" placeholder="아이디" tabindex="1"></td>
						<td rowspan="2" style="width:80px;">
						<button type="submit" class="btn btn-primary" style="height:77px; width:77px;"  tabindex="3">로그인</button></td>
					</tr>
					<tr>
						<td><input type="password" class="form-control" name="pass" placeholder="패스워드" tabindex="2"></td>
					</tr>
				</table>
			</form>
</body>

</html>
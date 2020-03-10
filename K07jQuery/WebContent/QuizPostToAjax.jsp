<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QuizPostToAjax.jsp</title>
<script src="./js/jquery-3.4.1.js"></script>
<!--
퀴즈) JQ15Post의 세번째 예제를 $.ajax()함수로 구현하시오
    JDBC연동이 되어야 한다.
 -->
<script>
function errFunc(){//로그인 실패메시지-무시됨
    alert("에러발생. 디버깅하세욤.");
}
function sucFunc(resData){//로그인 성공메시지
    alert("$.ajax()메소드 요청성공");
    $('#Display').html(resData);
}
function sucFunc2(responseData){//로그인 성공시 콜백메소드, 실패메소드를 겸함
    
    var rData = JSON.parse(responseData);//json데이터를 콜백받아 파싱
    if(rData.result==1){//콜백받은 json데이터중 result라는 키값을 가진 자료가 1이라는 value를 갖는지 확인
   	 alert('로그인 성공입니다.');
   	 var disTxt =
   		 "<h3>"+ rData.user_name + "("+ rData.user_id+")님 반갑습니다.</h3>";   		 
   		 $('#loginTable').html(disTxt);//loginTable이라는 id를 갖는 태그 영역을 비우고(empty) 해당영역에 내용을 채움(append)
    }
    else{
   	 alert('로그인 실패입니다.');
   	 var disTxt = "<h3>로그인 실패 ㅜㅠ;</h3>";
   	 $('#Display').empty();
   	 $('#Display').append(disTxt);//empty()+append()=html()
   	 $('#Display').css("color","red");
    }
}
//-----------자바스크립트 함수------------------------------------------------------
$(function(){    
    $('#btnLogin1').click(function(){
   	 var log = $('#loginFrm').serialize();//json객체 자동생성 함수
   	 $.ajax({
   		 url: './common/PostLogin3.jsp',//수업예제와 동일한 문서
   		 dataType : "html",
   		 type : "get",//get방식
   		 contentType : "text/html;charset:utf-8",
   		 data : log,
   		 success : sucFunc2,
   		 error : errFunc//sucFunc2의 else부분이 먼저 실행되어서 무시된다.   	 
   	 });
    });
    $('#btnLogin2').click(function(){
   	 $.ajax({
   		 url: './common/PostLogin3.jsp',
   		 dataType : "html",
   		 type : "post",//post방식
   		 contentType : "application/x-www-form-urlencoded;charset:utf-8",
   		 data : {
   			 user_id : $('#user_id').val(),//user_id폼에 입력된 value값을 파라미터로 전송
   			 user_pw : $('#user_pw').val()//user_pw폼에 입력된 value값을 파라미터로 전송
   		 },
   		 success : sucFunc2//성공시 콜백 메소드
   		 //실패시 콜백메소드    생략    
   	 });
    });    
    
    /*  
    	$.post() / $.get() 메소드의 콜백데이터는 무조건 text타입으로 지정된다.
    	따라서 데이터가 json이라면 반드시 JSON.parse()를 통해 json데이터로 변경해야한다.
    	
    	$.ajax()는 콜백데이터의 타입을 지정할 수 있으므로 만약 json타입으로 콜백받는다면
    	JSON.parse()로 변경없이 바로 사용할 수 있다.
    */
    $('#btnLogin3').click(function(e){
     	 var log = $('#loginFrm').serialize();//json객체 자동생성 함수
     	 $.ajax({
     		 url: './common/PostLogin3.jsp',//수업예제와 동일한 문서
     		 dataType : "text",
     		 type : "post",//post방식
       		 contentType : "application/x-www-form-urlencoded;charset:utf-8",
     		 data : log,
     		 success : function(d){
     			//var rData = JSON.parse(d);//json데이터를 콜백받아 파싱
     		    if(rData.result==1){//콜백받은 json데이터중 result라는 키값을 가진 자료가 1이라는 value를 갖는지 확인
     		   	 alert('로그인 성공입니다.');
     		   	 var disTxt =
     		   		 "<h3>"+ rData.user_name + "("+ rData.user_id+")님 반갑습니다.</h3>";   		 
     		   		 $('#loginTable').html(disTxt);//loginTable이라는 id를 갖는 태그 영역을 비우고(empty) 해당영역에 내용을 채움(append)
     		    }
     		    /* else{
     		   	 alert('로그인 실패입니다.');
     		   	 var disTxt = "<h3>로그인 실패 ㅜㅠ;</h3>";
     		   	 $('#Display').empty();
     		   	 $('#Display').append(disTxt);//empty()+append()=html()
     		   	 $('#Display').css("color","red");
     		    } */
     		 },
     		 error : function(e){
     			 alert("오류발생:"+e.status+":"+e.statusText);
     			 console.log("오류발생:"+e.status+":"+e.statusText);
     		 }	 
     	 });
      });      
});//----------------jQuery함수-----------------------------------
</script>
</head>
<body>
    
    <h3>Ajax로 로그인 구현하기</h3>
    <div class="row" id="loginTable">
   	 <form name="loginFrm" id="loginFrm" onsubmit="return checkFrm();">
   		 <table class="table table-bordered">
   			 <tr>
   				 <td>아이디</td>
   				 <td>
   					 <input type="text" id="user_id"
   						 name="user_id" value="" />
   				 </td>
   			 </tr>
   			 <tr>
   				 <td>패스워드</td>
   				 <td>
   					 <input type="password" id="user_pw"
   						 name="user_pw" value="" />
   				 </td>
   			 </tr>
   		 </table>    
   		 <button type="button" class="btn btn-success"
   			 id="btnLogin1">
   			 로그인하기1(serialize()함수사용)</button>
   		 <button type="button" class="btn btn-success"
   			 id="btnLogin2">
   			 로그인하기2</button>
   		 <button type="button" class="btn btn-success"
   			 id="btnLogin3">
   			 로그인하기3</button>
   	 </form>
    </div>
    <br/>
    <div class="row" id="Display">
   	 Login결과출력
    </div>
</body>
</html>

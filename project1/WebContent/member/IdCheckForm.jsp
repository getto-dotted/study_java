<%@page import="dataObject.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 
String overFlag = request.getParameter("overFlag");
if(overFlag==null || overFlag.equals("")){
	overFlag = "2";
}
%>
<style type="text/css">
#wrap {
	width: 490px;
	text-align: center;
	margin: 0 auto 0 auto;
}

#chk {
	text-align: center;
}

#cancelBtn {
	visibility: visible;
}

#useBtn {
	visibility: hidden;
}
</style>

<script type="text/javascript">


        // 회원가입창의 아이디 입력란의 값을 가져온다.
        function pValue(){        	
        	document.getElementById("uncheckedId").value = opener.document.joinForm.id.value;        	
        }
        
    	// 아이디 입력체크
        function idCheck(){
            var id = document.getElementById("uncheckedId").value;
 
            if (!id) {
                alert("아이디를 입력하지 않았습니다.");
                document.getElementById("msg").innerHTML ="";
                return false;
            }	            
            document.checkForm.method="post";
            document.checkForm.action="check.jsp";
        }
        
        // 사용하기 클릭 시 부모창으로 값 전달 
        function sendCheckValue(){
            // 중복체크 결과인 idCheck 값을 전달한다.
            opener.document.joinForm.idDuplication.value ="checked";
            // 회원가입 화면의 ID입력란에 값을 전달
            opener.document.joinForm.id.value = document.getElementById("checkedId").value;
            
            if (opener != null) {
                //opener.chkForm = null;
                self.close();
            }    
        }    
   </script>

</head>
<body onload="pValue()">
	<div id="wrap">
		<br> <b><font size="4" color="gray">아이디 중복체크</font></b>
		<hr size="1" width="460">
		<br>
		<div id="chk">
<%
			if(overFlag.equals("1") || overFlag.equals("2")){
%>			
			<form name="checkForm" onsubmit="return idCheck();">
				<input type="text" name="id" id="uncheckedId"> <input type="submit" value="중복확인">
			</form>
<%
			} else if(overFlag.equals("0")) {//사용가능
%>
			<form name="checkForm" onsubmit="return idCheck();">
				<input type="text" name="id" id="checkedId" value="${param.id }" readonly>
				<input type="button" value="아이디 사용하기" onclick="sendCheckValue();">
			</form>
<%
}
%>
			<div id="msg"></div>
			<br> <input id="cancelBtn" type="button" value="취소" onclick="window.close()"><br> 
			<input id="useBtn" type="button" value="사용하기" onclick="sendCheckValue()">
		</div>
	</div>
</body>
</html>

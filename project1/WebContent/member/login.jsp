<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<script>
function loginValidate() {
		if (SubLoginForm.user_id.value == "") {
			alert("아이디를 입력하세요");
			MainLoginForm.user_id.focus();
			return false;
		}
		if (!SubLoginForm.user_pw.value) {
			alert("패스워드를 입력하세요");
			MainLoginForm.user_pw.focus();
			return false;
		}
		document.SubLoginForm.action = "../LoginSession/LoginProcess.jsp";
		document.SubLoginForm.method = "post";
	}
</script>

 <body>
 <%
	//세션영역에 USER_ID 속성값이 없는 경우(로그아웃 상태)
	if (session.getAttribute("USER_ID") == null) {
		%>
	<center>
	<div id="wrap">
		<%@ include file="../include/top.jsp" %>

		<img src="../images/member/sub_image.jpg" id="main_visual" />

		<div class="contents_box">
			<div class="left_contents">
				<%@ include file = "../include/member_leftmenu.jsp" %>
			</div>
			<div class="right_contents">
				<div class="top_title">
					<img src="../images/login_title.gif" alt="인사말" class="con_title" />
					<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;멤버쉽&nbsp;>&nbsp;로그인<p>
				</div>
				<div class="login_box01">
				<form name="SubLoginForm" method="post" action="" onsubmit="return loginValidate()">
					<img src="../images/login_tit.gif" style="margin-bottom:30px;" />
					<ul>
						<li><img src="../images/login_tit001.gif" alt="아이디" style="margin-right:15px;" /><input type="text" name="user_id" value="" class="login_input01" /></li>
						<li><img src="../images/login_tit002.gif" alt="비밀번호" style="margin-right:15px;" /><input type="text" name="user_pw" value="" class="login_input01" /></li>
					</ul>
					<input type="image" src="../images/login_btn.gif" />					
				</div>
				</form>
				<p style="text-align:center; margin-bottom:50px;"><a href="../member/id_pw.jsp"><img src="../images/login_btn02.gif" alt="아이디/패스워드찾기" /></a>&nbsp;<a href="../member/join01.jsp"><img src="../images/login_btn03.gif" alt="회원가입" /></a></p>
			</div>
		</div>
<%
}else{
%>
<script>
	alert("<%=session.getAttribute("USER_NAME")%>님 반갑습니다.");
	location.href="../main/main";
</script>

		<%} %>
		<%@ include file="../include/quick.jsp" %>
	</div>
	

	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>

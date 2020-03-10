<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>


 <body>
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
					<img src="../images/member/id_pw_title.gif" alt="" class="con_title" />
					<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;멤버쉽&nbsp;>&nbsp;아이디/비밀번호찾기<p>
				</div>
				<div class="idpw_box">
					<div class="id_box">
					<form action="findID.jsp" method="post" onsubmit="checkFrm()">
						<ul>
							<li><input type="text" name="name" value="" class="login_input01" /></li>
							<li><input type="text" name="email" value="" class="login_input01" /></li>
						</ul>
						<input type="image" src="../images/member/id_btn01.gif" "/>
						<!-- <a href=""><img src="../images/member/id_btn01.gif" class="id_btn" /></a> -->
						<a href="join01.jsp"><img src="../images/login_btn03.gif" class="id_btn02" /></a>
						</form>
					</div>
<script>
function pwFind(){
	var fn = document.pw_box;
	fn.action="idpw_find_proc.jsp";
	fn.method="post";
	fn.submit();
}
</script>
					<div class="pw_box">
					<form name="pw_box" >
					
						<ul>
							<li><input type="text" name="user_id" value="test2" class="login_input01" /></li>
							<li><input type="text" name="user_name" value="홍길동" class="login_input01" /></li>
							<li><input type="text" name="user_email" value="1234" class="login_input01" /></li>
							<li><input type="hid den" name="mode" value="pw_find" /></li>
						</ul>						
						<a href="javascript:pwFind()"><img src="../images/member/id_btn01.gif"/></a>
						<button type="submit" onsubmit="pwFind();">전송확인</button>
						</form>
					</div>
					
				</div>
			</div>
		</div>
		<%@ include file="../include/quick.jsp" %>
	</div>
	

	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>

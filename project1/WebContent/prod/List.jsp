<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<script>
	function check(){
		
		var chkArr = document.getElementsByName("choice");
		var chkStock = document.getElementsByName("stock");
		
		var f = document.getElementsByName("choice");
		var g = document.getElementsByName("stock");
		var h = document.getElementsByName("price");
		
		if(f.length==1){
			
			if(f[i].checked == false){
				g[i].disabled = true;
				h[i].disabled = true;
			}
		}
		else{
			
			for(var i=0; i<f.length; i++){
				if(f[i].checked == false){
					g[i].disabled = true;
					h[i].disabled = true;
				}
			}
			
		}
		var cnt =0;
		var tValue = 0;
		
		for (var i = 0; i < chkArr.length; i++) {
			if (chkArr[i].checked == true) {
				cnt++;				
			}			
		}
		
		for (var i = 0; i < chkStock.length; i++) {			
				 tValue += chkStock[i].value;
		} 
		
		if (tValue == 0) {
			alert("선택된 상품의 갯수가 0개입니다.");
			return false;
		}
		
		if(cnt==0){
			alert("상품을 하나 이상 선택해 주세요.");
			return false;
		} 
		
		if(!<%=session.getAttribute("USER_ID")%>){
			alert("로그인 해주세요.");
			location.href="../member/login.jsp";
			return false;
		}		
		
		
	}
</script>

 <body>
	<center>
	<div id="wrap">
		<%@ include file="../include/top.jsp" %>

		<img src="../images/market/sub_image.jpg" id="main_visual" />

		<div class="contents_box">
			<div class="left_contents">
				
				<%@ include file = "../include/market_leftmenu.jsp" %>
			</div>
			<div class="right_contents">
				<div class="top_title">
					<img src="../images/market/sub01_title.gif" alt="수아밀 제품 주문" class="con_title" />
					<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;열린장터&nbsp;>&nbsp;수아밀 제품 주문<p>
				</div>
					<div class="row text-right"
						style="margin-bottom: 20px; padding-right: 50px;">
						<!-- 검색부분 -->
						<form class="form-inline">
							<div class="form-group">
								<select name="searchColumn" class="form-control">
									<option value="name" ${map.Column=="name" ? "selected" : ""}>상품명</option>
									<option value="info" ${map.Column=="info" ? "selected" : ""}>상품설명</option>
								</select>
							</div>
							<div class="input-group">
								<input type="text" name="searchWord" class="form-control" />
								<div class="input-group-btn">
									<button type="submit" class="btn btn-default">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</div>
							</div>
						</form>
					</div>
					<table cellpadding="0" cellspacing="0" border="0" class="market_board01">
					<colgroup>
						<col width="5%" />
						<col width="20%" />
						<col width="*" />
						<col width="10%" />
						<col width="10%" />
						<col width="15%" />
					</colgroup>
					<tr>
						<th>선택</th>
						<th>상품이미지</th>
						<th>상품명</th>
						<th>가격</th>
						<th>수량</th>
						<th>구매</th>
					</tr>							
					<!-- 리스트반복 -->
					<form name="ordering" method="post" action="../basket/Write" onsubmit="return check()">
						<tr>
							<c:choose>
								<c:when test="${empty listsProd }">
									<tr>
										<td colspan="6">등록된 게시물이 없습니다.</td>
									</tr>										
								</c:when>
								<c:otherwise>
									<c:forEach items="${listsProd }" var="row" varStatus="loop">
										<tr>		
											
												<td><input type="checkbox" name="choice" value="${row.idx }" /></td>									
												<td><a href="../prod/View?idx=${row.idx }&nowPage=${param.nowPage }">
														<c:if test="${not empty row.ofile }">
															<img src="../Upload/${row.sfile }" width="100px" />														
														</c:if></a></td>
												<td class="t_left"><a href="../prod/View?idx=${row.idx }&nowPage=${param.nowPage }">${row.name }</a></td>		
												<td>${row.price } <input type="hidden" name="price" value="${row.price }" /> </td>
												<td><input type="text" name="stock" value="0" class="n_box" /></td>
												<td><input type="image" src="../images/market/btn01.gif" style="margin-bottom:5px;"/><br />
												<input type="image" src="../images/market/btn02.gif" />
												</td>
											
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tr>
						</form>
					</table>
			</div>
<%
//세션영역에 USER_ID 속성값이 없는 경우(로그아웃 상태)
if (session.getAttribute("USER_ID") == null) {} 
else{
/* 세션영역에 USER_ID 속성값이 있지만 관리자가 아닌경우*/
	if(session.getAttribute("grade").toString().equals("0") || session.getAttribute("grade") == null){}
/* 세션영역에 USER_ID 속성값이 있고 관리자인 경우 */
	else {	
	%>
<button type="button" class="btn btn-default" onclick="location.href='Write';">글쓰기</button>
<%
	}
}
%>	
		</div>
		<%@ include file="../include/quick.jsp" %>
	</div>
	

	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>

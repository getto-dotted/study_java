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

		var f = document.basket
		f.method = "post";
		f.action = "../deli/List";
		f.submit();
	}
	
	
	
	function del(pid){
		var f = document.basket
		document.basket.pid.value = pid;
		f.method = "post";
		f.action = "../basket/Delete";
		f.submit();
	}

</script>

<c:set var="row" value="${listsbasket }" />		
<c:set var = "ttprice" value="0"/>
<c:set var = "tdprice" value="0"/>
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
				<table cellpadding="0" cellspacing="0" border="0" class="basket_list">
					<colgroup>
						<col width="7%" />
						<col width="10%" />
						<col width="*" />
						<col width="10%" />
						<col width="8%" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
						<col width="8%" />
					</colgroup>
					<thead>
						<tr>
							<th>선택</th>
							<th>이미지</th>
							<th>상품명</th>
							<th>판매가</th>
							<th>적립금</th>
							<th>수량</th>
							<th>배송구분</th>
							<th>배송비</th>
							<th>합계</th>
						</tr>
					</thead>
					<tbody>					
						<!-- 리스트반복 -->
						<tr>
							<form name="basket" method="post">
								<input type="hidden" name="pid"  /> 												
								<input type="hidden" name="nowPage" value="${param.nowPage }"/> 										
							</form>
							
							<c:choose>
								<c:when test="${empty listsbasket }">
									<tr>
										<td colspan="6">등록된 게시물이 없습니다.</td>
									</tr>											
								</c:when>
								<c:otherwise>
									<c:forEach items="${listsbasket }" var="row" varStatus="loop">
										<tr>		
												<td><input type="checkbox" name="choice" value="${row.idx }" /></td>									
												<td>
													<c:if test="${not empty row.ofile }">
														<img src="../Upload/${row.sfile }" width="80px" />														
													</c:if>												
												</td>
												<td class="t_left">${row.name }</td>		
												<td>${row.price }</td>
												<td>${row.dispoint }</td>
												<td><input type="text" name="stock" value="${row.cstock}" class="n_box" /></td>
												<td><c:choose><c:when test="${not empty row.deliv}">${row.deliv }</c:when>	
												<c:otherwise>무료배송</c:otherwise>
												</c:choose></td>
												<td><c:choose><c:when test="${not empty row.dprice}">${row.dprice }</c:when>	
												<c:otherwise>0원</c:otherwise>
												</c:choose></td>												
												<td style="color:green">${row.price+row.dprice } 원</td>
												<td><button type="button" onclick="check()"><img src="../images/market/btn01.gif" /></button><br />
												<button type="button" onclick="del(${row.pid });"><img src="../images/delete.jpg" width="40px;" /></button>																						
											</td>
											
										</tr>
										<c:set var = "ttprice" value="${ttprice + row.price }"/>
										<c:set var = "tdprice" value="${tdprice + row.dprice }"/>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tr>
					</tbody>
				</table>	
								
				<p class="basket_text">[ 기본 배송 ] <span>상품구매금액</span><c:out value="${ttprice }"/> + <span>배송비</span><c:out value="${tdprice }"/> = 합계 : <span class="money"><c:out value="${ttprice + tdprice}"/> 원</span><br /><br />
				<a href="../prod/List"><img src="../images/market/basket_btn01.gif" /></a>&nbsp;<input type="image" src="../images/market/basket_btn02.gif" /></p>
							
			</div>
		</div>
		<%@ include file="../include/quick.jsp" %>
	</div>
	

	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>

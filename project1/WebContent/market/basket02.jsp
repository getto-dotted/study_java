<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>

	function check(){		
		
		var chkArr = document.getElementsByName("choice");
		var chkStock = document.getElementsByName("stock");
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
		
	}
	
	
	
	function del(pid){
		var f = document.basket
		document.basket.pid.value = pid;
		f.method = "post";
		f.action = "../basket/Delete";
		f.submit();
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
				<p class="con_tit"><img src="../images/market/basket_title01.gif" /></p>
				<table cellpadding="0" cellspacing="0" border="0" class="basket_list" style="margin-bottom:50px;">
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
												<td><input type="text" name="stock" value="장바구니 페이지에서 변경한 값을 파라미터로 받음" class="n_box" /></td>
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

				<p class="con_tit"><img src="../images/market/basket_title02.gif" /></p>
				<table cellpadding="0" cellspacing="0" border="0" class="con_table" style="width:100%;" style="margin-bottom:50px;">
					<colgroup>
						<col width="15%" />
						<col width="*" />
					</colgroup>
					<tbody>
					<tr>
							<form name="member" method="post">
								<input type="hidden" name=""  /> 												
								<input type="hidden" name="" value=""/> 	
							</form>
							
							<c:choose>
								<c:when test="${empty listsmember }">
									<tr>
										<td colspan="6">등록된 게시물이 없습니다.</td>
									</tr>											
								</c:when>
								<c:otherwise>
									<c:forEach items="${listsmember }" var="rowm" varStatus="loop">
										<tr>		
												<th>성명</th>
												<td style="text-align:left;"><input type="text" name=""  value="${rowm.name })" class="join_input" /></td>								
										</tr>
						<tr>
							<th>주소</th>
							<td style="text-align:left;"><input type="text" name=""  value="${rowm.zipcode }" class="join_input" style="width:100px; margin-bottom:5px;" />
							 <a href=""><img src="../images/market/basket_btn03.gif" style="margin-bottom:5px;" /></a><br />
							 <input type="text" name=""  value="${rowm.addr }" class="join_input" style="width:300px; margin-bottom:5px;" /> 기본주소<br />
							 <input type="text" name=""  value="${rowm.addr2 }" class="join_input" style="width:300px;" /> 나머지주소</td>
						</tr>
						<c:set var="mobile" value="${fn:split(rowm.mobile), '-' }" />
						<tr>
							<th>휴대폰</th>
							<td style="text-align:left;"><input type="text" name=""  value="${mobile[0] }" class="join_input" style="width:50px;" /> - 
							<input type="text" name=""  value="${mobile[1] }" class="join_input" style="width:50px;" /> - 
							<input type="text" name=""  value="${mobile[2] }" class="join_input" style="width:50px;" /></td>
						</tr>		
						<c:set var="email" value="${fn:split(rowm.email), '@' }" />
						<tr>
							<th>이메일주소</th>
							<td style="text-align:left;"><input type="text" name=""  value="${email[0] }" class="join_input" style="width:100px;" /> @ 
							<input type="text" name=""  value="${email[1] }" class="join_input" style="width:100px;" /></td>
						</tr>											
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tr>
						<tr>
							<th>성명</th>
							<td style="text-align:left;"><input type="text" name=""  value="" class="join_input" /></td>
						</tr>
						<tr>
							<th>주소</th>
							<td style="text-align:left;"><input type="text" name=""  value="" class="join_input" style="width:50px; margin-bottom:5px;" /> - <input type="text" name=""  value="" class="join_input" style="width:50px; margin-bottom:5px;" /> <a href=""><img src="../images/market/basket_btn03.gif" style="margin-bottom:5px;" /></a><br /><input type="text" name=""  value="" class="join_input" style="width:300px; margin-bottom:5px;" /> 기본주소<br /><input type="text" name=""  value="" class="join_input" style="width:300px;" /> 나머지주소</td>
						</tr>
						<tr>
							<th>휴대폰</th>
							<td style="text-align:left;"><input type="text" name=""  value="" class="join_input" style="width:50px;" /> - <input type="text" name=""  value="" class="join_input" style="width:50px;" /> - <input type="text" name=""  value="" class="join_input" style="width:50px;" /></td>
						</tr>
						<tr>
							<th>이메일주소</th>
							<td style="text-align:left;"><input type="text" name=""  value="" class="join_input" style="width:100px;" /> @ <input type="text" name=""  value="" class="join_input" style="width:100px;" /></td>
						</tr>
					</tbody>
				</table>

				<p class="con_tit"><img src="../images/market/basket_title03.gif" /></p>
				<p style="text-align:right">배송지 정보가 주문자 정보와 동일합니까? 예<input type="radio" /> 아니오<input type="radio" /></p>
				<table cellpadding="0" cellspacing="0" border="0" class="con_table" style="width:100%;" style="margin-bottom:50px;">
					<colgroup>
						<col width="15%" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>성명</th>
							<td style="text-align:left;"><input type="text" name=""  value="" class="join_input" /></td>
						</tr>
						<tr>
							<th>주소</th>
							<td style="text-align:left;"><input type="text" name=""  value="" class="join_input" style="width:50px; margin-bottom:5px;" /> - <input type="text" name=""  value="" class="join_input" style="width:50px; margin-bottom:5px;" /> <a href=""><img src="../images/market/basket_btn03.gif" style="margin-bottom:5px;" /></a><br /><input type="text" name=""  value="" class="join_input" style="width:300px; margin-bottom:5px;" /> 기본주소<br /><input type="text" name=""  value="" class="join_input" style="width:300px;" /> 나머지주소</td>
						</tr>
						<tr>
							<th>휴대폰</th>
							<td style="text-align:left;"><input type="text" name=""  value="" class="join_input" style="width:50px;" /> - <input type="text" name=""  value="" class="join_input" style="width:50px;" /> - <input type="text" name=""  value="" class="join_input" style="width:50px;" /></td>
						</tr>
						<tr>
							<th>이메일주소</th>
							<td style="text-align:left;"><input type="text" name=""  value="" class="join_input" style="width:100px;" /> @ <input type="text" name=""  value="" class="join_input" style="width:100px;" /></td>
						</tr>
						<tr>
							<th>배송메세지</th>
							<td style="text-align:left;"><input type="text" name=""  value="" class="join_input" style="width:500px;" /></td>
						</tr>
					</tbody>
				</table>

				<p class="con_tit"><img src="../images/market/basket_title04.gif" /></p>
				<table cellpadding="0" cellspacing="0" border="0" class="con_table" style="width:100%;" style="margin-bottom:30px;">
					<colgroup>
						<col width="15%" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>결제금액</th>
							<td style="text-align:left;"><span class="money">60,000원</span></td>
						</tr>
						<tr>
							<th>결제방식선택</th>
							<td style="text-align:left;"><input type="radio" /> 카드결제&nbsp;&nbsp;&nbsp;<input type="radio" /> 무통장입금&nbsp;&nbsp;&nbsp;<input type="radio" /> 실시간 계좌이체</td>
						</tr>
					</tbody>
				</table>
				<p style="text-align:right;"><a href=""><img src="../images/market/basket_btn04.gif" /></a></p>
			</div>
		</div>
		<%@ include file="../include/quick.jsp" %>
	</div>
	

	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>

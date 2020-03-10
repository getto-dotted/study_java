<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<script>
	function check(){
		
		var chkArr = document.getElementsByName("choice");
		var chkStock = document.getElementsByName("stock");
		int cnt =0;
		int tValue = 0;
		
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
									<option value="title" ${map.Column=="title" ? "selected" : ""}>상품명</option>
									<option value="content"
										${map.Column=="content" ? "selected" : ""}>상품설명</option>
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
						<tr>
							<c:choose>
								<c:when test="${empty listsProd }">
									<tr>
										<td colspan="6">등록된 게시물이 없습니다.</td>
									</tr>
										<tr>
											
											<td><input type="checkbox" name="" value="" /></td>
											<td><a href="market_view.jsp"><img src="../images/market/img01.jpg" /></a></td>
											<td class="t_left"><a href="market_view.jsp">녹차 쌀 무스케잌</a></td>
											<td class="p_style">30,000</td>
											<td><input type="text" name="stock" value="0" class="n_box" /></td>
											<td><a href="basket2.jsp"><input type="img" src="../images/market/btn01.gif" />											
											<img src="" style="margin-bottom:5px;" /></a><br />
												<a href="basket.jsp"><input type="img" src="../images/market/btn02.gif" />
												<img src="" /></a></td>
										</tr>	
								</c:when>
								<c:otherwise>
									<c:forEach items="${listsProd }" var="row" varStatus="loop">
										<tr>		
											<form method="get" onsubmit="return check()">
												<td><input type="checkbox" name="choice" value="${row.idx }" /></td>									
												<td><a href="../pic/View?idx=${row.idx }&nowPage=${param.nowPage }">
														<c:if test="${not empty row.ofile }">
															<img src="../Upload/${row.sfile }" width="100px" />														
														</c:if></a></td>
												<td class="t_left"><a href="../pic/View?idx=${row.idx }&nowPage=${param.nowPage }">${row.name }</a></td>		
												<td>${row.price }</td>
												<td><input type="text" name="stock" value="0" class="n_box" /></td>
												<td><a href="basket2.jsp"><input type="img" src="../images/market/btn01.gif" />											
												<img src="" style="margin-bottom:5px;" /></a><br />
													<a href="basket.jsp"><input type="img" src="../images/market/btn02.gif" />
													<img src="" /></a></td>
											</form>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tr>
					</table>
			</div>
		</div>
		<%@ include file="../include/quick.jsp" %>
	</div>
	

	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>

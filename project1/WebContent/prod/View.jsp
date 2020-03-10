<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/global_head.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
/* function numWithCom(${dto.price }){
	var price = ${dto.price }
	return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","); 	
}
 */
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
			<div class="right_contents" align="center">

				<div class="top_title">
					<img src="../images/market/sub01_title.gif" alt="수아밀 제품 주문" class="con_title" />
					<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;열린장터&nbsp;>&nbsp;수아밀 제품 주문<p>
				</div>
				<div class="market_view_box">
					<div class="market_left">
						<c:if test="${not empty dto.ofile }">
							<img src="../Upload/${dto.sfile }" width="100px" />														
						</c:if>						
					</div>
					<div class="market_right">
						<p class="m_title">${dto.name }
						<p>■ ${dto.name }</p>
						<ul class="m_list">
							<li>
								<dl>
									<dt>가격</dt>
									<dd class="p_style">${dto.price }</dd>
								</dl>
								<dl>
									<dt>적립금</dt>
									<dd>${dto.dispoint }</dd>
								</dl>
								<dl>
									<dt>수량</dt>
									<dd style="margin-bottom: 10px;"><input type="number" name="stock" value="1" class="n_box" /></dd>									
									<dt>재고</dt>
									<dd>${dto.stock } 개</dd>
								</dl>
								<dl>
									<dt>상품 상세설명</dt>
									<dd>${dto.info }</dd>
								</dl>
								<dl style="border-bottom:0px;">
									<dt>주문정보</dt>
									<dd><input type="text" name="etc" class="n_box" style="width:200px;" /></dd>
								</dl>
								<div style="clear:both;"></div>
							</li>
						</ul>
						<p class="btn_box"><a href=""><img src="../images/market/m_btn01.gif" alt="바로구매" /></a>&nbsp;&nbsp;<a href="basket.jsp"><img src="../images/market/m_btn02.gif" alt="장바구니" /></a></p>
					</div>				
				</div>
					<!-- 각종 버튼 부분 -->
				<button type="button" class="btn btn-primary" method="post"
					onclick="location.href='../prod/Identify?idx=${param.idx }&mode=edit&nowPage=${param.nowPage }';">수정하기</button>
				<button type="button" class="btn btn-success" method="post"
					onclick="location.href='../prod/Identify?idx=${dto.idx }&mode=delete&nowPage=${param.nowPage }';">삭제하기</button>
				<button type="button" class="btn btn-warning"
					onclick="location.href='./List?nowPage=${param.nowPage }';">리스트보기</button>	
			</div>
		</div>			
				
			<%@ include file="../include/quick.jsp" %>
	</div>
	

	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>

package ex09Package.korea.buyer;

import ex09Package.korea.seller.FruitSeller4;

public class FruitBuyer4 {
	int myMoney;//보유금액
	int numOfApple;//보유한 사과의 갯수
	
	public FruitBuyer4(int _myMoney, int _numOfApple) {
		myMoney= _myMoney;
		numOfApple= _numOfApple;		
	}	
	public void showBuyResult() {
		System.out.println("[구매자] 현재잔액:"+ myMoney);
		System.out.println("[구매자] 사과갯수:"+ numOfApple);
	}
	public void buyApple(FruitSeller4 seller, int money) {		
		numOfApple +=seller.saleApple(money);
		myMoney -=money;
	}		

}

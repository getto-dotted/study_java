package ex08Class;

//과일판매자를 정의한 클래스
class FruitSeller{
	int numOfApple = 100;//판매자의 사과보유갯수
	int myMoney = 0;//판매수익금
	final int APPLE_PRICE = 1000;
	/*
	 사과의 단가.
	 일반적으로 프로그램내에서 단가 같은 경우는 상수형태로 선언하는 것이 일반적이다.
	 값이 변할 수 없으므로 초기화 이후 값을 변경하면 에러가 발생한다.
	 */
	
	/*
	사과를 판매하기 위한 멤버메소드
	
	1. 매개변수를 통해서 금액을 받는다.
	 */
	public int saleApple(int money) {
		//2. 금액에 해당하는 사과의 갯수를 구함
		int num = money / APPLE_PRICE;
		//3. 사과의 갯수만큼 차감한다.
		numOfApple -= num;
		//4. 판매수익금이 증가한다.
		myMoney += money;
		//5. 구매자에게 판매한 사과의 갯수를 반환한다.
		return num;
	}
	public void shoSaleResult() {
		System.out.println("[판매자] 남은 사과갯수:"+numOfApple);
		System.out.println("[판매자] 판매수익:"+myMoney);
	}
		
}
class FruitBuyer{
	int myMoney = 5000;//보유한 금액
	int numOfApple =0;//구매한 사과의 갯수
	
	/*
	사과를 구매하는 행위를 표현한 멤버메소드
	
	1. 판매자에게 금액을 지불한다.(매개변수로 전달)
	 */
	public void buyApple(FruitSeller seller, int money) {
		/*
		2. 판매자가 금액에 해당하는 사과의 갯수를 반환하면 
		그 값을 통해 보유한 사과의 갯수를 증가시킨다.
		 */
		numOfApple +=seller.saleApple(money);
		//3. 판매자에게 지불한 금액만큼 보유금액을 차감한다.
		myMoney -=money;
	}
	
	public void showBuyResult() {
		System.out.println("[구매자] 현재잔액:"+ myMoney);
		System.out.println("[구매자] 사과갯수:"+ numOfApple);
	}
	
	
	
	
}


public class FruitSalesMain1 {

	public static void main(String[] args) {

		FruitSeller seller = new FruitSeller();//판매자 객체
		FruitBuyer buyer = new FruitBuyer();//구매자 객체
		
		System.out.println("구매행위가 일어나기 전의 상태");
		seller.shoSaleResult();
		buyer.showBuyResult();
		/*
		구매자가 판매자에게 5000원을 지불하고 사과를 구매하는 행위를 코드로 표현함.
		 */
		buyer.buyApple(seller, 5000);
		
		System.out.println("구매행위가 일어난 후의 상태");
		seller.shoSaleResult();
		buyer.showBuyResult();
		
		
		
		
		
		
		
	}

}

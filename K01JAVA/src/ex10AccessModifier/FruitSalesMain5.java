package ex10AccessModifier;


class FruitSeller5{
	int numOfApple;
	int myMoney;
	final int APPLE_PRICE;

	public FruitSeller5(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		APPLE_PRICE = price;
	}
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	public void shoSaleResult() {
		System.out.println("[판매자] 남은 사과갯수:"+numOfApple);
		System.out.println("[판매자] 판매수익:"+myMoney);
	}		
}
class FruitBuyer5{
	int myMoney;
	int numOfApple;
	
	public FruitBuyer5(int _myMoney, int _numOfApple) {
		myMoney= _myMoney;
		numOfApple= _numOfApple;		
	}	
	public void showBuyResult() {
		System.out.println("[구매자] 현재잔액:"+ myMoney);
		System.out.println("[구매자] 사과갯수:"+ numOfApple);
	}
	public void buyApple(FruitSeller5 seller, int money) {		
		numOfApple +=seller.saleApple(money);
		myMoney -=money;
	}		
}
public class FruitSalesMain5 {
	public static void main(String[] args) {


		FruitSeller5 seller1 = new FruitSeller5(0, 100, 1000);//수익금, 사과보유수, 단가
		FruitSeller5 seller2 = new FruitSeller5(0, 80, 500);
		FruitBuyer5 buyer = new FruitBuyer5(10000, 0);
				
		System.out.println("구매전의 상태");
		seller1.shoSaleResult();
		seller2.shoSaleResult();
		buyer.showBuyResult();
		
		/*
		아래의 코드는 문법적으로는 오류가 없으나 지불금액과 구매갯수에 논리적 오류가 발생되어 코드를 통한 규칙이 완전히 무너졌다.
		이와같은 논리적 오류를 차단하기 위해 객체지향에서는 "정보은닉" 하도록 권장하고 있다.
		 */
		seller1.myMoney += 1000;//판매자1에게 1000원지불하고 
		seller1.numOfApple -= 100;//사과 100개를 구매한다.
		
		seller2.myMoney += 500;//판매자2에게 500원 지불하고
		seller2.numOfApple -= 90;//사과 90개를 구매한다.
		
		
		System.out.println("구매후의 상태");
		seller1.shoSaleResult();
		seller2.shoSaleResult();
		buyer.showBuyResult();		
	}

}

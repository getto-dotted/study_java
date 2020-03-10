package ex10AccessModifier;


class FruitSeller6{
	private int numOfApple;
	private int myMoney;
	private final int APPLE_PRICE;

	public FruitSeller6(int money, int appleNum, int price) {
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
class FruitBuyer6{
	private int myMoney;
	private int numOfApple;
	
	public FruitBuyer6(int _myMoney, int _numOfApple) {
		myMoney= _myMoney;
		numOfApple= _numOfApple;		
	}	
	public void showBuyResult() {
		System.out.println("[구매자] 현재잔액:"+ myMoney);
		System.out.println("[구매자] 사과갯수:"+ numOfApple);
	}
	public void buyApple(FruitSeller6 seller, int money) {		
		numOfApple +=seller.saleApple(money);
		myMoney -=money;
	}		
}
public class FruitSalesMain6 {
	public static void main(String[] args) {


		FruitSeller6 seller1 = new FruitSeller6(0, 100, 1000);//수익금, 사과보유수, 단가
		FruitSeller6 seller2 = new FruitSeller6(0, 80, 500);
		FruitBuyer6 buyer = new FruitBuyer6(10000, 0);
				
		System.out.println("구매전의 상태");
		seller1.shoSaleResult();
		seller2.shoSaleResult();
		buyer.showBuyResult();
		
		
		//멤버변수가 private으로 선언되므로 외부클래스에서는 접근이 불가능하여 아래 코드는 오류가 발생한다.
				
		/*
		seller1.myMoney += 1000;//판매자1에게 1000원지불하고 
		seller1.numOfApple -= 100;//사과 100개를 구매한다.
		seller2.myMoney += 500;//판매자2에게 500원 지불하고
		seller2.numOfApple -= 90;//사과 90개를 구매한다.
		*/
		
		/*
		판매자에게 각각의 금액을 지불하고, 금액에 해당하는 사과를 정상적으로 구매함.
		정보은닉을 통해 판매의 규칙이 지켜지게 됨.
		 */
		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 3000);
		
		System.out.println("구매후의 상태");
		seller1.shoSaleResult();
		seller2.shoSaleResult();
		buyer.showBuyResult();		
	}

}

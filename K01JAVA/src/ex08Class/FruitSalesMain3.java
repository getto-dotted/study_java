package ex08Class;


class FruitSeller3{
	int numOfApple;
	int myMoney;
	final int APPLE_PRICE;
/*
상수는 딱 한번만 초기화 되므로 일반적인 메소드에서는 초기화 할 수 없다. 단, 생성자메소드에서는 초기화가 가능하다.
생성자 역시 딱 한번만 호출되고, 임의로 호출할 수 없기 때문이다.
 */
	public FruitSeller3(int money, int appleNum, int price) {
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
class FruitBuyer3{
	int myMoney;//보유금액
	int numOfApple;//보유한 사과의 갯수
	
	public FruitBuyer3(int _myMoney, int _numOfApple) {
		myMoney= _myMoney;
		numOfApple= _numOfApple;		
	}	
	public void showBuyResult() {
		System.out.println("[구매자] 현재잔액:"+ myMoney);
		System.out.println("[구매자] 사과갯수:"+ numOfApple);
	}
	public void buyApple(FruitSeller3 seller, int money) {		
		numOfApple +=seller.saleApple(money);
		myMoney -=money;
	}		
}
public class FruitSalesMain3 {
	public static void main(String[] args) {

//생성자를 통해 객체생성과 동시에 초기화를 진행하므로 초기화 메소드 호출없이도 객체를 생성할 수 있다.		
		FruitSeller3 seller1 = new FruitSeller3(0, 100, 1000);//수익금, 사과보유수, 단가
		FruitSeller3 seller2 = new FruitSeller3(0, 80, 500);
		FruitBuyer3 buyer = new FruitBuyer3(10000, 0);
				
		System.out.println("구매전의 상태");
		seller1.shoSaleResult();
		seller2.shoSaleResult();
		buyer.showBuyResult();
		
		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);
		
		System.out.println("구매후의 상태");
		seller1.shoSaleResult();
		seller2.shoSaleResult();
		buyer.showBuyResult();		
	}

}

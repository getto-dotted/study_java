package ex09Package.korea.seller;

public class FruitSeller4 {
	int numOfApple;
	int myMoney;
	final int APPLE_PRICE;
/*
상수는 딱 한번만 초기화 되므로 일반적인 메소드에서는 초기화 할 수 없다. 단, 생성자메소드에서는 초기화가 가능하다.
생성자 역시 딱 한번만 호출되고, 임의로 호출할 수 없기 때문이다.
 */
	public FruitSeller4(int money, int appleNum, int price) {
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

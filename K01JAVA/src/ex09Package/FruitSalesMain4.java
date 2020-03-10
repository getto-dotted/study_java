package ex09Package;


import ex09Package.korea.seller.FruitSeller4;

public class FruitSalesMain4 {
/*
연습문제] 해당 프로그램을 아래의 지시에 따라 패키지로 
구분하여 정상 실행되도록 변경하시오.

FruitSeller4 클래스 -> korea.seller 패키지에 묶는다.
FruitBuyer4 클래스 -> korea.buyer 패키지에 묶는다.

두 클래스를 적당히 import하여 정상동작할수 있도록 
FruitSalesMain4 클래스를 구성한다.
 */

	
	public static void main(String[] args) {

//생성자를 통해 객체생성과 동시에 초기화를 진행하므로 초기화 메소드 호출없이도 객체를 생성할 수 있다.		
		FruitSeller4 seller1 = new FruitSeller4(0, 100, 1000);//수익금, 사과보유수, 단가
		FruitSeller4 seller2 = new FruitSeller4(0, 80, 500);
		ex09Package.korea.buyer.FruitBuyer4 buyer = new ex09Package.korea.buyer.FruitBuyer4(10000, 0);
				
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

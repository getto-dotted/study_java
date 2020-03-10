package review.mycard;
/*
체크카드 클래스 Ver.01

시나리오] 체크카드를 클래스로 표현해보자.
	멤버변수 : 카드번호, 소유자, 잔액, 포인트
	멤버메소드 : 충전(입금), 결제, 적립, 현재상태출력
	적립율 : 사용금액의 0.1%	
*/

public class CheckCard1 {

	public long cardN;
	public String owner;
	public int balance;
	public int point;
	
	public void charge(int amount) {
		balance+=amount;
		System.out.printf("[%s님 충전]%d원 완료\n", owner, amount);
		System.out.printf("[잔고]%d원 입니다.\n\n", balance);
	}
	
	public void payment(int amount) {
		balance -=amount;
		System.out.printf("[%s님 결제]%d원 출금 완료\n", owner, amount);
		System.out.printf("[잔고]%d원 입니다.\n\n", balance);
		savingPoint(amount);		
	}
	public void savingPoint(int amount) {
		int plusPoint = amount/1000;
		point += plusPoint;
		System.out.printf("[적립]%d포인트 완료\n", plusPoint);
		System.out.printf("[포인트잔액]%d 입니다.\n\n", point);
	}
	public void showState() {
		System.out.println("============================");
		System.out.println("카드번호:"+cardN);
		System.out.println("소유자:"+owner);
		System.out.println("잔고:"+balance);
		System.out.println("포인트:"+point);
		System.out.println("============================");
	}
	
}

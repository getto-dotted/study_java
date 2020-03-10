package review.mycard;
/*
	체크카드 클래스 Ver.02

버전02에서 추가부분
	1. 멤버변수 초기화 메소드 정의 
		메소드명 : initMembers()
	2. 기본생성자, 인자생성자 정의
	3. 멤버변수 정보은닉
	4. getter/setter 메소드 추가

*/

public class CheckCard2 {
//private로 정보은닉처리
	private long cardN;
	private String owner;
	private int balance;
	private int point;
	
	public void initMembers(long num, String own, int bal, int po) {
		cardN = num;
		owner = own;
		balance = bal;
		point = po;
	}	
	public CheckCard2() {
		
	}	//기본생성자
	
	public CheckCard2(long cardN, String owner, int balance, int point) {//인자생성자
		this.cardN = cardN;
		this.owner = owner;
		this.balance = balance;
		this.point = point;
	}
		//getter/setter 메소드 정의
	public long getCardN() {
		return cardN;
	}
	public void setCardN(long cardN) {
		this.cardN = cardN;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
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

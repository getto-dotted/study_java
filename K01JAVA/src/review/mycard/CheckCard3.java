package review.mycard;
/*
	체크카드 클래스 Ver.03
	: initMembers 초기화 메소드는 삭제처리 
	
	1.충전은 10000원 단위로만 가능하다.
	만약 5000원을 충전하면 충전불능으로 처리한다.
	
	2.잔고가 부족하면 결제불능으로 처리해야 한다.
	
	3.카드번호 생성시 0으로 시작할수 없고 전체자리수는 16자리여야
	한다.
	
	4.생성자 오버로딩 처리
		new CheckCard3(카드번호, 소유자, 잔고, 포인트);
		new CheckCard3(카드번호, 소유자, 잔고); => 포인트 0으로 초기화
		new CheckCard3(카드번호, 소유자); => 잔고, 포인트 0으로 초기화
	
	5.포인트 적립율 변경
		10만원 이하결제 : 0.1%적립
		10만원 초과결제 : 0.3%적립

*/

public class CheckCard3 {
//private로 정보은닉처리
	private long cardN;
	private String owner;
	private int balance;
	private int point;
	
	
	
	public CheckCard3() {
		if(cardNumCheck(cardN)==true) {
			this.cardN = cardN;
		}
		else {
			System.out.println("카드번호는 16자리이며 맨앞에 0이 올 수 없습니다.");
			return;
		}
	}	//기본생성자
	
	public CheckCard3(long cardN, String owner, int balance, int point) {
		if(cardNumCheck(cardN)==true) {
			this.cardN = cardN;
		}
		else {
			System.out.println("카드번호는 16자리이며 맨앞에 0이 올 수 없습니다.");
			return;/*
			생성자 메소드 내에서 return을 만나면 그 즉시 실행이 종료된다. 즉 여기서는 해당 객체는 생성이 되지만
			멤버변수가 null인 상태로 생성되게 된다.
			*/
		}
		this.cardN = cardN;
		this.owner = owner;
		this.balance = balance;
		this.point = point;
		
	}
	public CheckCard3(long cardN, String owner, int balance) {
		if(cardNumCheck(cardN)==true) {
			this.cardN = cardN;
		}
		else {
			System.out.println("카드번호는 16자리이며 맨앞에 0이 올 수 없습니다.");
			return;
		}
		this.cardN = cardN;
		this.owner = owner;
		this.balance = balance;
		this.point = 0;	//포인트는 무조건 0으로 초기화	
	}
	public CheckCard3(long cardN, String owner) {
		if(cardNumCheck(cardN)==true) {
			this.cardN = cardN;
		}
		else {
			System.out.println("카드번호는 16자리이며 맨앞에 0이 올 수 없습니다.");
			return;
		}
		this.cardN = cardN;
		this.owner = owner;
		this.balance = 0;//잔액은 무조건 0으로 초기화
		this.point = 0;//포인트는 무조건 0으로 초기화
		
	}
	
	public boolean cardNumCheck(long cardN) {
		if(cardN/1000000000000000L<1) {			
			return false;
		}		
		else {
			return true;
		}
	}
	/*카드번호의 자리수가 16자리인지 체크하는 메소드
	public boolean cardNumberRange(long cn) {
		if(cn>=1000_0000_0000_0000L && cn<=9999_9999_9999_9999L) {
			return true;
		}
		else {
			return false;
		}
	}
	*/
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
		if(amount%10000==0) {
			balance+=amount;			
			System.out.printf("[%s님 충전]%d원 완료\n", owner, amount);
			System.out.printf("[잔고]%d원 입니다.\n\n", balance);
		}
		else {
			System.out.println("충전은 만원 단위로만 가능합니다.");
		}
	}
	
	public void payment(int amount) {
		if(balance>=amount) {
			balance -=amount;			
			System.out.printf("[%s님 결제]%d원 출금 완료\n", owner, amount);
			System.out.printf("[잔고]%d원 입니다.\n\n", balance);
			savingPoint(amount);		
		}
		else {
			System.out.println("잔액이 부족하여 결제를 할 수 없습니다.");
		}
	}
	public void savingPoint(int amount) {
		int plusPoint;
		if(amount<=100000) {
			plusPoint = amount/1000;			
		}
		else {
			plusPoint = 3*amount/1000;
		}
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

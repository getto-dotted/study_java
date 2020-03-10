package ex08Class;
/*
연습문제] 은행계좌를 추상화 해보자
	멤버변수 : 예금주(name)
			계좌번호(accountNumber)
			잔고(balance)
			
	멤버메소드 : 입금하다(deposit())
	 		출금하다(withdraw())
	 		계좌잔고 출력하기(showAccount())
	
	조건1 : 입금은 무제한으로 가능함
	조건2 : 잔고가 부족할 경우에는 출금불능 처리

 계산해야 하는 변수= int
 잔고
 계산할 필요가 없는 변수 = string
 예금주/계좌번호
 
 행동의 결과
 입금하면 잔고가 증가
 출금하면 잔고가 감소(단 0까지만 감소)
 */
public class AccountMain {
	
	String name;
	String accountNumber;
	int balance;
	int money;
	
	public void deposit(int money) {
		balance += money;
		System.out.println(name + "고객님의 계좌 "+ accountNumber + "에 " + money + "원 을 입금합니다.");
		System.out.println("고객님의 잔고는 "+ balance + " 원 입니다.");
	}
	
	public void withdraw(int money) {
		balance -= money;
		if(balance<=0) {
			System.out.println(name + "고객님의 계좌 " + accountNumber + " 에서 " + (money + balance) + "원 을 출금합니다.");
			System.out.println("더이상 출금이 불가능합니다.");
			System.out.println(name + "고객님의 잔고는 0원 입니다.");
			balance=0;
		}
		else {
			System.out.println(name + "고객님의 계좌 " + accountNumber + " 에서 " + money + "원 을 출금합니다.");
			System.out.println("고객님의 잔고는 "+ balance + " 원 입니다.");
		}
	}
	
	public void showAccount() {
		System.out.println(name + "고객님의 계좌 " + accountNumber + "의 현재잔액은 "+balance+"원 입니다.");
	}
	

	public void initAccount(String _name, String _accountNumber, int _balance) {
		name = _name;
		accountNumber = _accountNumber;
		balance = _balance;
		
	}


	public static void main(String[] args) {
		
		AccountMain account1 = new AccountMain();
		account1.initAccount("홍길동", "5000", 100000);
		
		account1.deposit(5000);
		account1.withdraw(50000);
		account1.withdraw(56000);
		account1.withdraw(56000);
		account1.deposit(3000000);
		account1.withdraw(500000);
		account1.showAccount();

	}

}

package ex;

public class Account {
	private String owner;
	private String account;
	private int balance;
	
	public Account() {}
	
	public Account(String owner, String account, int balance) {
		this.owner = owner;
		this.account = account;
		this.balance = balance;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void inMoney(int balance) {
		this.balance += balance;
		System.out.println(this.balance);
	}
	
	public void outMoney(int outMoney) {
		balance -= outMoney;
		if(balance<0) {
			System.out.println("잔액이 부족합니다.");
			balance += outMoney;
		}
		else {
			System.out.println(outMoney);
		}
	}
	
	public void toString(String owner, String account, int balance) {
		System.out.println("예금주 : " + owner);
		System.out.println("계좌 : " + account);
		System.out.println("잔액 : " + balance);
	}
}

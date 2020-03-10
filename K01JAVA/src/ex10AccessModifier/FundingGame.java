package ex10AccessModifier;

import java.util.Random;

public class FundingGame {

	int rNumber = new Random().nextInt();
	int rNumber2 = new Random().nextInt();
	int rNumber3 = new Random().nextInt();
	final int INVESTMENT = 1000;
	int balance=0;
	int inCount=0;
	
	public void invest() {
		balance += INVESTMENT;
		inCount++;
		
		if(rNumber>=0) {
			balance=2*balance;
		}
		else {
			balance=balance/2;
		}
	}
	
	public void waiting() {
		
		if(rNumber2>=0) {
			balance=2*balance;
		}
		else {
			balance=balance/2;
		}	
	}
	
	public void exit() {
		System.out.printf("펀딩을 종료합니다. 현재 펀드의 금액은 %d원 입니다.\n", balance);
	}
	
	public void showCrrStat() {
		System.out.printf("고객님이 가입하신 펀드의 현재 금액은 %d원 입니다.\n고객님의 투자횟수는 총%d회 입니다.\n", 
				balance, inCount);
	}

	public static void main(String[] args) {
		
		FundingGame invester = new FundingGame();
		
		invester.invest();
		invester.exit();
		invester.showCrrStat();
		invester.waiting();
		invester.showCrrStat();
		
	}

}

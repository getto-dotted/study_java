package ex;

public class Q3 extends Account{

	public static void main(String[] args) {

		Account ac = new Account("자바맨", "123-456", 10000);
		
		ac.inMoney(15000);
		ac.outMoney(30000);
	}

}

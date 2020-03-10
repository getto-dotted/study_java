package ex08Class;


class CalculatorEx{
	public Adder adder;
	public Subtractor subtractor;
	public Multiply multiply;
	public Division division;
	
	public CalculatorEx(){
		adder = new Adder();
		subtractor = new Subtractor();
		multiply = new Multiply();
		division = new Division();
	}

	public double add(double n1, double n2) {
		return adder.add(n1, n2);
	}
	public double min(double n1, double n2) {
		return subtractor.min(n1, n2);
	}
	public double mul(double n1, double n2) {
		return multiply.mul(n1, n2);
	}
	public double div(double n1, double n2) {
		return division.div(n1, n2);
	}
	public void showOpCount() {
		System.out.println("덧셈횟수:"+ adder.getCntAdd());
		System.out.println("뺄셈횟수:"+ subtractor.getCntSub());
		System.out.println("곱셈횟수:"+ multiply.getCntMul());
		System.out.println("나눗셈횟수:"+ division.getCntDiv());
	}
	public void init() {
		int cntAdd;
		int cntSub;
		int cntMul;
		int cntDiv;
		
		cntAdd=0;
		cntSub=0;
		cntMul=0;
		cntDiv=0;
		
		
	}
	
}
	
class Adder{
	public int cntAdd;
	
	Adder(){
		cntAdd=0;
	}
	public int getCntAdd() {
		return cntAdd;
	}
	double add(double n1, double n2) {
		cntAdd++;
		return n1+n2;
	}
}	
class Subtractor{
	public int cntSub;
	
	Subtractor(){
		cntSub=0;
	}
	public int getCntSub() {
		return cntSub;
	}
	double min(double n1, double n2) {
		cntSub++;
		return n1-n2;
	}
}	
class Multiply{
	public int cntMul;
	
	Multiply(){
		cntMul=0;
	}
	public int getCntMul() {
		return cntMul;
	}
	double mul(double n1, double n2) {
		cntMul++;
		return n1*n2;
	}
}	
class Division{
	public int cntDiv;
	
	Division(){
		cntDiv=0;
	}
	public int getCntDiv() {
		return cntDiv;
	}
	double div(double n1, double n2) {
		cntDiv++;
		return n1/n2;
	}
}	


public class QuSimpleCalculator {

	public static void main(String[] args) {
		
		CalculatorEx cal = new CalculatorEx();
	    cal.init();
	    System.out.println("1 + 2 = " + cal.add(1 , 2));
	    System.out.println("10.5 - 5.5 = " + cal.min(10.5 , 5.5));
	    System.out.println("4.0 * 5.0 = " + cal.mul(4.0 , 5.0));
	    System.out.println("100 / 25 = " + cal.div(100 , 25));
	    System.out.println("10.0 * 3.0 = " + cal.mul(10.0 , 3.0));
	    cal.showOpCount();


	}

}

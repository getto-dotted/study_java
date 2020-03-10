package ex03operator;

public class ArithOperator {

	public static void main(String[] args) {
		
		
		int num1 =7;
		int num2 =3;
		
		System.out.println("덧셈:"+(num1+num2));
		System.out.println("뺄셈:"+(num1-num2));
		System.out.println("곱셈:"+(num1*num2));
		/*
		/ : 나눗셈을 한 후 몫을 구하는 연산자
		% :나눗셈을 한 후 나머지를 구하는 연산자
		 */
		System.out.println("나눗셈:"+(num1/num2));
		System.out.println("나머지:"+(num1%num2));

		int result = 3*2+5%2-6/3*5;
		System.out.println("결과는?" +result);
		

	}

}

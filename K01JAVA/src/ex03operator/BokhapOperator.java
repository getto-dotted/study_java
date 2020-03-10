package ex03operator;

public class BokhapOperator {

	public static void main(String[] args) {
		/*
		 복합대입연산자 : 산술연산자와 대입연산자를 붙여놓은 형태로 좌우측의 값을 연산하여 좌측의 변수에 대입하는 형태로 진행된다.
		 주로 누적연산을 할 떄 사용된다.
		 */
		
		
		double e=3.1;
		e+=2.1;//e=3.1+2.1=5.2
		e*=2;//e= 5.2*2=10.4
		e=e+e;//e=10.4+10.4=20.8
		System.out.println("e의 결과값:"+e);
		
		
		
		/*
		 참고] 복합대입연산자의 경우 문법의 구조상 자동형변환이 일어나지 않고 기존의 자료형을 유지한다.
		 */
		int n=5;
		//n=n*2.7; <- 에러발생됨. int형으로 casting해야한다.
		n*=2.7; //정상실행. 기존의 자료형을 유지한다.
		System.out.println("n의 결과:"+n);//13 출력됨.
		
		
		n=n*(int)2.7;
		System.out.println(n);
		

	}

}

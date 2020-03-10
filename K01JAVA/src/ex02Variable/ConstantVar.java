package ex02Variable;

public class ConstantVar {

	public static void main(String[] args) {

		/*
		 상수 : 저장된 값이 절대 변하지 않는 메모리의 한종류
		 선언방법 : final 자료형 변수명 = 초기값;
		 프로그램에서 딱 한번만 초기화되고, 중간에 값을 변경하면 에러발생됨.
		 전체를 대문자로 선언하며 연결된 단어가 있는경우 _(언더바)를 사용한다.
		 상수는 주로 코드의 가독성을 높여주기 위한 용도로 활용된다.
		 */
		
		
		final double PI = 3.14159;
		System.out.println("원주율 PI="+PI);
		
		final int SCISSOR =1;
		final int ROCK = 2;
		final int PAPER =3;
		
		
		/*
		 개발자가 가위는 1, 바위는 2, 보는 3으로 결정했다고 가정한다...
		 */
		
		int computer, user;
		
		
		
		/*
		 1, 3 은 개발자 본인만 알 수 있으므로 가독성이 떨어지는 코드임, 즉 명시적이지 않은 코드.
		 */
		computer =1;
		user=3;
		System.out.println("컴퓨터가 이겼습니다");

		/*
		 PAPER와 같은 단어는 누가 보더라도 이해할 수 있으므로 가독성이 높은 코드. 즉 명시적인 코드가 된다.
		 */
		
		
		computer =SCISSOR;
		user=PAPER;
		System.out.println("컴퓨터가 이겼습니다");
		
		/*
		 상수의 값은 한번 초기화되면 변경할 수 없다.
		 */
		//PI=3.15;
		System.out.println("PI변경후 : "+PI);
		
		
		/*
		 상수 선언후 초기화하지 않은 상태에서 출력을 시도했기 때문에 에러 발생됨.
		 */
		final String NICK_NAME;
		//System.out.println("내 별명은"+NICK_NAME);
		NICK_NAME="홍길동";
		System.out.println("내 별명은"+NICK_NAME);
		
System.out.println("나는 \"홍길동\"이다.");		
		
		
		
		
		
		
		
		
		

	}

}

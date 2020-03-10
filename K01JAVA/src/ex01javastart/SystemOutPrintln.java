package ex01javastart;

public class SystemOutPrintln {

	
	/*
	 자바 프로그램에서는 항상 main()메소드로부터 실행이 시작된다.
	 자바런처를 통해 실행하면 자동으로 호출되어 동작하게된다.
	 */
	public static void main(String[] args) {
		
		/*
		 한 문장이 끝날때는 반드시 세미콜론(;)을 기술해야 한다.
		 한글에서 마침표와 같은 역할이라 생각하면 된다.
		 */
		System.out.println(7);//정수로 인식하여 7출력
		System.out.println(3.14);//실수로 인식하여 3.14출력
		
		/*
		 문자열과 숫자(정수 or 실수) 를 연결하는 용도로 +기호가
		 사용되었다.
		 */
		System.out.println("3+5="+8);
		System.out.println(3.15+"는 실수입니다");
		
		//문자열과 문자열을 연결
		System.out.println("3+5"+"의 연산결과는 8입니다.");
		//숫자와 숫자로 인식하여 실제 덧셈연산의 결과를 출력한다.
		System.out.println(3+5);
		
		
		int num = 10;
		System.out.println("num은" + num + "입니다.");
		
		

	}

}

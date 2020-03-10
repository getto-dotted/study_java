package ex04ControlStatement;

import java.util.Scanner;

public class SwitchEx {
/*
 switch문 : if문처럼 조건에 따라 분기하는 제어문형식]
 	switch(정수식 or산술식){
 		case 값1 :
 			실행문; break;
 		case 값2 :
 			실행문 ; break;
 		default:
 				위조건에 위배될때 실행되는 문장;
 				else와 동일한 의미;
 				}
 		※switch문 내부에서 break문을 만나게 되면 실행이 중지되고 문장을 탈출하게 된다.
 */
	public static void main(String[] args) {
		
		/*
		 Scanner클래스 : JDK5.0부터 추가된 클래스로 키보드를 통해 사용자로부터 값을 입력받을때 사용한다.
		 nextInt(): 정수를 입력받음
		 nextLine() : 문자열을 입력받음
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력하세요:");
		int iNum = scanner.nextInt();
		System.out.println("입력한 숫자는:"+iNum);
			
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력하세요:");
		String iNum2 = sc.nextLine();
		System.out.println("입력한 문자는:"+iNum2);
			*/	
		
	/*
	 만약 switch 문에 break문을 쓰지 않으면 그 아래에 있는 문장들이 실해오디므로 주의해야 한다. 
	 입력받는 수가 만약 9라면 세문장 모두가 출력되게 된다.
	 */
		int remain = iNum %3;
		switch(remain) {
		case 0:
			System.out.println("나머지는 0입니다.");
			break;
		case 1:
			System.out.println("나머지는 1입니다.");
			break;
		default:
			System.out.println("나머지는 2입니다.");
		}
		
		/*
		 여러 case를 동시에 처리할때는 아래와 같이 break없이 case를 나열한다. if 구문에서의 논리 OR조건과 동일하다.
		 */
		
		
	int season = 10;
	switch(season) {
	case 4: case 5: case 6:
		System.out.println("봄입니다.");
		break;
	case 7: case 8: case 9:
		System.out.println("여름입니다.");
		break;
	case 10:
		System.out.println("가을입니다.");
		break;
	default:
		System.out.println("겨울입니다.");
	}
		
	
	String str ="오라클";
	switch(str) {
	case "자바":
			System.out.println("자바 좋아요");
			break;
	case"오라클":
		System.out.println("오라클 좋아요");
	}
		
	/*
	 switch문을 사용할때 주의할점
	 1.  long타입의 변수는 사용불가
	 	:byte/short/int/char/String형만 사용가능
	 */
	
	
	
	
		/*
		long lng =10;
		switch(lng) {
		case 10:
			System.out.println("long타입 변수는?");
			break;
		case 20:
			System.out.println("사용이 안되는군...");
		}
		
		/*
		 2. 비교식이나 논리식은 사용할 수 없음.
		 */
		/*
		switch(iNum%3 ==0)  {
		System.out.println("논리식도 사용이 안됨");
		}
		
		*/
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

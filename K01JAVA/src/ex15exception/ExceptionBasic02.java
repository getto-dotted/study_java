package ex15exception;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
2]런타임에러
		-컴파일시에는 체크가 안되고 실행시에만 발생되는 에러
		-RuntimeException클래스 계열로 NullPointerException이 대표적인
		하위클래스이다.
		-main메소드에서 무시하기 위해 throws하더라도 오류가 발생되므로
		반드시 예외처리를 해야한다.
		-예외발생시 JVM은 해당 예외클래스를 객체화해서 프로그램쪽으로 전달하게 된다.
 */


public class ExceptionBasic02 {

	//참조변수로 선언만 하고 객체생성은 되지 않은 상태
	//아래 NullPointerException에서 테스트함.
	static Date toDay; //=new Date();
	//주석처리된 new 부분을 해제하면 예외발생x
	
	public static void main(String[] args) {
	
		// 2-1] ArrayIndexOutOfBoundsException
		//		:배열의 크기를 벗어난 인덱스를 사용할 경우 발생되는 예외

		int[] intArr = new int [2];//배열의 크기는2
		
		try {
			intArr[0] = 100;
			System.out.println("0번방은:"+intArr[0]);
			intArr[1] =200;
			System.out.println("1번방은:"+intArr[1]);
			intArr[2] =300; //<-예외발생지점
			//위에서 예외가 발생하므로 아래 문장은 실행되지 않음. ↓↓↓↓
			System.out.println("앗~이방은?"+intArr[2]);					
		}
		catch(ArrayIndexOutOfBoundsException e) {
			//try문에서 발생된 예외를 JVM이 객체화하여 catch쪽으로 전달하면 해당 예외객체를 받아서 적절하게 예외처리한다.
			System.out.println("예외가 발생했어요");
			System.out.println("예외메세지:"+e.getMessage());
			e.printStackTrace();
			//getMessage() : 예외에 대한 간략한 메세지만 표시
			//printStackTrace() : 예외가 발생할때의 에러메세지를 그대로 화면에 출력해줌. 개발시 훨씬 더 사용빈도가 높음.
		}
		System.out.println("0번방 재출력:"+intArr[0]);
		System.out.println("==ArrayIndexOutOfBoundsException발생후==");
		//2-2] NumberFormatException
		//		: 숫자형식이 아닌 문자열을 int로 변환하는 경우 발생하는 예외
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("나이를 입력하세요:");
			String strAge = sc.nextLine(); //<-10살 형태로 입력
			int ageAfter10 = Integer.parseInt(strAge)+10; //<-예외발생
			System.out.println("당신의 10년후 나이는:"+ageAfter10);
			
		}
		catch(NumberFormatException e) {
			System.out.println("나이는 숫자로만 입력해야 합니다.");
			System.out.println("예외메세지:"+e.getMessage());
			e.printStackTrace();
		}
		//2-3] InputMismatchException
		
		try {
			System.out.println("나이를 입력하세요:");
			int intAge = sc.nextInt();//<-문자를 입력하면 예외발생
			int ageAfter10 = intAge+10;
			System.out.println("당신의 10년후 나이는:"+ageAfter10);
			
		}
		catch(InputMismatchException e) {
			System.out.println("나이를 문자형태로 입력하면 안되요.");
			System.out.println("예외메세지:"+e.getMessage());
			e.printStackTrace();
		}
		
		//2-4]NullPointerException
//				:참조변수가 참조할 객체가 없는 상태에서 멤버를 호출할때 발생되는 예외이다. 
//				참조변수가 null값을 가지게 되면 참조할 객체가 없다는 뜻이므로 반드시 객체생성후 멤버를 호출해야 한다.
		System.out.println("toDay="+toDay);
		try {
			//예외발생 지점을 try밖으로 옮기면 예외발생 즉시 실행이 중지된다.
			System.out.println(toDay.getTime());
		}
		catch(NullPointerException e) {
			System.out.println("toDay 참조변수는 null입니다.");
			System.out.println("예외메세지:"+e.getMessage());
		}
		
		/*
		※빈문자열과 null값의 차이
		"" : 빈문자열로 null이 아니다. String객체는 생성되었으나 값이 없는 상태를 말한다.
		null : 객체자체가 생성되지 않은 상태를 말한다.
		 */
		
		String emptyString = "";
		System.out.println("emptyString의 문자열길이:"+emptyString.length());
		String nullString = null;
		
		try {
			System.out.println("nullString의 문자열길이:"+nullString.length());
		}
		catch(NullPointerException e) {
			System.out.println("nullString은 null입니다.");
			System.out.println(e.getMessage());
		}
		
		//2-5] ArithmeticException
//				: 수학적 계산이 불가능한 경우 발생되는 예외
		
		int result = 10;
		try {
			result = result /0;
			System.out.println("결과는 : "+result);
			
		}
		catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
			System.out.println("예외메세지:"+e.getMessage());
		}
		//2-6]ClassCastException
//				: 객체의 형변환이 불가능한 경우 발생되는 예외
		
		Object object = new Object();
		try {
//			Object클래스 자체를 다른 타입으로 형변환 할 수 없다.
		
			String strObject = (String)object;
		}
		catch(ClassCastException e) {
			System.out.println("형변환 할 수 없습니다.");
			System.out.println(e);
			System.out.println(e.getMessage());
			e.printStackTrace();//<-개발시 가장 많이 사용함
		}
		System.out.println("==ClassCastException발생후==");
		
//		Object클래스의 String클래스간의 형변환을 확인하기 위한 참조코드
		String str= "형변환되나요?";
		boolean castFlag= myClassCast(str);
		if(castFlag==true) {
			System.out.println("됩니다용.");
		}
		else {
			System.out.println("안됩니다용");
		}
	}
	//매개변수로 전달된 String객체를 Object클래스로 받으므로 둘 사이에 상속관계가 확인된다.
//	(자동형변환 됨)
	public static boolean myClassCast(Object str) {
		if(str instanceof String) {
			return true;
		}
		else {
			return false;
		}
	}
}

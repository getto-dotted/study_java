package review;

import java.util.Scanner;

/*
static으로 선언된 변수/메소드는 컴파일러에 의해 프로그램이 시작될때
미리 초기화되어 메소드영역에 로드된다.
로드된 static 변수/메소드는 객체생성없이 클래스명만으로 접근이 가능하다.
new연산자를 통해 새로운 객체를 계속 생성하지 않고, 하나의 객체를
프로그램 전체에서 공유하는 공유메모리 역할을 하게된다. */
class AddClass{
	public static Scanner scan = new Scanner(System.in);
	
	public void inputNum() {
		int num2=scan.nextInt();
		System.out.println("입력받은 정수는: "+num2);
	}
}

public class R07static {

	private String name;
	
	public R07static() {
		System.out.println("나는 기본생성자");
	}
	public R07static(String n) {
		name = n;
		System.out.println("나는 인자생성자");
	}
	void showName() {
		System.out.println("나는 "+ name +" 이다.");
	}	
	
	public static void main(String[] args) {
		/*
		main함수는 static으로 선언되어 있으므로 해당 함수를
		포함한 클래스의 객체를 선언할 수 있다.
		 */
		System.out.println("===첫번째 객체생성===");
		R07static stat1 = new R07static();
		stat1.name = "신도림2번출구";
		stat1.showName();
		
		System.out.println("===두번째 객체생성===");
		new R07static("한.직.전").showName();	/*
		정적멤버로 선언된 Scanner 객체를 프로그램 전체에서
		객체생성없이 사용이 가능하다.	
		Scanner scan = new Scanner(System.in);*/
		System.out.println("===main클래스에서 입력받기===");
		int num1 = AddClass.scan.nextInt();
		System.out.println("입력한 정수는: "+num1);
		
		System.out.println("===AddClass클래스에서 입력받기===");
		new AddClass().inputNum();	
	}

}

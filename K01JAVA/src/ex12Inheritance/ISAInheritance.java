package ex12Inheritance;

/*
IS-A 관계 : X is a Y => X는 Y의 일종이다로 표현가능
	노트북은 컴퓨터의 일종이다 
	와 같이 IS-A관계가 성립하는 것을 상속으로 표현하기에 적합하다.	
 */
//컴퓨터 : 기본적인 컴퓨팅 환경을 제공한다.
class Computer{
	//멤버변수
	String owner;
	//생성자
	public Computer(String name) {
		owner = name;
	}
	//멤버메소드
	private void keyboardTouch() {
		System.out.println("키보드를 통해서 입력한다.");
	}
	private void calculate() {
		System.out.println("요청된 내용을 계산한다.");
	}
	public void calculateFunc() {
		/*
		필요한 메소드를 캡슐화하여 순서까지 정하여 정의함.
		 */
		keyboardTouch();
		calculate();
	}
	/*
	private접근지정자로 선언된 멤버메소드는 외브클래스 혹은
	상속받은 클래스에서 접근이 불가능하므로 public으로 선언된
	멤버메소드를 통해 간접적으로 호출한다. 상속관계이므로 protected로
	선언된 메소드로 호출할 수도 있다.
	 */
}
class NoteBookComputer extends Computer{
	int battary;
	public NoteBookComputer(String name, int initCharge) {
		/*
		부모클래스의 생성자호출을 위한 super()는 생략은 가능하지만,
		다른 문장이 먼저 기술되면 오류가 발생되므로 주의해야 한다.
		 */
		super(name);
		battary = initCharge;
	}
	public void charging() {
		battary +=5;
	}
	public void movigCal() {
		//배터리 양을 체크한후 사용여부를 판단
		if(battary<1) {
			System.out.println("배터리가 방전되어 사용불가");
			return;
		}
		System.out.println("이동하면서 ");
		
		//캡슐화된 메소드를 통해 기능수행
		calculateFunc();
		battary -= 1;
	}
}
class TabletNotebook extends NoteBookComputer{
	
	//태블릿을 사용하기위한 펜슬(등록된 것만 사용가능함)
	String registPencil; //ISE-1234
	public TabletNotebook(String name, int initCharge, String pen) {
		super(name, initCharge);
		registPencil = pen;
	}
	public void write(String penInfo) {
		if(battary<1) {
			System.out.println("배터리가 방전되어 사용불가");
			return;
		}
		
		/*
		A. compareTo(B)
			:문자열 A와 B를 비교하여 동일한 문자열이면 0, 
			다른 문자열이면 1 혹은 -1을 반환한다.
			사전순으로 문자열을 비교하는 메소드이다.
		 */
		if(registPencil.compareTo(penInfo)!=0) {
			System.out.println("등록된 펜이 아닙니다.");
			return;
		}
		
		movigCal();
		System.out.println("스크린에 펜으로 그림을 그린다.");
		battary -=1;
	}
}
public class ISAInheritance {

	public static void main(String[] args) {
		NoteBookComputer noteBook = new NoteBookComputer("공유", 5);
		TabletNotebook tablet = new TabletNotebook("이동욱", 5, "ISE-1234");
		
		System.out.println("==노트북컴퓨터사용==");
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();//사용불가처리
		noteBook.movigCal();
		noteBook.movigCal();
		
		System.out.println("==ISE-1234펜으로 테블릿 사용==");
		tablet.write("ISE-1234");//정상사용

		System.out.println("==XYZ-9876펜으로 테블릿 사용==");
		tablet.write("XYZ-9876");//등록된 펜이 아닙니다. 사용불가
	}

}

package ex12Inheritance;
/*
상속(Inheritance)
	: 기존에 정의된 클래스에 메소드와 변수를 추가하여 새로운 클래스를 정의하는 것을 말한다.
	부모 클래스를 자식 클래스가 상속할때는 extends 키워드를 사용한다.
 */
//부모클래스 : 사람의 일반적인 형태를 표현
class Man{
	//멤버변수
	private String name;
	//기본생성자
	public Man() {
		
		//만약 자식클래스에서 super()를 통해 매개변수를 전달하지 않는다면 초기화가 되지 않아서 이름이 null로 출력될 수 있다.
		System.out.println("Man클래스 디폴트 생성자 호출됨");
	}
	//인자생성자
	public Man(String name) {
		this.name = name;
		System.out.println("Man 클래스 인자 생성자 호출됨");
	}
	//멤버메소드
	public void tellYourName() {
		System.out.println("내 이름은 "+name+" 입니다.");
	}
}
//자식클래스 : Man클래스를 상속받은 회사원 클래스
class BusinessMan extends Man{
	//멤버변수
	private String company;
	private String position;
	
	//생성자메소드
	public BusinessMan(String name, String compny, String positoin) {
		/*
		상속받은 하위클래스에서는 부모클래스의 생성자를 호출하여 부모객체가 먼저 생성되도록 해야하는 책임을 가지고 있다.
		super()는 부모클래스의 생성자를 호출하는 역할을 한다.
		만약 기술하지 않으면 디폴트 생성자가 호출되게 된다.
		 */
		super(name);//부모클래스의 매개변수 1개인생성자 호출 
		this.company = compny;
		this.position = positoin;
		System.out.println("BusinessMan 생성자 호출");
	}
	public void tellYourInfo() {
		System.out.println("회사명은 "+company+" 입니다.");
		System.out.println("직급은 "+position+" 입니다.");
		/*
		부모클래스를 상속받았으므로 자식클래스에서 부모클래스의 메소드를 호출하는 것이 가능하다.
		 ↓↓↓↓↓*/
		tellYourName();
		System.out.println("===================");
	}
}

public class BusinessManMain {

	public static void main(String[] args) {
		
		
		BusinessMan man1 = new BusinessMan("홍길동", "Naver", "팀장");
		BusinessMan man2 = new BusinessMan("고길동", "Daum", "부장");
		
		
		
		man1.tellYourInfo();
		man1.tellYourName();
		
		man2.tellYourInfo();
		man2.tellYourName();

	}

}

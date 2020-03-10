package ex17innerClass;
/*
익명클래스(Anonymous Class)
-이름이 없는 클래스를 말한다.
-내부클래스처럼 이벤트 기반 프로그램에서 많이 사용된다.
-부모클래스의 메소드를 오버라이딩 하는 것이 주된 목적이다.
-클래스를 정의하는 형태가 메소드를 정의하는 것과 비슷하다.

형식]
	부모클래스명 객체명 = new 부모클래스명(){
		클래스의 실행부;
		부모클래스의 메소드 오버라이딩;
	};
	-> 새로운 객체를 생성하는 형태이므로 문장의 끝에 ; 을 붙여줘야 한다.
 */
class Person{
	String name;
	public Person(String n) {
		name = n;
	}
	void printInfo() {
		System.out.println(String.format("이름:%s", name));
	}
}
class Student extends Person{
	String stNumber;
	public Student(String n, String stNum) {
		super(n);
		stNum = stNum;
	}
	String getInfo() {
		//문자열 서식에 맞춰서 반환해주는 메소드
		return String.format("학번:%s", stNumber);
	}
	@Override
	void printInfo() {
		super.printInfo();
		System.out.println(getInfo());
	}
}

//추상클래스
abstract class AbstractClass{
	abstract void abstractMethod();
}
//인터페이스
interface InterFace{
	void abstractMethod();
}

public class AnonymousClass {

	public static void main(String[] args) {

		//이름이 있는 자식클래스의 일반적인 참조형태
		Person person = new Student("김탁구", "2016");
		person.printInfo();
		
		//Person타입으로 Student객체를 접근하기 위해서는 반드시 다운캐스팅 진행후 접근해야 한다.
		//person.stNumber = "2015"; -> 오류발생
		((Student)person).stNumber = "2015";
		System.out.println(((Student)person).getInfo());
		
		/*
		Person클래스를 상속받은 익명클래스 정의
		: Person타입의 객체변수에 Person을 상속받은 익명객체를 생성하여 그 참조값을 할당한 형태이다.
		
		new Person(){}; => 익명 extends Person과 같은 형태라 생각하면 된다.
		
		이름이 없기 때문에 부모클래스의 이름을 빌려서 객체를 생성했다고 생각하면 된다.
		 */
		Person anonyPerson = new Person("홍두깨") {
			int newVar;
			void newMethod() {
				System.out.println("익명클래스에서 새롭게 확장한 메소드");
			}
			//오버라이딩하여 재정의
			@Override
			void printInfo() {
				System.out.println("newVar="+newVar);
				newMethod();
				System.out.println("익명클래스에서 오버라이딩");
			}
		};
		//익명클래스에서 오버라이딩 했으므로 호출가능함
		anonyPerson.printInfo();
		//익명클래스에서 확장한 메소드이므로 접근불가함.
//		anonyPerson.newMethod();//[접근불가-에러발생]
		
		Student anonyStudent = new Student("김두한", "2017") {
			int age=1;
			@Override
			String getInfo() {
				return super.getInfo()+", 나이:"+age;
			}
			@Override
			void printInfo() {
				System.out.println("이름:"+name+","+getInfo());
			}
		};
		System.out.println("[Student클래스를 상속받은 익명클래스]");
		anonyStudent.printInfo();
//		anonyStudent.age = 100;//접근불가-에러발생
//		((Student)anonyStudent).age = 100;//다운캐스팅 불가 - 에러발생
		/*
		다운캐스팅은 "(자식클래스명)부모타입의 객체" 형태로 형변환하여 하위클래스의
		멤버에 접근하기 위한 수단이다.
		그러나 익명클래스는 이름이 없기 때문에 다운캐스팅 자체가 불가능하다.
		즉 익명클래스에서는 새롭게 정의한 멤버에 접근할 수 없다.
		따라서 익명클래스는 오버라이딩의 목적으로만 사용해야 한다.
		 */
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

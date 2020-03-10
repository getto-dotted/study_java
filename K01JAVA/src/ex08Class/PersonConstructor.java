package ex08Class;
/*
생성자(Constructor)
	- 클래스를 객체화할때 자동으로 호출되는 메소드
	- 자동으로 호출되며 개발자가 임의로 호출할 수 없다.
	- 반환값이 없다. 즉 특정 연산후 반환을 할 수 없고 void와 같은 키워드를 붙일 수 없다.
	- 클래스명과 동일한 이름을 가진다.
	- 그외는 메소드가 가진 모든 기능을 가지고 있따.(매개변수전달, 오버로딩 등)
	
	
생성자 내에서 this의 사용법
1. 동일 클래스 내에서 다른 생성자를 호출할때
	사용법:
		this(매개변수1, 매개변수2, ....);
	단, 생성자 내에서만 호출이 가능하다.
		
		
		
2. 멤버변수와 매개변수를 구분할 때
	this.변수명  => 해당 클래스의 멤버변수를 가리킴
	변수명 => 매개변수 혹은 일반적인 변수를 가리킴
	단, 멤버변수와 매개변수의 이름이 다르다면 this를 생략해도 무방하다.
	명시적인 코드를 위해 사용된다.
 
 */
public class PersonConstructor {

	//멤버변수
	String name;
	int age;
	String addr;
	
	/*
	만약 클래스를 생성할때 아래와 같이 생성자를 정의하지 않으면
	디폴트 생성자가 컴파일러에 의해 자동으로 생성되게 된다.
	
	public PersonConstructor(){}
	
	디폴트 생성자는 매개변수도 없고 실행부도 없는 형태로 정의된다.
	단, 만약 생성자를 하나라도 정의하게 되면 디폴트 생성자는 생성되지 않으므로 주의해야 한다.
	 */
		
	
	//생성자1 : 기본생성자
	public PersonConstructor() {
		name = "이름없음";
		age = 1;
		addr= "미상";
		System.out.println("나는 기본생성자 입니다.");
	}
	
	
	//생성자2 : 인자생성자
	public PersonConstructor(String name) {
		this.name = name;
		age =1;
		addr = "출처불명";
	}
	public PersonConstructor(String name, int age) {
		/*
		 해당 생성자내에서 매개변수가 3개인 다른 생성자를 호출한다.
		 */
		this(name, age, "미상");
		System.out.println("나는 인자생성자[2]입니다.");
	}
	public PersonConstructor(String _name, int age, String addr) {
		name = _name;
		this.age = age;
		this.addr = addr;
		System.out.println("나는 인자생성자[3]입니다");
	}
		
	public PersonConstructor(String _name, String addr) {
			this.name = _name;
			this.addr = addr;
			System.out.println("나는 인자생성자 [4]입니다");
	}
	void initialize(String name, int age, String addr) {
		/*
		
		this()는 생성자 내에서만 사용이 가능하다. initialize()는
		생성자 메소드가 아니므로 아래 코드는 에러가 발생된다.
		
		this(name, age, "미상");
		*/
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	//정보출력용 메소드
	void showPersonInfo() {
		System.out.printf("%s 님의 정보\n", this.name);
		System.out.printf("나이:%d\n", age);
		System.out.printf("주소:%s\n", addr);
	}
	
	
}

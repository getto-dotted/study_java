package ex08Class;

class Car{
	
	/*
	 멤버상수 선언
	 ※static으로 선언된 변수(or 상수)는 메소드영역에 미리 생성되어 프로그램내에서 언제든 접근할 수 있다.
	 */
	public static final String AUTO ="자동";
	public static final String MANUAL ="수동";
	
	/*
	 멤버변수 선언
	 */
	
	String carGear = AUTO;
	String carModel;
	int carYear;
	Human owner;
	/*
	소유주를 표현 : Human클래스를 기반으로 하는 멤버변수로 이름, 나이, 에너지 세가지 값을 필요로 한다.
	 */
	
	//멤버 메소드 정의
	void drive() {
		/*
		Car클래스의 멤버변수로 Human객체가 선언되었으므로 출력할때는 .(닷)연산자를 이용해서 name변수에 접근한다.
		 */
		System.out.println(owner.name+"이(가) " + carModel+"을 운전한다.");
	}
	/*
	객체의 초기화를 담당하는 메소드로 아래는 항상 동일한 값으로만 초기화 된다는 단점을 가지고 있다.
	 */
	void initialize() {
		carModel = "람보르기니";
		carYear = 2017;
		owner = new Human();
		owner.name = "캡틴 로져스";
		owner.age = 30;
		owner.energy =10;
	}
	
	/*
	 위와 동일한 이름으로 오버로딩에 의해 정의된 메소드로 다양한 매개변수를 통해
	 초기화 하는 것이 가능하다.
	 */
	
	void initialize(String model, int year, String name, int age, int energy) {
		carModel = model;
		carYear = year;
		owner = new Human();
		owner.name = name;
		owner.age = age;
		owner.energy = energy;
		
	}
	
	void showCarInfo() {
		System.out.println("[차량정보]");
		System.out.printf("모델명:%s\n", carModel);
		System.out.printf("연식:%d\n", carYear);
		System.out.printf("기어:%s\n", carGear);
		owner.showState();
	}
	
	
}//end of Car Class

public class CarMain {

	public static void main(String[] args) {
		
		//자동차1 객체 생성
		
		Car car1 = new Car();
		System.out.println("[초기화메소드 호출전]");
		System.out.println("car1.owner="+car1.owner);
		/*
		객체생성후 초기화 하지 않은 상태에서 출력을 시도해서
		NullPointerException 발생됨
		car1.drive(); <--에러발생
		 */
		
		System.out.println("[초기화메소드 호출후]");
		car1.initialize();//고정된 내용으로 초기화
		car1.drive();
		car1.showCarInfo();//객체의 내용 출력
		
		//자동차2 객체 생성 : 각 멤버변수에 접근후 초기화
		Car car2 = new Car();
		car2.carGear = Car.MANUAL;
		car2.carModel = "밴틀리";
		car2.carYear = 2018;
		car2.owner = new Human();
		car2.owner.name = "토니스타크";
		car2.owner.age = 52;
		car2.owner.energy = 8;
		
		System.out.println("자동차 정보와 소유자 정보 같이보기");
		car2.showCarInfo();
		
		//세번째 자동차 객체생성 : 매개변수가 있는 초기화
		// 메소드를 이용하여 객체 초기화. 가장 효율적임.
		Car car3 = new Car();
		car3.initialize("스포츠카", 2012, "성유겸", 8, 10);
		car3.showCarInfo();//객체 정보출력

	}

}

package review.mycar;
/*
자동차를 표현하는 클래스
	1.기본속성(멤버변수)
		차주, 차량번호, 속도, 연료 
	 
	2.멤버변수 초기화(생성자)  : 기본/인자생성자
	  
	3.기능(멤버메소드)
	  	브레이크 : 속도가 -20줄어든다. 연료소모는 없다.
	  	엑셀레이터 : 속도가 +20증가한다. 연료소모는 -20
	  	주유(연료보충) : 전달된 매개변수만큼 보충함.
	4.제한조건(연습문제)
	   속도 : 0~200km/h 즉 음수가 될수없고, 200을 초과할수 없음
	   연료 : 0~100ℓ
	   
	   -멤버메소드 주유, 브레이크, 엑셀에 제한조건을 충족할수
	   있는 조건식을 삽입하시오.
 */

public class Car {

	private String owner;
	private String carNumber;
	private int speed;
	private int fuel;
	
	//멤버상수 : 제약조건은 상수로 선언하는 것이 좋다.
	final int MAX_FUEL = 100;
	final int MAX_SPEED = 200;
	//기본/인자생성자
	public Car() {}
	public Car(String name, String cNumber, int spee, int fu) {
		this.owner = name;
		this.carNumber = cNumber;
		this.speed = spee;
		this.fuel = fu;
	}
	//getter/setter
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	
	public void refueling(int amount) {
		fuel+=amount;
		if(fuel>MAX_FUEL) {
			System.out.println("기름통 터져욧");
			fuel = MAX_FUEL;
		}
		else {
			System.out.println("휘발유 "+amount+"리터 주유완료");
		}		
	}
	public void breaking() {
		speed-=20;		
		if(speed<0) {
			System.out.println("속도는 음수가 될 수 없습니다.");
			speed=0;
			System.out.println("브레이크: 속도 0Km/h");
		}
		else {
			System.out.println("브레이크: 속도 20Km/h 감소");
		}
	}
	public void accelerator() {
		if(fuel<=0) {
			System.out.println("기름이 앵꼬입니다");
			speed=0;
			return;
		}
		else {
			speed+=20;
			fuel-=20;
			System.out.println("엑셀레이터 : 속도 20Km/h증가");
			
			if(fuel<0) {
				System.out.println("기름이 부족합니다");
				speed=0;
				fuel =0;
				return;
			}
			if(speed>MAX_SPEED) {
				System.out.println("이미 최대속도입니다");
				speed = MAX_SPEED;
			}
			System.out.println("연료 20L 감소");
		}
	}
	
	public void showCarInfo() {
		System.out.println("===============");
		System.out.println("차주 : "+owner);
		System.out.println("차번 : "+carNumber);
		System.out.println("속도 : "+speed);
		System.out.println("연료 : "+fuel);
		System.out.println("===============");
	}

	
	
	
	
	
	
	
	
	
	
	
}//Car끝

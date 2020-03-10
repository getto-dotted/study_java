package review;

import review.mycar.Car;
import review.mycar.SportsCar;
import review.mycar.SUV;

public class R06MyCarInheritance {

	public static void main(String[] args) {
		
		Car car1 = new Car("정우성", "12가9876", 190, 50);
		car1.accelerator();
		for(int i=1; i<=20; i++) {
			car1.accelerator();
		}
		car1.breaking();
		for(int i=1; i<=20; i++) {
			car1.breaking();
		}
		car1.refueling(200);
		car1.showCarInfo();
		System.out.println("===================");
		
		//스포츠카 객체생성 : 차량용품 없음
		SportsCar sCar1 = new SportsCar("부가티", "차승원", "01 가 1234", 0, 50);
//		sCar1.fuel = 300; -> private멤버
		sCar1.setFuel(300);
		sCar1.showSportsCarInfo();
		
		//스포츠카 객체생성 : 네비+블랙박스
		SportsCar sCar2 = new SportsCar("카마로", "범블비", "02나5678", 0, 0, "만도", "8Gb");
		sCar2.showSportsCarInfo();
		
		//SUV+네비
		SUV suvCar2 = new SUV("스포티지", "메가트론", "03다9876", 0, 0, "카카오네비", "");
		suvCar2.showSUVInfo();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//메인끝
}

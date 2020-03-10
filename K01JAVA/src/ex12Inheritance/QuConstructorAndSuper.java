package ex12Inheritance;

	class Car
	{
	       	int gasoline;
	       	public Car(int _gasoline){
	       		//멤버변수 gasoline을 초기화
	       		//최상위 클래스이므로 super없이 멤버변수만 초기화
	       		gasoline = _gasoline;
	       		System.out.println("Car클래스 생성자");
  
	       	}
	   	public void showNow() {
	   		System.out.println("Car클래스");
	   	}
	}
	class HybridCar extends Car
	{
	       	int electric;
	       	public HybridCar(int _gasoline, int electric) {
	       		//멤버변수 electric를 초기화, 나머지 1개는 부모에게 전달
	       		super(_gasoline);
	       		this.electric = electric;
		   		System.out.println("HybridCar클래스 생성자");
	       	}
		public void showNow() {
	   		System.out.println("HybridCar클래스");
	   	}
	       	
	}
	class HybridWaterCar extends HybridCar
	{
	       	int water;
	       	public HybridWaterCar(int _gasoline, int electric, int water) {
	       		//멤버변수 water 초기화, 나머지 2개는 부모에게 전달
	       		super(_gasoline, electric);
	       		this.water = water;
	       		System.out.println("HybridWaterCar클래스 생성자");
	       	}
	       	public void showNow() {
		   		System.out.println("HybridWaterCar클래스");
		   	}
	       	public void showNowGauge()
	       	{
	                 	System.out.println("남은가솔린:"+gasoline);
	                 	System.out.println("남은전기량:"+electric);
	                 	System.out.println("남은워터량:"+water);
	       	}
	}

public class QuConstructorAndSuper {

	public static void main(String[] args) {
		HybridWaterCar hcar = new HybridWaterCar (10,20,30);
		hcar.showNowGauge();
		hcar.showNow();


	}

}

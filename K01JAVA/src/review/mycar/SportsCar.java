package review.mycar;

public class SportsCar extends Car {
	//멤버변수
	String carName;
	
	//네비게이션, 블랙박스 장착
	Navigation navi;
	BlackBox box;
	//생성자
	public SportsCar(String carName, String o, String n, int s, int f) {
		//부모클래스의 생성자 호출
		super(o,n,s,f);
		//해당 클래스의 멤버변수 초기화
		this.carName=carName;
	}
	//네비, 블랙박스 추가로 생성자 추가정의됨
	public SportsCar(String carName, String o, String n, int s, int f, String nProduct, String bCapacity) {
		super(o,n,s,f);
		this.carName=carName;
		
		if(!nProduct.equals("")) {
			navi = new Navigation(nProduct);
		}
		if(!bCapacity.equals("")) {
			box = new BlackBox(bCapacity);
		}
	}
	//멤버메소드
	public void showSportsCarInfo() {
	//자신의 정보출력
		super.showCarInfo();
		System.out.println("스포츠카명 : "+carName);
		if(navi==null) {
			System.out.println("Navigation이 없습니다.");
		}
		else {
			navi.showNaviInfo();
		}
		if(box==null) {
			System.out.println("BlackBox가 없습니다.");
		}
		else {
			box.showBoxInfo();
		}
	}
}

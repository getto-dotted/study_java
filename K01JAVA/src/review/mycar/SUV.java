package review.mycar;

public class SUV extends Car {

	//멤버변수
	String suvName;
	
	//네비게이션 장착, 블랙박스 X
	Navigation navi;
	BlackBox box;
	//생성자
	public SUV(String suvName, String o, String n, int s, int f) {
		//부모클래스의 생성자 호출
		super(o,n,s,f);
		//해당 클래스의 멤버변수 초기화
		this.suvName=suvName;
	}
	//네비, 블랙박스 추가로 생성자 추가정의됨
	public SUV(String suvName, String o, String n, int s, int f, String nProduct, String bCapacity) {
		super(o,n,s,f);
		this.suvName=suvName;
		
		if(!nProduct.equals("")) {
			navi = new Navigation(nProduct);
		}
		if(!bCapacity.equals("")) {
			box = new BlackBox(bCapacity);
		}
	}
	//멤버메소드
	public void showSUVInfo() {
	//자신의 정보출력
		super.showCarInfo();
		System.out.println("SUV명 : "+suvName);
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

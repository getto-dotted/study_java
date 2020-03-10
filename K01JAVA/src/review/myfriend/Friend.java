package review.myfriend;

public abstract class Friend {
	public String name;	//이름
	public String phone;	//전화번호
	public String addr;	//주소
	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	/*
	만약 클래스가 한개 이상의 abstract 메소드를 포함하게 된다면
	해당 클래스도 반드시 abstract 로 선언해야 한다. 
	
	아래와 같이 추상메소드의 경우는 함수의 몸체(실행부)가 없다.
	오버라이딩의 목적으로만 생성하는 경우에 주로 사용한다. 
	 */
	public abstract void showBasicInfo();
}
package common;

public class Student extends Person{
	//확장한 멤버변수
	private String stNumber;//학번
	
	public Student(String name, int age, String stNumber) {
		//부모클래스의 생성자 호출
		super(name, age);
		this.stNumber = stNumber;
	}
	@Override
	public String getInfo() {
		//부모클래스의 멤버메소드 호출
		return super.getInfo()+", 학번:"+stNumber;
	}
	@Override
	public void showInfo() {
		System.out.println("학생의 정보");
		System.out.println(getInfo());
	}
}

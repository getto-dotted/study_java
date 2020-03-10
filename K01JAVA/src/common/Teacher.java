package common;

public class Teacher extends Person{
	//선생에서 확장한 멤버변수
	private String subject;//
	
	public Teacher(String n, int a, String s) {
		//부모클래스의 생성자 호출
		super(n, a);
		this.subject = s;
	}
	@Override
	public String getInfo() {
		//부모클래스의 멤버메소드 호출
		return String.format("%s, 과목:%s", super.getInfo(), subject);
		}
	@Override
	public void showInfo() {
		System.out.println(getInfo());
	}
}

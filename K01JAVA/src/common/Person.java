package common;

public class Person {
	//멤버변수
	private String name;//이름
	private int age;//나이
	public Person() {
	}//기본생성자, 인자생성자
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	//멤버메소드
	public String getInfo() {
		return String.format("이름:%s, 나이:%d", name, age);
	}
	public void showInfo() {
		System.out.println(getInfo());
	}
	
	//getter/setter메소드 정의
	
	
	public static void main(String[] args) {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
		
		
	}
//	이클립스의 자동생성 메뉴로 구현한코드
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + age;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Person other = (Person) obj;
//		if (age != other.age)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
//	
//	hashCode()
//			: Object클래스에 정의된 메소드로 두 객체가 동일한 객체인지 동일성을 비교한다. 
//			또한 Set컬렉션과 같이 사용될때는 컬렉션에 객체를 추가할 때마다 이미 저장된 객체와
//			비교를 위해 자동으로 호출된다.
	@Override
	public int hashCode() {
		return age%3;
	}
	/*
	equals()
		: 두개의 객체가 동일한 값을 가지고 있는지 비교할때 사용되는 메소드.
	 */
	@Override
	public boolean equals(Object obj) {
			Person comparePerson = (Person)obj;
			System.out.println("오버라이딩한 equals()호출"+name);
			/*
			※같은 값을 가졌을땐 true, 다른 값을 가졌을땐 false를 반환한다.(중요)
			 */
			if(comparePerson.age==this.age && comparePerson.name.equals(this.name)) {
				return true;
			}
			else {
				return false;
			}
	}
	
	
	
	
	
	

}

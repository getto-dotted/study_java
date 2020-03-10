package ex08Class;
/*
추상화 : 현실세계의 사물을 클래스로 형상화 하는 것을 추상화 라고 한다.
	Person 클래스는 "사람"의 일반적인 사항을 추상화 하고 있다.

 */

class Person{
	/*
	 멤버변수 : 클래스의 속성값(데이터)을 표현한다.
	 	해당 클래스내에 정의된 멤버메소드에서 별다른 선언 혹은 전달없이 직접 접근이 가능하다.
	 */
	
	String name = "정우성";
	int age =47;
	String gender = "남자";
	String job="영화배우";
	
	/*
	멤버 메소드: 클래스에서 객체의 동작(행위)를 표현한다.
		클래스 외부에서 호출할 때는 객체의 참조변수를 통해서 호출해야 한다.
	 */
	void eat() {
		System.out.printf("%s가(이) 식사를 한다\n", name);
	}
	void sleep() {
		System.out.printf("나이가 %d인 %s가(이) 잠자고 있다.\n", age, name);
	}
}

public class PersonMain {

	public static void main(String[] args) {
		//Person클래스의 객체를 생성한다.
		Person person = new Person();
		
		//객체의 참조변수를 통해서 멤버메소드를 호출한다.
		person.eat();
		person.sleep();
		
		
		
		
		
		
		
		
	}

}

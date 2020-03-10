package ex14useBasicClass;

class MyClass{
	int data;
	public MyClass(int data) {
		this.data = data;
	}
	
	//toString(): 실제 저장된 데이터가 반횐되도록 Object 클래스로부터 상속받아 오버라이딩한 메소드.
	@Override
	public String toString() {
		return String.valueOf(data);
	}
//	hashCode(): 객체의 고유한 주소값을 문자열의 형태로 반환한다. 차후 set컬렉션에서 중복제거를 위해 사용될 예정임.
	@Override
	public int hashCode() {
		return data;
	}
	//equals() : 두 객체간의 내용비교를 위해 오버라이딩한 메소드로 멤버변수를 비교해서 동일여부를 판단한다.
	@Override
	public boolean equals(Object obj) {
		//비교의 대상이 되는 객체를 매개변수로 전달받아 해당 객체타입인지 확인후 내용을 비교한다.
		if(obj instanceof MyClass) {
			//매개변수로 전달될 때 Object로 업캐스팅(자동형변환)되기 때문에 실제 값을 비교하기 위해서 다운캐스팅을 진행한다.
			MyClass mc = (MyClass)obj;
			//동일한 값일때 true반환
			if(mc.data == this.data) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}

class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//객체1의 x,y값과 객체2의 x,y값을 각각 비교하여 동일한 객체인지 판단한다.
	//따라서 객체의 형태에 따라 equals()메소드의 내용은 달라질 수 있다.
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point pos = (Point)obj;
			if(this.x==pos.x && this.y==pos.y) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "x="+String.valueOf(x)+", y="+String.valueOf(y);
	}
}
public class ObjectEquals2 {

	public static void main(String[] args) {
		
		MyClass mc1 = new MyClass(10);
		MyClass mc2 = new MyClass(10);
		
		System.out.println("[두 객체를 equals()메소드로 비교]");
		if(mc1==mc2) {
			System.out.println("인스턴스 참조값(주소값)이 같다");			
		}
		else {
			System.out.println("인스턴스 참조값(주소값)이 다르다");
		}
		System.out.println(mc1.equals(mc2) ? "같다" : "다르다");
		
		System.out.println("[두 객체의 toString()메소드 호출]");
		System.out.println("mc1.toString()=>"+mc1.toString());
		System.out.println("mc2.toString()=>"+mc2.toString());
		
		Point pos1 = new Point(10, 20);
		Point pos2 = new Point(10, 30);
		System.out.print("두 점의 비교결과:");
		System.out.println(pos1.equals(pos2)?"같다":"다르다");
		
		//아래 toString)()메소드는 굳이 호출하지 않아도 print()문이 실행될때 자동으로 호출된다. 즉 아래문장의 실행결과는 동일하다.
		System.out.println("pos1.toString()=>"+pos1.toString());
		System.out.println("pos2.toString()=>"+pos2.toString());
		System.out.println(pos1);
		System.out.println(pos2);
		
		

	}

}

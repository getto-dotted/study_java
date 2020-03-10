package ex14useBasicClass;
/*
equals()메소드
-자바에서 인스턴스의 내용비교를 위한 비교연산자(==)을 사용하는 것은 단순한 참조값에 대한 비교이므로
실제 내용에 대한 비교는 equals()메소드를 사용한다.
-String과 같은 기본 클래스는 별도의 오버라이딩 없이도 내용비교가 가능하다.
-개발자가 직접 정의한 클래스인 경우 내용 비교를 위해서는 반드시 오버라이딩 하여 사용해야 한다.
 */
class IntNumber{
	int num;
	public IntNumber(int num) {
		this.num = num;
	}
	/*
	아래 메소드는 equals()메소드가 어떻게 객체간의 내용비교를 하는지 설명하기 위한 샘플코드이다.
	 */
	public boolean isEquals(IntNumber numObj) {
		if(this.num==numObj.num) {
			return true;
		}
		else {
			return false;
		}
	}
}
public class ObjectEquals1 {

	public static void main(String[] args) {
		//기본메소드인 String클래스의 객체비교
		String str1 = new String("한국직업전문학교");
		String str2 = "한국직업전문학교";
		
		if(str1.equals(str2)) {
			System.out.println("같은 문자열 입니다.");
		}
		else {
			System.out.println("다른 문자열 입니다.");
		}
		//개발자가 직접 정의한 클래스에 대한 내용비교
		IntNumber num1 = new IntNumber(10);
		IntNumber num2 = new IntNumber(20);
		IntNumber num3 = new IntNumber(10);
		
		if(num1.isEquals(num2)) {
			System.out.println("num1과 num2는 동일한 정수");
		}
		else {
			System.out.println("num1과 num2는 다른 정수");
		}
		if(num1.isEquals(num3)) {
			System.out.println("num1과 num3는 동일한 정수");
		}
		else {
			System.out.println("num1과 num3는 다른 정수");
		}

	}

}

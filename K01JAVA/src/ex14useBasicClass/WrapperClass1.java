package ex14useBasicClass;
/*
Wrapper클래스
	: 기본자료형의 데이터를 객체화할때 사용하는 클래스
	-오토박싱 : 기본자료형이 자동으로 객체로 변경되는 것을 뜻함.
		예] int => Integer
	-오토언박싱 : 객체가 기본자료형으로 자동으로 변경되는 것
	
	※오토박싱, 언박싱은 JDK1.5(5.0) 이상에서 적용된다.
 */
public class WrapperClass1 {

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 20;
		int result = num1+num2;
		System.out.println("result=" + result);
		
		//JDK1.4이전 버전에서의 코딩형태
		Integer n10Obj = new Integer(10);
		Integer n20Obj = new Integer(num2);
		int result2 = n10Obj.intValue()+ n20Obj.intValue();
		/*
		Integer 객체를 Unboxing해주는 메소드를 통해 덧셈연산을 진행함.
		 */
		System.out.println("result2="+result2);
		
		Integer resultObj = new Integer(result2);
		System.out.println("결과값을 byte형 값으로 변경:"+ resultObj.byteValue());
		
		System.out.println("결과값을 이진수로 변경:"+Integer.toBinaryString(result2));
		
		//JDK1.5이상에서의 코딩형태로 오토박싱 처리됨.
		Integer numObj1 = 100;
		Integer numObj2 = 200;
		int num3 = numObj1;//오토언박싱 처리됨.
		
		System.out.println("int 형의 최대값:"+ Integer.MAX_VALUE);
		System.out.println("int 형의 최소값:"+ Integer.MIN_VALUE);
		System.out.println("10을 2진수로:"+Integer.toBinaryString(10));
		System.out.println("10을 8진수로:"+Integer.toOctalString(10));
		System.out.println("10을 16진수로:"+Integer.toHexString(10));
				
		

	}

}

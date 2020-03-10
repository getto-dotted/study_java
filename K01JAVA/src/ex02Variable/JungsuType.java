package ex02Variable;

public class JungsuType {

	public static void main(String[] args) {
		
		/*
		 규칙]
		 1. 큰자료형과 작은자료형의 연산결과는 항상 큰 자료형을 따른다.
		 즉 실수 + 정수 =실수
		 
		 2. 동일자료형끼리의 연산결과는 동일자료형이 된다.
		 단, int보다 작은자료형(byte, short, char)의 연산결과는
		 int형이 된다. 즉 byte+byte=int 가 된다는 것에 주의해야 한다.
		 */
		byte b1;
		b1 = 127;
		System.out.println("b1="+b1);
		
		/*
		 byte형은 127까지 표현할 수 있으므로 아래는 에러		 */
		//b1 =128; 표현범위는 -128 ~127
		b1 = (byte)128;
		System.out.println("형변환후 b1="+b1);
		/*
		byte에 담을 수 없는 128을 byte형으로 형변환후 자료를 저장한다.
		문법적인 오류는 없으나 자료의 손실이 발생하여 -128이 출력된다.
		
		형변환(Type Casting) : 현재의 자료형을 다른 자료형으로 변환하는 행위를 말한다.
		단, 큰 자료형을 작은 자료형에 대입하는 경우 자료의 손실이 발생할 수 있다는 것에 주의해야 한다. 
		 */
		
		/*
		byte와 byte의 연산결과는 int가 된다. 위에서 설명한 규칙2에 해당한다.
		 */
		
		byte b2=20, b3=30;
		//byte b4 = b2 + b3; 에러발생됨
		int b5 =b2+b3;
		System.out.println("byte형끼리의 연산결과"+b5);

		/*
		규칙
		3. 정수형에서 int형보다 큰 자료형(int, long)끼리의 연산결과는 기본규칙을 따른다.
		 */
		
		int num2=100, num3=200;
		long lng1=1000, lng2=2000;
		
		int num4 = num2 + num3;
		System.out.println("int끼리 연산 num4="+num4);
		
		long lng3=lng1+lng2;
		System.out.println("long끼리 연산 lng3="+lng3);
		
		long lng4 = num2+lng1;
		System.out.println("int와 long의 연산 lng4="+lng4);
		
		
		
		/*
		에러 발생됨 out of range
		자바컴파일러(CPU)는 정수를 기본적으로 int 형으로 간주하기 때문에 아래와 같이 접미사(L또는 l)을 붙여서 int형이 아닌 long형의 자료라는 것을 컴파일러에게 
		알려줘야 에러가 발생하지 않는다.
		 */
		
		
		
		//long lng5 = 2200000000;
		long lng6 = 2200000000L;
		System.out.println("lng6="+lng6);
		
		
		/*
		 long타입의 자료를 int타입으로 형변환 했으므로 에러는 없어졌으나 자료의 손실이 발생되어 마이너스의 결과가 출력된다.
		 */
		
		int num7 = (int)2200000000L;
		System.out.println("형변환후 num7="+num7);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

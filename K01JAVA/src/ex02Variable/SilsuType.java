package ex02Variable;

public class SilsuType {

	public static void main(String[] args) {
		
		
		
		/*
		 규칙
		 1. 실수자료형에서 기본은 double형이다.
		 2. 정수형보다는 실수형이 더 큰 자료형이다. (0과 1 사이에 무수한 실수가 존재하기 때문)
		 */
		
		long ln1 = 100;
		float f1 = 200;
		
		
		/*
		long과 float의 연산결과는 float가 된다. 별도의 형변환없이 대입이 가능하다.
		 */
		
		float f2 = ln1 +f1;
				System.out.println("long과 float의 연산결과 f2="+f2);
		
				
				/*
				  float와 long의 연산결과를 long으로 변환하여 받고 싶다면 
				  1. float를 long으로 변환후 연산하거나
				  2. 계산결과 전체를 long으로 변환한다.
				 */
				
		long ln2 = ln1 +(long)f1;
		System.out.println("형변환후 연산결과 ln2="+ln2);
		long ln3 = (long)(ln2 + f1);
		System.out.println("계산후 형변환결과ln3="+ln3);
				
		/*
		 실수형에서 기본형은 double 형이다.
		 소수점이 있는 데이터는 무조건 double형으로 인식하므로, float에 바로 할당할수는 없다.
		 이때는 접미사(F혹은 f)를 사용한다.
		 */				
		float f3 =100;
		
		//float f4 = 3.14;
		float f5 = (float)3.14;//형변환은 권장하지 않음
		System.out.println("f5="+f5);
		
		
		float f6 = 3.14F;
		System.out.println("f6="+f6);
		
		
		
		
		
		
		
		
		
		

	}

}

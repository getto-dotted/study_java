package ex02Variable;

public class Quiz02 {

	public static void main(String[] args) {
		//원의 넓이 (int, float, double)
		
		//원주율을 상수로 선언하려면 final double 변수명 =3.14 로 설정 가능하다.
		
		int r = 10;
		
		int area_int = r*r*(int)3.14;
		float area_float = r*r*3.14f;
		double area_double = r*r*3.14;
		
		
		System.out.printf("정수%d, 소수%f, 소수%f", area_int, area_float, area_double);
		
	/*
	 int radius = 10;
	 double pi =3.14;
	 final double PI=3.14;
	 
 	int area_int = r*r*(int)3.14;
	float area_float = r*r*3.14f;
	double area_double = r*r*3.14;
	
		area_double = radius*radius*pi;
		area_float = (float)(radius*radius*pi);
		area_int = (int)(radius*radius*pi);
		
		System.out.println("int형 넓이: "+ area_int)
		System.out.println("float형 넓이: "+ area_float)
		System.out.println("double형 넓이: "+ area_double)
		
	 
	 */
		
		
		
		
	}
	

}

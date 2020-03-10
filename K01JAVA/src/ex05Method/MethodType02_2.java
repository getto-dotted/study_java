package ex05Method;

import java.util.Scanner;

public class MethodType02_2 {

	
	static String getHakjum() {
		//스캐너 클래스를 사용할 준비
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("국어점수: ");
		int kor = scanner.nextInt();
		System.out.print("영어점수: ");
		int eng = scanner.nextInt();
		System.out.print("수학점수: ");
		int math = scanner.nextInt();
		
		//평균값
		double avg=(kor+eng+math)/3.0;
		//학점반환을 위한 변수 생성
		String hakjum ="";
		
		
		int result = (int)avg/10; // <-핵심포인트
		/*
		 평균점수를 10으로 나눠주는 이유는 나눈 몫을 통해 학점의 구간을 구하기 위함이다.
		 
		 93/10=9
		 99/10=9
		 과 같이 10으로 나눈 몫은 점수의 구간이 된다.
		 */
		switch(result) {
		case 10: case 9:
			hakjum = "A학점";break;
		case 8 :
			hakjum = "B학점";break;
		case 7 :
			hakjum = "C학점";break;
		case 6 :
			hakjum = "D학점";break;
		default :
			hakjum = "F학점";
		}
		return hakjum;
		
	}
	
	public static void main(String[] args) {

/*
 시나리오] 사용자로부터 국, 영, 수 점수를 입력받아 평균을 구한후 학점을 반환하는 메소드를 정의하시오.
 */
		
		
	System.out.println("너의 학점은 "+getHakjum()+" 이얌~!");
	
	String h = getHakjum();
	System.out.printf("당신의 학점은 %s 입니다.", h);
		
		
		
		
		
		
		
		
		

	}

}

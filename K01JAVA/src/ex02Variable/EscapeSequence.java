package ex02Variable;

public class EscapeSequence {

	public static void main(String[] args) {
	
		/*
		 이스케이프 시퀀스(Escape Sequence) : 특정 형식에 맞게 출력하기위해 사용되는 문자로 \(역슬러쉬)를 붙여주면 된다.
		 */
		
		/*
		 \t : 탭(tap)기능.
		 */
		System.out.println("4월엔 벚꽃~~");
		System.out.println("4월엔 \t벚꽃~~");
		
		
		/*
		 \n : 줄바꿈(Line Feed) 기능
		 */
		System.out.println("신도림에 오신걸 환영합니다.");
		System.out.println("여긴 한국직업\n전문학교 입니다.");
		
		
		/*
		 \" : 더블 쿼테이션을 표현하는 기능
		 */
		System.out.println("나는 \"개발자\"가 되고싶어요");
		System.out.println("\"빅데이터\"도 하고 싶어요");
		
		
		
		
		
		
		/*
		 printf()문 : 문자열을 서식에 맞춰 출력할때 사용함. 
		 서식문자
		 %d : 정수값(byte/short/int/long)
		 %f : 실수값(float/double)
		 %s : 문자열
		 %c : 문자
		 %n : 줄바꿈. \n과 동일한 기능임.
		 */
		int kor=100, eng=99, math=98;
		System.out.printf("국어:%d, 영어:%d, 수학:%d", kor, eng, math);
		
		System.out.println();
		System.out.println("국어:"+kor+", 영어:"+eng+", 수학:"+math);
		
		System.out.print("print문은 줄바꿈 기능 없음\n");
		System.out.printf("printf문도 줄바꿈 안됨%n");
		System.out.println();
		System.out.println("나는 줄바꿈 되지롱~~");
System.out.println("--프로그램끝--");

		
		
		
		
		

	}

}

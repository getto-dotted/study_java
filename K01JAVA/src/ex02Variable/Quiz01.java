package ex02Variable;

public class Quiz01 {

	public static void main(String[] args) {

/*
  퀴즈01] 파일명 : Quiz01.java
1.국어, 영어, 수학점수 및 과목의 총점을 저장할수 있는 
변수를 선언하시오.
2.국어 89점, 영어 99점, 수학 78점을 대입한다.
3.국영수 총합을 구해서 총점을 저장할 변수에 대입한다.
4.총합점수를 출력한다.
5.평균값을 도출하시오. 단 실수로 출력하시오
실행결과 
 	국어점수:XX점, 수학점수:XX점, 영어점수:XX점
 	3과목의 총점은 : XXX점

 */
		
		/*
		 1. 변수선언 : 국어, 영어, 수학, 총점
		 2. 변수 초기화
		 3. 총점을 구해서 변수에 대입
		 4. 출력
		 5. 평균
		 */
	
				
		int kor=89, eng=99, math=78;
				
		int total = (kor+eng+math);
		
		double avg = total/(double)3;
		
		System.out.println(total/3.0);
		
		System.out.printf("국어점수=%d점, 영어점수=%d점, 수학점수=%d점, 총점=%d점", kor, eng, math, total);
		
		System.out.printf("\n평균점수=%f점", avg);
		
		//소수점 이하 자리수 결정하기
		
		double mean = (double)total/3;
		System.out.printf("평균:%9.3f\n", avg);
		System.out.printf("평균:%-9.9f\n", avg);
		
		
		
		
	}

}

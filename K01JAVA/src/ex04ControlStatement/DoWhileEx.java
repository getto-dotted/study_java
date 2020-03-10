package ex04ControlStatement;

public class DoWhileEx {
		/*
		do ~ while 문
			: 반드시 한번은 실행해야 할 경우 사용하는 반복문. 조건검사 없이 무조건 한번은 실행한 후 조건을 검사한다.
			형식]		
			do {
				실행문장;
				증감식;
			}while(조건식); <- 세미콜론으로 마무리
		 */
	public static void main(String[] args) {
		
		int sum = 0;
		int i =1;
		do {
			sum += i;
			i++;
		}while(i<=10);
		System.out.println("1~10까지의 합: "+sum);
		
		
		/*
		 시나리오] 1~1000까지의 정수중 4의 배수이거나 7의 배수인 수의 합을 구하여 출력하는 프로그램을 do~while문을 사용해서 작성하시오.
		 */
		
		
		int total = 0;//누적합을 저장할 변수
		int j = 1;//반복을 위한 변수
		
		do {//조건체크 없이 무조건 한번 실행
			if(j%4==0 || j%7==0) {
			//조건에 맞을때 변수j를 total에 누적
			total += j;
			}
			j++;
		}while(j<=1000);//반복의 조건을 체크
		
		System.out.println("1~1000까지 4 or 7의 배수의 합 : "+total);
		
		
		total =0;
		int k=1;
		
		do {
			if(k%3==0 && k%5==0) {
			
			total +=k;}
			k++;
		}while(k<=1000);
		
		System.out.println("1~1000까지 3과 5의 공배수의 합 : "+ total);
			
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

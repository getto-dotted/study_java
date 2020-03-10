package review;

public class R02while_for {
/*
반복문
	while문 : 조건을 먼저 검사한 후 참일때 while문의 루프를 반복하는 반복문.
			조건에 맞지 않으면 단 한번도 실행되지 않을 수도 있다.
		형식]
			반복을 위한 초기식;
			while(조건식){
				실행문;
				while을 탈출하기 위한 증감식;
			}
			
	do~while문 : 조건검사없이 무조건 1번 실행후 조건을 판단한다.
				따라서 1번은 반드시 실행해야하는 문장인 경우 사용한다.
		형식]			
			반복을 위한 초기값;
			do{
				실행문;
				증감식;
				}while(조건식); <-- 세미콜론이 반드시 들어감
					
	for문 : 반복의 횟수가 일정하게 정해져있을때 주로 사용하는 반복문. 
	반복의 횟수가 명확하지 않다면 while문을 사용하는 것이 좋다.
		형식]
			for(초기값; 조건식; 증감식){
 				실행문장;	
 				}	
 */
	public static void main(String[] args) {

		//1~10까지 누적합을 구하는 프로그램을 작성하시오
		
		int i=1;
		int sum=0;
		while(i<=10) {
			sum+=i;
			i++;
		}
		System.out.println(sum);
		
		//1~10까지 누적합을 구하는 프로그램을 작성하시오(do~while문 사용)
		int j=1;
		int sum2=0;
		do {
			sum2+=j;
			j++;
		}while(j<=10);
		System.out.println(sum2);
		
		
		//1~100까지 누적합을 구하는 프로그램을 작성하시오(for문)
		
		int hap=0;
		for(int k=1; k<=100; k++) {
			hap+=k;			
		}
		System.out.println("hap="+hap);
/*
연습문제] 두개의 주사위를 던졌을때 눈의 합이 6이되는 경우를
모두 출력하는 프로그램을 for문과 if문을 이용하여 작성하시오.
실행결과]
	1+5=6
	2+4=6
	.......
	5+1=6
 */
		
		for(int i1=1; i1<=6; i1++) {			
			for(int j1=1; j1<=6; j1++) {				
				if(i1+j1==6) {
//					System.out.println(i1+"+"+j1+"="+(i1+j1));
					System.out.printf("%d+%d=%d\n",i1,j1,(i1+j1));
				}
			}
		}
		System.out.println("=========================");
/*
위 주사위 문제를 do~while문으로 변경하시오.
 */
		int m=1;		
		do {
			int n=1;
			do {
				if(m+n==6) {
					System.out.printf("%d+%d=%d\n",m,n,(m+n));
				}				
				n++;
			}while(n<=6);
			m++;			
		}while(m<=6);
		
		
/*
연습문제] 방정식 2x+4y=12를 만족하는 모든 x,y값을 구하시오.
단, x,y의 범위는 0~10사이의 정수이고 while문을 통해
구현하시오.
실행결과]
	x=0, y=3
	x=2, y=2
	.......
 */
		System.out.println("=========================");
		int x=0;
		while(x<=10) {
			int y =0;
			while(y<=10) {
				if(2*x+4*y==12) {
					System.out.printf("x=%d, y=%d\n", x, y);
				}
				y++;
			}
			x++;
		}
		System.out.println("=========================");

/*
연습문제] 1-2+3-4+5- ..... +99-100 의 합계를 구하는 프로그램을 작성하시오.(for문)
 */

		int total=0;
//		int u =0;
		for(int z=1; z<=100; z++) {
			if(z%2==0) {
				total-=z;
//				u=z*-1;
			}
			else {
				total+=z;
//				u=z;
			}
//			total+=u; 이러한 식으로 변수를 하나 더 추가해서 계산할 수도 있다. 변수의 조건이 더 다양할경우 이게 더 유용할듯	
		}
		System.out.println("total="+total);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

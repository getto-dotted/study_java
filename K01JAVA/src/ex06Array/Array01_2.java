package ex06Array;

import java.util.Random;

public class Array01_2 {

	public static void main(String[] args) {
		
		
		/*
		 난수 생성방법1
		 Math.random() : 0~1사이싀 실수를 반환한다.
		 */
		
		double dblRandom = Math.random();
		System.out.println("생성된 난수: "+dblRandom);
		
		
		int intRandom = (int)(dblRandom*100);
		System.out.println("정수로 변경된 난수: "+intRandom);
		
		
		
		
		/*
	 	난수 생성방법2
	 	Random 클래스의 하위메소드인 nextInt()를 사용한다.
		 */
		Random rndNumber = new Random();
		System.out.println("생성된 난수: "+rndNumber.nextInt());
		
		
		//intRandom = (int)(dblRandom*100%45+1);
		//System.out.println("정수로 변경된 난수: "+intRandom);//로또 생성기
		
		/*
		 시나리오] 난수를 생성하여 크기가 6인 배열을 초기화 하시오.(여기서는 로또번호처럼 1~45사이의 난수를 생성하여 배열을 초기화해본다)
		 */
		
		System.out.println("=========================");
		System.out.println();
		System.out.println("1~45사이의 난수생성: "+(int)((Math.random()*100)%45+1));
		System.out.println();
		System.out.println("=================================");
		
		/*
		 로또 번호처럼 1~45사이의 난수를 생성하는 방법
		 1. 0.xxxx형태의 난수를 정수로 변경하기 위해 100(혹은 더 큰 수도 상관없음)을 곱한후 int로 형변환한다.
		 2. 45로 %연산을 진행하여 나머지를 구한다. 이때 결과는 0~44가 된다.
		 3. 2번의 결과에 1을 더하면, 1~45사이의 난수를 구할 수 있다.
		 
		 */
		
		System.out.println("크기가 6인 배열에 난수 입력");
		int[] lottoNum = new int[6];
		for(int i=0; i<lottoNum.length; i++) {
			/*
			 생성된 난수로 크기가 6인 정수형 배열을 초기화한다.	
			 */
			lottoNum[i] = (int)((Math.random()*100)%45)+1;
		}
		for(int i=0; i<lottoNum.length; i++) {
			System.out.printf("%d ", lottoNum[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

package ex06Array;

public class QuizArray1To10 {
	/*
	 다음 절차에 따라 프로그램을 작성하시오.
1. 크기가 10인 정수타입의 배열을 선언한다.
2. 반복문을 이용하여 배열을 채운다. 
이때 배열은 1,2,3,4....순서대로 채운다.
3. 2번에서 채운 배열을 출력한다.
4. 위에서 채운 배열의 첫번째 값에서 마지막값까지 누적해서 더한다.
5. 누적해서 더한 값을 출력한다. 
	 */

	public static void main(String[] args) {
		
		int[] arrNumber = new int[10];
		for(int i = 0; i<arrNumber.length; i++) {
			arrNumber[i] = i+1; 
			System.out.print(arrNumber[i]+" ");
			
			}
		/*
		for(int i=0; i<arrNumber.length; i++) {
			System.out.printf("%d ", arrNumber[i]);
		}
		 */
		
		int arrSum = 0;
		for(int i= 0; i<arrNumber.length; i++) {
		arrSum +=arrNumber[i];
		}
		System.out.println();
		System.out.print("누적합 : "+arrSum+" ");
		
		
		
		
		
		
		

	}

}

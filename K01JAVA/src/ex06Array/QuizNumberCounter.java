package ex06Array;

public class QuizNumberCounter {

	public static void main(String[] args) {
		
		/*
 다음에 주어진 answer 배열에는 1~4까지의 정수가 여러개 저장되어 있다. 
 배열 전체의 데이터를 읽어서 각 정수가 몇개씩 있는지 카운트하여 counter 배열에 순서대로 저장하시오.

int[] answer = { 1,4,4,3,1,4,4,2,1,3,2  };
int[] counter = new int[4];

실행결과]
counter[0] => 3
counter[1] => 2
counter[2] => 2
counter[3] => 4

		 */
		
		//answer 배열의 크기만큼 루프
		
		/*
		int[] answer = { 1,4,4,3,1,4,4,2,1,3,2  };
		int[] counter = new int[4];
		
		for(int i=0; i<answer.length; i++) {
			//아래 if~else문을 한줄로 바꾸면 다음과 같다.
			counter[answer[i]-1]++;
			/*
			if(answer[i]==1) {
				counter[0]++;
			}
			else if(answer[i]==2) {
				counter[1]++;
				
			}
			else if(answer[i]==3) {
				counter[2]++;
				
			}
			else if(answer[i]==4) {
				counter[3]++;
				
			}
			*/
		/*
		}
		for(int i=0; i<counter.length; i++) {
			System.out.printf("counter[%d](%d)의 갯수 : %d%n", i, i+1, counter[i]);
			
		}
		
		*/
		
		
		
		int[] answer = { 1,4,4,3,1,4,4,2,1,3,2  };
		int
		[] counter = new int[4];
		
		counter = countAndSum(answer, counter);
		for(int i=0; i<counter.length; i++)
		System.out.println("counter["+i+"] => "+counter[i]+" ");
			
	}
/*
	static int[] countAndSum(int[]answer, int[]counter) {
		for(int i = 0; i<counter.length; i++) {
			for(int j =0; j<answer.length; j++) {
				if(answer[j]==i+1) {
					counter[i]++;
				}
			}
			
		}
		return counter;
		*/
	
	static int[] countAndSum(int[]answer, int[]counter) {
		int i=0;
		while(i<4) {
			for(int j =0; j<answer.length; j++) {
				if(answer[j]==i+1) {
					counter[i]++;
					}
			}
		i++;
		}
	return counter;
	}
}

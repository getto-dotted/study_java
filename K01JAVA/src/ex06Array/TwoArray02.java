package ex06Array;

public class TwoArray02 {

	public static void main(String[] args) {
		
		/*
		 아래와 같이 초기화하면 세로크기는 3, 가로크기는 4로 지정된다. 초기화할 요소가 없는 부분은 null로 채워지게 된다.
		 ※null값 : 아무것도 없는 값을 일컫는다. 즉 빈값을 말한다.
		 	단 스페이스를 눌렀을때의 공백과는 다르다는 것에 주의하자.
		 */
		
		int[][] arr = {
				{1,2},
				{3,4,5},
				{6,7,8,9}
		};
		System.out.println("배열의 세로크기:"+ arr.length);
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%d행의 크기:%d\n",i,arr[i].length);
		}
		System.out.println("배열 출력하기");
		System.out.println("arr[0][1]="+arr[0][1]);//정상출력
		
		/*
		 arr[0][2]는 초기화되지 않아 null이므로 출력을 시도하면
		 ArrayIndexOutOfBoundsException : 예외가 발생된다.
		 */
		//System.out.println("arr[0][2]="+arr[0][2]);
		

	}

}

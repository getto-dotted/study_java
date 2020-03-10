package ex06Array;

public class ArrayAndMethod {

	public static void main(String[] args) {
		
		/*
		 배열의 선언과 동시에 초기화. 요소의 갯수를 통해 배열의 크기가 결정됨.
		 */
		
		
		int[] arr = {1, 2, 3, 4, 5};
		int[] ref;
		System.out.println("초기화 직후 출력");
		
		/*
		 arr 배열의 크기만큼 반복하면서 요소를 출려갛ㅁ
		 */
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
			
		}
		System.out.println();
		
		/*
		 배열명을 매개변수로 전달하는 것은 배열의 참조값(힙영역의 주소값) 을 전달하게 된다. 해당 참조값을 통해 배열을 접근할 수 있다.
		 */
		System.out.println("===================================");
		
		ref = addAllArray(arr,7);
		System.out.println("메소드 호출후 출력");
		/*
		 배열변수 ref로 출력하는 것과 arr로 출력하는 것은 동일한 결과가 나오게 된다.
		 이유는 동일한 주소값(참조값)을 가지고 있기 때문이다.
		 */
		for(int i=0; i<ref.length; i++) {
			System.out.print(ref[i]+" ");
		}
		System.out.println();
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
				
			
		
	}

	static int[] addAllArray(int[] ar, int addVal) {
		for(int i=0; i<ar.length; i++) {
			ar[i] += addVal;
			//위를 바궈쓰면 => ar[i]=ar[i]+addVal;
		}
		/*
		 매개변수로 전달받았던 주소값을 그대로 반환한다.
		 */
		return ar;
	}
}

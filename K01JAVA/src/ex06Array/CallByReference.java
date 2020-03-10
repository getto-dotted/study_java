package ex06Array;
/*
 Call by reference(참조(주소값)에 의한 호출) : 메소드를 호출할때 참조값을 전달하므로써 서로 다른 지역에서도 동일한 메모리(힙영역)를 
 참조할 수 있게 하는 호출방법이다. 메소드의 지역이 서로 다르더라도 참조값을 통해 참조하므로 A영역에서의 값의 변경을 B역역에서도 그대로 참조할 수 있는
 장점을 가지고 있다.
 */
public class CallByReference {

	public static void main(String[] args) {
		
		int [] arr = {100,200};
		System.out.println("[메인메소드] - Swap전 출력");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		
		callByReference(arr);
		
		System.out.println("[메인메소드]-Swap이후 출력");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	
	static void callByReference(int[]ar) {
		int temp;
		temp = ar[0];
		ar[0] = ar[1];
		ar[1] = temp;
	}

}

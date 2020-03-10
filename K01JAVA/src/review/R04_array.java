package review;

import java.util.Random;

public class R04_array {

	public static boolean arrayExistElements(int[] arr) {
		boolean numFlag = true;
		
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<arr.length; j++) {
				if(i!=j && arr[i]==arr[j]) {
					//중복발견
					numFlag=false;
				}
			}
		}
		return numFlag;
	}

	public static void randomCreate(int[] lotto) {
		while(true) {	//난수6개 생성
			for(int i=0; i<lotto.length; i++) {
				lotto[i] = (int)(Math.random()*45)+1;
			}	
			
			boolean isOverlap = arrayExistElements(lotto);
			if(isOverlap==false) {
				System.out.println("중복발생됨");
				/*
				반복문에서 continue를 만나게 되면 그 이후에 나오는 문장들은 실해오디지 않고
				반복문의 처음으로 돌아가서 조건을 검사한 후 반복여부를 판단한다.
				 */
				continue;//난수 6개 다시생성
			}
			else {
				/*
				반복문안에서 break를 만나면 가장 가까운 반복문 하나를 탈출하게 된다.
				따라서 반복문이 중첩되었다면 탈출여부를 신중히 판단해야 한다.
				 */
				break;//생성완료이므로 while문 탈출
			}					
		}
	}
	static void bubbleSort(int[] arr) {
		int temp;//스왑을 위한 임시변수
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<(arr.length-1)-i; j++) {
			//앞자리 숫자와 뒷자리 숫자를 비교후 앞자리가 크면 뒷자리와 교환
				if(arr[j]>arr[j+1]) {
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1] =temp;
				}
			}
		}
			
	}
	
	public static void showArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	
	public static void main(String[] args) {

		/*
		시나리오]1차원배열을 생성과 동시에 초기화하고 배열의 요소에
		중복값이 있는지 검사하는 프로그램을 작성하시오.
		중복이 없는경우에는 true, 중복이 있는경우에는 false를 반환한다.
		 */
		int[] arr1 = new int[] {1,2,3,4,5};
		int[] arr2 = {1,2,3,2,5};

		boolean isExist1 = arrayExistElements(arr1);
		if(isExist1==true) System.out.println("중복없음");
		else System.out.println("중복있음");
		
		boolean isExist2 = arrayExistElements(arr2);
		if(isExist2==true) System.out.println("중복없음");
		else System.out.println("중복있음");
		
		/*
		연습문제] 중복되지 않는 난수 6개를 생성하시오. 생성한 
		난수는 아래 배열에 채워 넣으시오.
		 */
		int[] lottoNum = new int[6];
		
		//난수생성 및 중복검사
		randomCreate(lottoNum);
		
		//배열출력
		System.out.println("버블정렬 전 출력");
		showArray(lottoNum);
		
		//버블정렬
		bubbleSort(lottoNum);
		System.out.println();
		System.out.println("버블정렬 후 출력");
		showArray(lottoNum);
		
		
		
		
		
	}

}

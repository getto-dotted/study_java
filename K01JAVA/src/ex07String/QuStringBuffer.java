package ex07String;

public class QuStringBuffer {

	public static void main(String[] args) {
/*
 1. String str1 = "ABCDEFGHI";
이 문자열을 역순으로 다시 출력하는 프로그램을 작성하자.

2. String str2 = "1234567-1212121"
위 문자열에서 중간에 삽입된 하이픈(-)을 삭제하는 인스턴스를 생성해보자.

-위 1,2번은 하나의 파일에서 동시에 구현하면 된다. 

 */
		
		/*
		 방법1 : str1의 전체 길이를 읽어들이고 빈 스트링에 str1의 맨뒤 배열부터 읽어들여서 쓴다.
		String str1 = "ABCDEFGHI";
		String rev = "";
		
		int len = str1.length();
		for(int i = len -1; i>=0; i--)
			rev = rev + str1.charAt(i);
		System.out.println(rev);
		*/
		
		//방법2 새로운 객체 sb를 만들고 sb에 str1의 값을 대입한 다음 .reverse().toString()기능을 이용해 뒤집는다. 왜 스트링을 직접 쓰면 안되는것인지?
		
		String str1 = "ABCDEFGHI";
		StringBuffer sb = new StringBuffer(str1);
		String rev = "";
		
		rev = sb.reverse().toString();
		System.out.println(rev);
		
		
		String str2 = "1234567-1212121";
		//System.out.println(str2.replace("-", ""));
		StringBuffer sb2 = new StringBuffer(str2);
		sb2.deleteCharAt(str2.indexOf("-"));
		
		System.out.println("하이픈 삭제후 출력:"+sb2.deleteCharAt(str2.indexOf("-")));
	
		
		
	}

}

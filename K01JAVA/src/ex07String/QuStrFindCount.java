package ex07String;
/*
아래 조건을 충족하는 메소드를 작성하시오.
-메서드명 : strCount
-기능 : 주어진 문자열에 찾으려는 문자열이 몇 번 나오는지 반환한다.
-메인메소드 호출문장	
	public static void main(String[] args) {
		System.out.println(strCount("12345AB12AB345AB","AB"));
		System.out.println(strCount("12345","AB"));
	}
-실행결과
	문자열 12345AB12AB345AB 에서 AB의갯수 : 3
	문자열 12345 에서 AB의갯수 : 0

힌트] indexOf(찾을문자열, 시작인덱스(fromIndex))
 */

public class QuStrFindCount {
	/*
	1. 스트링 버퍼를 이용함.
	public static StringBuffer strCount(String start, String find) {
		int strCount=0;
		StringBuffer sb = new StringBuffer(String.format("문자열 "+start+" 에서 "+find+"의 갯수: ")
				);
		while(true){
			int findIdx = start.indexOf(find);
			if(findIdx!=-1) {
				int nextIdx=findIdx+find.length();
				//System.out.println(findIdx+"-"+nextIdx);
				start = start.substring(nextIdx);
				//System.out.println(start);
				strCount++;
			}
			else {
				break;
			}
		}
		return sb.append(strCount);
		}
		*/
	/*
	방법2 스트링을 이용함
	public static String strCount(String start, String find) {
	int strCount=0;
	String sb = new String("문자열 "+start+" 에서 "+find+"의 갯수: ");
	while(true){
		int findIdx = start.indexOf(find);//findIdx : 검색할 문자열
		if(findIdx!=-1) {
			int nextIdx=findIdx+find.length();//nextIdx : 다음번에 검색할 문자열
			start = start.substring(nextIdx);
			strCount++;
		}
		else {
			break;
		}
	}
	return sb+(strCount);
	}
	*/
	
	 /* 선생님답안
	 public class QuStrFindCount {

	     public static void main(String[] args) {
	         System.out.println(strCount("12345AB12AB345AB4534545AB445455AB","AB"));
	         System.out.println(strCount("12345","AB"));
	     }

	     static StringBuffer strCount(String compStr, 
	             String findStr) {
	         int strCount=0;
	         StringBuffer sb = new StringBuffer(
	                 String.format("문자열 "+ compStr 
	                         +" 에서 "+ findStr +"의갯수:")
	             );        
	                 
	         while(true) {
	             int findIdx = compStr.indexOf(findStr);
	             if(findIdx!=-1) {
	                 int nextIdx = findIdx + findStr.length();
	                 //System.out.println(findIdx +"-"+ nextIdx);
	                 compStr = compStr.substring(nextIdx);                
	                 //System.out.println(compStr);
	                 strCount ++;
	             }
	             else {
	                 break;
	             }
	         }
	         //문자열 끝에 찾는문자열의 갯수를 추가함.
	         return sb.append(strCount);
	     }

	 }
*/
	 
	public static String strCount(String start, String find) {
		int strCount=0;
		String sb = new String("문자열 "+start+" 에서 "+find+"의 갯수: ");
		while(true){
			int findIdx = start.indexOf(find);
			if(findIdx!=-1) {
				int nextIdx=findIdx+find.length();
				start = start.substring(nextIdx);
				strCount++;
			}
			else {
				break;
			}
		}
		return sb+(strCount);
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(strCount("12345AB12AB345AB","AB"));
		System.out.println(strCount("12345","AB"));
				
	}
}


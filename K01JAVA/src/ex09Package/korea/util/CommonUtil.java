package ex09Package.korea.util;

public class CommonUtil {

/*
해당 메소드는 static으로 선언된 정적 메소드로 
프로그램 시작과 동시에 메소드 영역에 로드되어 사용될 준비를 하게 된다.
사용시 new를 통해 객체생성을 하지 않고, 클래스명으로 즉시 호출하여 사용할 수 있다.	
 */
	public void isVoid() {
		
	}
	
	public static boolean isNumber(String strValue) {
		//문자열이 공백이면 즉시 false를 반환
		if(strValue.length()==0)
			return false;
		/*
		문자열이 공백이 아닌 경우 크기만큼 반복하면서 
		특정 문자가 숫자형태인지 검사한다.
		 */
		for(int i=0; i<strValue.length();i++) {
			int acode = strValue.codePointAt(i);
			if(!(acode>='0' &&acode<='9')) {
				return false;
			}
		}
		
		return true;
	}
}

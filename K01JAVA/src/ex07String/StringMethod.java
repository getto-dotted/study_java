package ex07String;

public class StringMethod {

	public static void main(String[] args) {
		
		System.out.println("String 클래스의 주요 메소드");
		
		String str1 = "Welcome to java";
		String str2 = "자바야 놀자!";
		
		/*
		 1.length(): 문자열의 길이를 반환한다.
		 */
		System.out.println("str1의 길이:"+ str1.length());
		System.out.println("str2의 길이:"+ str2.length());
		
		/*
		 2. charAt(인덱스) : 특정 index에 해당하는 문자하나를 반환한다. index는 배열처럼0부터 시작한다.
		 */
		
		System.out.println("str1의 두번째 문자:" +str1.charAt(1));
		System.out.println("str2의 두번째 문자:" +str2.charAt(1));
		
		/*
		 시나리오] 주민등록번호를 이용하여 성별을 판단하는 프로그램을 작성하시오 
			190419-3000000 => 남자
			190419-4000000 => 여자
		 */
		
		String juminNum = "190419-2000000";
		if(juminNum.charAt(7)=='1'
				|| juminNum.charAt(7)=='3'){
					System.out.println("남자입니다");
				}
				else if(juminNum.charAt(7)=='2'|| juminNum.charAt(7)=='4') {
					System.out.println("여자입니다.");
				}
				else {
					System.out.println("주민번호가 잘못되었습니다.");
				}
		/*
		 3. compareTo()
		 : 두 문자열을 첫번째 문자부터 순차적으로 비교해가면서 
			 앞문자의 아스키코드가 크면 양수를 반환
			 뒷문자의 아스키코드가 크면 음수를 반환
			 같으면 0을 반환한다.
		 */
		
		String str3 = "A";
		String str4 = "B";
		System.out.println(str3.compareTo(str4));//-1
		System.out.println(str4.compareTo(str3));//1
		System.out.println("ABC".compareTo("ABC")==0 ? "문자열이 같다":"문자열이 다르다");
		
		/*
		4. concat()
			: 두개의 문자열을 연결할때 사용한다. 자바에서는 주로 + 연산자를 사용한다.
		 */
		
		System.out.println("JAVA".concat(" WORLD").concat(" GO"));
		System.out.println("JAVA"+" WORLD"+" GO");
		
		
		
		/*
		5. contains()
			: 문자열에 특정 문자열이 포함되어 있는지 판단하여 포함되었을때 true를 반환한다.
		 */
		
		
		System.out.println(str1.contains("TO"));
		System.out.println(str1.contains("to"));
		
		/*
		 시나리오] 해당 문자열이 이메일 형식인지 검사하는 프로그램을 작성하시오.
		hong@ikosmo.co.kr => 이메일 형식임
		not@naver => 이메일 형식이 아님
		 */
		
		
		String email1 = "hong@ikosmo.co.kr";
		if(email1.contains("@") && email1.contains(".")) {
			System.out.println("이메일 형식임");
		}
		else {
			System.out.println("이메일 형식이 아님");
		}
		
		/*
		public static String strCount(String start, String find) {
		int strCount=0;
		String sb = new String("문자열 "+start+" 에서 "+find+"의 갯수: "
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
		return sb+(strCount);
		}
		 */
		
		
		/*
		 6. format()
		 	: 출력형식을 지정하여 문자열로 반환하고 싶을때 사용하는 메소드. 
		 	사용법은 printf()와 동일하고 주로 웹어플리케이션을 제작할때 사용된다.
		 */
		System.out.printf("국어:%d, 영어:%d, 수학:%d\n", 81,92,100);
		String formatStr =
				String.format("국어:%d, 영어:%d, 수학:%d\\n", 81,92,100);
		System.out.println(formatStr);
		
		/*
		 7. indexOf()
		 	: 문자열에서 특정 문자열의 시작인덱스를 반환한다.
		 	만약 찾는 문자열이 없다면 -1을 반환한다.
		 */
		
		
		System.out.println(str1.indexOf("ava"));
		System.out.println(str1.indexOf("J"));
		System.out.println(email1.indexOf("@")!=-1 ? "이메일 형식 맞음":"이메일 형식 아님");
		
		
		/*
		 주민번호에서 -(하이픈) 기호의 index값을 찾아서 1을 더하면 성별을 나타내는 숫자를 가져올 수 있다.
		 */
		
		juminNum = "120403-3012345";
		int index = juminNum.indexOf("-")+1;
		
		
		
		if(juminNum.charAt(index)=='3') {
			System.out.println("남자");
		}
		else {
			System.out.println("여자");
		}
		
		/*
		 8.lastIndexOf()
		 	: indexOf()와 사용법은 동일하나 문자열의 뒤에서부터 특정문자열을 찾아서 인덱스를 반환한다.
		 */

		
		System.out.println(str1.lastIndexOf("ava"));
		System.out.println(str1.lastIndexOf("J"));
		
		
		System.out.println("indexOf:"+str1.indexOf("a"));
		System.out.println("lastIndexOf:"+str1.lastIndexOf("a"));
		
		
		/*
		 9. replace()
		 	: 특정 문자열을 찾아서 지정된 문자열로 변경한다.
		 	만약 찾는 문자열이 없다면 변경만 되지 않을뿐 에러가 발생하지는 않는다.
		 */
		
		
		
		System.out.println("J를 G로 변경하기");
		System.out.println(str1.replace("J", "G"));
		
		System.out.println("java를 KOSMO로 변경하기");
		System.out.println(str1.replace("java", "Kosmo"));
		
		System.out.println("자바를 지울때도 사용할 수 있음");
		System.out.println(str2.replace("자바", ""));
		
		
		
		/*
		10. split()
			: 문자열을 구분자로 분리해서 String타입의 배열로 반환한다. 
			해당 구분자가 없는 경우에는 배열크기가 1인 String 배열로 반환된다.
		 */
		String phoneNumber = "010-1234-5678";
		String[] phoneArr = phoneNumber.split("-");
		for(int i=0; i<phoneArr.length; i++) {
			System.out.printf("phoneArr[%d]=%s\n", i , phoneArr[i]);
		}
		
		/*
		 %구분자가 없기 때문에 크기가 1인 배열로 반횐된다.
		 */
		
		phoneArr = phoneNumber.split("%");
		for(int i=0; i<phoneArr.length; i++) {
			System.out.printf("phoneArr[%d]=%s\n", i , phoneArr[i]);
		}
		
		/*
		11. substring()
			: 시작인덱스와 끝인덱스 사이의 문자열을 잘라서 반환해주는 메소드.
			사용법1 : 매개변수가 하나일때 -> 인덱스부터 끝까지를 잘라서 반환함
			사용법2 : 인덱스에 포함되는 문자열만 잘라서 반환함.
		 */
		System.out.println(str1.substring(3));
		System.out.println(str1.substring(3, 7));
		
		/*
		연습문제] 다음 파일명에서 확장자를 잘라내는 프로그램을 작성하시오.
		파일명 : my.file.images.jpg
		출력결과 : 파일의 확장자는 jpg 입니다.
		 */
		//방법1
		String str5 = "my.file.images.jpg";
		int i = str5.lastIndexOf(".");
		System.out.println("파일의 확장자는 "+str5.substring(i+1)+" 입니다.");
		
		//방법2
		String str6 = "my.file.images.jpg";
		String[] strArr = str6.split("\\.");
		String j = strArr[strArr.length-1];
		System.out.printf("파일의 확장자는 %s입니다.", j);
		
		
		
		

	}

}

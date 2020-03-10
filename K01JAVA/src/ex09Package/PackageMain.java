package ex09Package;

import java.util.Date;

import ex09Package.korea.util.CommonUtil;



public class PackageMain {

	public static void main(String[] args) {
/*
하나의 클래스안에서 패키지는 다르나 같은 이름의 클래스를 동시에 사용해야 할 때
방법1 : 클래스명 앞에 패키지명 전체를 써준다.
방법2 : 하나의 클래스는 import하고 다른 하나만 패키지명 전체를 써준다.
 */
		Date utilDate = new Date();
		System.out.println("utilDate=" + utilDate);
		
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println("sqlDate=" + sqlDate);
		
/*
ex09Package 하위에 ex09Package.korea.util 패키지가 생성되지만
이 두개는 서로 다른 패키지로 인식한다.
즉 클래스가 저장된 위치가 다르면 무조건 다른 패키지로 인식하므로 주의해야 한다.
따라서 해당 클래스에서는 ex09Package.korea.util 패키지를 import해야 한다.		
 */
	String strValue = "987654321";
	boolean isNum = CommonUtil.isNumber(strValue);
	if(isNum==true)
		System.out.println("문자열은 숫자입니다.");
	else
		System.out.println("숫자가 아닙니다.");
	
	System.out.println(ex09Package.korea.util.CommonUtil.isNumber("백20"));
	
	}

}

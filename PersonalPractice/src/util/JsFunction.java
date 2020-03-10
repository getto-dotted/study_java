package util;

import javax.servlet.jsp.JspWriter;

public class JsFunction {

	public static String jsAlertLocation(String msg, String url) {
		/*
		 JS 함수를 아래와 같이 String으로 표현할때 
		 "(더블)의 중복사용으로 에러가 나면 이스케이프 시퀀스를 이용하는 방법과 
		 '(싱글)로 변경하는 두가지 방법이 있다.
		 */
		String str = "" 
				+ "<script>" 
				+ " alert('" + msg + "');" 
				+ "	location.href='" + url + "';" 
				+ "</script>";

		return str;
	}

	public static void jsAlertBack(String msg, JspWriter out) {
		try {
			String str = "" 
					+ "<script>" 
					+ " alert('" + msg + "');" 
					+ "	history.back();" 
					+ "</script>";

			out.println(str);
		} catch (Exception e) {}
	}	
}

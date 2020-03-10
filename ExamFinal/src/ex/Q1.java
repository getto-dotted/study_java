package ex;

import java.util.Calendar;

public class Q1 {

	public static void main(String[] args) {
		int year = 1988;
		Calendar today = Calendar.getInstance();   
		int cyear = today.get(Calendar.YEAR);
		int age = cyear - year;
		System.out.println("나의 나이 : " +age);
		System.out.println("나의 출생연도 : " +year);
		
	}

}

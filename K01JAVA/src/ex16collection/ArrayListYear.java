package ex16collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListYear {

	public static void main(String[] args) {
		
		ArrayList listJa = new ArrayList();
		
		listJa.add("신");
		listJa.add("유");
		listJa.add("술");
		listJa.add("해");
		listJa.add("자");
		listJa.add("축");
		listJa.add("인");
		listJa.add("묘");
		listJa.add("진");
		listJa.add("사");
		listJa.add("오");
		listJa.add("미");
		
		
		ArrayList listGab = new ArrayList();
		
		listGab.add("경");
		listGab.add("신");
		listGab.add("임");
		listGab.add("계");
		listGab.add("갑");
		listGab.add("을");
		listGab.add("병");
		listGab.add("정");
		listGab.add("무");
		listGab.add("기");
		

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("연도를 입력하세요 : ");
			int year = sc.nextInt();
			int yearJa = year%12;
			int yearGab = year%10;
			System.out.print("입력하신 연도는 ");
			System.out.print(listGab.get(yearGab));
			System.out.print(listJa.get(yearJa));
			System.out.println("년 입니다.");
			System.out.println();
		}
		
	}

}

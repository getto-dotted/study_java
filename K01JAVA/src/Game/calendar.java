package Game;

import java.util.Scanner;

public class calendar {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void calendarMaking() {
		
		System.out.println("연도를 입력하세요 : ");
		int yearNum = scan.nextInt();
		
		boolean yoon = false;		
		if(yearNum%4==0) {
			yoon=true;
		}
		
		int weekNum=0;
		
		switch(yearNum%28) {
		case 1: case 7: case 18: case 24:
			weekNum =0;
			break;
		case 2: case 8: case 13: case 19:
			weekNum =1;
			break;
		case 3: case 14: case 20: case 25:
			weekNum =2;
			break;
		case 4: case 9: case 15: case 26:
			weekNum =3;
			break;
		case 10: case 16: case 21: case 27:
			weekNum =4;
			break;
		case 0: case 5: case 11: case 22:
			weekNum =5;
			break;
		case 6: case 12: case 17: case 23: 
			weekNum =6;
			break;
		}
		
		int date;
		int totalDate=0;
		int gap = weekNum;
		
		for(int month=1; month<=12; month++) {
		
			int monthLength;
			
			switch(month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				monthLength=31;
				break;
			case 4: case 6: case 9: case 11:
				monthLength=30;
				break;
			default:
				if(yoon==true) {
					monthLength=29;
					break;
				}
				else {
					monthLength=28;
					break;
				}
			}
			System.out.println();
			System.out.println();
			System.out.printf("%25s", ""+month+"월\n\n");			
			System.out.printf("%8s일%7s월%7s화%7s수%7s목%7s금%7s토", "", "", "", "", "", "", "");
			System.out.println();
			
			
			
			while(gap>0) {
				System.out.printf("%6s","");
				gap--;
			}			
			for(date=1; date<=monthLength; date++) {				
				System.out.printf("%6d",date);
				if((date+totalDate)%7==(7-weekNum)) {
					System.out.println();
				}				
			}
			totalDate+=monthLength;		
			gap=(totalDate)%7+weekNum;	
			if(gap>=7) {
				gap=gap%7;
			}					
		}
	}//캘린더 메소드 끝	
	public static void main(String[] args) {
		
		try {
			calendarMaking();
		}
		catch(Exception e) {
			System.out.println("올바른 연도를 입력해 주세요.");
		}

	}//메인끝

}

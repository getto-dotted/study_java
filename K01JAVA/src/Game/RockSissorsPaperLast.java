package Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RockSissorsPaperLast {
	
	
	public static void threeGame() {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		
		int cnt=0;
		int cWin=0;
		int pWin=0;
		
		
		while(true) {
			
			
			int com = (int)(Math.random()*3)+1;
			System.out.print("가위 바위 보! : ");
			
			int player = sc.nextInt();
					
			if( !(player<1 || player>3) ) {
				
				System.out.printf("\n사용자:%s, 컴퓨터:%s \n\n",
						displayRPS(player), displayRPS(com));
				
				
				switch(player - com) {
				case 0:
					System.out.println("비겼습니다.");break;
				case 1: case -2:
					System.out.println("이겼습니다!");pWin++;break;
				case -1: case 2:
					System.out.println("졌습니다...");cWin++;break;
				}
				cnt++;
				
			}
			else {
				System.out.println("가위바위보 할줄 모름??");
			}
			
			
			System.out.printf("\n게임진행 횟수 : %d, 플레이어 승리 횟수 : %d, 컴퓨터 승리 횟수 : %d\n", cnt, pWin, cWin);
			System.out.println();
			
			if(cnt>=5) {
				
				String restart;
				while(true) {
					restart = sc.nextLine();
					System.out.print("종료하시겠습니까? y/n:");
					if(restart.equals("y") || restart.equals("n")) {
						//정상입력이면 루프탈출
						break;
					}
					else {
						System.out.println("y/n");
					}
				}								
				if(restart.equals("y")) {
					//게임종료를 위해 while루프 탈출
					break;
				}
				else {
					System.out.println("게임을 속행합니다");
					cnt=0;
				}
			}

//			if(cnt%5==0) {
//				System.out.println("종료하시겠습니까? y/n");
//				String exit = sc1.nextLine();						
//				if(exit.equals("y")) {
//					System.out.println("게임을 종료합니다.");	
//					System.exit(0);
//					break;		
//				}				
//				else {
//					System.out.println("게임을 속행합니다.");
//				}					
//				
//			}
			
		}
	}
	public static String displayRPS(int n) {
		String str = "";
		switch (n) {
		case 1:
			str = "가위";break;
		case 2:
			str = "바위";break;
		case 3:
			str = "보";break;
		}
		return str;
	}
	
	public static void main(String[] args) {

		while(true) {
				try {
					threeGame();
				}
				catch(InputMismatchException e){
//				e.printStackTrace();
//				System.out.println(e.getMessage());
//				Scanner sc = new Scanner(System.in);
//				sc.nextLine(); <----버퍼에 남아있는 엔터키 제거(소멸시킴)
					System.out.println("1,2,3중에 선택하여 주세요.");
					System.out.println();			
				}
		}
		
	}
}

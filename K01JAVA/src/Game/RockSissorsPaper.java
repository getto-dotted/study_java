package Game;

import java.util.Scanner;

public class RockSissorsPaper {
	
	
	public static void main(String[] args) {

		
			Scanner sc = new Scanner(System.in);
			Scanner sc1 = new Scanner(System.in);
			
			int cnt=0;
			int cWin=0;
			int pWin=0;
			
			
			while(true) {
				
				
				int com = (int)(Math.random()*3)+1;
				System.out.print("가위 바위 보! : ");
				
				int player = sc.nextInt();
						
				if(player-com==0) {
					System.out.println("비겼습니다.");					
				}
				else if(player-com==2||player-com==-1){
					System.out.println("컴퓨터의 승리!");
					cWin++;
				}
				else if(player-com==1||player-com==-2) {
					System.out.println("승리하셨습니다!");
					pWin++;
				}			
			
				
				cnt++;
				
				System.out.printf("게임진행 횟수 : %d, 플레이어 승리 횟수 : %d, 컴퓨터 승리 횟수 : %d\n", cnt, pWin, cWin);
				System.out.println();
				
				if(cnt%5==0) {
					System.out.println("종료하시겠습니까? y/n");
					String exit = sc1.nextLine();						
					if(exit.equals("y")) {
						System.out.println("게임을 종료합니다.");	
						System.exit(0);
						break;		
					}				
					else {
						System.out.println("게임을 속행합니다.");
					}					
					
				}
				
			}
		}
		
	}


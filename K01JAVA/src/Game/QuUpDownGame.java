package Game;
import java.util.Scanner;
/*
게임설명 : 업다운게임을 메소드를 이용해 구현한다.
컴퓨터는 1~100사이의 숫자 하나를 생성한다.
총 시도횟수는 7번을 부여한다.
사용자는 7번의 시도안에 숫자를 맞춰야 한다.
사용자가 숫자를 입력했을때 컴퓨터는 높은지/낮은지 알려준다.
7번안에 맞추면 성공, 맞추지 못하면 실패라고 출력한다.
성공/실패 후 계속 할지를 물어보고 1이면 게임 재시작, 0이면 프로그램을 종료한다.
함수를 사용하여 구현한다.
무한루프에 빠지게 된다면 scan.nextLine()을 활용하여 버퍼에 남아있는 Enter키를 제거해주도록 하자.
 */
/*
class OutOfRange100Exception extends Exception{
	public OutOfRange100Exception() {
		super("[예외발생] 1~100사이의 숫자를 입력하세요");
	}
}
try {
	if(if(guess>100||guess<0)) {
		OutOfRange100Exception outExc = new OutOfRange100Exception();
		throw outExc;
	}
}
catch(outExc){
	
}

*/



public class QuUpDownGame {

	public static void upDown() {				
		int restart =7;
		int correctAnswer = (int) (Math.random()*100)+1;			
		
		while(true) {	
			
			Scanner sc = new Scanner(System.in);
			System.out.println("1~100까지의 숫자중 정답은? :");
			
			int guess = sc.nextInt();
			
			if(guess>100||guess<0) {
				System.out.println("1~100사이의 숫자를 입력해주세요.");
				System.out.printf("남은 도전 횟수: %d회\n", restart);
			}
			else {					
				if(correctAnswer==guess) {
					System.out.println("정답입니다!\n");	
					String exit;
					while(true) {
						exit = sc.nextLine();
						System.out.println("다시 도전하시겠습니까? y/n");						
						if(exit.equals("y") || exit.equals("n")) {						
							break;
						}						
					}								
					if(exit.equals("n")) {		
						System.out.println("게임을 종료합니다.");
						System.exit(0);
						break;
					}
					else {
						System.out.println("게임에 재도전합니다");
						correctAnswer = (int) (Math.random()*100)+1;
						restart=7;
					}
				}
				else if(correctAnswer>guess) {
					System.out.println("정답은 "+ guess +" 보다 큰 수 입니다.");
					restart--;
					System.out.printf("남은 도전 횟수: %d회\n\n", restart);				
				}
				else if(correctAnswer<guess) {
					System.out.println("정답은 "+ guess +" 보다 작은 수 입니다.");
					restart--;
					System.out.printf("남은 도전 횟수: %d회\n\n", restart);
				}
			}
			if(restart==0) {
				System.out.println("도전에 실패했습니다.");
				String exit;
				while(true) {
					exit = sc.nextLine();
					System.out.println("다시 도전하시겠습니까? y/n");
					if(exit.equals("y") || exit.equals("n")) {						
						break;
					}
				}								
				if(exit.equals("n")) {	
					System.out.println("게임을 종료합니다.");
					System.exit(0);
					break;
				}
				else {
					System.out.println("게임에 재도전합니다\n");
					correctAnswer = (int) (Math.random()*100)+1;
					restart=7;
				}
			}				
		}		
	}	
	
	public static void main(String[] args) {
		
		while(true) {
			try {
				upDown();
			}
			catch(Exception e) {
				System.out.println("1~100사이의 숫자를 입력해 주세요.\n");				
			}
		}		
	}
}

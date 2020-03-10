package ex;

public class Q2 {
	public static void main(String[] args) {		
		int j = 1;
		int cnt=0;
		int cnt2=0;
		
		for(int i=1; i<=1000; i++) {
			if(i%2==0 && i%5!=0) {
				cnt +=i;
			}
			if(i%5==0 && i%2!=0) {
				cnt +=i;
			}			
		}				
		while(j<=1000) {
			if(j%2==0 && j%5!=0) {
				cnt2 +=j;
			}
			if(j%5==0 && j%2!=0) {
				cnt2 +=j;
			}		
			j++;
		}
		System.out.println(cnt);
		System.out.println(cnt2);
	}
	
}

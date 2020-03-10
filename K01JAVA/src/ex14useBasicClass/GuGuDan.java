package ex14useBasicClass;

public class GuGuDan {

	public static void main(String[] args) {

		int i;
		int x;
		int y;
		int k;
		
		for(x=2; x<=9; x++) {
			System.out.println();
			k=1;
			for(y=1; y<=9; y++) {
				k*=x;
				for(i=1; i<y; i++) {
				System.out.print(x+"x");
				}
				System.out.println(x+"="+k);
			}
		}
		
	}

}

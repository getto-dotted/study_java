package ex10AccessModifier;

public class Contack600 {
	//멤버변수
	SneezeCap sneeze= new SneezeCap();
	SinivelCap sinivel= new SinivelCap();
	SnuffleCap snuffle= new SnuffleCap();
			
	//멤버메소드
	public void take() {
		/*
		처방된 약의 복용순서를 지켜 메소드를 각인
		콧물 ->기침 ->코막힘
		 */
		sinivel.take();
		sneeze.take();
		snuffle.take();
		
	}
	
}

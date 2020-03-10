package review.mycar;

public class BlackBox {

	String mCapacity;
	
	public BlackBox(String c) {
		this.mCapacity =c;
	}
	
	public void showBoxInfo() {
		System.out.println("블랙박스의 메모리용량: "+mCapacity);
		System.out.println("주행 영상을 녹화합니다.");
	}
}

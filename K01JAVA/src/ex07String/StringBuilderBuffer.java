package ex07String;

/*
StringBuffer 클래스
	: String클래스는 내부 메소드를 이용해서 새로운 문자열을 생성하면 원래 문자열은 변하지 않고 새롭게 생성된 메모리에
	문자열이 저장된다. 이런 메모리의 낭비를 막기위해서 StringBuffer클래스를 사용한다. 해당 클래스는 새로운 메모리를
	사용하지 않고 기존 메모리를 변경하는 형태로 문자열을 변경하게 된다.
 */
public class StringBuilderBuffer {

	public static void main(String[] args) {
		
	StringBuffer strBuf = new StringBuffer("AB");
	strBuf.append(25);
	strBuf.append("Y").append(true);
	System.out.println("strBuf="+strBuf);
	
	strBuf.insert(2,  false);
	strBuf.insert(strBuf.length(), 'Z');
	System.out.println("strBuf="+strBuf);
	
		
		

	}

}

package ex16collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import common.Student;

public class ArrayList2 {

	public static void main(String[] args) {
		/*
		List계열의 컬렉션 생성. Student객체를 저장할 수 있음.
		ArrayList<Student> list2 = new ArrayList<Student>();
		ArrayList와 LinkedList의 멤버메소드가 완전히 동일하므로 별도의 변경이 필요없다.
		단지 내부적으로 데이터를 처리하는 방식(자료구조)만 다르다.
		데이터의 참조는 ArrayList가 훨씬 빠르므로 일반적으로 많이 사용한다.
		*/
		LinkedList<Student> list2 = new LinkedList<Student>();
				
		//외부패키지에 정의된 Student클래스를 객체화 함.
		Student st1 = new Student("정우성", 10, "2018");
		Student st2 = new Student("원빈", 20, "2017");
		Student st3 = new Student("장동건", 30, "2016");
		Student st4 = new Student("공유", 40, "2015");
		
		//컬렉션에 객체 추가
		list2.add(st1);//index:0
		list2.add(st2);
		list2.add(st3);
		list2.add(st4);
		list2.add(st2);
		//객체의 중복저장 : List 계열의 컬렉션은 중복저장을 허용한다.		
		
		
		//foreach문을 통해 컬렉션 내용 출력
		System.out.println("[중복저장후]");
		for(Student st : list2) {
			st.showInfo();
		}
		
		
		//객체삭제 : 동일한 객체가 2개이상 저장된 경우에는 앞쪽 인덱스인 하나만 삭제된다.
		
		list2.remove(st2);
		System.out.println("[중복 저장된 객체 삭제후]");
		for(Student st : list2) {
			st.showInfo();
		}
		System.out.println("[반복자 사용]");
		Iterator<Student> it2 = list2.iterator();
		while(it2.hasNext()) {
//			Student student = it2.next();
//			student.showInfo();
			
//			위와 동일한 문장임. 참조값을 통해 멤버접근
			it2.next().showInfo();
		}
		System.out.println("[일반 for문 사용]");
		for (int i = 0; i < list2.size(); i++) {
//			List계열의 컬렉션은 인덱스를 통해 접근하는 것이 가능함. 이때 get()메소드를 사용한다.
			list2.get(i).showInfo();
		}		
		System.out.println("[확장 for문 사용]");
		for(Student st : list2) {
			st.showInfo();
		}
//		remove()를 통해 객체를 삭제하면 삭제된 객체의 참조값을 반환한다.
		System.out.println("삭제된 객체의 이름:"+list2.remove(2).getName());//공유 객체 삭제
		list2.remove(st1);//정우성 객체 삭제
		
		System.out.println("[인스턴스 삭제후]");
		for(Student st : list2) {
			st.showInfo();
		}				
		
	}
}

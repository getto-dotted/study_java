package ex16collection;

import java.util.HashSet;
import java.util.Iterator;

import common.Person;

public class HashSet02 {

	public static void main(String[] args) {

		/*
		Set<T> 컬렉션은 새로운 객체가 입력될때 클래스에 오버라이딩된 hashCode(), equals()메소드를 통해 
		동일한 객체가 있는지를 판단하게 되고, 동일한 객체가 없을때만 추가한 후 true를 반환한다.
		 */
		HashSet<Person> set = new HashSet<Person>();
		
		Person p1 = new Person("정우성", 30);
		Person p2 = new Person("장동건", 40);
		Person p3 = new Person("정우성", 30);
		Person p4 = new Person("장동건", 30);
		
		set.add(p1);
		set.add(p2);
		System.out.println(set.add(p3));//false반환됨
		System.out.println(set.add(p4));
		System.out.println(set.add(p4));
		System.out.println(set.add(p4));
		System.out.println("hashCode 오버라이딩 후 데이터 수:"+set.size());
		
		
		//저장된 데이터 출력하기
		Iterator<Person> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().getInfo());
		}
		
	}

}

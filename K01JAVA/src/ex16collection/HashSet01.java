package ex16collection;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import common.Teacher;
/*
HashSet : Set계열의 인터페이스를 구현한 컬렉션으로 객체가 순서없이 저장된다.
		객체의 중복저장이 허용되지 않는다. 단, 기본클래스가 아닌 새롭게 정의한 클래스라면
			hashCode, equals메소드를 적절히 오버라이딩해야 한다.
		List는 배열의 성격을 띄고, Set은 집합의 성격을 가진다.
 */
public class HashSet01 {

	public static void main(String[] args) {

		/*
		1]set컬렉션 생성
				: 생성시 제네릭 타입을 지정하지 않거나, Object로 지정하면 모든 객체를 저장할 수 잇는 컬렉션이 된다.
		 */
		HashSet<Object> set = new HashSet<Object>();
		//2] 다양한 객체 생성
		String strObject1 = "JAVA";
		String strObject2 = new String("KOREA51기");
		Date dateObject = new Date();
		int number = 100;
		Teacher teacher = new Teacher("김봉두", 55, "체육");
		
		/*
		3]컬렉션에 객체저장 - boolean add(객체)
			: 정상적으로 저장되면 true를 반환한다.
		 */
		
		System.out.println(set.add(strObject1));//true반환
		set.add(strObject2);
		set.add(dateObject);
		set.add(number);
		set.add(teacher);
		
		/*
		4]컬렉션에 저장된 객체수 얻기
		 */
		System.out.println("[중복저장전 객체수]:"+set.size());//5개
		
		/*
		5-1]중복저장
		 */
		System.out.println(set.add(strObject2)?"저장성공":"저장실패");
		//중복된 객체이므로 저장실패 처리됨.
		System.out.println("[중복(String)저장후 객체수]:"+set.size());//5개
		
//		System.out.println(set.add("JAVA")?"저장성공":"저장실패");
//		중복된 객체이므로 저장실패 처리됨.
//		System.out.println("[중복(String)저장후 객체수]:"+set.size());//5개
		
		/*
		5-2]사용자가 생성한 객체 중복저장
		 */
		Teacher teacher2 = new Teacher("김봉두", 55, "체육");
		System.out.println(set.add(teacher2)?"성공":"실패");
		//동일한 정보를 가진 객체이지만 사용자가 정의한 클래스의 객체이므로 중복저장됨.
		//중복을 확인하기 위해서 hashCode, equals메소드의 오버라이딩이 필요함.
		System.out.println("[중복(teacher2)]저장후 객체수:"+set.size());//6개
		
		/*
		6] 저장된 객체 꺼내오기 : 순서없이 저장되므로 출력도 순서를 지정할 수 없다.
		 */
		Iterator itr = set.iterator();
		while(itr.hasNext()) {
			Object object = itr.next();
			/*
			저장된 모든객체는 Object타입으로 형변환되어 저장되므로 출력할때는 어떤 타입의 객체인지를 instanceof 연산자를 통해 확인해야 한다.
			 */
			if(object instanceof String) {
				System.out.println("String타입:"+object);
			}
			else if(object instanceof Date) {
				System.out.println("Date타입:"+object);
			}
			else if(object instanceof Integer) {
				System.out.println("Integer타입:"+object);
			}
			else if(object instanceof Teacher) {
				System.out.println("Teacher타입:"+((Teacher)object).getInfo());
			}
			else {
				System.out.println("넌 뭐임??-_-;");
			}
		}
			
			//1-7]존재유무확인 : boolean contains(Object e)
			System.out.println(set.contains(strObject1)?
					"strObject1있다":"strObject1없다");
			System.out.println(set.contains(number)?
					"number있다":"number없다");
			System.out.println(set.contains("JaVa")?
					"JaVa있다":"JaVa없다");
			
			//1-8]삭제 : boolean remove(Object e)
			System.out.println(set.remove(strObject2)?
					"strObject2삭제성공":"strObject2삭제실패");
			System.out.println(set.remove("Android")?
					"Android삭제성공":"Android삭제실패");
			System.out.println("[삭제 후 객체수]"+set.size());
			
			//1-9]전체삭제
//			set.clear();
			System.out.println("전체삭제:"+set.removeAll(set));
			System.out.println("[전체삭제후 객체수]:"+set.size());
		}//end of while
				
	}
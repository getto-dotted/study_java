package ex16collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
HashMap<K,V>
	:Map<T> 인터페이스를 구현한 컬렉션 클래스로 key, Value의 쌍으로 객체를 구성한다.
	키값은 중복될 수 없다. 만약 중복될경우 덮어쓰기가 된다. 즉 기존값이 삭제된다.
	키값으로 검색하기 때문에 다른 컬렉션보다 속도가 빠르다.
 */
public class HashMapMain {

	public static void main(String[] args) {

		/*
		1.Map 컬렉션 객체 생성
		 */
		HashMap<String, String> map = new HashMap<String, String>();
		
		/*
		2.객체저장
			:String put(키,밸류);
			여기서 반환되는 값은 String타입으로 해당 키값으로 저장된 이전객체의 value값이 반환된다.
			만약 이전에 저장된 객체가 없다면 null이 반환된다.
		 */
		
		System.out.println("name이라는 키값으로 저장된 이전의 값:"+map.put("name", "홍길동")); //->null반환됨
		
		int number = 20;
//		map.put("age", number);->에러발생. value타입 틀림
		map.put("age", String.valueOf(number));
//		Integer객체를 String타입으로 변경후 입력함
		map.put("gender", "남자");
		map.put("address", "신도림역2번출구");
		
		/*
		3.객체수
		 */
		System.out.println("저장된 객체수:"+map.size());
		
		/*
		4.중복저장
		 */
		System.out.println("name이라는 키값으로 저장된 이전의 값:"+map.put("name", "최길동"));
		//put()메소드 실행후 반환되는 값은 기존의 값"홍길동:/ 실제 입력되는 값은 "최길동"
		System.out.println("키값으로 중복저장후 객체수:"+map.size());
		
		/*
		5]출력
		5-1]키값을 알고 있을때 출력하기 : get(키값)
		 */
		
		System.out.println("키값을 알때:"+map.get("name"));
		
		/*
		5-2]키값을 모를때 출력하기 
			Set<T> KeySet()메소드 호출을 통해 키값을 Set 계열의 컬렉션형태로 반환한다.
			Map계열의 컬렉션은 처음부터 확장for문을 사용하는 것이 불가능하고, 키값을 얻어온 후 사용해야 한다.
		 */
		Set<String> keys = map.keySet();
		System.out.println("[확장for문 적용]");
		for(String key: keys) {
			String value = map.get(key);
			System.out.println(String.format("%s:%s", key, value));
		}			
			/*
			5-3]반복자를 통한 출력
				:Iterator를 사용할 때도 keySet()으로 키값을 먼저 얻어온 후 출력할 수 있다.
			 */
			
		System.out.println("[반복자 사용하기]");
		Set<String> keys2 = map.keySet();
		Iterator<String> it = keys2.iterator();
		while(it.hasNext()) {
			//키값얻기
			String key = it.next();
			//키값으로 밸류값얻기
			String value = map.get(key);
			System.out.println(String.format("%s:%s", key, value));
		}
		
		/*
		5-4] Value값만 얻어올때 : values()메소드 사용
		 */
		System.out.println("[value값들만 출력하기]");
		Collection<String> values = map.values();
		for (String value : values) {
			System.out.println(value);
		}
		
		/*
		6]존재유무확인 : 해당 key 혹은 value의 존재유무만 확인할 수 있다.
					존재할 경우 true 반환
		 */
		System.out.println(map.containsKey("name")? "name키값있다":"name키값없다");
		System.out.println(map.containsKey("account")? "account키값있다":"account키값없다");
		System.out.println(map.containsValue("남자")? "남자있다":"남자 없다");
		System.out.println(map.containsValue("여자")? "여자있다":"여자없다");
		
		/*
		7]삭제 : 삭제가 완료되면 삭제된 key값에 해당하는 value가 반환된다
		 */
		
		System.out.println("삭제된객체:"+map.remove("age"));
		System.out.println("[age키값을 삭제후 출력]");
		for (String key : keys) {
			System.out.println(String.format("%s:%s", key, map.get(key)));
		}
		
		//8] 전체삭제 : removeAll()은 없음
		
		map.clear();
		
		System.out.println("전체삭제후 객체수 :"+map.size());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
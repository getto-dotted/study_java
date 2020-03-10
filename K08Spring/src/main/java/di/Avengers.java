package di;
/*
DTO(Data Transfer Object), VO(Value Object)
: 특정한 처리를 하기위한 비즈니스로직은 없고 단순히
데이터를 저장하기 위한 용도의 빈(객체)을 뜻한다.
 */
public class Avengers {

	private String name;
	private String heroName;
	private String ability;
	private String age;
	
	public Avengers() {}

	public Avengers(String name, String heroName, String ability, String age) {
		super();
		this.name = name;
		this.heroName = heroName;
		this.ability = ability;
		this.age = age;
	}
	//생성자가 setter의 역할을 대신함
	public String getName() {
		return name;
	}

	public String getHeroName() {
		return heroName;
	}

	public String getAbility() {
		return ability;
	}

	public String getAge() {
		return age;
	}

	
	
}

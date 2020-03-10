package model;

public class StudentDTO {
	private String name;
	private String age;
	private String gradeNum;
	private String classNum;
	
	//인자생성자를 정의하지 않으면 디폴트 생성자가
	//자동으로 정의된다.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGradeNum() {
		return gradeNum;
	}
	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	
	
}

package model;

import java.sql.Date;
/*
DTO(Data Transfer Object) : 계층간의 데이터 전달을 위해 사용하는
	데이터객체로 로직은 전혀 가지고 있지 않으며, 각 멤버변수에
	접근하기 위한 getter/setter메소드만 가진 클래스를 의미한다.
 */
public class MemberDTO {
	//멤버변수
	private String id;
	private String pass;
	private String name;
	private java.sql.Date regidate;
	//getter/setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public java.sql.Date getRegidate() {
		return regidate;
	}
	public void setRegidate(java.sql.Date regidate) {
		this.regidate = regidate;
	}
	
	public MemberDTO() {}//기본생성자
	public MemberDTO(String id, String pass, String name, Date regidate) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = regidate;
	}//인자생성자
	
	
	
}

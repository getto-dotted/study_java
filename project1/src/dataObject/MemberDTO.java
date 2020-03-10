package dataObject;

public class MemberDTO {
	private String id;
	private String pass;
	private String name;
	private String tel;
	private String mobile;
	private String email;
	private String zipcode;
	private String addr;
	private String addr2;
	private int email_open;
	private int grade;
	
	
	public MemberDTO() {}

	

	public MemberDTO(String id, String pass, String name, String tel, String mobile, String email, String zipcode,
			String addr, String addr2, int email_open, int grade) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.tel = tel;
		this.mobile = mobile;
		this.email = email;
		this.zipcode = zipcode;
		this.addr = addr;
		this.addr2 = addr2;
		this.email_open = email_open;
		this.grade = grade;
	}
	


	public String getAddr2() {
		return addr2;
	}



	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}



	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getEmail_open() {
		return email_open;
	}

	public void setEmail_open(int email_open) {
		this.email_open = email_open;
	}

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}

package model;

import java.sql.Date;

public class BbsDTO {
	// 멤버변수(필드, 컬럼)
	private String num;
	private String title;
	private String content;
	private java.sql.Date postdate;
	private String id;
	private String visitcount;

	public BbsDTO(String num, String title, String content, Date postdate, String id, String visitcount) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.postdate = postdate;
		this.id = id;
		this.visitcount = visitcount;
	}

	public BbsDTO() {
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.sql.Date getpostdate() {
		return postdate;
	}

	public void setpostdate(java.sql.Date postdate) {
		this.postdate = postdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVisitcount() {
		return visitcount;
	}

	public void setVisitcount(String visitcount) {
		this.visitcount = visitcount;
	}
	
	

}

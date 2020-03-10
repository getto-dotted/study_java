package controller;

import java.sql.Date;

public class DataRoomDTO {
	
	//멤버변수
	private String idx; 
	private String name;
	private String title;
	private String content;
	private java.sql.Date postdate;
	private String ofile;//원본파일명
	private String sfile;//저장된파일명
	private int downcount;
	private String pass;
	private int visitcount;
	
	public DataRoomDTO() {}
	
	public DataRoomDTO(String idx, String name, String title, String content, Date postdate, String ofile, String sfile,
			int downcount, String pass, int visitcount) {		
		this.idx = idx;
		this.name = name;
		this.title = title;
		this.content = content;
		this.postdate = postdate;
		this.ofile = ofile;
		this.sfile = sfile;
		this.downcount = downcount;
		this.pass = pass;
		this.visitcount = visitcount;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getOfile() {
		return ofile;
	}

	public void setOfile(String ofile) {
		this.ofile = ofile;
	}

	public String getSfile() {
		return sfile;
	}

	public void setSfile(String sfile) {
		this.sfile = sfile;
	}

	public int getDowncount() {
		return downcount;
	}

	public void setDowncount(int downcount) {
		this.downcount = downcount;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getVisitcount() {
		return visitcount;
	}

	public void setVisitcount(int visitcount) {
		this.visitcount = visitcount;
	}	
}

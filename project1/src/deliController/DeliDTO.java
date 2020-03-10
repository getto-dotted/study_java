package deliController;

import java.util.Date;

public class DeliDTO {
		
	private String pid;
	private String id;
	private String idx;
	private String oprice;
	private String cstock;	
	private String purc;	
	private String name;
	private String info;
	private String ofile;
	private String sfile;
	private String price;
	private String dispoint;
	private String stock;	
	private String deliv;
	private String dprice;
	private java.util.Date postdate;
	private String sellcnt;
	private String etc;
	
	public DeliDTO() {}

	

	public DeliDTO(String pid, String id, String idx, String oprice, String cstock, String purc, String name,
			String info, String ofile, String sfile, String price, String dispoint, String stock, String deliv,
			String dprice, Date postdate, String sellcnt, String etc) {
		super();
		this.pid = pid;
		this.id = id;
		this.idx = idx;
		this.oprice = oprice;
		this.cstock = cstock;
		this.purc = purc;
		this.name = name;
		this.info = info;
		this.ofile = ofile;
		this.sfile = sfile;
		this.price = price;
		this.dispoint = dispoint;
		this.stock = stock;
		this.deliv = deliv;
		this.dprice = dprice;
		this.postdate = postdate;
		this.sellcnt = sellcnt;
		this.etc = etc;
	}

	

	public String getPid() {
		return pid;
	}



	public void setPid(String pid) {
		this.pid = pid;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getOprice() {
		return oprice;
	}

	public void setOprice(String oprice) {
		this.oprice = oprice;
	}

	public String getCstock() {
		return cstock;
	}

	public void setCstock(String cstock) {
		this.cstock = cstock;
	}

	public String getPurc() {
		return purc;
	}

	public void setPurc(String purc) {
		this.purc = purc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDispoint() {
		return dispoint;
	}

	public void setDispoint(String dispoint) {
		this.dispoint = dispoint;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getDeliv() {
		return deliv;
	}

	public void setDeliv(String deliv) {
		this.deliv = deliv;
	}

	public String getDprice() {
		return dprice;
	}

	public void setDprice(String dprice) {
		this.dprice = dprice;
	}

	public java.util.Date getPostdate() {
		return postdate;
	}

	public void setPostdate(java.util.Date postdate) {
		this.postdate = postdate;
	}

	public String getSellcnt() {
		return sellcnt;
	}

	public void setSellcnt(String sellcnt) {
		this.sellcnt = sellcnt;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	
	
	

}

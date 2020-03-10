package prodController;

import java.util.Date;

public class ProdDTO {
	
	private String idx;
	private String name;
	private String info;
	private String ofile;
	private String sfile;
	private String price;
	private String dispoint;
	private String stock;
	private String cstock;
	private String deliv;
	private String dprice;
	private java.util.Date postdate;
	private String sellcnt;
	private String etc;
	
	public ProdDTO() {}

	public ProdDTO(String idx, String name, String info, String ofile, String sfile, String price, String dispoint,
			String stock, String cstock, String deliv, String dprice, Date postdate, String sellcnt, String etc) {
		super();
		this.idx = idx;
		this.name = name;
		this.info = info;
		this.ofile = ofile;
		this.sfile = sfile;
		this.price = price;
		this.dispoint = dispoint;
		this.stock = stock;
		this.cstock = cstock;
		this.deliv = deliv;
		this.dprice = dprice;
		this.postdate = postdate;
		this.sellcnt = sellcnt;
		this.etc = etc;
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

	public String getCstock() {
		return cstock;
	}

	public void setCstock(String cstock) {
		this.cstock = cstock;
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

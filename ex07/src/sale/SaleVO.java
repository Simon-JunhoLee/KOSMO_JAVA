package sale;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import product.ProductVO;

public class SaleVO extends ProductVO{
	private int seq;
	private String code;
	private String sale_date;
	private int price;
	private int cnt;
	
	public SaleVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SaleVO(int seq, String code, String sale_date, int price, int cnt) {
		super();
		this.seq = seq;
		this.code = code;
		this.sale_date = sale_date;
		this.price = price;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###원");
		String fmtPrice = df.format(price);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일");
//		String sdfDate = sdf.format(sale_date);
		return "판매일 : " + getSale_date() + "\t| 상품코드 : " + code  + "\t| 상품명 : " + getName()+ "\t| 판매수량 : " + cnt
				+ "개\t| 매출액 : " + fmtPrice;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSale_date() {
		return sale_date;
	}
	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}

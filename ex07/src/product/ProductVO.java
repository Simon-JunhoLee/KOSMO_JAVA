package product;

import java.text.DecimalFormat;

public class ProductVO {
	private String code;
	private String name;
	private int price;
	
	public ProductVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductVO(String code, String name, int price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###원");
		String fmtPrice = df.format(price);
		return "상품코드 : " + code + " | 상품명 : " + name + "\t| 상품단가 : " + fmtPrice;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}

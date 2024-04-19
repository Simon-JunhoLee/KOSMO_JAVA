package sale;

public class Sale {
	private int code;
	private String name;
	private int price;
	private int cnt;
	
	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sale(int code, String name, int price, int cnt) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "Sale [code=" + code + ", name=" + name + ", price=" + price + ", cnt=" + cnt + "]";
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}

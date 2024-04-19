package pm;

public class Sale {
	// 필드
	private String code;
	private String name;
	private int price;
	private int cnt;

	// 생성자
	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sale(String code, String name, int price, int cnt) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	
	public int sum() {
		int sum = price * cnt;
		return sum;
	}
	
	// 내용 가로 출력
	public void print_land() {
		System.out.printf("%s\t%s\t%,d원\t%d개\t%,d원\n", code, name, price, cnt, sum());
	}
	
	// 내용 세로 출력
	public void print_port() {
		System.out.printf("상품명 : %s\n", name);
		System.out.printf("가격 : %,d원\n", price);
		System.out.printf("수량 : %,d개\n", cnt);
		System.out.printf("금액 : %,d원\n", sum());
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}

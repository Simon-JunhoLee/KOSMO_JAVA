package am;

public class Student {
	// 필드(속성)
	String no;
	String name;
	String address;
	String phone;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(String no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public Student(String no, String name, String address, String phone) {
		super();
		this.no = no;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public void print() {
		System.out.printf("학번 : %s\n이름 : %s\n주소 : %s\n전화번호 : %s\n", no, name, address, phone);
	}

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}

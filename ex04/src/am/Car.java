package am;

import java.util.Date;

public class Car {
	// 필드
	private String company;
	private String model;
	private String color;
	private int distance;
	private Date date;
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Car(String company, String model, String color, int distance, Date date) {
		super();
		this.company = company;
		this.model = model;
		this.color = color;
		this.distance = distance;
		this.date = date;
	}

	public void print() {
		System.out.println("회사명 : " + company);
		System.out.println("모델명 : " + model);
		System.out.println("색상 : " + color);
		System.out.println("주행거리 : " + distance);
		System.out.println("연식 : " + date);
	}
	
	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", distance=" + distance
				+ ", date=" + date + "]";
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}

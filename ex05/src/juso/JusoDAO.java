package juso;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JusoDAO {	// DAO : Data Access Object
	File file = new File("C:/data/java/ex05/juso.txt");
	// 주소삭제
	public void delete(int no) {
		ArrayList<Juso> array = new ArrayList<>();
		try {
			Juso juso = new Juso();
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			String lines = "";
			while((line = reader.readLine()) != null) {
				String[] items = line.split(",");
				if(Integer.parseInt(items[0]) != no) {				
//					System.out.println(line);
					lines = lines + line + "\n";
				}
			}
			FileWriter writer = new FileWriter(file, false);
			writer.write(lines);
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("정보삭제 : " + e.toString());
		}
	}
	
	// 주소등록
	public void insert(Juso juso) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(juso.getNo() + "," + juso.getName() + "," + juso.getPhone() + "," + juso.getAddress() + "\n");
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("정보등록 : " + e.toString());
		}
	}
	
	// 이름조회
	public Juso read(String name) {
		Juso juso = new Juso();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = reader.readLine()) != null) {
				String[] items = line.split(",");
				
				if(items[1].equals(name) || items[0].equals(name)) {
					juso.setNo(Integer.parseInt(items[0]));
					juso.setName(items[1]);
					juso.setPhone(items[2]);
					juso.setAddress(items[3]);	
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("이름조회 : " + e.toString());
		}
		return juso;
	}
	
	// 주소목록
	public ArrayList<Juso> list() {
		ArrayList<Juso> array = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = reader.readLine()) != null) {
				String[] items = line.split(",");
				Juso juso = new Juso();
				juso.setNo(Integer.parseInt(items[0]));
				juso.setName(items[1]);
				juso.setPhone(items[2]);
				juso.setAddress(items[3]);
				
				array.add(juso);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("주소목록 : " + e.toString());
		}
		return array;
	}
}

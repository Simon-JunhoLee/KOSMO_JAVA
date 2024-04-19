package juso;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		JusoDAO dao = new JusoDAO();
		boolean run = true;
		while(run) {
			System.out.println("\t\t\t   ┈┈┈ ୨୧ JUSO PROJECT ୨୧┈┈┈");
			System.out.println("╔══════════════════════════════════════════════════════════════════════════════════╗");
			System.out.println("\t1. 주소등록  |  2. 주소조회  |  3. 주소목록  |  4. 주소삭제  |  0. 프로그램 종료");
			System.out.println("╚══════════════════════════════════════════════════════════════════════════════════╝");	
			System.out.print("\n➲ 프로그램 선택 > ");
			String menu = sc.nextLine();
			System.out.println();
			switch(menu) {
					case "1": {
						Juso juso = new Juso();
						// 새로운 번호 구하기
						ArrayList<Juso> list = dao.list();
						Juso juso1 = list.get(list.size()-1);
						int idx = juso1.getNo()+1;
						System.out.println("➲ 번호 > " + idx);
						juso.setNo(idx);
						System.out.print("➲ 이름 입력 > ");
						String name = sc.nextLine();
						if(name == "") break;
						juso.setName(name);
						System.out.print("➲ 전화번호 입력 > ");
						String phone = sc.nextLine();
						if(phone == "") break;
						juso.setPhone(phone);
						System.out.print("➲ 주소 입력 > ");
						String address = sc.nextLine();
						if(address == "") break;
						juso.setAddress(address);
						dao.insert(juso);
						System.out.println("\n✔ 정보등록 완료");
						break;
					}
					case "2": {
						System.out.print("➲ 번호/이름 입력 > ");
						String name = sc.nextLine();
						Juso juso = dao.read(name);
						if(juso.getNo() != 0) {							
							System.out.println("번호 : " + juso.getNo());
							System.out.println("이름 : " + juso.getName());
							System.out.println("전화번호 : " + juso.getPhone());
							System.out.println("주소 : " + juso.getAddress());
						}else {
							System.out.println("⚠ " + name + "님은 존재하지 않습니다!\n");
						}
						break;
					}
					case "3": {
						ArrayList<Juso> array = dao.list();
						for(Juso j:array) {
							System.out.println(j.toString());
						}
						System.out.println();
						break;
					}
					case "4": {
						System.out.print("➲ 번호 입력 > ");
						String sno = sc.nextLine();
						if(sno == "") break;
						Juso juso = dao.read(sno);
						if(juso.getNo() == 0) {
							System.out.println("\n⚠ " + sno + "번은 존재하지 않습니다!\n");
						}else {							
							dao.delete(Integer.parseInt(sno));
							System.out.println("\n✔ " + juso.getName() + " 삭제완료!");
						}
						break;
					}
					case "0": {
						run = false;
						break;
					}
					default:
						System.out.println("⚠ 메뉴 0~4번을 선택하세요! ⚠\n");
				}
		}
		System.out.println("✔ 프로그램을 종료합니다.");
	}

}

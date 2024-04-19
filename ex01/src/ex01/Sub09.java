package ex01;

import java.util.Scanner;

public class Sub09 {
	public static void run() {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		String menu = "";
		int count = 0;
		String[] names = new String[100];
		String[] addresses = new String[100];
		String[] phones = new String[100];
		while(run) {
			System.out.println("====================================");
			System.out.println("1. 주소 등록  |  2. 주소 출력  |  0. 종료");
			System.out.println("====================================");
			System.out.print("메뉴 선택 > ");
			menu = sc.nextLine();
			switch(menu) {			
			case "1":
				System.out.print("이름 > ");
				String name = sc.nextLine();
				System.out.print("주소 > ");
				String address = sc.nextLine();
				System.out.print("전화번호 > ");
				String phone = sc.nextLine();
				names[count] = name;
				addresses[count] = address;
				phones[count] = phone;
				count++;
				System.out.println("※등록이 완료되었습니다.");
				break;
			case "2":				
				System.out.println("번호\t이름\t주소\t전화번호");
				for(int i=0; i<count; i++) {					
					System.out.println((i+1) + "\t" + names[i] + "\t" + addresses[i] + "\t" + phones[i]);	
				}
				break;
			case "0":				
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("0~2번 메뉴를 선택해주세요.");
			}
		}
	}
}

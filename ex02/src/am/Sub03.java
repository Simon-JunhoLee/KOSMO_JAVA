package am;

import java.util.Scanner;

public class Sub03 {
	public static void run() {
		System.out.println("\t  ═════════•°• 주소관리 •°•═════════");
		Scanner sc = new Scanner(System.in);
		
		String[] names = new String[100];
		String[] addresses = new String[100];
		String[] phones = new String[100];
		int count = 0;
		
		boolean run = true;
		while(run) {
			System.out.println();
			System.out.println("╔═══════════════════════════════════════════════════╗");
			System.out.println("\t1. 주소등록  |  2. 주소현황  |  0. 프로그램 종료");
			System.out.println("╚═══════════════════════════════════════════════════╝");	
			System.out.print("\n➲ 메뉴 선택 > ");
			String menu = sc.nextLine();
			System.out.println();
			switch (menu) {
			case "1": {
				while(true) {					
					System.out.print("➲ 이름 > ");
					String name = sc.nextLine();
					if(name == "") {
						System.out.println("\n✔ 입력을 종료합니다.");
						break;
					}
					System.out.print("➲ 주소 > ");
					String address = sc.nextLine();
					if(address == "") {
						System.out.println("\n✔ 입력을 종료합니다.");
						break;
					}
					System.out.print("➲ 전화번호 > ");
					String phone = sc.nextLine();
					if(phone == "") {
						System.out.println("\n✔ 입력을 종료합니다.");
						break;
					}
					names[count] = name;
					addresses[count] = address;
					phones[count] = phone;
					System.out.println("\n✔ " + names[count] + "님 등록이 완료되었습니다.\n");
					count++;
				}
				break;
			}
			case "2": {
				if(count == 0) {
					System.out.println("⚠ 등록된 주소가 없습니다! ⚠\n");
				}else {
					System.out.println("no.\t이름\t주소\t전화번호");
					for(int i=0; i<count; i++) {
						System.out.printf("%d\t%s\t%s\t%s\n", i+1, names[i], addresses[i], phones[i]);
					}
					System.out.println("\n➱ " + count + "명이 존재합니다.");
				}
				break;
			}
			case "0": {
				run=false;
				break;
			}
			default:
				System.out.println("⚠ 메뉴 0~2번을 선택하세요! ⚠\n");
			}
		}
		System.out.println("\n✔ 프로그램을 종료합니다.\n");
	}
}

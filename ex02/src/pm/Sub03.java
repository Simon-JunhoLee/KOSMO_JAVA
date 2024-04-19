package pm;

import java.util.ArrayList;
import java.util.Scanner;

public class Sub03 {
	public static void run() {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> addresses = new ArrayList<String>();
		ArrayList<String> phones = new ArrayList<String>();		
		
		int idx = 0;
		
		boolean run = true;
		while(run) {
			System.out.println();
			System.out.println("╔═══════════════════════════════════════════════════════════════════╗");
			System.out.println("\t1. 주소등록 | 2. 이름검색 | 3. 주소목록 | 4. 주소삭제 | 0. 종료");
			System.out.println("╚═══════════════════════════════════════════════════════════════════╝");	
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
						names.add(name);
						addresses.add(address);
						phones.add(phone);
						System.out.println("\n✔ " + names.get(idx) + "님 등록이 완료되었습니다.\n");
						idx++;
					}
					break;
				}
				case "2": {
					System.out.print("➲ 이름 검색 > ");
					String sname = sc.nextLine();
					boolean find = false;
					for(int i=0; i<names.size(); i++) {					
						if(sname.equals(names.get(i))) {
							find = true;
						}
					}
					if(find == true) {
						System.out.println("\n✔ " + sname + "님은 존재합니다.");
					}else {
						System.out.println("\n⚠ " + sname + "님은 존재하지 않습니다.");
					}
					break;
				}
				case "3": {
					if(idx == 0) {
						System.out.println("⚠ 등록된 주소가 없습니다! ⚠\n");
					}else {
						System.out.println("no.\t이름\t주소\t전화번호");
						for(int i=0; i<names.size(); i++) {
							System.out.printf("%d\t%s\t%s\t%s\n", i+1, names.get(i), addresses.get(i), phones.get(i));
						}
						System.out.println("\n➱ " + names.size() + "명이 존재합니다.");
					}
					break;
				}
				case "4": {
					System.out.print("➲ 이름 입력 > ");
					String sname = sc.nextLine();
					boolean removal = false;
					boolean find = false;
					for(int i=0; i<names.size(); i++) {
						if(sname.equals(names.get(i))) {
							find = true;
							System.out.print("\nℹ  "+ sname + "님의 정보를 삭제하시겠습니까? (y/n) > ");
							String check = sc.nextLine();
							if(check.equals("y")) {								
								names.remove(i);
								addresses.remove(i);
								phones.remove(i);
								removal = true;
								break;
							}else if(check.equals("n")) {
								break;
							}else {
								System.out.println("⚠ y 혹은 n을 입력해주십시오.");
							}
						}
					}
					if(find == true) {
						if(removal == true) {							
							System.out.println("\nℹ  "+ sname + "님의 정보가 삭제완료되었습니다.");
						}else {
							System.out.println("\nℹ  "+ "삭제가 취소되었습니다.");
						}
					}else {
						System.out.println("\n⚠  "+ sname + "님은 존재하지 않습니다.");
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

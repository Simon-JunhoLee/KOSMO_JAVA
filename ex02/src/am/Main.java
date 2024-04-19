package am;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Sub01.run();
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("\t\t    ┈┈┈ ୨୧ KOSMO PROJECT ୨୧┈┈┈");
			System.out.println("╔═════════════════════════════════════════════════════════════════════╗");
			System.out.println("\t1. 성적관리  |  2. 매출관리  |  3. 주소관리  |  0. 프로그램 종료");
			System.out.println("╚═════════════════════════════════════════════════════════════════════╝");	
			System.out.print("\n➲ 프로그램 선택 > ");
			String menu = sc.nextLine();
			System.out.println();
			switch(menu) {
				case "1": {
					Sub01.run();
					break;
				}
				case "2": {
					Sub02.run();
					break;
				}
				case "3": {
					Sub03.run();
					break;
				}
				case "0": {
					run = false;
					break;
				}
				default:
					System.out.println("⚠ 메뉴 0~3번을 선택하세요! ⚠\n");
			}
		}
		System.out.println("\n✔ 프로그램을 종료합니다.");
	}

}

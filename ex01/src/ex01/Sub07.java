package ex01;

import java.util.Scanner;

public class Sub07 {
	public static void run() {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		while(run) {
			System.out.println("==========================================================================");
			System.out.println("1. 100까지의 합계  |  2. 100까지 홀수 합계  |  3. 100까지 짝수 합계  |  0. 프로그램 종료");
			System.out.println("==========================================================================");
			System.out.print("선택 > ");
			String menu = sc.nextLine();
			switch(menu) {
			case "1":
				int sum = 0;
				int count = 0;
				for(int i=1; i<=100; i++) {
					System.out.print(i + "\t");
					sum += i;
					count++;
					if(count%10 == 0) {
						System.out.print("\n");
					}
				}
				System.out.println("합계 : " + sum);
				break;
			case "2":
				sum = 0;
				count = 0;
				for(int i=1; i<=100; i++) {
					if(i%2 == 1) {
						System.out.print(i + "\t");
						sum += i;
						count++;
					}
					if(count%10 == 0) {
						System.out.print("\n");
					}
				}
				System.out.println("합계 : " + sum);
				break;
			case "3":
				sum = 0;
				count = 0;
				for(int i=1; i<=100; i++) {
					if(i%2 == 0) {			
						System.out.print(i + "\t");
						sum += i;
						count++;
					}
					if(count%10 == 0) {
						System.out.print("\n");
					}
				}
				System.out.println("합계 : " + sum);
				break;
			case "0":
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("0~3번 메뉴를 선택하세요.");
			}	// switch
		}	// while
	}	// method
}	// class

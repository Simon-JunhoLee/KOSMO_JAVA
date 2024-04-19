package ex01;

import java.util.Scanner;

public class Sub10 {
	public static void run() {
		Scanner sc = new Scanner(System.in);
		String[] names = new String[100];
		int[] prices = new int[100];
		int[] cnt = new int[100];
		int count = 0;
		
		boolean run = true;
		while(run) {
			System.out.println("\n====================================================");
			System.out.println("\t1. 매출 등록  |  2. 매출 현황  |  0. 종료");
			System.out.println("====================================================\n");
			System.out.print("메뉴 선택 >");
			String menu = sc.nextLine();
			switch(menu) {
			case "1":				
				System.out.print("상품명 > ");
				names[count] = sc.nextLine();
				System.out.print("가격 > ");
				prices[count] = Integer.parseInt(sc.nextLine());
				System.out.print("개수 > ");
				cnt[count] = Integer.parseInt(sc.nextLine());
				count++;
				System.out.println("▶ 등록완료 되었습니다.");
				break;
			case "2":
				System.out.println("◈ 매출 현황 ◈");
				if(count<0) {
					System.out.println("▶ 등록된 상품이 없습니다.");
				}else {
					System.out.println("no.\t상품명\t가격\t개수\t총계\n");
					for(int i=0; i<count; i++) {
						System.out.printf("%d\t%s\t%d원\t%d개\t%d원\n", i+1, names[i], prices[i], cnt[i], prices[i]*cnt[i]);
					}
				}
				break;
			case "0":
				run = false;
				System.out.println("▶ 프로그램을 종료합니다.");
				break;
			default:
				System.out.println("▶ 0~2번 메뉴를 선택하세요.");
			}
		}
	}
}

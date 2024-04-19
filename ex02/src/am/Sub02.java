package am;

import java.util.Scanner;

public class Sub02 {
	public static void run() {
		System.out.println("\t\t     ☙ 매출현황 ❧");
		Scanner sc = new Scanner(System.in);
		
		String[] names = new String[100];
		int[] prices = new int[100];
		int[] cnts = new int[100];
		names[0] = "노트북"; prices[0] = 150; cnts[0] = 23;
		names[1] = "TV"; prices[1] = 205; cnts[1] = 17;
		int count = 2;
		
		boolean run = true;
		while(run) {
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("\t1. 매출등록  |  2. 매출출력  |  0. 종료");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.print("➲ 메뉴 선택 > ");
			String menu = sc.nextLine();
			switch (menu) {
			case "1": {
				System.out.print("➲ 상품명 > ");
				names[count] = sc.nextLine();
				System.out.print("➲ 상품단가 > ");
				prices[count] = Integer.parseInt(sc.nextLine());
				System.out.print("➲ 판매수량 > ");
				cnts[count] = Integer.parseInt(sc.nextLine());
				System.out.println("\n✔ " + names[count] + "이 등록완료되었습니다.\n");
				count++;
				break;
			}
			case "2": {
				int tot_sum = 0;
				int tot_cnt = 0;
				System.out.println("no.\t물품명\t상품단가\t판매수량\t매출액");
				for(int i=0; i<count; i++) {
					int sum = prices[i] * cnts[i];
					System.out.printf("%d\t%s\t%,d만원\t%d개\t%,d만원\n", i+1, names[i], prices[i], cnts[i], prices[i]*cnts[i]);
					tot_sum += sum;
					tot_cnt += cnts[i];
				}
				System.out.printf("\n➱ 총 판매수량 : %,d개  |  총 매출액 : %,d만원", tot_cnt, tot_sum);
				System.out.println("\n➱ " + count + "개의 상품이 등록되었습니다.");
				System.out.println();
				break;
			}
			case "0": {
				run = false;
				break;
			}
			default:
				System.out.println("⚠ 메뉴 0~2번을 선택하세요! ⚠\n");
			}
		}
		System.out.println("✔ 프로그램을 종료합니다.");
	}
}

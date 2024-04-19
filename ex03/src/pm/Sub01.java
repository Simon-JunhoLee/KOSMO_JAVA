package pm;

import java.util.ArrayList;
import java.util.Scanner;

public class Sub01 {
	public static void run() {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Sale> sales = new ArrayList<>();
		Sale s1 = new Sale();
		s1.setCode("100");
		s1.setName("냉장고");
		s1.setPrice(2500000);
		s1.setCnt(58);
		
		Sale s2 = new Sale("101", "세탁기", 1800000, 43);
		
		sales.add(s1);
		sales.add(s2);
		
		while(run) {
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("\t1. 매출등록 | 2. 매출목록 | 3. 상품조회 | 4. 매출삭제 | 0. 종료");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.print("\n➲ 메뉴 선택 > ");
			String menu = sc.nextLine();
			System.out.println();
			switch (menu) {
				case "1": {
					while(true) {	
						Sale s3 = new Sale();
						Sale last = sales.get(sales.size()-1);
						int curr_code = Integer.parseInt(last.getCode())+1;
						String code = Integer.toString(curr_code);
						System.out.println("➲ 상품코드 > " + code);
						if(code == "") {
							System.out.println("\n✔ 입력을 종료합니다.");
							break;
						}
						System.out.print("➲ 상품명 > ");
						String name = sc.nextLine();
						if(name == "") {
							System.out.println("\n✔ 입력을 종료합니다.");
							break;
						}
						System.out.print("➲ 상품가격 > ");
						String price = sc.nextLine();
						while(true) {
							if(checkNumber(price) || price == "") {
								break;
							}
							System.out.print("➲ 상품가격 > ");
							price = sc.nextLine();
						}
						if(price == "") {
							System.out.println("\n✔ 입력을 종료합니다.");
							break;
						}
						System.out.print("➲ 판매수량 > ");
						String cnt = sc.nextLine();
						while(true) {
							if(checkNumber(cnt) || cnt == "") {
								break;
							}
							System.out.print("➲ 판매수량 > ");
							cnt = sc.nextLine();
						}
						if(cnt == "") {
							System.out.println("\n✔ 입력을 종료합니다.");
							break;
						}
						
						s3.setCode(code);
						s3.setName(name);
						s3.setPrice(Integer.parseInt(price));
						s3.setCnt(Integer.parseInt(cnt));
						sales.add(s3);
						
						System.out.println("\n✔ " + s3.getName() + " 등록이 완료되었습니다.\n");
					}	
					break;
				}
				case "2": {
					int tot_cnt = 0;
					int tot_sum = 0;
					System.out.println("no.\t상품명\t가격\t\t개수\t매출액\n");
					for(Sale s:sales) {
						s.print_land();
						tot_cnt += s.getCnt();
						tot_sum += s.sum();
					}
					System.out.printf("\nℹ 총 판매수량 : %,d개", tot_cnt);
					System.out.printf("\nℹ 총 판매수량 : %,d원", tot_sum);
					System.out.println("\nℹ " + sales.size() + "개의 매출이 존재합니다.\n");
					
					break;
				}
				case "3": {
					while(true) {						
						System.out.print("➲ 조회 이름 > ");
						String sname = sc.nextLine();
						if(sname == "") {
							break;
						}
						System.out.println();
						boolean find = false;
						for(Sale s:sales) {
							if(s.getName().equals(sname)) {
								s.print_port();
								find = true;
							}
						}
						if(!find) {
							System.out.println("⚠  "+ sname + "의 정보는 존재하지 않습니다.\n");
						}
					}
					break;
				}
				case "4": {
					System.out.print("➲ 삭제 이름 > ");
					String sname = sc.nextLine();
					boolean removal = false;
					boolean find = false;
					for(Sale s:sales) {
						if(sname.equals(s.getName())) {
							find = true;
							s.print_port();
							System.out.print("\nℹ  "+ sname + "의 매출 정보를 삭제하시겠습니까? (y/n) > ");
							String check = sc.nextLine();
							if(check.equals("y")) {								
								sales.remove(s);
								removal = true;
								break;
							}else if(check.equals("n")) {
								break;
							}else {
								System.out.println("\n⚠ y 혹은 n을 입력해주십시오.");
							}
						}
					}
					if(find == true) {
						if(removal == true) {							
							System.out.println("\nℹ  "+ sname + "의 매출 정보가 삭제완료되었습니다.\n");
						}else {
							System.out.println("\nℹ  "+ "삭제가 취소되었습니다.\n");
						}
					}else {
						System.out.println("\n⚠  "+ sname + "의 정보는 존재하지 않습니다.\n");
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
		System.out.println("\n✔ 프로그램을 종료합니다.\n");
	}
	
	// 숫자인지 아닌지 판별하는 메서드
	public static boolean checkNumber(String str) {
		try {
			int num = Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
	}
}

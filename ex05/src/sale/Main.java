package sale;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SaleDAO dao = new SaleDAO();
		boolean run = true;
		while(run) {
			System.out.println("\t\t\t   ┈┈┈ [ SALE PROJECT ] ┈┈┈");
			System.out.println("╔══════════════════════════════════════════════════════════════════════════════════╗");
			System.out.println("\t1. 매출등록  |  2. 매출조회  |  3. 매출목록  |  4. 매출삭제  |  0. 프로그램 종료");
			System.out.println("╚══════════════════════════════════════════════════════════════════════════════════╝");	
			System.out.print("\n➲ 메뉴 선택 > ");
			String menu = sc.nextLine();
			System.out.println();
			switch(menu) {
					case "1": {
						Sale sale = new Sale();
						// 새로운 번호 구하기
						ArrayList<Sale> list = dao.list();
						Sale lastSale = list.get(list.size()-1);
						int idx = lastSale.getCode()+1;
						System.out.println("➲ 번호 > " + idx);
						sale.setCode(idx);
						System.out.print("➲ 상품명 입력 > ");
						String name = sc.nextLine();
						if(name == "") {
							System.out.println("\n✔ 입력 종료!");
							break;
						}
						sale.setName(name);	
						System.out.print("➲ 상품단가 입력 > ");
						String price = sc.nextLine();
						while(true) {							
							if(price == "") {
								System.out.println("\n✔ 입력 종료!");
								break;
							}
							if(check(price)) {
								sale.setPrice(Integer.parseInt(price));
								break;
							}
							System.out.print("➲ 상품단가 입력 > ");
							price = sc.nextLine();
						}
						if(price == "") break;
						System.out.print("➲ 판매수량 입력 > ");
						String cnt = sc.nextLine();
						while(true) {
							if(cnt == "") break;
							if(check(cnt)) {
								sale.setCnt(Integer.parseInt(cnt));
								break;
							}
							System.out.print("➲ 판매수량 입력 > ");
							cnt = sc.nextLine();
						}
						if(cnt == "") {
							System.out.println("\n✔ 입력 종료!");
							break;
						}
						dao.insert(sale);
						System.out.println("\n✔ 매출등록 완료");
						break;
					}
					case "2": {
						System.out.print("➲ 코드 조회 > ");
						String code = sc.nextLine();
						while(true) {
							if(code == "") {
								System.out.println("\n✔ 조회 종료!");
								break;
							}
							if(check(code)) {
								Sale sale1 = dao.read(Integer.parseInt(code));
								if(sale1.getName() != null) {									
									System.out.printf("상품이름 : %s\n", sale1.getName());
									System.out.printf("상품단가 : %,d만원\n", sale1.getPrice());
									System.out.printf("판매수량 : %,d개\n", sale1.getCnt());
									System.out.printf("총매출 : %,d만원\n", sale1.getPrice()*sale1.getCnt());
									System.out.println();
								}else {
									System.out.println("\n⚠ " + code + "번 매출정보는 존재하지 않습니다.\n");
								}
							}
							System.out.print("➲ 코드 조회 > ");
							code = sc.nextLine();
						}
						break;
					}
					case "3": {
						ArrayList<Sale> array = dao.list();
						System.out.println("no.\t상품명\t상품단가\t  판매수량\t      총매출");
						for(Sale s:array) {
							System.out.printf("%2d\t%s\t%,3d만원\t%,5d개\t%,8d만원\n", s.getCode(), s.getName(), s.getPrice(), s.getCnt(), s.getPrice()*s.getCnt());
						}
						System.out.println();
						break;
					}
					case "4": {
						System.out.print("➲ 삭제 코드 > ");
						String code = sc.nextLine();
						while(true) {
							if(code == "") {
								System.out.println("\n✔ 조회 종료!");
								break;
							}
							if(check(code)) {
								Sale sale1 = dao.read(Integer.parseInt(code));
								if(sale1.getName() != null) {									
									System.out.printf("상품이름 : %s\n", sale1.getName());
									System.out.printf("상품단가 : %,d만원\n", sale1.getPrice());
									System.out.printf("판매수량 : %,d개\n", sale1.getCnt());
									System.out.printf("총매출 : %,d만원\n", sale1.getPrice()*sale1.getCnt());
									System.out.println();
									
									System.out.print("\n⚠" + sale1.getName() + "의 매출정보를 삭제하시겠습니까? (y/n) ");
									String del = sc.nextLine();
									if(del.equals("y")) {
										dao.delete(Integer.parseInt(code));
										System.out.println("\n✔" + code + "번의 매출 정보 삭제 완료\n");
										break;
									}else if(del.equals("n")) {
										System.out.println("\n✔ 매출 정보 삭제 취소\n");
									}else {
										System.out.println("\n⚠ y 혹은 n을 입력해주세요.\n");
									}
								}else {
									System.out.println("\n⚠ " + code + "번 매출정보는 존재하지 않습니다.\n");
								}
							}
							System.out.print("➲ 코드 조회 > ");
							code = sc.nextLine();
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
	
	// 숫자인지 체크 메서드
	public static boolean check(String str) {
		try {
			int num = Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("⚠ 숫자를 입력하세요!\n");
			return false;
		}
	}

}

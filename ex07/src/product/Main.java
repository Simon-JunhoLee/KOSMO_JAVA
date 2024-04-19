package product;

import java.text.SimpleDateFormat;
import java.util.*;

import sale.Sub;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ProductDAO dao = new ProductDAO();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(sdf.format(today));
		boolean run = true;
		while(run) {
			System.out.println("\t\t\t\t       ┈┈┈ [ PRODUCT MANAGEMENT ] ┈┈┈");
			System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
			System.out.println("\t1. 상품등록  |  2. 상품조회  |  3. 상품목록  |  4. 상품삭제  |  5. 상품수정  |  6. 매출관리  |  0. 프로그램 종료");
			System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");	
			System.out.print("\n➲ 메뉴 선택 > ");
			String menu = sc.nextLine();
			System.out.println();
			switch(menu) {
					case "1": {
						ProductVO vo1 = new ProductVO();
						vo1.setCode(dao.getCode());
						System.out.println("상품코드 : " + vo1.getCode());
						System.out.print("➲ 상품명 > ");
						String name1 = sc.nextLine();
						if(name1 == "") {
							System.out.println("✔ 상품등록을 취소합니다.");
							break;
						}else {
							vo1.setName(name1);
						}
						while(true) {							
							System.out.print("➲ 상품단가 > ");
							String price1 = sc.nextLine();
							if(price1 == "") {
								System.out.println("✔ 상품등록을 취소합니다.");
								break;
							}
							if(isNumber(price1)) {
								vo1.setPrice(Integer.parseInt(price1));
								dao.insert(vo1);
								System.out.println(vo1.toString());
								System.out.println("\n✔ " + vo1.getName() + "의 등록이 완료되었습니다.\n");
								break;
							}
						}
						break;
					}
					case "2": {	// 상품조회
						while(true) {							
							System.out.print("➲ 상품코드 입력 > ");
							String code2 = sc.nextLine();
							if(code2 == "") {
								System.out.println("✔ 조회를 취소합니다.");
								break;
							}
							ProductVO vo2 = dao.read(code2);							
							if(vo2.getCode() == null) {
								System.out.println("\n⚠ " + code2 + "번 상품은 존재하지 않습니다.");
							}else {							
								System.out.println(vo2.toString() + "\n");
							}
						}
						break;
					}
					case "3": {	// 상품목록
						ArrayList<ProductVO> array = dao.list();
						System.out.println("상품코드\t       상품명\t\t  상품단가");
						for(ProductVO vo:array) {
							System.out.println(vo.toString());
						}
						System.out.println();
						break;
					}
					case "4": {	// 상품삭제
						System.out.print("➲ 삭제할 상품코드 > ");
						String code4 = sc.nextLine();
						ProductVO vo4 = dao.read(code4);
						if(vo4.getCode() == null) {
							System.out.println(code4 + "번 상품은 존재하지 않습니다.");
						}else {
							System.out.println(vo4.toString());
							System.out.print("정말로 삭제하시겠습니까? (y/n) ");
							String del = sc.nextLine();
							if(del.equals("y")) {
								dao.delete(code4);
							}else if(del.equals("n")) {
								System.out.println("\n✔ 삭제를 취소합니다.");
								break;
							}else {
								System.out.println("\n⚠ y 혹은 n을 눌러주세요.");
							}
						}
						break;
					}
					case "5": {
						System.out.print("➲ 수정할 상품코드 > ");
						String code5 = sc.nextLine();
						ProductVO vo5 = dao.read(code5);
						if(vo5.getCode() == null) {
							System.out.println(code5 + "번 상품은 존재하지 않습니다.");
						}else {
							System.out.print("➲ 상품명 : " + vo5.getName() + " > ");
							String name5 = sc.nextLine(); 
							if(!name5.equals("")) {								
								vo5.setName(name5);
							}
							while(true) {								
								System.out.print("➲ 상품단가 : " + vo5.getPrice() + " > ");
								String price5 = sc.nextLine();
								if(price5.equals("")) {
									System.out.println("\n✔ 수정을 취소합니다.");
									break;										
								}
								if(isNumber(price5)) {
									vo5.setPrice(Integer.parseInt(price5));
									break;
								}
							}
							System.out.print("정말로 수정하시겠습니까? (y/n) ");
							String upt = sc.nextLine();
							if(upt.equals("y")) {
								dao.update(vo5);
							}else if(upt.equals("n")) {
								System.out.println("\n✔ 수정을 취소합니다.");
								break;
							}else {
								System.out.println("\n⚠ y 혹은 n을 눌러주세요.");
							}
						}
						break;
					}
					case "6": {
						Sub.run();
						break;
					}
					case "0": {
						run = false;
						break;
					}
					default:
						System.out.println("⚠ 메뉴 0~6번을 선택하세요! ⚠\n");
				}
		}
		System.out.println("✔ 프로그램을 종료합니다.");
	}
	public static boolean isNumber(String str) {
		try {
			int num = Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("\n⚠ 숫자를 입력해주세요.");
			return false;
		}
	}
	
	public static ProductVO read(String code) {
		ProductDAO dao = new ProductDAO();
		ProductVO vo = dao.read(code);
		if(vo.getCode() == null) {
			System.out.println(code + "번 상품은 존재하지 않습니다.");
		}
		return vo;
	}

}

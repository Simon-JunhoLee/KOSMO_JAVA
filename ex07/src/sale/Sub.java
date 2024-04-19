package sale;

import java.text.SimpleDateFormat;
import java.util.*;

import product.ProductDAO;
import product.ProductVO;



public class Sub {
	public static void run() {
		Scanner sc = new Scanner(System.in);
		SaleDAO dao = new SaleDAO();
		ProductDAO pdao = new ProductDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		boolean run = true;
		while(run) {
			System.out.println("\t\t\t\t┈┈┈ [ SALE MANAGEMENT ] ┈┈┈");
			System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════╗");
			System.out.println("\t1. 매출등록  |  2. 매출조회  |  3. 매출현황  |  4. 매출삭제  |  5. 상품수정  |  0. 프로그램 종료");
			System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════╝");	
			System.out.print("\n➲ 메뉴 선택 > ");
			String menu = sc.nextLine();
			System.out.println();
			switch(menu) {
					case "1": {
						System.out.print("➲ 상품코드 > ");
						String code1 = sc.nextLine();
						ProductVO vo1 = pdao.read(code1);
						if(vo1.getCode() == null) {
							System.out.println("\n⚠ " + code1 + "번 상품은 존재하지 않습니다.");
						}else {
							System.out.println("➲ 상품명 : " + vo1.getName());
							String today = sdf.format(new Date());
							System.out.print("➲ 판매일 : " + today + " > ");
							String date = sc.nextLine();
							System.out.print("➲ 판매가 : " + vo1.getPrice() + " > ");
							String price = sc.nextLine();
							System.out.print("➲ 판매수량 > ");
							String cnt = sc.nextLine();
							SaleVO svo = new SaleVO();
							svo.setCode(code1);
							svo.setName(vo1.getName());
							if(date != "") {								
								svo.setSale_date(date);
							}else {
								svo.setSale_date(today);
							}
							if(price != "") {
								svo.setPrice(Integer.parseInt(price));
							}else {
								svo.setPrice(vo1.getPrice());
							}
							if(cnt != "") {
								svo.setCnt(Integer.parseInt(cnt));								
							}else {
								svo.setCnt(1);
							}
							System.out.println(svo.toString());
							dao.insert(svo);
							System.out.println("✔ 매출등록 완료");
						}
						
						break;
					}
					case "2": {	// 매출조회
						while(true) {							
							System.out.print("➲ 상품코드 입력 > ");
							String code2 = sc.nextLine();
							if(code2 == "") {
								System.out.println("✔ 조회를 취소합니다.");
								break;
							}
							ProductVO vo2 = pdao.read(code2);							
							if(vo2.getCode() == null) {
								System.out.println("\n⚠ " + code2 + "번 상품은 존재하지 않습니다.");
							}else {							
								System.out.println(vo2.toString() + "\n");
							}
						}
						break;
					}
					case "3": {	// 매출목록
						System.out.println("\t\t\t\t\t[ 매출현황 ]\n");
						for(SaleVO vo:dao.list()) {
							System.out.println(vo.toString());
						}
						System.out.println();
						break;
					}
					case "4": {	// 매출삭제
						break;
					}
					case "5": {
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
}

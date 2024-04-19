package pm;

import java.util.ArrayList;
import java.util.Scanner;

public class Sub01 {
	public static void run() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<>();
		names.add("홍길동");	// 데이터 입력
		names.add("심청이");
		names.add("강감찬");
		names.add("성춘향");
		names.add("이몽룡");
		
		names.remove(1);	// 데이터 삭제
		
		for(int i=0; i<names.size(); i++) {		// 데이터 출력
			String name = names.get(i);
			System.out.println(name);
		}
		while(true) {			
			// 이름 검색
			System.out.print("검색할 이름 > ");
			String sname = sc.nextLine();
			if(sname == "") {
				System.out.println("검색을 종료합니다.");
				break;
			}
			boolean find = false;
			for(int i=0; i<names.size(); i++) {
				String name = names.get(i);
				if(sname.equals(name)) {
					find = true;
				}
			}
			if(find == false) {
				System.out.println("해당 인물이 존재하지 않습니다.");
			}else {			
				System.out.println("존재합니다.");
			}
		}
	}
}

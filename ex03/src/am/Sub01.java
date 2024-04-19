package am;

import java.util.ArrayList;
import java.util.Scanner;

public class Sub01 {
	public static void run() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<>();
		ArrayList<Integer> kors = new ArrayList<>();
		ArrayList<Integer> engs = new ArrayList<>();
		ArrayList<Integer> mats = new ArrayList<>();
		
		int idx = 2;
		names.add("홍길동"); kors.add(90); engs.add(72); mats.add(66);
		names.add("이준호"); kors.add(82); engs.add(95); mats.add(88);
		
		int tot = 0;
		double avg = 0;
		int kor_tot = 0;
		int eng_tot = 0;
		int mat_tot = 0;
		double kor_avg = 0;
		double eng_avg = 0;
		double mat_avg = 0;
		
		boolean run = true;
		while(run) {			
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("\t1. 성적등록 | 2. 성적목록 | 3. 성적조회 | 4. 성적삭제 | 0. 종료");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
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
						System.out.print("➲ 국어 > ");
						String kor = sc.nextLine();
						if(kor == "") {
							System.out.println("\n✔ 입력을 종료합니다.");
							break;
						}
						System.out.print("➲ 영어 > ");
						String eng = sc.nextLine();
						if(eng == "") {
							System.out.println("\n✔ 입력을 종료합니다.");
							break;
						}
						System.out.print("➲ 수학 > ");
						String mat = sc.nextLine();
						if(mat == "") {
							System.out.println("\n✔ 입력을 종료합니다.");
							break;
						}						
						names.add(name);
						kors.add(Integer.parseInt(kor));
						engs.add(Integer.parseInt(eng));
						mats.add(Integer.parseInt(mat));
						System.out.println("\n✔ " + names.get(idx) + "님 등록이 완료되었습니다.\n");
						idx++;
					}
					break;
				}
				case "2": {
					System.out.println("no.\t이름\t국어\t영어\t수학\t총점\t평균");
					for(int i=0; i<names.size(); i++) {
						tot = kors.get(i) + engs.get(i) + mats.get(i);
						avg = (double)tot/3;
						kor_tot += kors.get(i); eng_tot += engs.get(i); mat_tot += mats.get(i);
						kor_avg = (double)kor_tot/names.size(); eng_avg = (double)eng_tot/names.size(); mat_avg = (double)mat_tot/names.size();
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\n", i+1, names.get(i), kors.get(i), engs.get(i), mats.get(i), tot, avg);
					}
					System.out.printf("\n국어평균 : %.2f  |  영어평균 : %.2f  |  수학평균 : %.2f\n", kor_avg, eng_avg, mat_avg);
					System.out.println(names.size() + "명의 학생이 존재합니다.");
					System.out.println();
					break;
				}
				case "3": {
					System.out.print("➲ 조회 이름 > ");
					String sname = sc.nextLine();
					System.out.println();
					boolean find = false;
					for(int i=0; i<names.size(); i++) {
						if(names.get(i).equals(sname)) {
							System.out.println("국어 : " + kors.get(i));
							System.out.println("영어 : " + engs.get(i));
							System.out.println("수학 : " + mats.get(i));
							int personal_tot = kors.get(i) + engs.get(i) + mats.get(i); 
							System.out.println("총점 : " + personal_tot);
							System.out.printf("평균 : %.2f\n\n", (double)personal_tot/3);
							find = true;
						}
					}
					if(!find) {
						System.out.println("\n⚠  "+ sname + "님은 존재하지 않습니다.\n");
					}
					break;
				}
				case "4": {
					System.out.print("➲ 삭제 이름 > ");
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
								kors.remove(i);
								engs.remove(i);
								mats.remove(i);
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
							System.out.println("\nℹ  "+ sname + "님의 정보가 삭제완료되었습니다.\n");
						}else {
							System.out.println("\nℹ  "+ "삭제가 취소되었습니다.\n");
						}
					}else {
						System.out.println("\n⚠  "+ sname + "님은 존재하지 않습니다.\n");
					}
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
		System.out.println("\n✔ 프로그램을 종료합니다.\n");
		
	}
}

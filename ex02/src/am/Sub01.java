package am;

import java.util.Scanner;

public class Sub01 {
	public static void run() {
		System.out.println("\t\t◈ 성적관리 프로그램 ◈");
		Scanner sc = new Scanner(System.in);
		boolean stop = false;
		String[] names = new String[100];
		int[] kors = new int[100];
		int[] engs = new int[100];
		int[] mats = new int[100];
		names[0] = "이준호"; kors[0] = 87; engs[0] = 99; mats[0] = 77;
		names[1] = "홍길동"; kors[1] = 95; engs[1] = 67; mats[1] = 82;
		int count = 2;
		
		while(!stop) {
			System.out.println("=====================================================");
			System.out.println("\t1. 성적등록  |  2. 성적출력  |  0. 종료");
			System.out.println("=====================================================");
			System.out.print("선택 > ");
			String menu = sc.nextLine();
			switch (menu) {
			case "1": {
				System.out.println("▶ 성적등록");
				System.out.print("이름 > ");
				names[count] = sc.nextLine();
				System.out.print("국어 점수 > ");
				kors[count] = Integer.parseInt(sc.nextLine());
				System.out.print("영어 점수 > ");
				engs[count] = Integer.parseInt(sc.nextLine());
				System.out.print("수학 점수 > ");
				mats[count] = Integer.parseInt(sc.nextLine());
				System.out.println("▶ 등록이 완료되었습니다.");
				count++;
				break;
			}
			case "2": {
				System.out.println("▶ 성적을 출력합니다.");
				System.out.println("no.\t이름\t국어\t영어\t수학\t총점\t평균\t학점");
				int kor_tot = 0;
				int eng_tot = 0;
				int mat_tot = 0;
				double kor_avg = 0;
				double eng_avg = 0;
				double mat_avg = 0;
				double sum_avg = 0;
				for(int i=0; i<count; i++) {					
					int tot = kors[i] + engs[i] + mats[i];
					double avg = (double)tot/3;
					kor_tot += kors[i];
					eng_tot += engs[i];
					mat_tot += mats[i];
					kor_avg = (double)kor_tot/count;
					eng_avg = (double)eng_tot/count;
					mat_avg = (double)mat_tot/count;
					sum_avg = (double)(kor_avg + eng_avg + mat_avg)/3;
					String grade = "";
					if(avg >= 90) {
						if(avg >= 95) {
							grade = "A+";
						}else {
							grade = "A";
						}
					}else if(avg >=80){
						if(avg >= 85) {
							grade = "B+";
						}else {
							grade = "B";
						}
					}else if(avg >=70){
						if(avg >= 75) {
							grade = "C+";
						}else {
							grade = "C";
						}
					}else if(avg >=60){
						if(avg >= 65) {
							grade = "D+";
						}else {
							grade = "D";
						}
					}else {
						grade = "F";
					}
					System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", i+1, names[i], kors[i], engs[i], mats[i], tot, avg, grade);
				}
				System.out.println("총인원 : " + count + "명");
				System.out.printf("국어평균 : %.2f\t영어평균 : %.2f\t수학평균 : %.2f\t총평균 : %.2f\n", kor_avg, eng_avg, mat_avg, sum_avg);
				break;
			}
			case "0": {
				stop = true;
				System.out.println("▶ 프로그램을 종료합니다.");
				break;
			}
			default:
				System.out.println("▶ 0~2번의 메뉴를 선택해주세요.");
			}
		}
		
	}
}

package pm;

import java.util.ArrayList;
import java.util.Scanner;

public class Sub02 {
	public static void run() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> nums = new ArrayList<>();
		while(true) {
			System.out.print("수 입력 > ");
			String num = sc.nextLine();
			if(num == "") {
				System.out.println("입력을 종료합니다.");
				break;
			}else {
				nums.add(Integer.parseInt(num));
			}
		}
		
		// 데이터 개수, 수 합계, 수 평균 출력
		System.out.println("데이터 개수 : " + nums.size());
		int sum = 0;
		double avg = 0;
		for(int i=0; i<nums.size(); i++) {
			sum += nums.get(i);
		}
		System.out.println("수 합계 : " + sum);
		avg = (double)sum/nums.size();
		System.out.printf("수 평균 : %.2f", avg);
	}
}

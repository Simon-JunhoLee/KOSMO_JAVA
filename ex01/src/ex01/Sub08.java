package ex01;

public class Sub08 {
	public static void run() {
//		int[] scores = new int[] {90, 67, 82, 77, 65};
//		String[] people = {"홍길동", "이준호", "김철수", "밤양갱", "AK47"};
//		for(int i=0; i<scores.length; i++) {
//			System.out.println(people[i] + "의 점수는 " + scores[i]);			
//		}
		
		int[] no = new int[] {1, 2, 3};
		String[] name = new String[] {"홍길동", "심청이", "강감찬"};
		String[] address = new String[] {"인천", "서울", "부산"};
		for(int i=0; i<no.length; i++) {
			System.out.println(no[i] + "\t" + name[i] + "\t" + address[i]);
			System.out.println("------------------------------------");
		}
		
		int[] kor = new int[] {90, 88, 75};
		int[] eng = new int[] {86, 92, 66};
		int[] mat = new int[] {54, 85, 100};
		int tot = 0;
		double avg = 0;
		String grade ="";
		System.out.println("학번\t이름\t총점\t평균\t학점");
		for(int i=0; i<no.length; i++) {
			tot = kor[i] + eng[i] + mat[i];
			avg = (double)tot / no.length;
			if(avg >=90) {
				if(avg >=95) {
					grade = "A+";
				}else {
					grade = "A";
				}
			}else if(avg>=80){
				if(avg >=85) {
					grade = "B+";
				}else {
					grade = "B";
				}
			}else if(avg>=70){
				if(avg >=75) {
					grade = "C+";
				}else {
					grade = "C";
				}
			}else if(avg>=60){
				if(avg >=65) {
					grade = "D+";
				}else {
					grade = "D";
				}
			}else {
				grade = "F";
			}
			System.out.printf("%d\t%s\t%d\t%.2f\t%s\n", no[i], name[i], tot, avg, grade);
		}
			
	}
}

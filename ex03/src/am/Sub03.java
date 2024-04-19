package am;

import java.util.ArrayList;

public class Sub03 {
	public static void run() {
		ArrayList<Score> scores = new ArrayList<>();
		Score s1 = new Score("홍길동", 90, 90, 90);
		Score s2 = new Score("김길동", 85, 85, 85);
		Score s3 = new Score("박길동", 70, 70, 70);
		
		scores.add(s1);
		scores.add(s2);
		scores.add(s3);
		
		for(Score s:scores) {
			s.print();
		}
	}
}

package am;

import java.util.ArrayList;

public class Sub04 {
	public static void run() {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("100", "홍길동", "서울", "010-2222-1111"));
		students.add(new Student("101", "김길동", "인천", "010-3333-5555"));
		students.add(new Student("102", "이길동", "부산", "010-6666-7777"));
		students.add(new Student("103", "최길동", "대구", "010-9999-8888"));
		
		for(Student s:students) {
			s.print();
		}
	}
}

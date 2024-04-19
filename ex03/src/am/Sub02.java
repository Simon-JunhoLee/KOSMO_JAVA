package am;

import java.util.ArrayList;

public class Sub02 {
	public static void run() {
		System.out.println("클래스란?");
		Student s1 = new Student();
		s1.no = "100";
		s1.name = "홍길동";
		s1.address = "서울";
		s1.phone = "010-1234-5678";
		s1.print();
		System.out.println("==============================");
		Student s2 = new Student("101", "이순신");
		s2.print();
		System.out.println("==============================");
		Student s3 = new Student("102", "강감찬", "부산", "010-3030-3030");
		s3.print();
		System.out.println("==============================");
		Score sc1 = new Score("이준호", 90, 80, 70);
		sc1.total();
		System.out.println(sc1.total());
	}
}
package ex01;

public class Sub06 {
	public static void run() {		
		// 반복문(for문)
		int sum = 0;
		for(int i=1; i<=100; i++) {		// 1씩 증가해서 i에 저장
			sum += i;					// i에 대한 합계를 sum에 저장
			/*
			System.out.print(i + "\t");
			if(i%10 == 0) {
				System.out.println("\n");
			}
			*/
		}
		System.out.println("1~100의 합계 : " + sum);
		
		sum = 0;
		for(int i=1; i<=100; i++) {
			if(i%2==0) {
				sum += i;
			}
		}
		System.out.println("1~100 짝수의 합계 : " + sum);
		
		sum = 0;
		for(int i=1; i<=100; i++) {
			if(i%2==1) {
				sum += i;
			}
		}
		System.out.println("1~100 홀수의 합계 : " + sum);

		// 반복문(while문)
		int i = 1;
		sum = 0;
		while(i<=100) {
			sum += i;
			i++;
		}
		System.out.println("1~100 합계 : " + sum);

		i = 1;
		sum = 0;
		while(i<=100) {
			if(i%2==0) {				
				sum+=i;
			}
			i++;
		}
		System.out.println("1~100 짝수 합계 : " + sum);

		i = 1;
		sum = 0;
		while(i<=100) {
			if(i%2==1) {				
				sum+=i;
			}
			i++;
		}
		System.out.println("1~100 홀수 합계 : " + sum);
	}
}

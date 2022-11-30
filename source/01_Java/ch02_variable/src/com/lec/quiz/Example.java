package com.lec.quiz;

public class Example {
	public static void main(String[] args) {
		// 국어, 영어, 수학 점수 할당
		// 총점, 평균
		// 점수들 출력
		int kor = 85; // 국어
		int math = 50; // 수학
		int eng = 65; // 영어
		int tot = kor + math + eng; // 총점
		// double avg = tot / 3;
		// double avg = tot / 3.0;
		double avg = (double)tot / 3;
		System.out.println("============성적표================================");
		System.out.println("\t 국어 \t 영어 \t 수학");
		System.out.println("\t 85 \t 50 \t 65");
		System.out.printf("\t 총점 : %d\t평균 : %.2f\n", tot, avg);
		System.out.println("================================================");
		
			
	}
}

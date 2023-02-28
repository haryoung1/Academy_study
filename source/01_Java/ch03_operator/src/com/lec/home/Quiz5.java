package com.lec.home;

import java.util.Scanner;

// 국어, 영어, 수학 점수를 사용자에게 입력받아, 각 점수를 출력하고 총점, 평균(소수점2자리까지) 출력하는 프로그램을 구현 하시오
public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 점수는 ?");
		int kor = sc.nextInt();
		System.out.println("수학 점수는 ?");
		int mat = sc.nextInt();
		System.out.println("영어 점수는 ?");
		int eng = sc.nextInt();
		int sum = kor+mat+eng;
		double avg = sum / 3.;
		
		System.out.printf("국어 : %d" + "점\t" , kor);
		System.out.printf("영어 : %d" + "점\t" , eng);
		System.out.printf("수학 : %d" + "점\n" , mat);
		System.out.printf("총점 : %d" + "점\n", sum);
		System.out.printf("평균 : %.2f" + "점", avg);
		
	}
}

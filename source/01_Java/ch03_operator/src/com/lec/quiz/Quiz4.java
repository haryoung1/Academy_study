package com.lec.quiz;
// 나이에 따른 경로우대, 일반 출력
import java.util.Scanner;
public class Quiz4 {
	public static void main(String[] args) {
		System.out.println("나이를 입력 해주세요");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		System.out.println((age>=65)? "경로우대 입니다.": "일반 입니다.");
		sc.close();
	}
}

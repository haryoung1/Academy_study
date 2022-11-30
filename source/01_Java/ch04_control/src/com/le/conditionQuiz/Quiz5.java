package com.le.conditionQuiz;
import java.util.Scanner;
// 현재 몇월 인지를 키보드로부터 입력 받아 계절을 출력
public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("지금은 몇월인가요? \n숫자만 입력하시오 : ");
		int you = scanner.nextInt();
		if (you ==1) {
			System.out.println("1월이 아닙니다.");
		}else if (you ==2) {
			System.out.println("2월이 아닙니다.");
		}else if (you ==3) {
			System.out.println("3월이 아닙니다.");
		}else if (you ==4) {
			System.out.println("4월이 아닙니다.");
		}else if (you ==5) {
			System.out.println("5월이 아닙니다.");
		}else if (you ==6) {
			System.out.println("6월이 아닙니다.");
		}else if (you ==7) {
			System.out.println("7월이 아닙니다.");
		}else if (you ==8) {
			System.out.println("8월이 아닙니다.");
		}else if (you ==9) {
			System.out.println("9월이 아닙니다.");
		}else if (you ==10) {
			System.out.println("10월이 아닙니다.");
		}else if (you ==12) {
			System.out.println("12월이 아닙니다.");
		}else if (you ==11) {
			System.out.println("정답 입니다!");
		}else {
			System.out.println("다시 입력 해주세요.");
		}
		scanner.close();
	}
}

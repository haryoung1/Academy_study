package com.le.conditionQuiz;
import java.util.Scanner;
// 수를 입력받아 절대값을 출력하는 프로그램
public class Quiz1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수를 입력 하세요 : ");
		int su = scanner.nextInt();
		if (su>=0) {
			System.out.printf("입력하신 수의 절대 값은 %d\n", su);
		}else {
			System.out.printf("입력하신 수의 절대값 : %d\n", -su);
		}
		scanner.close();
	}
}

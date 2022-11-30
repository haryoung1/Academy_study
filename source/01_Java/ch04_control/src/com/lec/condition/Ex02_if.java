package com.lec.condition;
import java.util.Scanner;
// 두수를 입력 받아 어떤 수가 얼마나 더 큰지 출력
// 스캐너를 사용하려면 import에서 선언해야함.
public class Ex02_if {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 수 :");
		int num1 = scanner.nextInt();
		System.out.print("두번째 수 :");
		int num2 = scanner.nextInt();
		if(num1>num2) {
			System.out.printf("첫번째 수 (%d)가 %d만큼 더 큽니다", num1, (num1-num2));
		}else if(num1<num2) {
			System.out.printf("두번째 수 (%d)가 %d만큼 더 큽니다", num2, (num2-num1));
		}else {
			System.out.println("같은 수를 입력 하셨습니다.");
		} // if
		scanner.close();
	} // main
} // clasee

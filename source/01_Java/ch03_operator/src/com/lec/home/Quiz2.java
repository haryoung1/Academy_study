package com.lec.home;

import java.util.Scanner;

// 입력한 수가 짝수인지 홀수인지 출력
public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력 하세요.");
		int su = sc.nextInt();
		if (su%2 == 0) {
			System.out.println("입력하신 숫자는 짝수");
		}else {
			System.out.println("입력하신 숫자는 홀수");
		}
	}
}

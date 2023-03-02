package com.lec.conditionQuizHome;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는걸 내봐");
		System.out.println("가위 : 0 / 바위 : 1 / 보 :2");
		int you = sc.nextInt();

		if (you == 0) {
			System.out.println("너는 가위를 선택 했어");
		} else if (you == 1) {
			System.out.println("너는 바위를 선택 했어");
		} else if (you == 2) {
			System.out.println("너는 보자기를 선택 했어");
		} else {
			System.out.println("이봐, 0번 1번 2번만 선택이 가능해. 다시 골라봐");
		}
	}
}

package com.lec.conditionQuizHome;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("현재 몇월인지 입력 해주세요 : ");
		int su = sc.nextInt();

		switch (su) {
		case 12:
		case 1:
		case 2:
			System.out.println(su + "월" + " 지금은 겨울 입니다.");
			break;
		case 3:
		case 4:
			System.out.println("지금은 봄 입니다.");
			break;
		case 5:
		case 6:
		case 7:
		case 8:
			System.out.println("여름이네");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("고독한 가을이구먼");
			break;
		default:
			System.out.println("똑바로 입력해 이놈아.");
		}
	}
}

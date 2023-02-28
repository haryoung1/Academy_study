package com.lec.conditionQuizHome;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("가위바위보 게임 입니다.");
		System.out.println("가위 : 0 / 바위 : 1 / 보 :2");
		int user = sc.nextInt(); // 나
		if (user == 0) {
			System.out.println("가위를 냈습니다.");
		} else if (user == 1) {
			System.out.println("바위를 냈습니다.");
		} else if (user == 1) {
			System.out.println("보자기를 냈습니다.");
		} else {
			System.out.println("그런 숫자는 내면 안돼요 떽!");
		}

		int com = (int) (Math.random() * 3); // 컴퓨터
		if (com == 0) {
			System.out.println("컴퓨터가 가위를 냈습니다.");
		} else if (com == 1) {
			System.out.println("컴퓨터가 바위를 냈습니다.");
		} else if (com == 2) {
			System.out.println("컴퓨터가 보를 냈습니다.");
		}

		if (com == 0) {
			if (user == 0) {
				System.out.println("서로 비겼습니다.");
			}
			if (user == 1) {
				System.out.println("오, 당신이 졌어요.");
			}
			if (user == 2) {
				System.out.println("축하 합니다! 이겼습니다.");
			}
		}

		if (com == 1) {
			if (user == 0) {
				System.out.println("오, 당신이 졌어요.");
			}
			if (user == 1) {
				System.out.println("서로 비겼습니다.");
			}
			if (user == 2) {
				System.out.println("축하 합니다! 이겼습니다.");
			}
		}
		if (com == 2) {
			if (user == 0) {
				System.out.println("축하 합니다! 이겼습니다.");
			}
			if (user == 1) {
				System.out.println("오, 당신이 졌어요.");
			}
			if (user == 2) {
				System.out.println("서로 비겼습니다.");
			}
		}
	} // main
}

package com.lec.ex8_decimal;

import java.util.Random;
import java.util.Scanner;

// 이길때까지 가위바위보 게임

public class GGG {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int me;
		int com;
		final int SCISSOR = 0;
		final int ROCK = 1;
		final int PAPER = 3;
		final int NOTHING = 4;

		do {
			com = random.nextInt(3);
			System.out.println("가위바위보 게임 니가 이길때까지");
			String youStr = scanner.next().trim();
			if (youStr.equals("가위")) {
				me = SCISSOR;
			} else if (youStr.equals("바위")) {
				me = ROCK;
			} else if (youStr.equals("보")) {
				me = PAPER;
			} else {
				me = NOTHING;
				continue;
			}
			if ((me + 2) % 3 == com) {
				printResult(me, com);
				System.out.println("당신이 이겼어요");
			} else if (me == com) {
				printResult(me, com);
				System.out.println("비겼어요");
			} else {
				printResult(me, com);
				System.out.println("당신이 졌어요");
			} // if
		} while (me == NOTHING || (me + 2) % 3 != com);
			System.out.println("축하해요. BYE");
			scanner.close();
	}
	private static void printResult(int me, int com) {
		System.out.println("당신은 " + ((me == 0) ? "가위" : ((me == 1) ? "바위" : "보")));
		System.out.println("컴퓨터는 " + ((com == 0) ? "가위" : ((com == 1) ? "바위" : "보")));
	}

}

package com.lec.ex8_decimal;

import java.util.Random;
import java.util.Scanner;

// �̱涧���� ���������� ����

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
			System.out.println("���������� ���� �ϰ� �̱涧����");
			String youStr = scanner.next().trim();
			if (youStr.equals("����")) {
				me = SCISSOR;
			} else if (youStr.equals("����")) {
				me = ROCK;
			} else if (youStr.equals("��")) {
				me = PAPER;
			} else {
				me = NOTHING;
				continue;
			}
			if ((me + 2) % 3 == com) {
				printResult(me, com);
				System.out.println("����� �̰���");
			} else if (me == com) {
				printResult(me, com);
				System.out.println("�����");
			} else {
				printResult(me, com);
				System.out.println("����� �����");
			} // if
		} while (me == NOTHING || (me + 2) % 3 != com);
			System.out.println("�����ؿ�. BYE");
			scanner.close();
	}
	private static void printResult(int me, int com) {
		System.out.println("����� " + ((me == 0) ? "����" : ((me == 1) ? "����" : "��")));
		System.out.println("��ǻ�ʹ� " + ((com == 0) ? "����" : ((com == 1) ? "����" : "��")));
	}

}

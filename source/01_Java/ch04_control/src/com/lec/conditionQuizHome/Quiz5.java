package com.lec.conditionQuizHome;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ������� �Է� ���ּ��� : ");
		int su = sc.nextInt();

		switch (su) {
		case 12:
		case 1:
		case 2:
			System.out.println(su + "��" + " ������ �ܿ� �Դϴ�.");
			break;
		case 3:
		case 4:
			System.out.println("������ �� �Դϴ�.");
			break;
		case 5:
		case 6:
		case 7:
		case 8:
			System.out.println("�����̳�");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("���� �����̱���");
			break;
		default:
			System.out.println("�ȹٷ� �Է��� �̳��.");
		}
	}
}

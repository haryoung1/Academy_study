package com.lec.conditionQuizHome;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ϴ°� ����");
		System.out.println("���� : 0 / ���� : 1 / �� :2");
		int you = sc.nextInt();

		if (you == 0) {
			System.out.println("�ʴ� ������ ���� �߾�");
		} else if (you == 1) {
			System.out.println("�ʴ� ������ ���� �߾�");
		} else if (you == 2) {
			System.out.println("�ʴ� ���ڱ⸦ ���� �߾�");
		} else {
			System.out.println("�̺�, 0�� 1�� 2���� ������ ������. �ٽ� ����");
		}
	}
}

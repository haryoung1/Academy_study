package com.lec.conditionQuizHome;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���������� ���� �Դϴ�.");
		System.out.println("���� : 0 / ���� : 1 / �� :2");
		int user = sc.nextInt(); // ��
		if (user == 0) {
			System.out.println("������ �½��ϴ�.");
		} else if (user == 1) {
			System.out.println("������ �½��ϴ�.");
		} else if (user == 1) {
			System.out.println("���ڱ⸦ �½��ϴ�.");
		} else {
			System.out.println("�׷� ���ڴ� ���� �ȵſ� ��!");
		}

		int com = (int) (Math.random() * 3); // ��ǻ��
		if (com == 0) {
			System.out.println("��ǻ�Ͱ� ������ �½��ϴ�.");
		} else if (com == 1) {
			System.out.println("��ǻ�Ͱ� ������ �½��ϴ�.");
		} else if (com == 2) {
			System.out.println("��ǻ�Ͱ� ���� �½��ϴ�.");
		}

		if (com == 0) {
			if (user == 0) {
				System.out.println("���� �����ϴ�.");
			}
			if (user == 1) {
				System.out.println("��, ����� �����.");
			}
			if (user == 2) {
				System.out.println("���� �մϴ�! �̰���ϴ�.");
			}
		}

		if (com == 1) {
			if (user == 0) {
				System.out.println("��, ����� �����.");
			}
			if (user == 1) {
				System.out.println("���� �����ϴ�.");
			}
			if (user == 2) {
				System.out.println("���� �մϴ�! �̰���ϴ�.");
			}
		}
		if (com == 2) {
			if (user == 0) {
				System.out.println("���� �մϴ�! �̰���ϴ�.");
			}
			if (user == 1) {
				System.out.println("��, ����� �����.");
			}
			if (user == 2) {
				System.out.println("���� �����ϴ�.");
			}
		}
	} // main
}

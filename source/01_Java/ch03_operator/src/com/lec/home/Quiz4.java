package com.lec.home;

import java.util.Scanner;

// ���̸� �Է¹޾� �Է¹��� ���̰� 65�� �̻��� ��, ����ο�롱 ���, �ƴϸ� ���Ϲݡ����
public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���̸� �Է� �ϼ��� : ");
		int age = sc.nextInt();
		if (age > 65) {
			System.out.println("��ο�� �Դϴ�. ���");
		}else {
			System.out.println("65�� �̸��� �Ϲ� �̿���.");
		}
	}
}

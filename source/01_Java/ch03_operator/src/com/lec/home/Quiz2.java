package com.lec.home;

import java.util.Scanner;

// �Է��� ���� ¦������ Ȧ������ ���
public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է� �ϼ���.");
		int su = sc.nextInt();
		if (su%2 == 0) {
			System.out.println("�Է��Ͻ� ���ڴ� ¦��");
		}else {
			System.out.println("�Է��Ͻ� ���ڴ� Ȧ��");
		}
	}
}
